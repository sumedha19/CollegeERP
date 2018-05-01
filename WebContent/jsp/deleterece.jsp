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
<div>
<form method="post" action="/college_erp/Delrece" style="margin-top:50px;margin-left:100px">
Enter Employee ID : <input type="text" name="emp" style="border-style:inset;border-color:#f1f1f1;" required="required">
<input type="submit" value="Search">
</form>
<div style="color:red;margin-left:100px">${param.message}</div>
</div>
</body>
</html>