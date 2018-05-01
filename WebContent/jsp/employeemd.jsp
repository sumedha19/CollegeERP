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

	var cs=document.getElementById("dp").value;
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
String str="select * from department";
ResultSet rs=CrudOperation.getValue(str);
%>
<div style="margin-left:150px;margin-top:100px;background-color: #f1f1f1;width:450px;height:200px;float:left">
<form method="get" action="/college_erp/jsp/viewed.jsp" style="margin-top:30px;float:left;margin-left:20px" >
Search by Employee Id : <input type="text" name="eid" required="required">
<input type="submit" value="GO"><br>
<div style="color:red">${param.message}</div>
</form>
<form method="get" action="/college_erp/jsp/viewdpd.jsp" style="margin-top:30px;margin-left:20px;float:left">
Search by Department : <br><select name="dp" id="dp" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def" required="required">Select Department</option>
<%
try
{ while(rs.next())
{
%>
<option value='<%=rs.getString("dept_id") %>'><%=rs.getString("name") %>(<%=rs.getString("dept_id") %>)</option>
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