/*
 * IntToFloat �� ���ؼ� ����
 */


package ch01;


public class IntToDouble {
	public static void main(String[] args) {
		// int�� float ��� 32��Ʈ���� ������ �Ǽ���� ���̰� �ִ�.
		// ���� �� Ÿ���� ���� ������ �ٸ���.
		
		int num1 = 123456780;
		int num2 = 123456780;
		
		double num3 = num2; // int > double
		num2 = (int) num3; // double > int
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		
		/*
		num1 : 123456780
		num2 : 123456780
		num3 : 1.2345678E8
		E�� ���� ��������, E ���� ���ڴ� �Ҽ��� ��ġ�� ����
		 */
		
		int result = num1 - num2 ;
		System.out.println("double�� ��ȯ�߱� ������ num1 > num2 ���� ��ȭ�� ����.");
		System.out.println("num1 - num2: " + result);

		
	}

}
