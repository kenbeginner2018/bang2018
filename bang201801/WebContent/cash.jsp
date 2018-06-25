<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.Customer" %>
<%@page import="model.GoodsBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
Customer loginUser = (Customer)session.getAttribute("loginUser");
GoodsBean goodsBean = (GoodsBean)session.getAttribute("goodsBean");
List <GoodsBean>cartList = (List <GoodsBean>)session.getAttribute("cartList");
int count = 0;
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>購入画面①</title>
</head>
<body>
	<h1>カート内容一覧</h1>

<table border="1" summary="商品購入一覧">

	<tr class="genre2">
		<td class="col1">商品名</td>
		<td class="col2">製作者</td>
		<td class="col3">ジャンル</td>
		<td class="col4">ディスク形態</td>
		<td class="col5">価格</td>
	</tr>


<%for(GoodsBean cList:cartList){%>


	<tr>
		<td><p><%=cList.getGoodsName() %></p></td>
		<td><p><%=cList.getCreater() %></p></td>
		<td><p></p></td>
		<td><p></p></td>
		<td><p><%=cList.getPrice()%></p></td>
		<td>
		</td>
	</tr>
	<p hidden>
		<%= count += cList.getPrice() %>
	</p>

<%}%>
</table>

</p>

合計金額は<%=count %>円です
<p>


	<p>
		<form action="payment.jsp" method="post">
		<input type = "submit" value = "支払方法入力へ進む"></input>
		</form>
	</p>

	<p>
		<form action = "/ShopSystem/cart" >
	    <input type="submit" value="カート画面へ"></input>
		</form>
	</p>
	<p>
		<form action = "/ShopSystem/Search">
	    <input type="submit" value="メイン画面へ"></input>
		</form>
	</p>

</body>
</html>