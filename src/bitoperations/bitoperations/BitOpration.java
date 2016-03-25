package bitoperations;

public  class BitOpration {
	//00000101 - num
	//00000010 - i
	//00000101 & 00000100
	static boolean getBit(int num ,int i){
		return ((num & (1<<i)) !=0);
	}
	//00000101
	static int setBit(int num,int i){
		return (num |(1<<i));
	}
	//00000101
	static int clearBit(int num ,int i){
		int mask = ~(1<<i);
		return num & mask;
	}
	
	public static void main(String[] args) {
		System.out.println("getBit:" + getBit(5, 0));
		System.out.println("setBit:" + setBit(5, 1));
		System.out.println("clearBit:" + clearBit(5, 2));
	}

}
