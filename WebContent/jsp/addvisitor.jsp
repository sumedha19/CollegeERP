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
<div style="width:600px;height:460px;background-color:#f7f7f7;margin-left:100px;margin-top:40px">
<form method="post" action="/college_erp/Addvisitor">
<table cellspacing="20px" style="margin-left:100px;margin-top:10px;float:left">
<tr><td>Date of visit :</td><td><input type="date" name="dv" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Visitor's Name :</td><td><input type="text" name="vnm" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Vehicle No :</td><td><input type="text" name="vno" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Person to meet :</td><td><input type="text" name="pnm" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Person Type :</td><td><select name="cs" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def">Select Type</option>
<option value="s">student</option>
<option value="f">faculty</option>
<option value="d">director</option>
<option value="e">employee</option>
</select></td></tr>
<tr><td>Time In :</td><td><input type="time" name="tin" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Time Out :</td><td><input type="time" name="tout" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Phone No :</td><td><input type="number" name="phno" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td><input type="submit" value="Add"></td><td><input type="Reset" value="Reset"></td></tr>
</table>
<div style="color:blue;margin-left:120px;float:left">${param.message}</div>
</form>
</div>
</body>
</html>