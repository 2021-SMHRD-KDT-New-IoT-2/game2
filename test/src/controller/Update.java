package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		HttpSession session = request.getSession(); 
		
		MemberVO vo = (MemberVO)session.getAttribute("member");
		
		String pw = vo.getUser_pw();
		
		String user_no = request.getParameter("user_no");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.update(user_pw);
		
		if (cnt > 0) {

			MemberVO vo2 = new MemberVO(user_no, user_id, user_pw);
			
			session.setAttribute("member", vo2);
			
			response.sendRedirect("main.jsp");
		} else {

			response.sendRedirect("main.jsp");
		}
	}

}
