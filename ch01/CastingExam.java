package ch01;

public class CastingExam {

	public static void main(String[] args) {
		// Casting = ���� Ÿ�� ��ȯ
		// ������ �߻��ص� ������ �����ϴ� ����� ���� Ÿ�� ��ȯ�̶�� ��.
		
		int intValue = 123456789;
		byte byteValue = (byte) intValue;
		System.out.println("int Ÿ�� �� ���: " + intValue);
		System.out.println("byte Ÿ�� �� ���: " + byteValue);
		// ���̳ʸ��ѹ����� 8��Ʈ�� ���� > ���øֳѹ��� ġȯ
		
		int kor = 87;
		int eng = 99;
		int math = 97;
		int total = kor + eng + math ;
		System.out.println("������ ����: " + total);
		double avg = total / 3;
		System.out.println("��� ����" + avg);
		// ���⼭ �Ҽ����� 0���� ������ ������ total�� int�� �����̴�.
		avg = (double) total / 3; // casting�ϰ� ���� ���� Ÿ���� �տ� ���δ�. (double)
		System.out.println("��� ����" + avg);
		
		

	}

}
