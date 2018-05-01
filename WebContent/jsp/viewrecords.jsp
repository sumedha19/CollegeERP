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
<%
String r=(String)request.getAttribute("rollv");
String strsql="select * from student where rollno=?";
ResultSet rs1=CrudOperation.getData(strsql,r);
if(rs1.next())
try
{
%>
<form method="post" action="/college_erp/Topdfstd" style="margin-left:800px;float:left;margin-top:20px">
<input type="text" name="roll" value='<%=r %>' style="display:none">
<input type="submit" value="Export as pdf" style="background-color:white">
</form>

<div style="background-color:#f7f7f7;width:900px;margin-left:100px;float:left;height:400px;margin-top:50px;border-style:solid;border-color:#f1f1f1">
<table cellspacing="20px" align="center">
<tr><th>Roll no :</th><td><%=rs1.getString("rollno")%></td>
<th>Name :</th><td><%=rs1.getString("name")%><br></td></tr>
<tr><th>Address :</th><td><%=rs1.getString("address")%></td>

<th>Email :</th><td><%=rs1.getString("email")%><br></td></tr>
<tr><th>Gender :</th><td><%=rs1.getString("gender") %></td>
<th>DOB :</th><td><%=rs1.getString("dob")%></td>
</tr>
<tr><th>DOA :</th><td><%=rs1.getString("doa")%></td>
<th>Current_sem :</th><td><%=rs1.getString("current_sem")%></td></tr>
<tr><th>Course :</th><td><%=rs1.getString("course_id")%>
</td><th>Phone No :</th><td><%=rs1.getString("phoneno")%></td></tr>
<tr><th>Hostel :</th><td><%=rs1.getString("hostel")%></td>
<th>Batch :</th><td><%=rs1.getString("pass_yr") %></td></tr>

</table>
<%
}
catch(Exception e)
{
	
}
%>
</div>
</body>
</html>