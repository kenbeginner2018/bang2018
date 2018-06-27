<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>
<%@page import="model.GoodsBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import= "model.AccountBean" %>

 <%
AccountBean account = (AccountBean)session.getAttribute("account");
GoodsBean goodsBean = (GoodsBean)session.getAttribute("goodsBean");
List <GoodsBean>cartList = (List <GoodsBean>)session.getAttribute("cartList");
int count = 0;
%>

<%--@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8}" />
<title>カート</title>
</head>
<body>

	<h1>カート内容</h1>

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
		<td><p><%=cList.getdGenreName() %></p></td>
		<td><p><%=cList.getDiscName() %></p></td>
		<td><p><%=cList.getPrice()%></p></td>

	</tr>
	<p hidden>
		<%= count += cList.getPrice() %>
	</p>

<%}%>
</table>

<p>


</p>

合計金額は<%=count %>円です
<p>
<%=request.getAttribute("message")%>
</p>
<p>
	<form action="/ShopSystem/LoginCheck">
			<input type="submit" name="btn" value="購入手続きに進む" />
	</form>
</p>
	<form action = "/ShopSystem/cart" method = "post">
		<input type="hidden" name="clear" value="clear"></input>
 		<input type="submit" value="カートを空にする"></input>
	</form>
<hr>
	<div style="display:inline-flex">
	<p>
		<form action = "/ShopSystem/Search">
	    	<input type="submit" value="TOP画面へ"></input>
		</form>
	</p>
	</div>
</body>
</html>