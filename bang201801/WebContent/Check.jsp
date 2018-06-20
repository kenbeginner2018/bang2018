<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8");
  String getPay = request.getParameter("pay");
  String getTime = request.getParameter("time");
  String getAddress = request.getParameter("address");
  String getFreeans = request.getParameter("freeans");

  %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>購入確認画面</title>
</head>
<body>

	<h1>下記の内容で購入確定します</h1>



	<table border="1" summary="配達指定">
	<tr>
		<th>支払方法</th>
		<td>
	<%=getPay %>
		</td>
	</tr>
	<tr>
		<th>配送日時指定</th>
		<td>
	<%=getTime %>
			</td>
	</tr>
	<tr>
		<th>住所</th>
		<td>
			<%=getAddress %>
		</td>
	</tr>
	</table>
<p>
<%=getFreeans %>
</p>





	<form action="CompleteOrder.jsp" method="post">
	<p><%=request.getAttribute("message") %></p>



	<input type="submit" value=" 購入確定 " />


	</form>
	<p>
		<a href="payment.jsp">支払情報入力へ戻る</a></p>
	<p>
		<a href="cart.jsp">カートへ戻る</a>
	</p>
	<p>
		<a href="main.jsp">TOPへ戻る</a>
	</p>

</body>
</html>