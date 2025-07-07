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
			System.out.println("프로그램 실행 중 오류 발생");
			e.printStackTrace();
		} finally {
			mainService.memberDAO.close();
			input.close();
		}

	}

	public void memberMenu(Scanner input) throws SQLException {
		boolean run = true;
		while (run) {
			System.out.println("===== 회원 서비스 메뉴 =====");
			System.out.println("1. 전체 회원 보기 <readAll>");
			System.out.println("2. 회원 가입 <insert>");
			System.out.println("3. 회원 조회 <readOne>");
			System.out.println("4. 회원 탈퇴 <delete>");
			System.out.println("5. 비밀번호 수정 <update>");
			System.out.println("6. 종료");
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
				System.out.println("회원 서비스를 종료합니다.");
				run = false;
				break;
			case "4486":
				System.out.println("김기원 선생님 존경합니다.");
			default:
				System.out.println("올바른 메뉴 번호를 선택하세요.");
			}
		}
	}

	private void readAll(Scanner input) throws SQLException {
		memberDAO.selectAllMembers();
	}

	private void insert(Scanner input) throws SQLException {
		System.out.println("[회원 가입]");
		System.out.print("이름 입력: ");
		String bwriter = input.nextLine();

		System.out.print("ID 입력: ");
		String id = input.nextLine();

		System.out.print("비밀번호 입력: ");
		String pw = input.nextLine();

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setBwriter(bwriter);
		memberDTO.setId(id);
		memberDTO.setPw(pw);

		memberDAO.insertMember(memberDTO);
	}

	private void readOne(Scanner input) throws SQLException {
		System.out.print("조회할 회원 ID 입력: ");
		String id = input.nextLine();

		MemberDTO memberDTO = memberDAO.selectOne(id);

		if (memberDTO != null) {
			System.out.println("===== 회원 정보 =====");
			System.out.println("회원번호: " + memberDTO.getMno());
			System.out.println("이름: " + memberDTO.getBwriter());
			System.out.println("ID: " + memberDTO.getId());
			System.out.println("비밀번호: " + memberDTO.getPw());
			System.out.println("가입일자: " + memberDTO.getRegidate());
		} else {
			System.out.println("해당 ID의 회원이 존재하지 않습니다.");
		}
	}

	private void delete(Scanner input) throws SQLException {
		System.out.print("탈퇴할 회원 ID 입력: ");
		String id = input.nextLine();

		int result = memberDAO.deleteOne(id);
		if (result > 0) {
			System.out.println("회원 탈퇴가 완료되었습니다.");
		} else {
			System.out.println("해당 ID의 회원이 존재하지 않습니다.");
		}
	}

	private void update(Scanner input) throws SQLException {
		System.out.print("비밀번호를 수정할 회원 ID 입력: ");
		String id = input.nextLine();

		System.out.print("새 비밀번호 입력: ");
		String newPw = input.nextLine();

		int result = memberDAO.updatePassword(id, newPw);
		if (result > 0) {
			System.out.println("비밀번호가 성공적으로 수정되었습니다.");
		} else {
			System.out.println("해당 ID의 회원이 존재하지 않습니다.");
		}
	}
}
