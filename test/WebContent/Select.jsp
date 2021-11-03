<%@page import="model.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>유저 관리</title>
<link rel="stylesheet" href="css/zz.css">
<link rel="stylesheet" href="css/reset.css">
</head>
<body>
	<%
		UserDAO dao = new UserDAO();
		ArrayList<UserVO> al = dao.selectAll();
		// System.out.print(al.size());
	%>
	<figure class="logo">
		<a href="Main.jsp"><img src="img/logo3.png" alt=""></a>
	</figure>

	<div class="wrap">
		<table>
			<caption>
				<span>유저 관리</span>
			</caption>
			<tr>
				<th>NUMBER</th>
				<th>ID</th>
				<th>DELETE</th>
			</tr>
			<%-- <%for(int i = 0; i < al.size(); i++){ %>
			<tr>
				<td>
					<%out.print(al.get(i).getUser_no()); %>
				</td>
				<td>
					<%out.print(al.get(i).getUser_id()); %>
				</td>
			<tr>
			<%} %> --%>
			
			<%
				for(UserVO vo : al){
					out.print("<tr>");
					out.print("<td>"+vo.getUser_no()+"</td>");
					out.print("<td>"+vo.getUser_id()+"</td>");
					out.print("<td><a href='Delete?user_id="+vo.getUser_id()+"'>삭제</a></td>");
					out.print("</tr>");
				}
			%>
			
				<!-- 스크롤바 js -->
		</table>
	</div>
</body>
</html>