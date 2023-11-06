
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <body>
        <%
        Users users = (Users)session.getAttribute("users");
        if(users != null){
        int Email = customer.getEmail();
        out.println("User not found. Please double check credentials and try again.");
            }
            %>
    </body>
    
</html>
