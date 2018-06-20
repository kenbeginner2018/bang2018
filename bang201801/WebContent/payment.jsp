<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<h1>支払情報を入力してください</h1>
	<form action="Check.jsp" method="get">

<table border="1" summary="配達指定">
	<tr>
		<th>支払方法</th>
		<td>
			<input type="radio" name="pay" value="代引き" checked="checked" />代引き
			<input type="radio" name="pay" value="クレジットカード"  />クレジットカード

		</td>
	</tr>
	<tr>
		<th>配送日時指定</th>
		<td>
			<select name="time">
			<option value ="午前" selected="selected">午前</option>
			<option value="午後">午後</option>
            </select>
		</td>
	</tr>
	<tr>
		<th>住所</th>
		<td>
			<textarea name="address" rows="4" cols="40">住所を記述してください</textarea>
		</td>
	</tr>

</table>

<p>
 <textarea name="freeans" rows="4" cols="40"> 自由に意見を記述してください </textarea>
</p>

	<p>
		<input type="submit" value="送信" />
		<input type="reset" value="クリア" />
	</p>
 </form>

 <a href="main.jsp">戻る</a>

</body>
</html>