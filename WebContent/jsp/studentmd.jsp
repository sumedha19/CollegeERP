<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<script>
function check()
{

	var cs=document.getElementById("cs").value;
	if(cs=="def")
		{
		alert("Please select one value");
		return false;
		}
	return true;
}
</script>
</head>
<body>
<%
String str="select * from courses";
ResultSet rs=CrudOperation.getValue(str);
String st="select distinct pass_yr from student";
ResultSet rs1=CrudOperation.getValue(st);
%>
<div style="margin-left:150px;margin-top:100px;background-color: #f1f1f1;width:450px;height:200px;float:left">
<form method="get" action="/college_erp/jsp/viewrd.jsp" style="margin-top:30px;float:left;margin-left:20px" >
Search by Roll No : <input type="text" name="roll" required="required">
<input type="submit" value="GO"><br>
<div style="color:red">${param.message}</div>
</form>
<form method="get" action="/college_erp/jsp/viewcsd.jsp" style="margin-top:30px;margin-left:20px;float:left">
Search by Course : <br><select name="cs" id="cs" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def" required="required">Select Course</option>
<%
try
{ while(rs.next())
{
%>
<option value='<%=rs.getString("courseid") %>'><%=rs.getString("name") %></option>
<%}
}
catch(SQLException e)
{
	
}
%>
</select>
Select batch : <select name="bt" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="all" required="required">All</option>
<%
try
{ while(rs1.next())
{
%>
<option value='<%=rs1.getString("pass_yr") %>'><%=rs1.getString("pass_yr") %></option>
<%}
}
catch(SQLException e)
{
	
}
%>
</select>
<input type="submit" value="GO" onclick="return check()"><br>
<div style="color:red">${param.message1}</div>
</form>
</div>
</body>
</html>