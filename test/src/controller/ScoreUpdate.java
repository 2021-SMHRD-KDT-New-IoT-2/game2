package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScoreDAO;

@WebServlet("/ScoreUpdate")
public class ScoreUpdate extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String user_no = request.getParameter("user_no");
		String score = request.getParameter("score");
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String completed_date = now.format(formatter);

		ScoreDAO dao = new ScoreDAO();

		int cnt = dao.ScoreInsert(user_no, score, completed_date);


	}

}
