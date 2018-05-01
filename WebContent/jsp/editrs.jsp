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
<%
String r=(String)request.getAttribute("nm");
String a=(String)request.getAttribute("anm");
Connection con=CrudOperation.createConnection();
String strsql="select * from resources where name=? and allotted_to=?";
PreparedStatement ps=con.prepareStatement(strsql);
ps.setString(1,r);
ps.setString(2,a);
ResultSet rs1=ps.executeQuery();
if(rs1.next())
try
{
%>
<div style="background-color:#f7f7f7;width:750px;margin-left:70px;height:300px;margin-top:70px;border-style:solid;border-color:#f1f1f1">
<form method="post" action="/college_erp/Updaters" style="margin-left:50px;margin-top:50px">
<table cellspacing="10px">
<tr><td>Name :</td><td><input type="text" name="rnm" style="border-style:inset;border-color:#f1f1f1" required="required" readonly="readonly" value='<%=rs1.getString("name")%>'></td>
<td>Total Amount:</td><td><input type="number" name="total" style="border-style:inset;border-color:#f1f1f1" required="required" value='<%=rs1.getInt("total")%>'><br></td></tr>
<tr><td>Allotted to :</td><td><input type="text" name="ato" style="margin-top:15px;border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("allotted_to")%>'></td>
<td>Allotted Quantity :</td><td><input type="number" name="aq" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("allot_quantity")%>'><br></td></tr>

<tr><td>Date Allotted :</td><td><input type="date" name="da" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("date_allotted")%>'></td>
<td>Return Date :</td><td><input type="date" name="dr" style="border-style:inset;border-color:#f1f1f1;" required="required" value='<%=rs1.getString("return_date")%>'></td></tr>

</table>
<input type="submit" value="Update Record" style="width:120px;height:30px;margin-left:150px;float:left;margin-top:20px">
<input type="reset" value="Reset" style="width:120px;height:30px;margin-left:50px;float:left;margin-top:20px">
<br><div style="color:blue;margin-left:30px"> ${param.message}</div>
</form>
</div>
<%}
catch(Exception e)
{
	
}
%>
</body>
</html>