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
float tat=0,tt=0;
String frm=request.getParameter("frm");
HttpSession hs=null;
hs=request.getSession(false);
String uid=(String)hs.getAttribute("uinfo");
int sem=Integer.parseInt(request.getParameter("sem"));
String to=request.getParameter("to");
String str="select course_id from student where rollno=?";
ResultSet rs=CrudOperation.getData(str, uid);
if(rs.next())
	{
	cs=rs.getString("course_id");

	}
%>
<div style="margin-top:50px;margin-left:100px;font-size: 25px;float:left">
Semester <%=sem %> Attendance (<%=frm %> to <%=to %>)
</div>
<div style="float:left;margin-top:30px;margin-left:100px">
<table border="15" style="border-style:inherit;text-align: center;width:800px">
<tr style="background-color: #b1b1b1"><th>Subject Id</th><th>Subject Name</th><th>No of classes attended</th><th>Total classes</th><th>Percentage Attendance</tr>
<%
try
{
	
String strsql="select * from subjects where courseid=? and sem=?";
Connection con=CrudOperation.createConnection();
PreparedStatement ps=con.prepareStatement(strsql);
ps.setString(1,cs);
ps.setInt(2,sem);
ResultSet rs1=ps.executeQuery();

while(rs1.next())
{
	int total=0,nt=0,at=0;
%>
	<tr><td><%=rs1.getString("sub_id") %></td><td><%=rs1.getString("name") %></td>
	<% 
	try
	{
		String s="select * from attendance where subject_id=? and date>=? and date<=?";
		PreparedStatement ps2=con.prepareStatement(s);
		ps2.setString(1,rs1.getString("sub_id"));
		ps2.setString(2,frm);
		ps2.setString(3,to);
		ResultSet rr=ps2.executeQuery();
		while(rr.next())
		{
			total++;
		}
	String strs="select * from attendance where subject_id=? and student_id=? and date>=? and date<=?";
	PreparedStatement ps1=con.prepareStatement(strs);
	ps1.setString(1,rs1.getString("sub_id"));
	ps1.setString(2,uid);
	ps1.setString(3,frm);
	ps1.setString(4,to);
	ResultSet rs2=ps1.executeQuery();
	int flag=0;
	while(rs2.next())
	{
		flag=1;
	nt++;
	
}
	if(flag==0)
		at=total;
	else
		at=total-nt;
	tt+=total;
	tat+=at;
	
}
catch(SQLException e)
{
	
}
	
%>
<td><%=at %></td><td><%=total %></td><td><%if(total!=0) {%>
<%=(at/total)*100 %>%
<%}
else %><%=0 %>
</td></tr>
<%
}
}
catch(SQLException e)
{
	
}
%>
</table>
<br><br>
Total Attendance in %:
<%if(tt!=0){ 
float p=tat/tt;
%>
<%=p*100 %>%
<%}
else
{
%>
<%=0 %>%
<%} %>
</div>
</body>
</html>