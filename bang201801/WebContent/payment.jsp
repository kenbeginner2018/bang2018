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
	<form action="">
	 支払い方法：<select name="支払い方法">
	                <option>代引き</option>
	                <option>クレジットカード</option>
	             </select>
	配送日時指定：<select name="日付指定">
	                <option>日付</option>

	             </select>
	             <select name="時間指定">
	                <option>時間</option>
	             </select>
	住所：<input type="text" name="住所" />

 <textarea name="freeans" rows="4" cols="40"> 自由に意見を記述してください </textarea>
 </form>
 <a href="">次へ</a>
 <a href="">戻る</a>

</body>
</html>