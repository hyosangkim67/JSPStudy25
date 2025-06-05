package ch01;

import java.util.Scanner;

public class LogicCircuitPractice {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// 0508 ���� �������� ���� ��ȯ, �Ҵ��, ��ȸ�� �� logic circuit ���񿡼� �����ߴ� �͵��� �����
		// 0509 if, &&, ||, Scanner ����
		
		/*
		 
		  ���� �ð��� ���� �ڵ�
		  
		  Scanner input = new Scanner(System.in); // sc +  �� ��
		  �ܼ��� ���� ���� ���� ��ü
		  String ������ = input.nextLine(); 
		  
		if((loginid.equals((id)) & loginpw.equals(pw))) {
			System.out.println("id�� pw�� ��ġ�մϴ�.");
			System.out.println("�α��� ����");
		}else {
			System.out.println("id�� pw�� �ٸ��ϴ�.");
			System.out.println("�α��� ����");
		}
		 
		 */
		
		// �Ʒ��� ���� �ð��� ���� ��� �ڵ带 �����ؼ� ������ �ڵ��
		
		// #1 1P�� 2P���� ������������ �Է� �޾� ����� ����
		
		String rock = "����";
		String paper = "��";
		String scissors = "����";
		System.out.print("1P�� ����, ����, �� �� ������ ���ðڽ��ϱ�? ");
		String a = input.nextLine();
		System.out.print("2P�� ����, ����, �� �� ������ ���ðڽ��ϱ�? ");
		String b = input.nextLine();
		System.out.println("1P�� "+ a + "�̰�, 2P�� " + b + "�Դϴ�.");
		System.out.println("===== �� �� =====");
		if(a.equals(b)){
			System.out.println("�����ϴ�.");
		}else if((rock.equals(a) && scissors.equals(b)) || (scissors.equals(a) && paper.equals(b)) || (paper.equals(a) && rock.equals(b))){
			System.out.println("1P�� �̰���ϴ�.");
		}else if((rock.equals(a) && paper.equals(b)) || (scissors.equals(a) && rock.equals(b)) || (paper.equals(a) && scissors.equals(b))){
		System.out.println("2P�� �̰���ϴ�.");
		}else {
			System.out.println("����, ����, �� �� �ϳ��� �Է��� �ּ���. ���α׷��� �ٽ� ������ �ּ���.");
			}
		

		// #2 input ���� �� ������ ���� ��� - Scanner ����
		 
		System.out.println("ù ��° ������ �Է��ϼ���. : ");
		int number1 = input.nextInt();
		System.out.println("�� ��° ������ �Է��ϼ���. : ");
		int number2 = input.nextInt();
		System.out.println("�� ������ ���� " + (number1+number2) + "�Դϴ�.");
		
		// #3 Scanner, if/else ��� ����
		
		System.out.println("Ȧ¦�� �Ǵ��� ������ �Է��� �ּ���. >>> ");
		int number3 = input.nextInt();
		if(number3 % 2 == 0) {
			System.out.println(number3 + ": ¦���Դϴ�.");
		}else {
			System.out.println(number3 + ": Ȧ���Դϴ�.");
		}
		
}
}
