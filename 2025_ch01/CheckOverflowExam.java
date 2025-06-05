package ch01;

public class CheckOverflowExam {

	public static void main(String[] args) {
		// �츮�� ���� Ÿ���� Ű����� �Է� �޾� ó���ϴ� ���� ��Ģ.
		// �Է°��� ����üũ�� ������ �ʿ䰡 �ִ�.
		// main �޼��� �̿ܿ� �� �ٸ� �Լ�(�޼���)�� �߰��Ͽ� �������.

		int result = safeAdd(70, 80);
		System.out.println(result);

	} // main �޼��� ����

	public static int safeAdd(int left, int right) {
		if (right > 0) { // true�� ��
			if (left > (Integer.MAX_VALUE - right)) {
				// (Integer.MAX_VALUE)�� int Ÿ���� �ִ밪. �� 21��
				// int Ÿ���� �ִ밪���� ������ ���� �� ���� ���� ������ �۾ƾ� ��
				throw new ArithmeticException("Overflow");
				// ���� ó�� ���� �߻��� �ڵ�
			}
		} else { // false�� ��
			if (left < (Integer.MIN_VALUE - right)) {
				// min_value�� int Ÿ���� �ּҰ�, �� -21��
				throw new ArithmeticException("Overflow");
			}
		}
		return left + right;
	} // safeAdd �޼��� ����
}// class ����
