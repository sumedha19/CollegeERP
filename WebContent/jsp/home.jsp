<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>College | ERP</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<script>
var arr=new Array(3);
arr[0]="/college_erp/images/1.jpg";
arr[1]="/college_erp/images/3.jpg";
arr[2]="/college_erp/images/4.jpg";
var idx=0;
function changepic()
{
	document.getElementById("myimg").src=arr[idx];
	idx++;
	if(idx>2)
		idx=0;
	setTimeout("changepic()",4000);
	}
</script>
</head>
<body background="/college_erp/images/i1.jpg" onload="changepic()" style="margin:0px 0px 0px 0px">
<div style="height:600px;width:500px;float:left">
<img id="myimg" src="/college_erp/images/1.jpg">
</div>
<div style="margin-right:20px;float:right"><a href="/college_erp/html/contactus.html" style="text-decoration:underline; ;color:white">Contact Us</a></div>
<div style="margin-right:20px;float:right"><a href="/college_erp/html/aboutus.html" style="text-decoration:underline; ;color:white">About Us</a></div>
<div style="margin-top:70px;color:white;height:100px;width:780px;margin-left:60px;font-family:Comic Sans MS;font-size:40px;float:left">
Welcome to College ERP System!<br>
Please Login to continue..
</div>
<div style="margin-top:80px;margin-left:150px;height:270px;width:500px;background-color:white;font-family:Comic Sans MS;font-size:30px;float:left;opacity: 0.8;filter: alpha(opacity=50);">
<div style="font-size:30px;width:220px;font-weight: bold;height:50px;float:left">&nbspExisting user?</div>
<div style="font-size:20px;width:150px;float:left;font-weight: bold;margin-left:10px;margin-top:10px">Log In</div>
<div style="height:200px;font-size:15px;float:left;margin-left:50px;margin-top:20px">
<form method="post" action="/college_erp/Login">
User Id*&nbsp&nbsp&nbsp&nbsp<input type="text" name="userid" id="uid" placeholder="Enter UserId Here" required="required" style="width:250px;height:27px;border-color:red"><br><br>
Password*&nbsp&nbsp<input type="password" name="userpass" id="upass" placeholder="Enter Password Here" required="required" style="width:250px;height:27px;border-color:red"><br><br>
<input type="submit" value="LOG IN" name="login" style="border-color: red;background-color: green;color:white;height:35px;width:70px;margin-left:80px;font-weight:bold;">
<div style="color:red;float:right;font-weight:lighter;margin-left:10px" id="in">&nbsp&nbsp${param.message}</div>
</form>
</div>
</div>
</body>
</html>