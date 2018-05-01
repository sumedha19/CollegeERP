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
<form method="post" action="/college_erp/ToExcelrs">
<input type="submit" value="Export as Excel" style="background-color: white;margin-left:700px;float:left;margin-top:50px">
</form>
<% String str="select * from resources";
			ResultSet rs=CrudOperation.getValue(str);
			out.println("<table border='15' style='border-style:inherit;width:1050px;margin-left:30px;margin-top:30px;text-align:center;float:left'>");
			out.println("<tr style='background-color:#b1b1b1'><th>Name</th><th>Total_quantity</th><th>Allotted_to</th><th>Allot_quantity</th><th>date_Allotted</th><th>Return_date</th></tr>");
			try
			{while(rs.next())
			{
				String a=rs.getString("name");
				int b=rs.getInt("total");
				String c=rs.getString("allotted_to");
				int d=rs.getInt("allot_quantity");
				String e=rs.getString("date_allotted");
				String f=rs.getString("return_date");
		out.println("<tr><td>"+a+"</td><td>"+b+"</td><td>"+c+"</td><td>"+d+"</td><td>"+e+"</td><td>"+f+"</td></tr>");
			}
			out.println("</table>");
		}
			catch(Exception e)
			{
				
			}
			%>
			${param.message}
</div></body>
</html>