package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mvc.database.DBConnection;

public class BoardDAO {

    private static BoardDAO instance;

    private BoardDAO() {
    }

    public static BoardDAO getInstance() {
        if (instance == null)
            instance = new BoardDAO();
        return instance;
    }

    public int getListCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM board";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public ArrayList<BoardDTO> getBoardList(int page, int limit, String items, String text) {
        ArrayList<BoardDTO> list = new ArrayList<>();
        String sql;

        int start = (page - 1) * limit;

        if (items == null || items.equals("")) {
            sql = "SELECT * FROM board ORDER BY num DESC LIMIT ?, ?";
        } else {
            sql = "SELECT * FROM board WHERE " + items + " LIKE ? ORDER BY num DESC LIMIT ?, ?";
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (items == null || items.equals("")) {
                pstmt.setInt(1, start);
                pstmt.setInt(2, limit);
            } else {
                pstmt.setString(1, "%" + text + "%");
                pstmt.setInt(2, start);
                pstmt.setInt(3, limit);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    BoardDTO board = new BoardDTO();
                    board.setNum(rs.getInt("num"));
                    board.setName(rs.getString("name"));
                    board.setSubject(rs.getString("subject"));
                    board.setContent(rs.getString("content"));
                    board.setHit(rs.getInt("hit"));
                    list.add(board);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getLoginNameById(String id) {
        String name = null;
        String sql = "SELECT name FROM member WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    name = rs.getString("name");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return name;
    }

    public void insertBoard(BoardDTO board) {
        String sql = "INSERT INTO board (id, name, subject, content) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, board.getId());
            pstmt.setString(2, board.getName());
            pstmt.setString(3, board.getSubject());
            pstmt.setString(4, board.getContent());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHit(int num) {
        String sql = "UPDATE board SET hit = hit + 1 WHERE num = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, num);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BoardDTO getBoardByNum(int num, int page) {
        BoardDTO board = null;
        String sql = "SELECT * FROM board WHERE num = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, num);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    board = new BoardDTO();
                    board.setNum(rs.getInt("num"));
                    board.setName(rs.getString("name"));
                    board.setSubject(rs.getString("subject"));
                    board.setContent(rs.getString("content"));
                    board.setHit(rs.getInt("hit"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return board;
    }

 
    public void updateBoard(BoardDTO board) {
        String sql = "UPDATE board SET subject = ?, content = ? WHERE num = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, board.getSubject());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getNum());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBoard(int num) {
        String sql = "DELETE FROM board WHERE num = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, num);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
