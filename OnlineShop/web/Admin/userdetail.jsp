<%-- 
    Document   : UserDetails
    Created on : May 28, 2022, 2:53:41 PM
    Author     : Pham Minh Giang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="a" value="${requestScope.Account}"/>
        <h1>User Detail</h1>
        <br>Name: ${a.name}
        <br>Gender: ${a.gender}
        <br>Email: ${a.email}
        <br>Phone: ${a.phone}
        <br>Role: ${a.role}
        <br>Address: ${a.address}
        <br>Status: ${a.status}
        
        
    </body>
</html>
