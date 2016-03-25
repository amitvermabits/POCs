package string;

import java.util.StringTokenizer;

public class ReverseString {
	
	public String reverseWords(String original) {
		if (original == null) {
			return original;
		}
		if (original.isEmpty()) {
			return original;
		}
		int length = original.length();
		String reverse = "";
		for (int i = length - 1; i >= 0; i--)
			reverse = reverse + original.charAt(i);
		return reverse;
	}
	
	public String reverseWordInSentence(String sentence) {
		String reverseSentence = "";
		if(sentence != null && !sentence.isEmpty()){
			StringTokenizer stringTokenizer = new StringTokenizer(sentence," ");
			while(stringTokenizer.hasMoreTokens()){
				if(reverseSentence.length() > 0){
					reverseSentence =  reverseSentence + " ";
				}
				String tokens = stringTokenizer.nextToken();
				reverseSentence = reverseSentence + reverseWords(tokens);
			}
		}
		return reverseSentence;
	}
	// smart am i
	public String reverseSentence(String sentence) {
		String reverseSentence = "";
		if(sentence != null && !sentence.isEmpty()){
			StringTokenizer stringTokenizer = new StringTokenizer(sentence," ");
			while(stringTokenizer.hasMoreTokens()){
				if(reverseSentence.length() > 0){
					reverseSentence = " " + reverseSentence ;
				}
				String tokens = stringTokenizer.nextToken();
				reverseSentence =tokens + reverseSentence;
			}
		}
		return reverseSentence;
	}

	
	public static void main(String[] args) {
		
		ReverseString reverseString = new ReverseString();
		String s = "I am smart";
		System.out.println(s + ":" + reverseString.reverseWordInSentence(s));
		System.out.println(s + ":" + reverseString.reverseWords(s));
		System.out.println(s + ":" + reverseString.reverseSentence(s));
	}
}
