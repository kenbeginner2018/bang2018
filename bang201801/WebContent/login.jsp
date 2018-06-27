<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ログイン</title>
</head>
<body>


	&nbsp;&nbsp;&nbsp;


	<p>
		※IDとパスワードは、半角で入力してください
	</p>
	<form action="login" method="post">
		ユーザーID：<input type="text" name="id"/><br />
		パスワード：<input type="password" name="pass"/><br/>
		<p>
			<input type="submit" value="ログイン"/>
		</p>
	</form>

	<a href="/WEB-INF/AddAccount.jsp">新規登録</a>
<hr>
	<p>
		<form action = "/ShopSystem/Search">
	    	<input type="submit" value="TOP画面へ"></input>
		</form>
	</p>


</body>
</html>