package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;

@WebServlet("/Delete")
public class Delete extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");

		String user_id = request.getParameter("user_id");

		UserDAO dao = new UserDAO();

		int cnt = dao.delete(user_id);

		if (cnt > 0) {
			System.out.println("삭제성공!");
			response.sendRedirect("Select.jsp");
		} else {
			System.out.println("삭제실패!");
			response.sendRedirect("Select.jsp");
		}
	}
}
