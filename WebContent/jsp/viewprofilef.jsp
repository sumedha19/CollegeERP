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
String s="select * from employee where emp_id=?";
HttpSession hs=null;
hs=request.getSession(false);
String uid=(String)hs.getAttribute("uinfo");

try
		{
			
			
			ResultSet rs1=CrudOperation.getData(s,uid);
			if(rs1.next())
			{%>
		<div style="margin-top:70px;margin-left:120px;font-size:20px">		
		<table cellspacing=5px style="width:800px;text-align: left">
				<tr><th>Employee Id </th><td><%=rs1.getString("emp_id") %></td><th>Name   </th><td><%=rs1.getString("name")%></td></tr>
				<tr><th>Address(permanent)  </th><td><%=rs1.getString("address_per") %></td><th>Address(residential)  </th><td><%=rs1.getString("address_res") %></td></tr>
				<tr><th>Email  </th><td><%=rs1.getString("email") %></td><th>Gender  </th><td><%=rs1.getString("gender") %></td></tr>
				<tr><th>PhoneNo  </th><td><%=rs1.getString("phoneno") %></td><th>Department Id   </th><td><%=rs1.getString("dept_id") %></td></tr>
				<tr><th>DOB  </th><td><%=rs1.getString("dob") %></td><th>Qualification </th><td><%=rs1.getString("qual") %></td></tr>
				<tr><th>Experience  </th><td><%=rs1.getInt("exp") %> years</td></tr>
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