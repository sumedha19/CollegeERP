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
String str="select * from department";
ResultSet rs=CrudOperation.getValue(str);
String r1=(String)request.getAttribute("empid");
String strsql="select * from employee where emp_id=?";
ResultSet rs1=CrudOperation.getData(strsql,r1);

try
{
	if(rs1.next())
	{
%>
<div style="background-color:#f7f7f7;width:900px;margin-left:100px;height:500px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<form method="post" action="/college_erp/Updaterece" style="margin-left:50px;margin-top:10px">
<table cellspacing="20px">
<tr><th>Emp_id :</th><td><input type="text" name="emid" style="border-style:inset;border-color:#f1f1f1" required="required" readonly="readonly" value='<%=rs1.getString("emp_id")%>'></td>
<th>Name :</th><td><input type="text" name="nm" style="border-style:inset;border-color:#f1f1f1;width:300px" required="required" value='<%=rs1.getString("name")%>'><br></td></tr>
<tr><th>Permanent Address :</th><td><textarea rows=2 cols=21 name="add" style="margin-top:15px;border-style:inset;border-color:#f1f1f1;" required="required"><%=rs1.getString("address_per")%></textarea></td>
<th>Residential Address :</th><td><textarea row=2 cols=21 id="rs" name="radd" style="display:block"><%=rs1.getString("address_res")%></textarea>

</td>
<tr><th>Phone no :</th><td><input type="number" name="phno" required="required" style="border-style:inset;border-color:#f1f1f1" value='<%=rs1.getLong("phoneno")%>'></td>
<th>Email :</th><td><input type="email" name="em" required="required" style="border-style:inset;border-color:#f1f1f1;width:300px" value='<%=rs1.getString("email")%>'></td></tr>
<tr><th>Qualification :</th><td><input type="text" name="qual" required="required" style="border-style:inset;border-color:#f1f1f1" value='<%=rs1.getString("qual")%>'></td>
<th>Experience(in years) :</th><td><input type="number" name="exp" required="required" style="border-style:inset;border-color:#f1f1f1" value='<%=rs1.getInt("exp")%>'></td></tr>
<tr><th>DOB :</th><td><input type="date" name="dob" required="required" style="border-style:inset;border-color:#f1f1f1" value='<%=rs1.getString("dob")%>'></td>
<th>DOJ :</th><td><input type="date" name="doj" required="required" style="border-style:inset;border-color:#f1f1f1;" value='<%=rs1.getString("doj")%>'></td></tr>
<tr><th>Salary :</th><td><input type="number" name="sal" required="required" style="border-style:inset;border-color:#f1f1f1;" value='<%=rs1.getLong("salary")%>'></td>
<th>Gender :</th><td><%=rs1.getString("gender") %></td></tr>
<tr><th>Department :</th><td><select name="dept" style="border-style:inset;border-color:#f1f1f1;" required="required">
<option value='<%=rs1.getString("dept_id")%>'><%=rs1.getString("dept_id")%></option> 
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
<option value='<%=rs1.getString("type")%>'><%=rs1.getString("type")%></option>
<option value="director">Director</option>
<option value="faculty">Faculty</option>
<option value="employee">Employee</option></select></td>
</tr>
</table>
<input type="submit" value="Update Record" style="width:120px;height:30px;margin-left:150px;float:left;margin-top:20px">
<input type="reset" value="Reset" style="width:120px;height:30px;margin-left:50px;float:left;margin-top:20px">
<br><div style="color:blue;margin-left:20px">${param.message}</div>
</form>
</div>
<%}
}
catch(Exception e)
{
	
}
%>
</body>
</html>