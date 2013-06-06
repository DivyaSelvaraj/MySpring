<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register page! </title>
<script type="text/javascript">

function validate()
{
	var x=document.forms["myForm"]["emailId"].value;
	var pass=document.forms["myForm"]["password"].value;
	var pass1=document.forms["myForm"]["password1"].value;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	var ac=document.forms["myForm"]["firstName"].value;
	var ac1=document.forms["myForm"]["lastName"].value;
	

	if (ac === "" || ac === null ||  ac1 === "" || ac1 === null || pass ==="" || pass === null || pass1 ==="" || pass1 === null)
	{
			alert(" firstName, lastName or password is empty ");
			return false;
	}
	
 	if( pass !== pass1) {
  		 
  		alert("Error: Password doesn't match");
  		document.forms["myForm"]["password1"].focus();
  		return false;
	}

	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
	{
			alert("Not a valid e-mail address");
			return false;
	}


}

</script>
</head>
<body bgcolor="lavender">
<h3 align ="center">New user can register here!!!</h3>
<form name="myForm" onsubmit="return validate()"   method="post" action=<%=blobstoreService.createUploadUrl("/registration") %> enctype="multipart/form-data"><br>

<table bgcolor="lavender"  align ="center">

<tr>

<td  align="justify" >First Name:</td><td align="justify" ><input name="firstName" type ="text"/></td>

</tr>

<tr>

<tr>

<td align="justify">Last Name:</td><td align="justify" ><input name="lastName" type ="text"/></td>

</tr>

<tr>

<tr>

<td align="justify">Email ID:</td><td align="justify" ><input name="emailId" type ="text"/></td>

</tr>

<tr>

<tr>

<td align="justify">Password:</td><td align="justify" ><input name="password" type ="password"/></td>

</tr>

<tr>

<td align="justify">Confirm Password:</td><td align="justify" ><input name="password1" type ="password" /></td>

</tr>

<tr>

<td align="justify">Upload Image:</td><td align="justify" ><input name="myFile"  type="file" /></td>

</tr>

<tr>

<td align="center"></td><td align="center"><input  name="login" type="submit" value="submit" /></td>

</tr>
</table>

</form>
</body>
</html>