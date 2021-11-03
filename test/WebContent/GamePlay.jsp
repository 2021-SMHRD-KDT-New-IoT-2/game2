<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/reset.css">
</head>
<style>
    @font-face {
		font-family: 'gdgd';
		src: url(fonts/DungGeunMo.ttf) format('truetype');
	}
    body{
        height: 100vh;
        width: 100%;
        background: radial-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
        url(img/cap.png) no-repeat;
        background-size: cover;
        overflow: hidden;
        font-family: 'gdgd' !important;
    }
    .header{
        height: 100px;
        width: 100%;
    }
    .header figure{
        	width: 426px;
        	height: 100%;
        }
        .header a{
        	height: 100%;
        }
        .header a img{
        	height: 100px;
       	}
    .main{
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: space-around;
        align-items: center;
    }
    .play{
        width: 960px;
        height: 600px;
        background-color: #fff;
        transform: translateY(-5%);
    }
    .rank{
        width: 500px;
        height: 700px;
        transform: translateY(-5%);
        text-align: center;
        overflow: hidden;
    }
    .rank>span{
        color: #fff;
        font-size: 30px;
        letter-spacing: 3px;
        font-weight: bold;

    }
    .rank>button{
        position: absolute;
        right: 0;
    }
    .rank>ul{
        display: flex;
        justify-content: space-around;
        text-align: center;
        height: 40px;
        line-height: 40px;
    }
    .rank>ul>li{
        width: 100%;
        background-color: #999;
        margin: 2px;
        border-radius: 3px;
    }
    .rank>ul:nth-of-type(1) li{
        background-color: #333;
    }
    .rank>ul:first-child{
        height: 50px;
        line-height: 50px;
    }
    .reset{
        position: absolute;
        top: 18%;
        right: 7%;
        width: 100px;
        height: 30px;
        border-radius: 5px;
        border: none;
        background-color: #fff;
        font-size: 16px;
        cursor: pointer;
    }
</style>
<body>
    <header class="header">
        <figure>
            <a href="Main.jsp"><img src="img/logo3.png" alt="#"></a>
        </figure>
    </header>
    
    <div class="main">
        <div class="play">

        </div>
        <div class="rank">
            <span>RANK</span>
            <ul>
                <li>순위</li>
                <li>번호</li>
                <li>점수</li>
                <li>플레이날짜</li>
            </ul>
            <ul>
                <li>1</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>2</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>3</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>4</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>5</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>6</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>7</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>8</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>9</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>10</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>11</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>12</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>13</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>14</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
            <ul>
                <li>15</li>
                <li>1</li>
                <li>5000</li>
                <li>300</li>
            </ul>
        </div>
        <button class="reset">새로고침</button>
    </div>
</body>
</html>