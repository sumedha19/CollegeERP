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
<div>
<table border=1 cellspacing=0 style="width:1000px;margin-left:80px;margin-top:80px;text-align:center;">
<tr style='background-color:#b1b1b1'><th>Rollno</th><th>Name</th><th>Address</th><th>Email</th><th>DOB</th><th>DOA</th><th>Current_sem</th><th>Course_id</th><th>Phoneno</th><th>Hostel</th><th>Batch</th></tr>
<%
String cs=request.getParameter("cs");
String bt=request.getParameter("bt");
ResultSet rs=null;
Connection con=CrudOperation.createConnection();
PreparedStatement ps=null;
int f=0;
if(bt.equals("all"))
{
String str="select * from student where course_id=? ORDER BY pass_yr";
ps=con.prepareStatement(str);
ps.setString(1,cs);
rs=ps.executeQuery();
}
else
{
String str="select * from student where course_id=? and pass_yr=? ORDER BY pass_yr";
ps=con.prepareStatement(str);
ps.setString(1,cs);
ps.setString(2,bt);
rs=ps.executeQuery();
}
try
{
while(rs.next())
{	
	f=1;
%>
<tr><td><%=rs.getString("rollno") %></td><td><%=rs.getString("name") %></td><td><%=rs.getString("address") %></td>
<td><%=rs.getString("email") %></td><td><%=rs.getDate("dob") %></td><td><%=rs.getDate("doa") %></td><td><%=rs.getInt("current_sem") %></td>
<td><%=rs.getString("course_id") %></td><td><%=rs.getString("phoneno") %></td><td><%if(rs.getBoolean("hostel")){%><%="yes" %><%}
else %><%="No" %></td><td><%=rs.getString("pass_yr") %></td></tr>
<%
}
}
catch(Exception e)
{
	
}
if(f==0)
{
	String message1 = "Record not found";
	response.sendRedirect("/college_erp/jsp/studentmd.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));
}
%>
</table>
</div>
</body>
</html>