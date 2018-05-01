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
<div  style="margin-top:50px;height:100px;width:500px;margin-left:50px">
<form method="post" action="/college_erp/Viewallh">
View Records :<select name="cs" style="border-style:inset;border-color:#f1f1f1;margin-left:10px" required="required">
<option value="def">Select Option</option>
<option value="hostel">Hostels</option>
<option value="hostl">Hostellers</option>
</select>
<input type="submit" value="View" style="margin-left:20px">
${param.message}
</form>
</div>
 
</body>

</html>