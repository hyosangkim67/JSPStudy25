/*
 * ���� �ð��� ���� ������ ��������� �ű� ��
 */

package ch01;

import java.util.Scanner; // �ܺ� ���̺귯��

public class LogicalExam {

	public static void main(String[] args) {
		// �� �����ڴ� ũ�� 5���� ������ �ִ�.
		// &: �� �� -> -�̰� (2���� ������ ��� ���� ���, ��)
		// | : �� �� -> -�̰ų� (2���� �� �ϳ��� ���� ���, ��)
		// ! : �� ���� -> ���� ������ �����Ѵ�.
		// ^ : ��Ÿ�� �� �� -> �� ���� �������� 1+1=0���� ��� ��
		
		String loginid = "kkw";
		String loginpw = "1234";
		
		Scanner input = new Scanner(System.in);
		// �ܼ��� ���� ���� ���� ��ü
		System.out.print("�α��� �� id�� �Է��ϼ���. : ");
		String id = input.nextLine();
		System.out.println("�Է��Ͻ� id: " + id + "�Դϴ�.");
		System.out.print("�α����� ��ȣ�� �Է��ϼ���. : ");
		String pw = input.nextLine();
		System.out.println("=== ���� ���Դϴ�. ===");
		
		if((loginid.equals((id)) & loginpw.equals(pw))) {
			System.out.println("id�� pw�� ��ġ�մϴ�.");
			System.out.println("�α��� ����");
		}else {
			System.out.println("id�� pw�� �ٸ��ϴ�.");
			System.out.println("�α��� ����");
		} //if�� ����

	} // main ����

} // Ŭ���� ����