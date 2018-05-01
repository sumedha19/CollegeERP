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
String str="select * from courses";
ResultSet rs=CrudOperation.getValue(str);
String r=(String)request.getAttribute("rollno");
String strsql="select * from student where rollno=?";
ResultSet rs1=CrudOperation.getData(strsql,r);
if(rs1.next())
try
{
%>
<div style="background-color:#f7f7f7;width:900px;margin-left:100px;height:400px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<form method="post" action="/college_erp/Updaterecs" style="margin-left:50px;margin-top:50px">
<table cellspacing="10px">
<tr><th>Roll no :</th><td><input type="text" name="roll" style="border-style:inset;border-color:#f1f1f1" required="required" readonly="readonly" value='<%=rs1.getString("rollno")%>'></td>
<th>Name :</th><td><input type="text" name="nm" style="border-style:inset;border-color:#f1f1f1;width:300px" required="required" value='<%=rs1.getString("name")%>'><br></td></tr>
<tr><th>Address :</th><td><textarea rows=2 cols=21 name="add" style="margin-top:15px;border-style:inset;border-color:#f1f1f1;" required="required"><%=rs1.getString("address")%></textarea></td>

<th>Email :</th><td><input type="email" name="email" style="border-style:inset;border-color:#f1f1f1;width:300px" required="required" value='<%=rs1.getString("email")%>'><br></td></tr>
<tr><th>Gender :</th><td><%=rs1.getString("gender") %></td>
<th>DOB :</th><td><input type="date" name="dob" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("dob")%>'></td>
</tr>
<tr><th>DOA :</th><td><input type="date" name="doa" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("doa")%>'></td>
<th>Current_sem :</th><td><input type="number" name="sem" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("current_sem")%>'></td></tr>
<tr><th>Course :</th><td><select name="cs" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("course_id")%>'>
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
</select></td><th>Phone No :</th><td><input type="number" name="phno" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("phoneno")%>'></td></tr>
<tr><th>Hostel :</th><td><input type="text" value='<%=rs1.getString("hostel")%>' name="hostel"></td>
<th>Batch(Passing year) :</th><td><input type="text" name="pyr" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("pass_yr")%>'></td></tr>

</table>
<input type="submit" value="Save Record" style="width:120px;height:30px;margin-left:150px;float:left;margin-top:20px">
<input type="reset" value="Reset" style="width:120px;height:30px;margin-left:50px;float:left;margin-top:20px">
<br><div style="color:blue;margin-left:30px"> ${param.message}</div>
</form>
</div>
<%}
catch(Exception e)
{
	
}
%>
</body>
</html>