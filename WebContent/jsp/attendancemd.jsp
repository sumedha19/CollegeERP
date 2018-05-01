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
		
		if(st=="def")
			{
				alert("Please select one value");
				return false;
				}
			return true;
	}
</script>
</head>
<body>
<div style="margin-left:150px;margin-top:100px;background-color: #f1f1f1;width:600px;height:300px;float:left">
<form method="get" action="/college_erp/jsp/viewad.jsp" style="margin-top:30px;float:left;margin-left:50px" >
Search by Roll No :
<table>
<tr><td style="width:200px"><input type="text" name="roll" required="required" placeholder="Enter Roll No Here"></td>
<td><select name="sem" id="sem" style="width:200px">
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
</select></td></tr>
<tr><td>From :
<input type="date" name="frm" required="required"></td>
<td>To :
<input type="date" name="to" required="required"></td><td>
<input type="submit" value="GO"  onclick="return check()"></td></tr></table>
<div style="color:red">${param.message}</div>
</form>
<form method="get" action="/college_erp/jsp/viewlecd.jsp" style="margin-top:30px;margin-left:50px;float:left">
Search by Lecture : <br><select name="sb" id="sb" style="border-style:inset;border-color:#f1f1f1;" required="required">
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
</select>&nbsp &nbsp
Date :<input type="date"  name="dt" required="required">&nbsp 
<input type="submit" value="GO" onclick="return checks()"><br>
<div style="color:red">${param.message1}</div>
</form>
</div>
</body>
</html>