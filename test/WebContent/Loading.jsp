<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
/* page-loading */
#loading {
  	width: 100%;
  	height: 100%;
  	top: 0;
  	left: 0;
  	position: fixed;
  	display: block;
  	
  	background: #e4e4e4;
  	z-index: 99;
  	text-align: center;
  }

  #loading > img {
  	position: absolute;
  	top: 30%;
  	left: 42%;
  	z-index: 50;
  }
   #loading > p {
    	position: absolute;
    	top: 57%;
    	left: 43%;
    	z-index: 101;
        font-size: 20px;
    }
    </style>
</head>
<body>
<!--�ε���-->
<div id="loading" style="margin-left: 0px;">
    <img src="img/pblue-export.gif">
    <p>456���� Ż �غ� �Ǽ̽��ϱ�</p>
</div>
<script>
//�α��ι�ư�� ������ �ε�â�� �߰��ϴ�
    $(document).ready(function() {
    
    $('#loading').hide();
    $('#trans').submit(function(){
        $('#loading').show();
        return true;
        });
    });
    
    </script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>