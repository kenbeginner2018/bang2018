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
List <GoodsBean>shopList = (List <GoodsBean>)session.getAttribute("shopList");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8}" />
<title>Insert title here</title>
</head>
<body>
<h1>ショッピングカート</h1>
<%
	ArrayList<GoodsBean> goods = (ArrayList<GoodsBean>)request.getAttribute("goods");
	for (GoodsBean good:goods){
%>
<table border="1" summary="カート内容一覧">
	<tr class="genre2">
		<td class="col1">商品名</td>
		<td class="col2">製作者</td>
		<td class="col3">ジャンル</td>
		<td class="col4">ディスク形態</td>
		<td class="col5">価格</td>
		<td class="col6">個数</td>
		<td></td>
	</tr>
	<tr>
	<form action="good" method="post">
	<%--仮にカートに入れた商品データの配列変数を、「cList」にしてます --%>
	<%for(GoodsBean cList:cartList){%>
		<td><p><%=cList.getGoodsName() %></p></td>
		<td><p><%=cList.getCreater() %></p></td>
		<td></td>
		<td></td>
		<td><p><%=cList.getPrice()%></p></td>
		<td>
			<input type="submit" name="btn" value="削除" />
		</td>
	<%
		}
	%>
	</form>
	</tr>
</table>
	<form action="good" method="post">
	<p class="marginLeft">
		<input type="submit" name="btn" value="購入手続きに進む" />
		<%--<input type="hidden" name="goodId" value="<%=order.getorderId() " />--%>
	</p>
	</form>
	<a href="/main.jsp">TOPに戻りショッピングを続ける</a>
</body>
</html>