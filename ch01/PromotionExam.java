package ch01;

public class PromotionExam {

	public static void main(String[] args) {
		// �ڵ� Ÿ�� ��ȯ ����
		// float���ٴ� double ���, float�� ���̻� F
		// 21�� �� �̻� ����� ���� long ���, ���̻� L
		
		byte byteValue = 10; // ����Ʈ�� 8��Ʈ¥��
		int intValue = byteValue; // �ڵ� Ÿ�� ��ȯ
		System.out.println("�ڵ�Ÿ�� �� int:" + intValue);
		char charValue = '��';
		intValue = charValue; // �ڵ� Ÿ�� ��ȯ
		System.out.println("�ڵ�Ÿ�� �� int:" + intValue);
		
		intValue = 500;
		long longValue = intValue;
		System.out.println("�ڵ�Ÿ�� �� int:" + longValue);
		double doubleValue = intValue;
		System.out.println("�ڵ�Ÿ�� �� int:" + doubleValue);

	}

}
