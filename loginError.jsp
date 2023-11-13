
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Users"%>
<!DOCTYPE html>
<html>
    <head>
    <body>
        <h1>Login Error</h1>
        <%      
            Users userEmail = (Users)session.getAttribute("userEmail");
            if(userEmail != null){
            out.println("Error logging in for user with Email" + userEmail +  ", invalid password!");
           out.println("cool!");
            }
            else{
            out.print("User not found. Please go back and try again.");
            }
            %>
    </body>
    
</html>
