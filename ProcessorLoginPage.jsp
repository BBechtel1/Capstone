<%--
  Created by IntelliJ IDEA.
  User: blainebechtel
  Date: 9/30/23
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/cards.css" rel="stylesheet">
    <%--                                    Web Browser Bar Header                                       --%>
    <title>CardsProcessorLogIn</title>

    <style>
        <%--                                Web Page Background                                          --%>
        html {
            -webkit-background-size: 100%;
            -moz-background-size: 100%;
            -o-background-size: 100%;
            background-size: 100%;
            background: url("errorCard.jpg") center no-repeat fixed;
        }
        h1 {
            background-color: transparent;
            color: black;
            text-align: center;
        }

    </style>
</head>
<body>
<%--                                            Page Header                                          --%>
<h1>Process LogIn Page</h1>
<%--                                       Set up Nav Buttons                                        --%>
<div class="navButtonCL">
    <a href="index.jsp">
        <button class="button">Home Page</button>
    </a></br></br></br></br>
</div>
<%--                                         Login Form layout                                       --%>
<nav class="navCL">

    <form action="ProcessorLoginServlet">      <!----Passes userID and passWord to LoginServletDB Servlet--->
        <label>USER ID:</label>
        <input type="text" name="userID"/> <br/><br/>   <!--onsubmit="validateUserID()"/>-->
        <label>PASSWORD:</label>
        <input type="text" name="passWord"/><br/><br/>  <!--onsubmit="validatePassWord()"/>-->

        <%--                       set up submit and clear buttons and style them here                   --%>
        <input type="submit" value="Login"
               style="color:rgb(1, 1, 170); height:35px; width:100px; font-size: 20px; margin-left:100px" ;/><br/><br/>
        <!--Submit the form and call login() button -->

        <input type="reset" value="Clear"
               style="color:rgb(1, 1, 170); height:35px; width:100px; font-size: 20px; margin-left:100px" ;/><br/>
        <!--Reset the form with the clear button-->
    </form>
</nav>

</body>
</html>