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
<div style="width:600px;height:350px;background-color:#f7f7f7;margin-left:100px;margin-top:50px">
<form method="post" action="/college_erp/Addhostel">
<table cellspacing="20px" style="margin-left:100px;margin-top:10px;float:left">
<tr><td>Hostel Name :</td><td><input type="text" name="name" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Location :</td><td><input type="text" name="loc" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Type :</td><td><select name="cs" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def">Select Type</option>
<option value="g">girls hostel</option>
<option value="b">boys hostel</option>
<option value="s">staff hostel</option>
</select></td></tr>
<tr><td>No. of floors :</td><td><input type="number" name="floor" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Rooms/Floor :</td><td><input type="number" name="room" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td><input type="submit" value="Add"></td><td><input type="Reset" value="Reset"></td></tr>
</table>
<div style="color:blue;margin-left:120px;float:left">${param.message}</div>
</form>
</div>
</body>
</html>