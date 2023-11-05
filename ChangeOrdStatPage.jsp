<%--
  Created by IntelliJ IDEA.
  User: blainebechtel
  Date: 9/30/23
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Business.Orders" %>
<%@ page import="Business.Users" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/cards.css" rel="stylesheet">
    <script src="js/forms.js"></script>

    <%--                                    Web Browser Bar Header                                 --%>
    <title>Check/ChangeOrderStatusCards</title>

</head>
<body>
    <%--                            Session Attributes for JSP tables                                --%>
    <%
        Orders o1 = (Orders) session.getAttribute("order1");
        Orders OID;
        OID = (Orders) session.getAttribute("order1");
        OID.display();
        o1.display();
    %>

<%--                          Page Header                                           --%>
<h1>Process Information Page</h1>


<nav>
    <%--                                       Set up Nav Buttons                                    --%>
    <div class="navButton">
        <a href="index.jsp">
            <button class="button">Home Page</button>
        </a>&nbsp;&nbsp;
        <a href="ProcessorLoginPage.jsp">
            <button class="button">User Login</button>
        </a></br>
    </div>
</nav>

<%
    Orders ord1 = (Orders) session.getAttribute("ordersList");

    if (ord1 == null) {
        ord1 = new Orders();
        ord1.setordID("99999999");
        ord1.display();
    }
%>
</br></br>


<table class="clientInfoTable">
    <%--                   Set up Table for passed in customer account information             --%>
    <tr>
        <%--TABLE HEADER FOR FIELDS--%>
        <th>OrderID</th>
        <th>UserID</th>
        <th>OrderTotal</th>
        <th>Status</th>

<%--    </tr>--%>

<%--    &lt;%&ndash;                          OID INFORMATION PASSED INTO THE TABLE FIELDS                               &ndash;%&gt;--%>
    <tr>


            <% for (int i = 0; i < o1.aList.cnt; i++) { %>
        <tr>
            <td><input type="text" name="OrderID" value="<%=o1.aList.ordArr[i].getordID()%>"/></td>
            <td><input type="text" name="UserID" value="<%=o1.aList.ordArr[i].getuserID()%>"/></td>
            <td><input type="text" name="OrderTotal" value="<%=o1.aList.ordArr[i].getorderTotal()%>"/></td>
<%--            <td><input type="text" name="OrderStatus" value="<%=o1.aList.ordArr[i].getordStatus()%>"/></td>--%>

            <% } %>

    </tr>
</table>


<nav>
    <div class="dForm1">

        <h4>Enter the Order ID and the updated Order Status information.</h4>
        <h4>Please fill out this form completely and press Update.</h4>

        <%--                            Call Validate form function                             --%>
        <form name="UpdateOrderForm" action="<%= request.getContextPath() %>/ProcessorLoginServletServlet"
              onsubmit="return validatePatForm()" method="post" required>


            <label>Order ID:</label>
            <input type="text" name="orderID"/><br/>
            <label>User ID:</label>
            <input type="text" name="userID"><br/>
            <label>Order Total:</label>
            <input type="text" name="orderTotal"><br/>

<%--********************Use the below if I want to keep the other fields hidden *******************--%>
<%--            <input type="hidden" name="userID" value="<%=OID.getuserID()%>"/>--%>

<%--            <input type="hidden" name="orderTotal" value="<%=OID.getorderTotal()%>"/><br/>--%>

            <label>Order Status:</label>
            <select orderStatus="Code" name="orderStatus">
                <option value=></option>
                <option value="Open">Open</option>
                <option value="Ready">Ready</option>
                <option value="Delivered">Delivered</option>

            </select> <br/><br/>

            <!-- set up submit and clear buttons and style them here-->
            <input type="submit" value="Update"
                   style="height:35px; width:100px; font-size: 20px; margin-left:120px"/>
            <input type="reset" value="Clear"
                   style="height:35px; width:100px; font-size: 20px; margin-left:30px"/><br/><br/>
        </form>

    </div>
</nav>

<%--ClientInfoPage from here--%>
</body>
</html>

