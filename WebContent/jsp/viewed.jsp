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
<h2 style="margin-left:100px;margin-top:30px;float:left">Employee Details</h2>
<%
String eid=request.getParameter("eid");
String str="select * from employee where emp_id=?";
ResultSet rs=CrudOperation.getData(str,eid);
if(rs.next())
{
	try
	{
%>
<table border=1 cellspacing=0 style="width:900px;margin-left:100px;margin-top:80px;text-align:center;">
<tr><td style="width:300px">Employee Id</td><td><%=rs.getString("emp_id") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Name</td><td><%=rs.getString("name") %></td></tr>
<tr><td>Address(permanent)</td><td><%=rs.getString("address_per") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Address(residential)</td><td><%=rs.getString("address_res") %></td></tr>
<tr><td>DOB</td><td><%=rs.getDate("dob") %></td></tr>
<tr style="background-color: #f7f7f7"><td>DOJ</td><td><%=rs.getDate("doj") %></td></tr>
<tr><td>Email Id</td><td><%=rs.getString("email") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Qualification</td><td><%=rs.getString("qual") %></td></tr>
<tr><td>Phone No</td><td><%=rs.getLong("phoneno") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Experience</td><td><%=rs.getInt("exp") %></td></tr>
<tr><td>Salary</td><td><%=rs.getLong("salary") %></td></tr>
<tr style="background-color: #f7f7f7"><td>Department Id</td><td><%=rs.getString("dept_id") %></td></tr>
<tr><td>Type</td><td><%=rs.getString("type") %></td></tr>
</table>
<%
	}
	catch(SQLException e)
	{
		
	}
}
else
{
	String message = "Employee Id not found";
	response.sendRedirect("/college_erp/jsp/employeemd.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
}
%>
</div>
</body>
</html>