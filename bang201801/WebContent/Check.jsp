<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>購入確認画面</title>
</head>
<body>

	<h1>下記の内容で購入確定します</h1>
	<%
		ArrayList<GoodsBean> goods = (ArrayList<GoodsBean>)request.getAttribute("goods");%>
	<p>


	</p>

	<form action="" method="post">
	<p><%=request.getAttribute("message") %></p>



	<input type="submit" value=" 購入確定 " />

  <script>
    window.confirm("購入確定しますか？");
  </script>

	</form>
	<p>
		<a href="*****カート画面******.jsp">カートへ戻る</a>
	</p>
	<p>
		<a href="main.jsp">TOPへ戻る</a>
	</p>

</body>
</html>