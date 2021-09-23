package dataStructure;

public class getBitEx {
	static boolean getBit(int num, int i) {
		return (num & (1<<i)) != 0;
	} // getBit : AND 
	static int setBit(int num, int i) {
		return (num | (1<<i));
	}// setBit : OR / �ش� index�� 1�� ����
	static int clearBit(int num,int i) {
		return num & ~(1 << i);
	}// clearBit : 0���� �ٲٰ� ���� index�� 0 �������� 1�� ���� and���� 
	static int clearLeftBit(int num, int i) {
		return num & (1<<i)-1;
	}
	static int clearRightBit(int num, int i) {
		return num & (-1<<(i+1));
	}
	static int updateBit(int num, int i,boolean val) {
		return (num & ~(1<<i)) | ((val?1:0)<<i);
	}
	public static void main(String[] args) {
		// 1 0 0 1
		
		System.out.println(getBit(9,3));
		int num = setBit(9,2);
		System.out.println(setBit(num,1));
		System.out.println(clearLeftBit(15,3));
		System.out.println(clearRightBit(15,2));
		System.out.println(updateBit(169,3,false));
	}
}
