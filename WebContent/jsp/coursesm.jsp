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

<div style="width:400px;float:left;background-color:#f7f7f7;margin-left:100px;height:200px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<div style="margin-top:10px;margin-left:20px;text-decoration: underline;">Add New Course</div>
<form method="post" action="/college_erp/Addcourses" style="margin-left:50px;margin-top:20px">
<table>
<tr><td>Course Id :</td><td><input type="text" name="cid" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>Name :</td><td><input type="text" name="nm"  required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td>No of Semester :</td><td><input type="number" name="sem"  required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td align="center"><input type="submit" value="Add"></td><td><input type="reset" value="Reset"></td></tr>
</table>
</form>
<div style="color:blue;margin-left:100px">${param.message}</div>
</div>
<div style="width:400px;float:left;background-color:#f7f7f7;margin-left:100px;height:200px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<div style="margin-top:10px;margin-left:20px;text-decoration: underline;">Delete Course</div>
<form method="post" action="/college_erp/Deletecourses" style="margin-top:50px;margin-left:50px">
Enter Course Id : <input type="text" name="cid" style="border-style:inset;border-color:#f1f1f1;" required="required"><br><br>
<input type="submit" value="Delete" style="margin-left:135px">
</form>
<div style="color:red;margin-left:100px">${param.message1}</div>

</div>

</body>
</html>