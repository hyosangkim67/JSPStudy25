/*
 * ��Ȯ�� ����� ������ ����ϴ� ���� ����!
 * �Ǽ����� ���� ���Ƿ� ������ ���� ����ϴ� ������.
 * double(�Ǽ�)�� ����ϴ� ���� accuracyExam1�� Ȯ������
 */

package ch01;

public class AccuracyExam2 {

	public static void main(String[] args) {
		// accuracyExam1�� ���� ���������� ��� 1���� 10���� ġȯ�ؼ�
		// ��� 1������ ���� 1�� �����. �Ҽ��� ó�� ���� int Ÿ���� Ȱ���Ѵ�.
		
		int apple = 1;
		int tempPiece = apple * 10;
		int number = 7;
		double result = (tempPiece - number) / 10.0 ;
		double result2 = (tempPiece - number) / 10 ;
		double result3 = (tempPiece - number) / (double)10 ;
		double result4 = (tempPiece - number) / (int)10.0 ;
		// �� / 10.0�� �ƴ϶� 10�� �ϸ� 0�� ������
		// ���������� int Ÿ���� �⺻���� �ϱ� ������ result�� int Ÿ���� �Ǿ������
		// �׷��� �Ҽ��� ������ �� �Ǵ� �� ����.
		System.out.println("���� ��� ���� ��: " + result);
		System.out.println("���� ��� ���� ��: " + result2);
		System.out.println("���� ��� ���� ��: " + result3);
		System.out.println("���� ��� ���� ��: " + result4);

	}

}
