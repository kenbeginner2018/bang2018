<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>支払い手続き</title>
</head>
<body>
<h1>支払情報を入力してください</h1>
	<form action="Check.jsp" method="get" onSubmit="return check()">

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
			<textarea name="address" rows="4" cols="40"></textarea>
		</td>
	</tr>

</table>

<p>ご自由にお書きください（例：不在時の宅配ボックスの利用）</p>
<p>
 <textarea name="freeans" rows="4" cols="40"></textarea>
</p>
※ご要望に沿えない場合もございます。ご了承ください。
	<p>
		<input type="submit" value="送信" />
	</p>
	<p>
		<input type="reset" value="入力内容クリア" />
	</p>
 </form>

 <hr>
 	<p>
		<form action = "/ShopSystem/cart" >
	    <input type="submit" value="カート画面に戻る"></input>
		</form>
	</p>
	<p>
		<form action = "/ShopSystem/Search">
	    <input type="submit" value="TOP画面へ"></input>
		</form>
	</p>

</body>
</html>