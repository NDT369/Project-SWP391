<%-- 
    Document   : UserList
    Created on : May 28, 2022, 1:09:54 AM
    Author     : Pham Minh Giang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User List</h1>
        
        <c:if test="${requestScope.UserList != null}">done</c:if>
        Search
        <form action="search">
            <input type="text" name="search" placeholder="Text in here" /> 
            <input type="submit" value="Search"/> 
        </form><br>
        <form id="f" action="userlist" method="post">
            Gender
            <select name="gender" onchange="document.getElementById('f').submit()">
                <option value=""></option>
                <option value="1">Male</option>
                <option value="0">Female</option>
            </select>
        </form>   
        <form id="r" action="userlist" method="post">
            Role
            <select name="role" onchange="document.getElementById('r').submit()">
                <option value=""></option>
                <option value="1">Admin</option>
                <option value="2">Customer</option>
                <option value="3">Sale</option>
                <option value="4">Marketing</option>
            </select>
        </form>
        <form id="s" action="userlist" method="post">
            Status
            <select name="status" onchange="document.getElementById('s').submit()">
                <option value=""></option>
                <option value="1">Action</option>
                <option value="0">Inaction</option>
            </select>
        </form><br>
        

        <form id="sb" action="search" method="post">
            Sort by:
            <select name="sort" onchange="document.getElementById('sb').submit()" value="${param.sort}">
            <!--<select name="sort" >-->
            <option value="Account_ID">ID</option>
                <option value="Name">Name</option>
                <option value="Gender">Gender</option>
                <option value="Email">Email</option>
                <option value="Phone">Phone</option>
                <option value="Role_ID">Role</option>
                <option value="Account_Status">Status</option>
            </select>
            
        </form>

        <table border = "1px" width = "80%">
            <tr>
                <th>User ID</th>
                <th>Full Name</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Role</th>
                <th>Status</th>
                <th>#</th>
            </tr>
            <c:forEach items="${requestScope.UserList}" var="a">
                <tr>
                    <td>${a.getAccountID()}</td>
                    <td>${a.getName()}</td>
                    <td>
                        <c:if test="${a.isGender()== true}">Male</c:if>
                        <c:if test="${a.isGender()== false}">Female</c:if>
                        </td>
                        <td>${a.getEmail()}</td>
                    <td>${a.getPhone()}</td>
                    <td>
                        <c:if test="${a.getRole()== 1}">Admin</c:if>
                        <c:if test="${a.getRole()== 2}">Customer</c:if>
                        <c:if test="${a.getRole()== 3}">Sale</c:if>
                        <c:if test="${a.getRole()== 4}">Marketing</c:if>
                        </td>
                        <td>
                        <c:if test="${a.isStatus()== true}">Action</c:if>
                        <c:if test="${a.isStatus()== false}">Inaction</c:if>
                        </td>
                        <td> <a href="userdetail?id=${a.getAccountID()}">Detail</a> </td>
                </tr>
            </c:forEach>
        </table>
        <a href="#"><input type="submit" value="Add User" /></a>
    </body>

</html>
