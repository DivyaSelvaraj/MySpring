<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page!</title>
</head>
<body>
<h3 align="center">Login to your account!!! </h3>
<form style="border: medium;" action="/logging">
<center>
<table  background="#EEEEE">
<tr><td align="center" bgcolor="lightblue">Log in</td></tr>
<tr><td>

Email-Id:<input name="emailId" type ="text"/>

<br><br></td></tr>
<tr><td><label style=" border-left-color: olive;">
Password:         <input name="password" type ="password" /><br><br></label></td></tr>
<tr><td>
          <center><input  type="submit" value="submit" /></center>
</td></tr>
</table></center></form>

<center><table >
<tr bordercolor="lavender" ><td><a href="/register">New User?</a></td></tr></table>
</center>

</body>
</html>




