<%-- 
    Document   : UserDetails
    Created on : May 28, 2022, 2:53:41 PM
    Author     : Pham Minh Giang
--%>

<%@page import="model.Account"%>
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
        <form action="userupdate">

            <table border = "1px">
                <tr>
                    <td>ID</td>
                    <td><input name="id" value="${a.accountID}"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>${a.name}</td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <c:if test="${a.gender==true}"><td>Male</td></c:if> 
                    <c:if test="${a.gender==false}"><td>Female</td></c:if> 
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${a.email}</td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td>${a.phone}</td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td>
                        <select name="role">
                            <option>${a.role}</option>
                          <c:forEach items="${requestScope.RoleList}" var="r">
                              <option value="${r.roleID}">${r.roleName}</option>
                          </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${a.address}</td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <select name="status">
                            <c:if test="${a.status==true}">
                                <option>1</option>
                            </c:if>
                            <c:if test="${a.status==false}">
                                <option>0</option>
                            </c:if>
                         <c:forEach items="${requestScope.StatusList}" var="s">
                              <option value="${s}">${s}</option>
                          </c:forEach>
                              
                            
                        </select>
                    </td>
                </tr>
            </table>  
            <input type="submit" value="Save Change" />
        </form>
    </body>
</html>
