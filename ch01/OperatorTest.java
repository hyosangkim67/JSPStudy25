package ch01;

		public class OperatorTest {

			public static void main(String[] args) {
				// ���ݱ��� ��� ���� Ÿ���� �⺻ Ÿ������, �ڹٿ��� ��ü ���� ����
				// String�� ���� ��ü�� �����ؾ� ������ ���ǻ� ������

				String strval1 = "����";
				String strval2 = "����";
				System.out.println(strval1 == strval2);
				
				/*
				 * �̹� ���� �����̶�� ��ü�� ������� ������ ������ ���� ������ �� �ƴϴ�. 
				 * strval1�� ���� �����̶�� ��ü�� ������ �����ϰ� ������ �Ŵ�.
				 */

				String strval3 = new String("����"); // ��ü ���� ����
				System.out.println(strval1 == strval3); // false
				// strval1�� "����"�̶�� ��ü�� strval3�� "����"�̶�� ��ü�� �ٸ���. ���� ������������ �ٸ� ������Ʈ��.
				// new��� ���̸� �ƿ� ���ο� ��ü�� ����� �� ����. �� �߻����ε�...
				
				// ��ü�� �ּҸ� �Ǵ��� ���� ==�� ���������, ��ü�� ���� ���� ���� ���� ����� �޼��带 ����ؾ� �Ѵ�.
				// String�� ��ü��, ��ü ���ʿ��� �޼������ ��� �ִ�.
				// �޼��尡 ���� ������ .�� ����.
				boolean eq1 = strval1.equals(strval3);
				System.out.println("strval1�� strval3�� ���ϱ� ����, equals �޼��带 ����� ����� " + eq1);
				
				

	
	}

}
