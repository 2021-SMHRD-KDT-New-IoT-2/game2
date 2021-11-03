<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/script.js" defer></script>
<style>
.login>form>input:nth-child(1),.login>form>input:nth-child(2){
	color: #fff;
	font-size: 18px;
}
</style>

</head>
<body>
	<%
		// ���� �α��� ���� �Ǻ� (vo == null => ��α��λ���)
		MemberVO vo = (MemberVO)session.getAttribute("user");
	%>
	<div class="wrap">
        <div class="circle">
            <a href="GamePlay.jsp"><span>GAME START</span></a>
        </div>
        
        <div class="tri">
            <img src="img/zz.png" alt="">
        </div>
        <%if(vo == null){%>
        <div class="squ">
            <div>
                <a href="#">LOGIN</a>
            </div>
            <div>
                <a href="#">JOIN</a>
            </div>
        </div>
        <%}else{ %>
        <div class="squ" style="width:400px;">
            <div style="width:200px">
                <a href="MyPage.jsp">����������</a>
            </div>
            <div style="width:200px">
                <a href="Logout">�α׾ƿ�</a>
            </div>
        </div>
        <span class="wc">WELCOME!<br> Your number is <%=vo.getUser_no() %></span>
        <%if(vo.getUser_id().equals("admin")) {%>
           	<a href="Select.jsp" class="admin">���� ����</a>
			<%} %>
        <%} %>
    </div>

    <div class="login">
        <span>�α���</span>
        <form action="Login" method="post">
            <input type="text" placeholder="ID" name="id">
            <input type="password" placeholder="PASSWORD" name="pw">
            <input class="login_btn" type="submit" value="LOGIN">
        </form>
        <div class="login_close"><img src="img/xx.png" alt=""></div>
    </div>

    <div class="join">
        <span>ȸ������</span>
        <form action="Join" method="post">
            <div>
                <span>ID</span>
                <span>PASSWORD</span>
            </div>
            <div>
               <input type="text" name="id" id="name">
                <input type="password" name="pw"> 
            </div>
            <div>
                <input type="button" value="ID�ߺ�üũ" onclick="idCheck()">
                <span id = "sp_result"></span>    
            </div>
            <div>
                <input class="join_btn" type="submit" value="JOINS">
                <input type="reset" value="RESET">    
            </div>
            
        </form>
        <div class="join_close"><img src="img/xx.png" alt=""></div>
    </div>
	    
	<script>
    function idCheck(){
				 
	var input = document.getElementById("name");
				
		$.ajax({
		  type : "post", //������ ����(��û) ���
		  data : {"id" : input.value}, //�����ϴ� ������
		  url : "idcheck", //�����͸� �����ϴ�(��û�ϴ�) ���� ������ url
		  dataType : "text", //���䵥������ ����
		  success : function(data){ //��� ����
			  var sp_result = document.getElementById("sp_result");
			  
			  if(data=="true"){
				  sp_result.innerText = "��� �Ұ����� ���̵�";
			  }else{
				  $("#sp_result").text("��� ������ ���̵�");
			  }
		  },
		  error : function(){ //��� ����
			  alert("��� ����!!");
			}
	  	});
 	}
	</script>
</body>
</html>