package ch01;

public class Comparing {

	public static void main(String[] args) {
		/*
		 * 
		 * �� �����ڴ� ���� �񱳿� ũ�� �񱳰� �ִ�.
		 * == : ����?
		 * != : �ٸ���?
		 * > : �ʰ�, ũ��?
		 * >= : �̻�, ũ�ų� ����?
		 * < : �̸�, �۳�?
		 * <= : ����, �۰ų� ����?
		 * 
		 */
		
		int num1 = 10;
		int num2 = 10;
		boolean result1a = (num1 == num2);
		// boolean Ÿ���� true, false �� ���� ���� ������.
		System.out.println(result1a);
		boolean result1b = (num1 != num2);
		System.out.println(result1b);
		
		char char1 = 'A'; // �����ڵ� 65
		char char2 = 'B'; // �����ڵ� 66
		boolean result2 = (char1 < char2); // 65 < 66 ==> true
		System.out.println(result2);
		// A�� a�� ���ϴ� �͵� �� �ô�. ���� �����ڵ尡 �ٸ���.
		// 1�� '1'�� ���ϴ� �͵� �ߴ�. ���� �ٸ���.
		
		int v2 = 1;
		double v3 = 1.0;
		System.out.println(v2 == v3); // ���� 1�� �Ǽ� 1.0�� ����?
		// �� �����ڿ� Ÿ���� �ٸ� ������ ���ϸ� �ڵ� Ÿ�� ��ȯ�� �Ͼ��.
		// �̶� �ڵ� Ÿ�� ��ȯ�� ū ������ Ÿ���� �����. ���⼭�� int�� double�� �������ٰ� ���� �ǰڴ�.
		
		double v4 = 0.1;
		float v5 = 0.1F;
		System.out.println("========================");
		System.out.println(v5 == v4); // false
		// �Ǽ����� �ε� �Ҽ��� ������ �����ؼ� �ٻ簪���� ǥ���Ѵ�.
		//  true�� ����� ���ؼ��� ���� Ÿ�� ��ȯ�� �ʿ��ϴ�.
		System.out.println((float)v4 == v5); // v4�� float���� ��ȯ�ϸ� true�� ��µȴ�.
		System.out.println(v4 == (double)v5); // �̰� false�� ���´�. ��...? �ڵ� Ÿ�� ��ȯ�̶�� �Ѵ�. 43��� ����.
		
		System.out.println((int)(v4*10) == (int)(v5*10)); // true 
		
		System.out.println("========================");
		System.out.println("========================");
		
		char x = 88;
		char xx = 'X';
		System.out.println(x == xx); // 88�� X�� ���ٰ� ���´�.

	}

}
