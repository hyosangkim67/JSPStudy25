package test_0613;

import java.sql.SQLException;
import java.util.Scanner;

public class MainService {
	public MemberDAO memberDAO = new MemberDAO();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MainService mainService = new MainService();

		try {
			mainService.memberMenu(input);
		} catch (SQLException e) {
			System.out.println("���α׷� ���� �� ���� �߻�");
			e.printStackTrace();
		} finally {
			mainService.memberDAO.close();
			input.close();
		}

	}

	public void memberMenu(Scanner input) throws SQLException {
		boolean run = true;
		while (run) {
			System.out.println("===== ȸ�� ���� �޴� =====");
			System.out.println("1. ��ü ȸ�� ���� <readAll>");
			System.out.println("2. ȸ�� ���� <insert>");
			System.out.println("3. ȸ�� ��ȸ <readOne>");
			System.out.println("4. ȸ�� Ż�� <delete>");
			System.out.println("5. ��й�ȣ ���� <update>");
			System.out.println("6. ����");
			System.out.print(">>> ");

			String select = input.nextLine();
			switch (select) {
			case "1":
				readAll(input);
				break;
			case "2":
				insert(input);
				break;
			case "3":
				readOne(input);
				break;
			case "4":
				delete(input);
				break;
			case "5":
				update(input);
				break;
			case "6":
				System.out.println("ȸ�� ���񽺸� �����մϴ�.");
				run = false;
				break;
			case "4486":
				System.out.println("���� ������ �����մϴ�.");
			default:
				System.out.println("�ùٸ� �޴� ��ȣ�� �����ϼ���.");
			}
		}
	}

	private void readAll(Scanner input) throws SQLException {
		memberDAO.selectAllMembers();
	}

	private void insert(Scanner input) throws SQLException {
		System.out.println("[ȸ�� ����]");
		System.out.print("�̸� �Է�: ");
		String bwriter = input.nextLine();

		System.out.print("ID �Է�: ");
		String id = input.nextLine();

		System.out.print("��й�ȣ �Է�: ");
		String pw = input.nextLine();

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setBwriter(bwriter);
		memberDTO.setId(id);
		memberDTO.setPw(pw);

		memberDAO.insertMember(memberDTO);
	}

	private void readOne(Scanner input) throws SQLException {
		System.out.print("��ȸ�� ȸ�� ID �Է�: ");
		String id = input.nextLine();

		MemberDTO memberDTO = memberDAO.selectOne(id);

		if (memberDTO != null) {
			System.out.println("===== ȸ�� ���� =====");
			System.out.println("ȸ����ȣ: " + memberDTO.getMno());
			System.out.println("�̸�: " + memberDTO.getBwriter());
			System.out.println("ID: " + memberDTO.getId());
			System.out.println("��й�ȣ: " + memberDTO.getPw());
			System.out.println("��������: " + memberDTO.getRegidate());
		} else {
			System.out.println("�ش� ID�� ȸ���� �������� �ʽ��ϴ�.");
		}
	}

	private void delete(Scanner input) throws SQLException {
		System.out.print("Ż���� ȸ�� ID �Է�: ");
		String id = input.nextLine();

		int result = memberDAO.deleteOne(id);
		if (result > 0) {
			System.out.println("ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("�ش� ID�� ȸ���� �������� �ʽ��ϴ�.");
		}
	}

	private void update(Scanner input) throws SQLException {
		System.out.print("��й�ȣ�� ������ ȸ�� ID �Է�: ");
		String id = input.nextLine();

		System.out.print("�� ��й�ȣ �Է�: ");
		String newPw = input.nextLine();

		int result = memberDAO.updatePassword(id, newPw);
		if (result > 0) {
			System.out.println("��й�ȣ�� ���������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("�ش� ID�� ȸ���� �������� �ʽ��ϴ�.");
		}
	}
}
