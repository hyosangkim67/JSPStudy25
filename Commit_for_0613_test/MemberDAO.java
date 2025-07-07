package test_0613;

import java.sql.*;

public class MemberDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.173:1521:xe", "boardtest",
					"boardtest");
			connection.setAutoCommit(false);
		} catch (Exception e) {
			System.out.println("DB 연결 실패: ojdbc 드라이버 또는 접속 정보 확인");
			e.printStackTrace();
			System.exit(0);
		}
	}

	// 자원 해제 메서드
	public void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("DB 자원 해제 중 오류 발생");
			e.printStackTrace();
		}
	}

	public void selectAllMembers() throws SQLException {
		String sql = "SELECT * FROM member ORDER BY mno ASC";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			System.out.println("[전체 회원 목록]");
			System.out.printf("%-3s %-10s %-10s %-10s %-15s\n", "♡", "이름", "ID", "비밀번호", "가입 일자");
			System.out.println("------------------------------------------------ ♡");

			while (resultSet.next()) {
				int mno = resultSet.getInt("mno");
				String bwriter = resultSet.getString("bwriter");
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				Date regidate = resultSet.getDate("regidate");

				System.out.printf("%-4d %-10s %-10s %-10s %-15s\n", mno, bwriter, id, pw, regidate.toString());
			}
		} catch (SQLException e) {
			System.out.println("selectAllMembers() 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertMember(MemberDTO dto) throws SQLException {
		String sql = "INSERT INTO member (mno, bwriter, id, pw, regidate) VALUES (board_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getBwriter());
			preparedStatement.setString(2, dto.getId());
			preparedStatement.setString(3, dto.getPw());

			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("[회원가입 성공]");
				connection.commit();
			} else {
				System.out.println("[회원가입 실패]");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("insertMember() 오류");
			e.printStackTrace();
			connection.rollback();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public MemberDTO selectOne(String id) throws SQLException {
		MemberDTO dto = null;
		String sql = "SELECT * FROM member WHERE id = ?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				dto = new MemberDTO();
				dto.setMno(resultSet.getInt("mno"));
				dto.setBwriter(resultSet.getString("bwriter"));
				dto.setId(resultSet.getString("id"));
				dto.setPw(resultSet.getString("pw"));
				dto.setRegidate(resultSet.getDate("regidate"));
			}
		} catch (SQLException e) {
			System.out.println("selectOne() 오류 발생");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	public int deleteOne(String id) throws SQLException {
		String sql = "DELETE FROM member WHERE id = ?";
		int result = 0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("deleteOne() 오류 발생");
			e.printStackTrace();
			connection.rollback();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int updatePassword(String id, String newPw) throws SQLException {
		String sql = "UPDATE member SET pw = ?, regidate = SYSDATE WHERE id = ?";
		int result = 0;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newPw);
			preparedStatement.setString(2, id);
			result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("updatePassword() 오류 발생");
			e.printStackTrace();
			connection.rollback();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
