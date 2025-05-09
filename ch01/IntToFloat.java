/*
 * IntToFloat �� ���ؼ� ����
 */

package ch01;

public class IntToFloat {

	public static void main(String[] args) {
		// float�� 32��Ʈ�� �� �ε� �Ҽ��� ���꿡 ���ȴ�.
		// ���� Ÿ���� �Ǽ� Ÿ������ ��ȯ�� �� �ս��� �߻��Ѵ�.
		// int(32bit) = float(32bit) bit�� ������ float�� �Ҽ����� �����ϱ� ������ ���� ������ �ٸ���.
		
		int num1 = 123456780 ;
		int num2 = 123456780 ;
		
		float num3 = num2 ; // int Ÿ�� ���� float�� ����
		num2 = (int) num3 ; // float > int
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3); // num3 : 1.23456784E8 < E�� ���������̰� E ���� ���ڴ� �ε� �Ҽ��� ó��
		// 																			 12. 3456784E7 E ���� ���ڴ� �Ҽ����� ��ġ�� ��Ÿ����.
		int result = num1 - num2 ;
		System.out.println("float���� �ٳ�� �Ŀ� num2 ���� �����.");
		System.out.println("num1 - num2: " + result);
	}

}
