<%-- 
    Document   : codeverify
    Created on : Jun 2, 2022, 12:03:52 PM
    Author     : DUC THINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="verificationemail" method="POST">
            <div>
                <h3>Please enter code in Email</h3>
                
                    <input type="text" name="codeInput" class="form-control bg-light border-0" placeholder="Code" style="height: 40px;"><br/>
                    <h5 style="color: #664d03;">${requestScope.notCorrect}</h5>
                
                    <input type="submit" value="submit"/>
            </div></form>
    </body>
</html>
