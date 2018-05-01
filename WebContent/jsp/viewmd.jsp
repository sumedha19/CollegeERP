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
String cs="";
int i=0,x=0,n=0;
int sem=Integer.parseInt(request.getParameter("sem"));
String roll=request.getParameter("roll");
String str="select * from student where rollno=?";
ResultSet rs=CrudOperation.getData(str,roll);
if(rs.next())
	{
	cs=rs.getString("course_id");
	
%>
<div style="margin-top:10px;margin-left:50px">Roll No : <%=roll %> &nbsp Name : <%=rs.getString("name") %>
&nbsp Course Id : <%=cs %>
</div>
<%
	}
else
{
	String message = "Rollno not found";
	response.sendRedirect("/college_erp/jsp/markmd.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
}
%> 
<div style="margin-top:50px;margin-left:100px;font-size: 25px;float:left">
Semester <%=sem %> Marks
</div>
<div style="float:left;margin-top:20px;margin-left:100px">
<table border="15" style="border-style:inherit;text-align: center;width:800px">
<tr style="background-color: #b1b1b1"><th>Subject Id</th><th>Subject Name</th><th>Internal Marks</th><th>External Marks</th></tr>
<%
try
{
String strsql="select * from subjects s,marks m where s.courseid=? and s.sem=? and m.student_id=? and s.sub_id=m.subject_id";
Connection con=CrudOperation.createConnection();
PreparedStatement ps=con.prepareStatement(strsql);
ps.setString(1,cs);
ps.setInt(2,sem);
ps.setString(3,roll);
ResultSet rs1=ps.executeQuery();
int flag=0;
while(rs1.next())
{
	flag=1;
	i+=rs1.getInt("int_marks");
	x+=rs1.getInt("ext_marks");
	n++;
	
%>
<tr><td><%=rs1.getString("sub_id") %></td><td><%=rs1.getString("name") %></td>
<td><%=rs1.getString("int_marks") %></td><td><%=rs1.getString("ext_marks") %></td></tr>
<%
}

}
catch(SQLException e)
{
	
}
%>
</table>
<br><br>

Percentage (Internal) :<%if(n!=0)
{%>
<%=i/n %>%
<%
}
else %><%=0 %><br>

Percentage (External) :<%if(n!=0)
{%>
<%=x/n %>%
<%
}
else %><%=0 %><br>
Overall Percentage :<%if(n!=0)
{%>
<%=(i+x)/(2*n) %>%
<%
}
else %><%=0 %><br>

</div>
</body>
</html>