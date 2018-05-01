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
<div style="width:600px;height:400px;background-color:#f7f7f7;margin-left:100px;margin-top:40px">
<form method="post" action="/college_erp/Addrs">
<table cellspacing="20px" style="margin-left:100px;margin-top:10px;float:left">
<tr><td>Resource Name :</td><td><input type="text" name="rnm" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Total Amount :</td><td><input type="number" name="total" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Alloted to :</td><td><input type="text" name="ato" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Allotted Quantity :</td><td><input type="number" name="aq"  required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Date Allotted :</td><td><input type="date" name="da"  style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Return Date :</td><td><input type="date" name="dr"  style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td><input type="submit" value="Add"></td><td><input type="Reset" value="Reset"></td></tr>
</table>
<div style="color:blue;margin-left:120px;float:left">${param.message}</div>
</form>
</div>
</body>
</html>