<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
</head>
<body>
<div  style="margin-top:50px;height:100px;width:500px;margin-left:50px">
<form method="get" action="/college_erp/Viewall">
View all :<select name="cs" style="border-style:inset;border-color:#f1f1f1;margin-left:10px" required="required">
<option value="def">Select Option</option>
<option value="courses">Courses</option>
<option value="dept">Departments</option>
<option value="emp">Employees</option>
<option value="hostel">Hostels</option>
<option value="hostl">Hostellers</option>
<option value="rs">Resources</option>
<option value="std">Students</option>
<option value="sub">Subjects</option>
<option value="vis">Visitors</option>
<option value="marks">Marks</option>
<option value="att">Attendance</option>
<option value="user">Users</option>
</select>
<input type="submit" value="View" style="margin-left:20px">
${param.message}
</form>
</div>
 
</body>

</html>