<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*,java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<script>
function check()
{
	var sb=document.getElementById("sb").value;
	var bt=document.getElementById("bt").value;
	if(sb=="def" || bt=="def")
		{
		alert("Please select one value");
		return false;
		}
	return true;
}
function checks()
{
	var sb=document.getElementById("sb1").value;
	var bt=document.getElementById("bt1").value;
	if(sb=="def" || bt=="def")
		{
		alert("Please select one value");
		return false;
		}
	return true;
}
</script>

</head>
<body>

<div style="width:400px;float:left;background-color:#f7f7f7;margin-left:100px;height:200px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<div style="margin-top:10px;margin-left:20px;text-decoration: underline;">Edit Student Marks</div>
<form method="post" action="/college_erp/jsp/editma.jsp" style="margin-left:50px;margin-top:20px">
<table>
<tr><td>Subject :</td><td><select name="sb" id="sb" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def" required="required">Select Subject</option>
<%
	String str1="select * from subjects";
ResultSet rs1=CrudOperation.getValue(str1);

try
{ while(rs1.next())
{
%>
<option value='<%=rs1.getString("sub_id") %>'><%=rs1.getString("name") %>(<%=rs1.getString("sub_id") %>)</option>
<%}
}
catch(SQLException e)
{
	
}
%>
</select></td></tr>
<tr><td>Batch :</td><td><select name="bt"  style="border-style:inset;border-color:#f1f1f1;" id="bt" required="required">
<option value="def">Select Batch</option>
<%
try
{
	String st="select distinct pass_yr from student";
	ResultSet rs2=CrudOperation.getValue(st);
	while(rs2.next())
	{%>
	<option value='<%=rs2.getString("pass_yr")%>'><%=rs2.getString("pass_yr")%></option>
	<%}
}
catch(Exception e)
{
	
}
	%>
</select></td></tr>
<tr><td>Student Id :</td><td><input type="text" name="roll"  required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td align="center"><input type="submit" value="GO" onclick="return check()"></td><td><input type="reset" value="Reset"></td></tr>
</table>
</form>
<div style="color:blue;margin-left:100px">${param.message}</div>
</div>
<div style="width:400px;float:left;background-color:#f7f7f7;margin-left:100px;height:200px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<div style="margin-top:10px;margin-left:20px;text-decoration: underline;">Delete Student Marks</div>
<form method="post" action="/college_erp/Delmarks" style="margin-top:20px;margin-left:30px">
<table>
<tr><td>Subject :</td><td><select name="sb" id="sb1" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def" required="required">Select Subject</option>
<%
	String str2="select * from subjects";
ResultSet rs3=CrudOperation.getValue(str1);

try
{ while(rs3.next())
{
%>
<option value='<%=rs3.getString("sub_id") %>'><%=rs3.getString("name") %>(<%=rs3.getString("sub_id") %>)</option>
<%}
}
catch(SQLException e)
{
	
}
%>
</select></td></tr>
<tr><td>Batch :</td><td><select name="bt"  style="border-style:inset;border-color:#f1f1f1;" id="bt1" required="required">
<option value="def">Select Batch</option>
<%
try
{
	String st="select distinct pass_yr from student";
	ResultSet rs2=CrudOperation.getValue(st);
	while(rs2.next())
	{%>
	<option value='<%=rs2.getString("pass_yr")%>'><%=rs2.getString("pass_yr")%></option>
	<%}
}
catch(Exception e)
{
	
}
	%>
</select></td></tr>
<tr><td>Student Id :</td><td><input type="text" name="roll"  required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><td align="center"><input type="submit" value="Delete" onclick="return checks()"></td><td><input type="reset" value="Reset"></td></tr>
</table>
</form>
<div style="color:blue;margin-left:100px">${param.message1}</div>

</div>

</body>
</html>