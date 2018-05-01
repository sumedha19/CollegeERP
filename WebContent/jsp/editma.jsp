<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*,java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
</head>
<body>
<%
String sb=request.getParameter("sb");
String bt=request.getParameter("bt");
String roll=request.getParameter("roll");
String str="select * from marks where subject_id=? and batch=? and student_id=?";
try
{
	Connection con=CrudOperation.createConnection();
	PreparedStatement ps=con.prepareStatement(str);
	ps.setString(1,sb);
	ps.setString(2,bt);
	ps.setString(3,roll);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
%>
<div style="width:500px;height:300px;background-color:#f1f1f1;margin-left:100px;margin-top:100px;float:left">
<label style="margin-left:30px;margin-top:20px;text-decoration: underline;float:left">Edit Student Marks Record</label>
<form method="post" action="/college_erp/Editma">
<table style="margin-top:50px;margin-left:30px">
<tr><td>Subject Id</td><td><input type="text" name="sb" value='<%=sb %>' readonly="readonly"></td></tr>
<tr><td>Batch</td><td><input type="text" name="bt" value='<%=bt %>' readonly="readonly"></td></tr>
<tr><td>Student Id</td><td><input type="text" name="roll" value='<%=roll %>' readonly="readonly"></td></tr>
<tr><td>Internal Marks</td><td><input type="number" name="intm" value='<%=rs.getInt("int_marks") %>'></td></tr>
<tr><td>External Marks</td><td><input type="number" name="extm" value='<%=rs.getInt("ext_marks") %>'></td></tr>
<tr><td></td><td><input type="submit" value="update"></td></tr>
</table>
</form>
</div>
<%
	}
	else
	{
		String message = "Record does not exists!";
		response.sendRedirect("/college_erp/jsp/edmark.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	}
}
catch(Exception e)
{
	
}
%>
</body>
</html>