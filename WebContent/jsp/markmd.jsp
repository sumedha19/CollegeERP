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
	var st=document.getElementById("sem").value;
	if(st=="def")
		{
		alert("Please select one value");
		return false;
		}
	return true;
	}
	function checks()
	{
		var st=document.getElementById("sb").value;
		var stt=document.getElementById("bt").value;
		if(st=="def" || stt=="def")
			{
				alert("Please select one value");
				return false;
				}
			return true;
	}
</script>
</head>
<body>
<div style="margin-left:150px;margin-top:100px;background-color: #f1f1f1;width:450px;height:250px;float:left">
<form method="get" action="/college_erp/jsp/viewmd.jsp" style="margin-top:30px;float:left;margin-left:20px" >
Search by Roll No :<br><input type="text" name="roll" required="required" placeholder="Enter Roll No Here">
<select name="sem" id="sem">
<option value="def">Select Semester</option>
<%
String str="select distinct sem from subjects ORDER BY sem";
ResultSet rs=CrudOperation.getValue(str);
try
{
	while(rs.next())
	{
%>
<option value='<%=rs.getInt("sem") %>'><%=rs.getInt("sem") %></option>
<%
	}
}
	catch(Exception e)
	{
		
	}
%>
</select>
<input type="submit" value="GO"  onclick="return check()"><br>
<div style="color:red">${param.message}</div>
</form>
<form method="get" action="/college_erp/jsp/viewsbd.jsp" style="margin-top:30px;margin-left:20px;float:left">
Search by Subject : <br><select name="sb" id="sb" style="border-style:inset;border-color:#f1f1f1;" required="required">
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
</select>
<%
String st="select distinct pass_yr from student";
ResultSet rs2=CrudOperation.getValue(st);
%>
<select name="bt" id="bt" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def" required="required">Select Batch</option>
<%
try
{ while(rs2.next())
{
%>
<option value='<%=rs2.getString("pass_yr") %>'><%=rs2.getString("pass_yr") %></option>
<%}
}
catch(SQLException e)
{
	
}
%>
</select>
<input type="submit" value="GO" onclick="return checks()"><br>
<div style="color:red">${param.message1}</div>
</form>
</div>
</body>
</html>