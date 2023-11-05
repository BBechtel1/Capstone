<%--
  Created by IntelliJ IDEA.
  User: blainebechtel
  Date: 9/30/23
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>


<%@ page import="Business.Users" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!Doctype html>
<html lang="en">
<!-- Set up for smaller screens, add title to webpage bar set hrefs for navigation-->
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/cards.css" rel="stylesheet">

    <%--                                    Web Browser Bar Header                                   --%>
    <title>ErrorPageCardsSite</title>

    <style>
        <%--                                Web Page Background                                          --%>
        html {
            -webkit-background-size: 100%;
            -moz-background-size: 100%;
            -o-background-size: 100%;
            background-size: 100%;
            background: indianred;
            /*background: rgba(189, 190, 192, 0.979) url("errorCard.jpg") no-repeat fixed top;*/
        }
        h1 {
            background-color: transparent;
            color: black;
            text-align: center;
        }
    </style>

</head>
<body>
<%--                                        Page Header                                           --%>
<br/><br/>
<h1>Cards Error Page</h1>
<br/><br/><br/>

<%--                                       Error Paragrapgh                                       --%>
<p class="errorPar">
<h2>
    You Must be a Processor to enter this page.</br><br>

    You have entered your Username or Password incorrectly.</br>
    Please navigate to the Home Page and try again.</br>
</h2>
</p>

<%--                                       Set up Nav Buttons                                    --%>
<div class="navButton">
    <a href="index.jsp">
        <button class="button">Home Page</button>
    </a>
</div>
</body>
</html>
