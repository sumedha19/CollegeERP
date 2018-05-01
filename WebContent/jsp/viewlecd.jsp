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
<div style="margin-left:120px;margin-top:40px;float:left">
<%
String sb=request.getParameter("sb");
String date=request.getParameter("dt");
Connection con=CrudOperation.createConnection();
String chk="select * from attendance where subject_id=? and date=?";
PreparedStatement pch=con.prepareStatement(chk);
pch.setString(1,sb);
pch.setString(2,date);
ResultSet rr=pch.executeQuery();
int f=0;
if(rr.next())
{
	if(rr.getString("student_id").equals("all"))
	{
		f=1;
	}
}
%>
<label style="color:blue;float:left;margin-left:-20px">Subject Id</label> :<%=sb %>
<label style="color:blue;margin-left:20px">Date</label> :<%=date %>
</div>
<div style="margin-top:50px;margin-left:100px;float:left">
View Attendance (List of all not present)
<table border="15" style="border-style:inherit;text-align: center;width:800px">

<tr style="background-color:#b1b1b1"><th>Roll no</th><th>Name</th><th>Course Id</th></tr>

<% 
if(f==0)
{
try
{
	String str="select s.rollno,s.name,s.course_id,a.subject_id from student s,attendance a where  a.subject_id=? and a.date=? and s.rollno=a.student_id ORDER BY s.rollno";

	
	PreparedStatement ps=con.prepareStatement(str);
	
	ps.setString(1,sb);
	ps.setString(2,date);
	ResultSet rs=ps.executeQuery();
	int flag=0;
	while(rs.next())
	{
		flag=1;
		
		
%>
<tr><td><%=rs.getString("rollno") %></td><td><%=rs.getString("name") %></td>
<td><%=rs.getString("course_id")%></td></tr>

<%
		}
		
	if(flag==0)
	{
		String message1 = "Record does not exists!";
		response.sendRedirect("/college_erp/jsp/attendancemd.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));

	}
}
	catch(SQLException e)
	{
		String message1 = "Record not found";
		response.sendRedirect("/college_erp/jsp/attendancemd.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));

	}
}
else
{
%>
<tr><td colspan=3>All Students Present</td></tr>
<%
}
%>
</table>
</div>
</body>
</html>