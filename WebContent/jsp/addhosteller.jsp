<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
</head>
<body>
<div style="width:600px;height:300px;background-color:#f7f7f7;margin-left:100px;margin-top:50px">
<form method="post" action="/college_erp/Addhosteller">
<table cellspacing="20px" style="margin-left:100px;margin-top:20px;float:left">
<tr><td>Hostel Name :</td><td><input type="text" name="nm" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Room no :</td><td><input type="number" name="room" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Student/Employee Id :</td><td><input type="text" name="id" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td><input type="submit" value="Add"></td><td><input type="Reset" value="Reset"></td></tr>
</table>
<div style="color:blue;margin-left:120px;float:left">${param.message}</div>
</form>
</div>
</body>
</html>