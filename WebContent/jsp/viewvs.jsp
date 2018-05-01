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
<div>
<form method="post" action="/college_erp/ToExcelvs">
<input type="submit" value="Export as Excel" style="background-color: white;margin-left:700px;float:left;margin-top:50px">
</form>
<% out.println("<table border='15' style='border-style:inherit;width:1050px;margin-left:30px;margin-top:30px;text-align:center;float:left'>");
String str="select * from visitor";
ResultSet rs=CrudOperation.getValue(str);
out.println("<tr style='background-color:#b1b1b1'><th>Sno</th><th>Date</th><th>Visitor's Name</th><th>Vehicle no</th><th>Person's Name</th><th>Ptype</th><th>Time in</th><th>Time out</th><th>Phone no</th></tr>");
try
{while(rs.next())
{
	int a=rs.getInt("sno");
	String b=rs.getString("date");
	String c=rs.getString("v_name");
	String d=rs.getString("vehicle_no");
	String e=rs.getString("p_name");
	String f=rs.getString("ptype");
	String g=rs.getString("time_in");
	String h=rs.getString("time_out");
	Long i=rs.getLong("phoneno");
out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td><td>"+g+"</td><td>"+h+"</td><td>"+i+"</td></tr>");
}
out.println("</table>");
}
catch(Exception e)
{
	
}
%>
${param.message}
</div>
</body>
</html>