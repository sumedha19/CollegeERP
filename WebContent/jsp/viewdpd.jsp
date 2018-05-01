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
<table border=1 cellspacing=0 style="width:1000px;margin-left:60px;margin-top:80px;text-align:center;">
<tr style='background-color:#b1b1b1'><th>Emp_id</th><th>Name</th><th>Address(per)</th><th>Address(res)</th><th>Phoneno</th><th>Email</th>
<th>Qualification</th><th>Experience</th><th>DOB</th><th>DOJ</th><th>Salary</th><th>Dept_id</th><th>Type</th></tr>
<%
String dp=request.getParameter("dp");
String str="select * from employee where dept_id=? ORDER BY emp_id";
ResultSet rs=CrudOperation.getData(str,dp);
int f=0;
try
{
while(rs.next())
{	
	f=1;
%>
<tr><td><%=rs.getString("emp_id") %></td><td><%=rs.getString("name") %></td><td><%=rs.getString("address_per") %></td>
<td><%=rs.getString("address_res") %></td><td><%=rs.getLong("phoneno") %></td><td><%=rs.getString("email") %></td><td><%=rs.getString("qual") %></td>
<td><%=rs.getInt("exp") %></td><td><%=rs.getDate("dob") %></td><td><%=rs.getDate("doj")%></td><td><%=rs.getLong("salary") %></td>
<td><%=rs.getString("dept_id") %></td><td><%=rs.getString("type") %></td></tr>
<%
}
}
catch(Exception e)
{
	
}
if(f==0)
{
	String message1 = "Record not found";
	response.sendRedirect("/college_erp/jsp/employeemd.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
}
%>
</table>
</div>
</body>
</html>