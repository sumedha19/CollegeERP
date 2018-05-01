<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*, college_erp.dbutil.*,java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/college_erp/css/style.css">
<script type="text/javascript">
function checkm()
{

	var intm=document.getElementById("i").value;
	var extm=document.getElementById("e").value;
	if(intm>100 || intm<0 || extm>100 || extm<0)
		{
		alert("marks should between 0 and 100.");
		return false;
		}
	return true;
}
</script>
</head>
<body>
<div style="margin-left:120px;margin-top:40px;float:left">
<%
String cs=request.getParameter("cs");
String sb=request.getParameter("sb");
String bt=request.getParameter("batch");
%>
<label style="color:blue">Course Id</label>: <%=cs %>
<label style="color:blue;margin-left:20px">Subject Id</label> :<%=sb %>
<label style="color:blue;margin-left:20px">Batch</label> :<%=bt %>
</div>
<div style="margin-top:100px;margin-left:-320px;float:left">
Enter Marks
<form method="post" action="/college_erp/Editm">
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
	int flag=0,f=0;
	while(rs.next())
	{
		if(rs.getInt("ext_marks")!=0)
		{	flag=1;
		break;
		}
			f=1;
	}
	ResultSet rs1=ps.executeQuery();
	if(flag==0 && f==1)
	{
		while(rs1.next())
	
	{
		
%>
<tr><td><input type="text" name="roll" value='<%=rs1.getString("rollno") %>' readonly="readonly" style="text-align: center;width:50px"></td><td><%=rs1.getString("name") %></td>
<td><%=cs %></td>
<td><input type="number" name="intm" id="i" maxlength="3" style="width:50px;margin-left:10px" value='<%=rs1.getInt("int_marks")%>' readonly="readonly"></td>
<td><input type="number" name="extm" id="e" maxlength="3" style="width:50px;margin-left:10px" value=0></td></tr>

<%
	}
	}
	else if(flag==1)
	{
		String message = "Update not allowed.Kindly contact admin!";
		response.sendRedirect("/college_erp/jsp/editmarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
	else if(f==0)
	{
		String message = "Record does not exists!";
		response.sendRedirect("/college_erp/jsp/editmarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));


	}
	
}
	catch(SQLException e)
	{
		String message = "Record not found";
		response.sendRedirect("/college_erp/jsp/editmarks.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

	}
%>

</table>
<br>
<input type="text" name="sb" value='<%=sb %>' style="display:none">
<input type="text" name="bt" value='<%=bt %>' style="display:none">
<input type="submit" value="Submit" onclick="return checkm()">
<input type="reset" value="Reset">
</form>
</div>
</body>
</html>