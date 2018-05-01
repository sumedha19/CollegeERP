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
String cs=request.getParameter("cs");
String sb=request.getParameter("sb");
String bt=request.getParameter("batch");
%>
<form method="post" action="/college_erp/ToExcel">
<input type="text" name="cs" value='<%=cs %>' style="display:none">
<input type="text" name="sb" value='<%=sb %>' style="display:none">
<input type="text" name="bt" value='<%=bt %>' style="display:none">
<input type="submit" value="Export as Excel" style="background-color: white;margin-left:600px;float:left">
</form>
<label style="color:blue">Course Id</label>: <%=cs %>
<label style="color:blue;margin-left:20px">Subject Id</label> :<%=sb %>
<label style="color:blue;margin-left:20px">Batch</label> :<%=bt %>
</div>
<div style="margin-top:40px;margin-left:130px;float:left">
View Marks
<table border="15" style="border-style:inherit;text-align: center;width:800px">

<tr style="background-color:#b1b1b1"><th>Roll no</th><th>Name</th><th>Course Id</th><th>Internal Marks</th><th>External Marks</th></tr>

<% 

try
{
	String str="select s.rollno,s.name,m.int_marks,m.ext_marks from student s,marks m where s.course_id=? and s.pass_yr=? and m.subject_id=? and s.rollno=m.student_id ORDER BY s.rollno";

	Connection con=CrudOperation.createConnection();
	PreparedStatement ps=con.prepareStatement(str);
	ps.setString(1,cs);
	ps.setString(2,bt);
	ps.setString(3,sb);
	
	ResultSet rs=ps.executeQuery();
	int flag=0;
	while(rs.next())
	{
		flag=1;
		
		
%>
<tr><td><%=rs.getString("rollno") %></td><td><%=rs.getString("name") %></td>
<td><%=cs %></td>
<td><%=rs.getInt("int_marks") %></td>
<td><%=rs.getInt("ext_marks") %></td></tr>

<%
		}
		
	if(flag==0)
	{
		String message = "Record does not exists!";
		response.sendRedirect("/college_erp/jsp/viewmarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
}
	catch(SQLException e)
	{
		String message = "Record not found";
		response.sendRedirect("/college_erp/jsp/viewmarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
%>

</table>
</div>
</body>
</html>