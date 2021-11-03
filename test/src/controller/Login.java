package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDAO;
import model.UserVO;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");

		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("pw");

		UserDAO dao = new UserDAO();

		UserVO vo = dao.login(user_id, user_pw);

		if (vo != null) {
			System.out.println("로그인성공");
			HttpSession session = request.getSession();

			session.setAttribute("user", vo);

			response.sendRedirect("Main.jsp");

		} else {
			System.out.println("로그인실패");
			response.sendRedirect("Main.jsp");
		}
	}
}
