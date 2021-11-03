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

@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession(); 
		
		UserVO vo = (UserVO)session.getAttribute("user");
		
		String user_no = vo.getUser_no();
		String user_id = vo.getUser_id();
//		String pw = vo.getUser_pw();
		
//		String user_no = request.getParameter("user_no");
//		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("pw");
		
		
		UserDAO dao = new UserDAO();
		
		int cnt = dao.update(user_id, user_pw);
		
		if (cnt > 0) {
			System.out.println("수정성공!");
			
			UserVO vo2 = new UserVO(user_no, user_id);
			
			session.setAttribute("user", vo2);
			
			response.sendRedirect("Main.jsp");
		} else {
			System.out.println("수정실패!");
			response.sendRedirect("Main.jsp");
		}
	}

}
