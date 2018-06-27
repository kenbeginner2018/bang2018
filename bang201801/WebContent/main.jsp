<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "model.AccountBean" %>
<%@page import= "model.GoodsBean" %>
<%@page import= "java.util.ArrayList"%>
<%@page import= "java.util.List"%>

<%
AccountBean account = (AccountBean)session.getAttribute("account");
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
<%if(account==null) {%>
<div style="display:inline-flex">
<form action = "login.jsp" >
	    <input type="submit" value="ログイン"></input>
</form>
&nbsp;&nbsp;&nbsp;
<%}else{ %>
<%=account.getCustomer_name()%>さん、ログイン中です。
<%} %>
<form action="/ShopSystem/LogoutService" method="poat" >

	<input type="submit" value="ログアウト"/>
</form >
</div>
<hr>

商品検索<form action="/ShopSystem/Search" method="get">
	<input type="text" name="title"/>
	<input type="submit" value="検索"/>
</form >

<h1>商品一覧</h1>
<table border="1" summary="検索結果一覧">
	<tr class="genre2">
		<td class="col1">商品名</td>
		<td class="col2">製作者</td>
		<td class="col3">ジャンル</td>
		<td class="col4">ディスク形態</td>
		<td class="col5">価格</td>
	</tr>


	<%for(GoodsBean sList:shopList) {%>

	<tr>
		<td><p><%=sList.getGoodsName() %></p></td>
		<td><p><%=sList.getCreater() %></p></td>
		<td><p><%=sList.getdGenreName() %></p></td>
		<td><p><%=sList.getDiscName() %></p></td>
		<td><p><%=sList.getPrice()%></p></td>
		<td>


			<form action = "/ShopSystem/cart" method = "get">
				<input type="hidden" name="itemNo" value="<%=sList.getGoodsId()%>"></input>
 			  	<input type="submit" value="カートへ"></input>
			</form>
		</td>
	</tr>

<%}%>

</table>
	<p>
	<%if(request.getAttribute("message") !=null) {%>
		<%=request.getAttribute("message")%>
	</p>
	<%}%>
<p>
	<form action = "/ShopSystem/cart" >
    	<input type="submit" value="カート確認画面へ"></input>
	</form>
</p>
	<p>
		<form action = "/ShopSystem/cart" method = "post" >
			  <input type="hidden" name="clear" value="clear"></input>
 			  <input type="submit" value="カートを空にする"></input>
		</form>
	</p>
<hr>
 	<p>
		<form action = "/ShopSystem/Search">
	    	<input type="submit" value="TOP画面へ"></input>
		</form>
	</p>

</body>
</html>