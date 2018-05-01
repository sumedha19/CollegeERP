<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*,java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
</head>
<body>
<div>
<h2 style="margin-left:100px;margin-top:30px;float:left">Student Details</h2>
<%
String roll=request.getParameter("roll");
String str="select * from student where rollno=?";
ResultSet rs=CrudOperation.getData(str,roll);
if(rs.next())
{
	try
	{
%>
<table border=1 cellspacing=0 style="width:900px;margin-left:100px;margin-top:80px;text-align:center;">
<tr><td style="width:300px">Roll No</td><td><%=rs.getString("rollno") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Name</td><td><%=rs.getString("name") %></td></tr>
<tr><td>Address</td><td><%=rs.getString("address") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Email Id</td><td><%=rs.getString("email") %></td></tr>
<tr><td>DOB</td><td><%=rs.getDate("dob") %></td></tr>
<tr style="background-color: #f7f7f7"><td>DOA</td><td><%=rs.getDate("doa") %></td></tr>
<tr><td>Current Semester</td><td><%=rs.getInt("current_sem") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Course Id</td><td><%=rs.getString("course_id") %></td></tr>
<tr><td>Phone No</td><td><%=rs.getLong("phoneno") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Passing Year</td><td><%=rs.getString("pass_yr") %></td></tr>
<tr><td>Hosteller</td><td><%if(rs.getBoolean("hostel")){%><%="yes" %><%}
else %><%="No" %></td></tr>
</table>
<%
	}
	catch(SQLException e)
	{
		
	}
}
else
{
	String message = "Rollno not found";
	response.sendRedirect("/college_erp/jsp/studentmd.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
}
%>
</div>
</body>
</html>