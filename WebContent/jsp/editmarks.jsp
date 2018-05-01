<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marks Management</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<script>
function check()
{

	var cs=document.getElementById("cs").value;
	var sb=document.getElementById("sb").value;
	var bt=document.getElementById("bt").value;
	if(cs=="def" || sb=="def" || bt=="def")
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

%>
<div style="margin-left:200px;margin-top:50px">
<form method="post" action="/college_erp/jsp/editm.jsp" >
<table cellspacing="10px">
<tr><td><label>Select Course : </label></td><td><select name="cs" style="border-style:inset;border-color:#f1f1f1;" id="cs">
<option value="def">Select Course</option>
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
</select></td></tr>
<tr><td><label>Select Subject :</label></td><%
HttpSession hs=null;
hs=request.getSession(false);
String uid=(String)hs.getAttribute("uinfo");
String strsql="select * from subjects where fac_id=?";
ResultSet rs1=CrudOperation.getData(strsql,uid);

%>
<td><select name="sb" style="border-style:inset;border-color:#f1f1f1;" required="required" id="sb">
<option value="def">Select Subject</option>
<%
try
{
	
	while(rs1.next())
{
%>
<option value='<%=rs1.getString("sub_id") %>'><%=rs1.getString("name") %></option>
<%}
}
catch(SQLException e)
{
System.out.println(e);	
}
%>

</select></td></tr>
<%
String st="select distinct pass_yr from student";
ResultSet rs2=CrudOperation.getValue(st);
%>
 <tr><td><label>Select Batch : </label></td><td><select name="batch"  style="border-style:inset;border-color:#f1f1f1;" id="bt" required="required">
<option value="def">Select Batch</option>
<%
try
{
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
</table>
<input type="submit" value="GO" style="margin-left:145px" onclick="return check()">
<div style="color:red;margin-left:200px;margin-top:-20px">${param.message}</div>
</form>

</div>

</body>
</html>