
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.BitSet;


public class BitSetExample {
    public static void main(String[] args) throws Exception {

        String inputFile = "c:\\temp\\numbers.txt";
        NumberFileSorter.sort(inputFile, 100);
    }
}

class NumberFileSorter {

    private NumberFileSorter() {
    }

    public static void sort(String inputFile, int maxValue) throws Exception {

        final BitSet bitSet = createBitSet(inputFile, maxValue);
        final String outputFile = deriveOutputFile(inputFile);
        writeBitSet(bitSet, outputFile);
    }

    private static BitSet createBitSet(String inputFile, int maxValue)
            throws Exception {

        final FileInputStream stream = new FileInputStream(inputFile);
        final InputStreamReader streamReader = new InputStreamReader(stream);
        final BufferedReader buffReader = new BufferedReader(streamReader);

        String line = null;
        int totalBits = maxValue + 1;
        BitSet bitSet = new BitSet(totalBits);

        try {
            while ((line = buffReader.readLine()) != null) {
                int number = Integer.parseInt(line);
                bitSet.set(number, true);
            }
        } finally {
            buffReader.close();
            streamReader.close();
            stream.close();
        }

        return bitSet;
    }

    private static String deriveOutputFile(String inputFile) {
        String outputFileName = Paths.get(inputFile).getParent().toString()
                + "/output.txt";
        return outputFileName;
    }

    private static void writeBitSet(BitSet bitSet, String outputFile)
            throws Exception {

        final File file = new File(outputFile);
        file.createNewFile();

        final FileOutputStream outputStream = new FileOutputStream(file);
        final OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        final BufferedWriter buffWriter = new BufferedWriter(writer);
        System.out.println("bitSet:" + bitSet.length());
        try {
            for (int bitIndex = 0; bitIndex < bitSet.length(); bitIndex++) {
            	if(bitIndex == 6 || bitIndex == 21 || bitIndex == 102){
            		System.out.println(bitIndex + ":" + bitSet.get(bitIndex));
            	}
                if (bitSet.get(bitIndex)) {
                	System.out.println(bitIndex + ":" + bitSet.get(bitIndex));
                    buffWriter.write(Integer.toString(bitIndex));
                    buffWriter.newLine();
                }
            }
        } finally {
            buffWriter.close();
            writer.close();
            outputStream.close();
        }
    }
}