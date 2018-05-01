<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<script>
function showres()
{
	var c=document.getElementsByName("chk");
	var txt=document.getElementById("rs");

if(!(c[0].checked))
	{
		txt.style.display="block";
	}
else
	txt.style.display="none";
	}
</script>
</head>
<body>
<%
String str="select * from department";
ResultSet rs=CrudOperation.getValue(str);

%>
<div style="background-color:#f7f7f7;width:900px;margin-left:100px;height:500px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<form method="post" action="/college_erp/Addrece" style="margin-left:50px;margin-top:10px">
<table cellspacing="20px">
<tr><th>Emp_id :</th><td><input type="text" name="emid" style="border-style:inset;border-color:#f1f1f1" required="required"></td>
<th>Name :</th><td><input type="text" name="nm" style="border-style:inset;border-color:#f1f1f1;width:300px" required="required"><br></td></tr>
<tr><th>Permanent Address :</th><td><textarea rows=2 cols=21 name="add" style="margin-top:15px;border-style:inset;border-color:#f1f1f1;" required="required"></textarea></td>
<th>Residential Address :</th><td><textarea row=2 cols=21 id="rs" name="radd" style="display:none"></textarea>
<input type="checkbox" name="chk" id="chk" onchange="showres()" checked="checked" value="same">Same as permanent address
</td>
<tr><th>Phone no :</th><td><input type="number" name="phno" required="required" style="border-style:inset;border-color:#f1f1f1"></td>
<th>Email :</th><td><input type="email" name="em" required="required" style="border-style:inset;border-color:#f1f1f1;width:300px"></td></tr>
<tr><th>Qualification :</th><td><input type="text" name="qual" required="required" style="border-style:inset;border-color:#f1f1f1"></td>
<th>Experience(in years) :</th><td><input type="number" name="exp" required="required" style="border-style:inset;border-color:#f1f1f1"></td></tr>
<tr><th>DOB :</th><td><input type="date" name="dob" required="required" style="border-style:inset;border-color:#f1f1f1"></td>
<th>DOJ :</th><td><input type="date" name="doj" required="required" style="border-style:inset;border-color:#f1f1f1;"></td></tr>
<tr><th>Salary :</th><td><input type="number" name="sal" required="required" style="border-style:inset;border-color:#f1f1f1;"></td>
<th>Gender :</th><td><input type="radio" name="gen" value="m" required="required" style="border-style:inset;border-color:#f1f1f1">m
<input type="radio" name="gen" value="f" required="required" style="border-style:inset;border-color:#f1f1f1">f</td></tr>
<tr><th>Department :</th><td><select name="dept" style="border-style:inset;border-color:#f1f1f1;">
<option value="def" required="required">Select Department</option>
<%
try
{ while(rs.next())
{
%>
<option value='<%=rs.getString("dept_id") %>'><%=rs.getString("name") %></option>
<%}
}
catch(SQLException e)
{
	
}
%>
</select></td>
<th>Type :</th>
<td><select name="type" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value="def" required="required">Select Type</option>
<option value="director">Director</option>
<option value="faculty">Faculty</option>
<option value="employee">Employee</option></select></td>
</tr>
</table>
<input type="submit" value="Save Record" style="width:120px;height:30px;margin-left:150px;float:left;margin-top:20px">
<input type="reset" value="Reset" style="width:120px;height:30px;margin-left:50px;float:left;margin-top:20px">
<br><div style="color:blue;margin-left:20px">${param.message}</div>
</form>
</div>
</body>
</html>