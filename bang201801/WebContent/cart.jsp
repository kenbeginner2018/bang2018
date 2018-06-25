<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>
<%@page import="model.GoodsBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

 <%
Customer loginUser = (Customer)session.getAttribute("loginUser");
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
<title>Insert title here</title>
</head>
<body>

	<h1>カート</h1>

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

<p>


</p>

合計金額は<%=count %>円です
<p>
<%=request.getAttribute("message")%>
</p>

<form action = "/ShopSystem/cart" method = "post">
			  <input type="hidden" name="clear" value="clear"></input>
 			  <input type="submit" value="カートを空にする"></input>
</form>

	<p>
		<form action = "/ShopSystem/Search">
	    <input type="submit" value="メイン画面へ"></input>
		</form>
	</p>

	<form action="cash.jsp" method="post">
	<p class="marginLeft">
		<input type="submit" name="btn" value="購入手続きに進む" />

	</p>
	</form>
	</body>
</html>