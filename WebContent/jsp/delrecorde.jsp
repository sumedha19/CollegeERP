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
String r=(String)request.getAttribute("empv");
String strsql="select * from employee where emp_id=?";
ResultSet rs1=CrudOperation.getData(strsql,r);
if(rs1.next())
try
{
%>
<div style="background-color:#f7f7f7;width:900px;margin-left:100px;height:400px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<table cellspacing="20px" align="center">
<tr><th>Employee ID :</th><td><%=rs1.getString("emp_id")%></td>
<th>Name :</th><td><%=rs1.getString("name")%><br></td></tr>
<tr><th>Permanent Address :</th><td><%=rs1.getString("address_per")%></td>
<th>Residential Address :</th><td><%=rs1.getString("address_res") %></td></tr>
<tr><th>Email :</th><td><%=rs1.getString("email")%></td>
<th>Gender :</th><td><%=rs1.getString("gender") %></td></tr>
<tr><th>DOB :</th><td><%=rs1.getString("dob")%></td><th>DOJ :</th><td><%=rs1.getString("doj") %></td></tr>
<tr><th>Phone NO :</th><td><%=rs1.getLong("phoneno") %></td>
<th>Qualification :</th><td><%=rs1.getString("qual") %></td></tr>
<tr><th>Salary :</th><td><%=rs1.getString("salary") %></td>
<th>Experience :</th><td><%=rs1.getInt("exp") %></td></tr>
<tr><th>Type :</th><td><%=rs1.getString("type") %></td>
<th>Department Id :</th><td><%=rs1.getString("dept_id") %></td></tr>

</table>
<form method="post" action="/college_erp/Delrecc">
<input type="text" name="r" value='<%=rs1.getString("emp_id")%>' style="display:none">
<button style="width:120px;height:30px;margin-left:150px;float:left;margin-top:20px">Delete Record</button>
</form>
<%
}
catch(Exception e)
{
	
}
%>
</div>
</body>
</html>