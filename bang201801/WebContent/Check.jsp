<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8");
  String getPay = request.getParameter("pay");
  String getTime = request.getParameter("time");

  String getFreeans = request.getParameter("freeans");
  %>

  <% String getAddress = request.getParameter("address");
  %>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>購入確認画面</title>

<script type="text/javascript">
<!--

function check(){

	if(window.confirm('購入確定してよろしいですか？')){ // 確認ダイアログを表示

		return true; // 「OK」時は送信を実行

	}
	else{ // 「キャンセル」時の処理

		//window.alert('キャンセルされました');
	// 警告ダイアログを表示
		return false; // 送信を中止

	}

}

// -->
</script>

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

		<%if(getAddress!= null&&!getAddress.isEmpty()){%>

<%=getAddress %>

<%}else{ %>
<font size="5" color="red">住所を入力してください</font>

		<%} %>


		</td>
	</tr>
	</table>
	<p>
		<%=getFreeans %>
	</p>


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

	</tr>
	<p hidden>
		<%= count += cList.getPrice() %>
	</p>

<%}%>
</table>


合計金額は<%=count %>円です


	<form action="CompleteOrder.jsp" method="post"  onSubmit="return check()">

<%if(getAddress!= null&&!getAddress.isEmpty()){%>

<input type="submit" value=" 購入確定 " />

<%}else{ %>
<font size="5" color="red">住所を入力してください</font>

		<%} %>




	</form>
	<p>
		<a href="payment.jsp">支払方法入力へ戻る</a></p>
	<p>
		<a href="cart.jsp">カートへ戻る</a>
	</p>
	<p>
		<a href="main.jsp">TOPへ戻る</a>
	</p>

</body>
</html>