package mvc.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mvc.model.BoardDAO;
import mvc.model.BoardDTO;

public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final int LISTCOUNT = 5;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String RequestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = RequestURI.substring(contextPath.length());

        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        if (command.equals("/BoardListAction.do")) {
            requestBoardList(request);
            RequestDispatcher rd = request.getRequestDispatcher("./board/list.jsp");
            rd.forward(request, response);

        } else if (command.equals("/BoardWriteAction.do")) {
            requestBoardWrite(request);
            RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
            rd.forward(request, response);

        } else if (command.equals("/BoardViewAction.do")) {
            requestBoardView(request);
            RequestDispatcher rd = request.getRequestDispatcher("/BoardView.do");
            rd.forward(request, response);

        } else if (command.equals("/BoardView.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("./board/view.jsp");
            rd.forward(request, response);

        } else if (command.equals("/BoardUpdateAction.do")) {
            requestBoardUpdate(request);
            RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
            rd.forward(request, response);

        } else if (command.equals("/BoardDeleteAction.do")) {
            requestBoardDelete(request);
            RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
            rd.forward(request, response);
        }
    }

    public void requestBoardList(HttpServletRequest request) {
        BoardDAO dao = BoardDAO.getInstance();
        List<BoardDTO> boardList = dao.getBoardList(1, LISTCOUNT, "", ""); // 기본값 사용
        int totalRecord = dao.getListCount();

        request.setAttribute("boardlist", boardList);
        request.setAttribute("total_record", totalRecord);
        request.setAttribute("pageNum", 1); 
    }


    public void requestBoardWrite(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
            BoardDTO board = new BoardDTO();
            board.setId(request.getParameter("id"));
            board.setName(request.getParameter("name"));
            board.setSubject(request.getParameter("subject"));
            board.setContent(request.getParameter("content"));

            BoardDAO dao = BoardDAO.getInstance();
            dao.insertBoard(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void requestBoardView(HttpServletRequest request) {
        int num = Integer.parseInt(request.getParameter("num"));
        int page = Integer.parseInt(request.getParameter("page"));

        BoardDAO dao = BoardDAO.getInstance();
        dao.updateHit(num);
        BoardDTO board = dao.getBoardByNum(num, page);

        request.setAttribute("num", num);
        request.setAttribute("page", page);
        request.setAttribute("board", board);
    }


    public void requestBoardUpdate(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
            BoardDTO board = new BoardDTO();
            board.setNum(Integer.parseInt(request.getParameter("num")));
            board.setSubject(request.getParameter("subject"));
            board.setContent(request.getParameter("content"));

            BoardDAO dao = BoardDAO.getInstance();
            dao.updateBoard(board);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void requestBoardDelete(HttpServletRequest request) {
        int num = Integer.parseInt(request.getParameter("num"));

        BoardDAO dao = BoardDAO.getInstance();
        dao.deleteBoard(num);
    }

}
