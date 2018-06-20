<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "model.Customer" %>
<%@page import= "model.GoodsBean" %>
<%@page import= "java.util.ArrayList"%>
<%@page import= "java.util.List"%>


<%
Customer loginUser = (Customer)session.getAttribute("loginUser");
GoodsBean goodsBean = (GoodsBean)session.getAttribute("goodsBean");
List <GoodsBean>shopList = (List <GoodsBean>)session.getAttribute("shopList");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>トップページ</title>
</head>
<body>

<form action="/Test/SerchClass" method="post">
<p>検索したい商品名を入力して下さい</p>
	<input type="radio" name="Disc" value="CD" checked="checked"/> CD
	<input type="radio" name="Disc" value="DVD"/> DVD/Blu-ray
<p>
	<input type="text" name="keyword" value="" />
	<input type="hidden" name="btn" value="SearchClass" />
	<input type="submit" value="検索" />
</p>
</form>
<h1>商品一覧</h1>
<table border="1" summary="検索結果一覧">
	<tr class="genre2">
		<td class="col1">商品名</td>
		<td class="col2">製作者</td>
		<td class="col3">ジャンル</td>
		<td class="col4">ディスク形態</td>
		<td class="col5">価格</td>
		<td class="col6">個数</td>
	</tr>
	<%for(GoodsBean sList:shopList){%>
	<tr>
	<form action="shop" method="post">
		<td><p><%=sList.getGoodsName() %></p></td>
		<td><p><%=sList.getCreater() %></p></td>
		<td><p></p></td>
		<td><p></p></td>
		<td><p><%=sList.getPrice()%></p></td>
		<td>
			<p class ="marginLeft">
			<select name="count">
				<option value="1" selected="selected">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>
			</p>
		</td>
		<td>
			<input type="submit" name="btn" value="カートに入れる" />
			<%--<input type="hidden" name="goodId" value="<%=order.getorderId() " />--%>
		</td>
	<%
		}
	%>
	</form>
	</tr>
</table>
</body>
</html>