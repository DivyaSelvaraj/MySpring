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
<title>Your account!!</title>
</head>
<body>
<center><h4>Hi <%= request.getAttribute("UserName") %> , Welcome to your account!!</h4>
<image src = " <%= request.getAttribute("imageUrl") %>"></image> <br/>
Your image has been retrieved successfully
Thank you for using.., 
<a href="/springs">Logout</a></center>
 </body>
</html>

