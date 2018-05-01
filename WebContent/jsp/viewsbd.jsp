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
<div style="margin-left:100px;margin-top:40px;float:left">
<%
String sb=request.getParameter("sb");
String bt=request.getParameter("bt");
%>
<label style="color:blue">Subject Id</label> :<%=sb %>
<label style="color:blue;margin-left:20px">Batch</label> :<%=bt %>
</div>
<div style="margin-top:50px;margin-left:100px;float:left">
View Marks
<table border="15" style="border-style:inherit;text-align: center;width:800px">

<tr style="background-color:#b1b1b1"><th>Roll no</th><th>Name</th><th>Course Id</th><th>Internal Marks</th><th>External Marks</th></tr>

<% 

try
{
	String str="select s.rollno,s.name,s.course_id,m.int_marks,m.ext_marks from student s,marks m where s.pass_yr=? and m.subject_id=? and s.rollno=m.student_id ORDER BY s.rollno";

	Connection con=CrudOperation.createConnection();
	PreparedStatement ps=con.prepareStatement(str);
	ps.setString(1,bt);
	ps.setString(2,sb);
	
	ResultSet rs=ps.executeQuery();
	int flag=0;
	while(rs.next())
	{
		flag=1;
		
		
%>
<tr><td><%=rs.getString("rollno") %></td><td><%=rs.getString("name") %></td>
<td><%=rs.getString("course_id")%></td>
<td><%=rs.getInt("int_marks") %></td>
<td><%=rs.getInt("ext_marks") %></td></tr>

<%
		}
		
	if(flag==0)
	{
		String message1 = "Record does not exists!";
		response.sendRedirect("/college_erp/jsp/markmd.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));

	}
}
	catch(SQLException e)
	{
		String message1 = "Record not found";
		response.sendRedirect("/college_erp/jsp/markmd.jsp?message1=" + URLEncoder.encode(message1, "UTF-8"));

	}
%>

</table>
</div>
</body>
</html>