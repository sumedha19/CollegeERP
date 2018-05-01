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
<div style="width:450px;float:left;background-color:#f7f7f7;margin-left:100px;height:280px;margin-top:30px;border-style:solid;border-color:#f1f1f1">
<div style="margin-top:10px;margin-left:20px;text-decoration: underline;">Search Record</div>
<form method="post" action="/college_erp/Searchrs" style="margin-left:50px;margin-top:20px">
Enter Resource Name :<br><input type="text" name="rnm" style="border-style:inset;border-color:#f1f1f1;margin-left:3px" required="required"><br><br>
Allotted to :<br><input type="text" name="anm" style="border-style:inset;border-color:#f1f1f1;margin-left:3px" required="required"><br><br>
<input type="submit" value="Search" style="margin-left:0px;margin-top:10px">
</form>
<div style="color:blue;margin-left:110px;margin-top:-22px">${param.message}</div>
</div>
</body>
</html>