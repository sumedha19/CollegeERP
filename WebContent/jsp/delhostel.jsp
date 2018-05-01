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

<div style="width:400px;float:left;background-color:#f7f7f7;margin-left:100px;height:200px;margin-top:30px;border-style:solid;border-color:#f1f1f1">
<div style="margin-top:10px;margin-left:20px;text-decoration: underline;">Delete Hostel</div>
<form method="post" action="/college_erp/Delhostel" style="margin-left:50px;margin-top:20px">
Enter Hostel Name :<br><br><input type="text" name="hid" style="border-style:inset;border-color:#f1f1f1;margin-left:3px" required="required">
<input type="submit" value="Delete" style="margin-left:200px;margin-top:-23px">
</form>
<div style="color:blue;margin-left:100px">${param.message1}</div>
</div>
<div style="width:400px;float:left;background-color:#f7f7f7;margin-left:100px;height:200px;margin-top:40px;border-style:solid;border-color:#f1f1f1">
<div style="margin-top:10px;margin-left:20px;text-decoration: underline;">Delete Hosteller</div>
<form method="post" action="/college_erp/DelHosteller" style="margin-top:30px;margin-left:30px">
Enter Student/Employee Id : <br><br><input type="text" name="id" style="border-style:inset;border-color:#f1f1f1;" required="required">
<input type="submit" value="Delete" style="margin-left:200px;margin-top:-23px">
</form>
<div style="color:blue;margin-left:100px">${param.message}</div>

</div>

</body>
</html>