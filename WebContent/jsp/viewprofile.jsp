<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<title>Insert title here</title>
</head>
<body>
<%
String s="select * from student where rollno=?";
HttpSession hs=null;
hs=request.getSession(false);
String uid=(String)hs.getAttribute("uinfo");

try
		{
			
			
			ResultSet rs1=CrudOperation.getData(s,uid);
			if(rs1.next())
			{%>
		<div style="margin-top:70px;margin-left:150px;font-size:20px">		
		<table cellspacing=5px style="width:700px;text-align: left">
				<tr><th>Roll No </th><td><%=rs1.getString("rollno") %></td></tr>
				<tr><th>Name   </th><td><%=rs1.getString("name")%></td></tr>
				<tr><th>Address  </th><td><%=rs1.getString("address") %></td></tr>
				<tr><th>Email  </th><td><%=rs1.getString("email") %></td></tr>
				<tr><th>Gender  </th><td><%=rs1.getString("gender") %></td></tr>
				<tr><th>PhoneNo  </th><td><%=rs1.getString("phoneNo") %></td></tr>
				<tr><th>Course Id   </th><td><%=rs1.getString("course_id") %></td></tr>
				<tr><th>Semester   </th><td><%=rs1.getString("current_sem") %></td></tr>
				<tr><th>Batch     </th><td><%=rs1.getString("pass_yr") %></td></tr>
				</table>
				</div>
				<% }
		}
			catch(SQLException e)
			{
				
			}
%>
</body>
</html>