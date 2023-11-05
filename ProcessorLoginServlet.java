//<%--
//        Created by IntelliJ IDEA.
//        User: blainebechtel
//        Date: 9/30/23
//        Time: 10:04 AM
//        To change this template use File | Settings | File Templates.
//        --%>
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

import Business.Users;
import Business.Orders;

import javax.annotation.processing.Processor;

/*************************************
 * PROCESSOR LOGIN SERVLET
 * ***********************************/
@WebServlet(name = "ProcessorLoginServlet", value = "/ProcessorLoginServlet")
public class ProcessorLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charsetUTF-8");
        PrintWriter out = response.getWriter();

        /******************************************************************
         * Declare variables for ID and Password from User for Client
         * ****************************************************************/
        String id, pw;  //Declare user variables
        String dbPassword = null;


        try {
            //STEP #1 Get the ID and password from the previous HTML file through userID and
            // passWord pass to local vars id and pw
            id = request.getParameter("userID");
            pw = request.getParameter("passWord");

            if (id == "" || pw == "")  {
                /************************************************************************************
                 * NEED TO BUILD A CARDS ERROR PAGE FOR THIS FUNCTION TO WORK
                 *(COMPLETED)(COMPLETED)(COMPLETED)(COMPLETED)(COMPLETED)(COMPLETED)(COMPLETED)
                 *  If Password or data fields are empty send to error page for User
                 *  *********************************************************************************/
                // STEP #5 Put the Client object in the session

                // STEP 6 Use RequestDispatcher to forward to the next .jsp if the fields do not match
                RequestDispatcher rd = request.getRequestDispatcher("/UserErrorPage.jsp");//Call the error page
                rd.forward(request, response);
                out.println("<h4> Your Password is incorrect </4> ");
            }

            //STEP #2 Get any objects out of the session using getAttributes() Not done on this page

            //STEP #3 Create any objects to look up a customer

            /************************************************************************************
             *  Initialize database connection Instantiate Users for Processor  (DID IT)
             *  *********************************************************************************/
            Users u1 = new Users();            //instantiate a User
            u1.selectDB(Integer.parseInt(id)); //bring in id from login page for Processor (LOGIN PAGE)
            dbPassword = u1.getuserPassWd();   //bring in Processor password from database matching id number if present
            //c1.display();

            //STEP #4 Make any decisions
            /**********************************************************************************************************
             *Do upon password proving correct if user password and database PW equal allow the following for Processor
             *  *******************************************************************************************************/
            if (dbPassword != null && dbPassword.equals(pw)) {
                u1.getuserID(); //Call getOrders list //////and pass the id to getOrders()*****************
                out.println("userID");

                // STEP #5 Put the Orders object in the session
                /********************************************************
                 * I MAY NOT NEED THIS HERE FOR UPDATING PROCESSOR INFO.
                 * Processor info can be changed with the main login page
                 * Processor object placed in session
                 * *******************************************************/
                Orders o1 = new Orders();
                o1.getOrders();
                HttpSession ses1;
                ses1 = request.getSession();
                ses1.setAttribute("order1", o1); // Places Processors ID into the session

                /*************************************************************************************
                 *  THIS WILL CHANGE TO ORDERS LIST OBJECT FOR ORDERS TABLE BUILD
                 *
                 * Process Order object placed in session to build the table
                 * **********************************************************************************/

                Orders o2 = o1.aList.ordArr[0];           //instantiate an Orders List call
                ses1.setAttribute("ordersList", o2);      //Pass the info to the ChangeOrdStatPage.jsp

                /************************************************
                 * Request dispatcher fot ClientLogin.JSP
                 * *********************************************/
                RequestDispatcher rd = request.getRequestDispatcher("/ChangeOrdStatPage.jsp"); // Calls/Opens account lookUp page
                rd.forward(request, response);
            } else {
                /******************************************************
                 *  If Password is incorrect pass to CARD ErrorPage
                 *  **************************************************/
                // STEP #5 Put the Client object in the session *****NOT USED HERE


                // STEP 6 Use RequestDispatcher to forward to the next .jsp
                RequestDispatcher rd = request.getRequestDispatcher("/UserErrorPage.jsp");//Call the error page
                rd.forward(request, response);
                out.println("<h4> Your Password is incorrect </4> ");
            }
        } finally {
            out.close();
        }
    }

    /*******************************************************
     * doPost for ORDERInfoPage Changes sent from client
     * *****************************************************/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Orders ordersInfo = new Orders();

        /****************************************************************************
         * THIS WILL BE AN UPDATE FUNCTION FOR THE Processor ID and personal info
         *
         * //BRING IN DATA FROM processor INFO PAGE FORM AND PASS TO UPDATE FUNCTION
         * ***************************************************************************/

        try {
                    ordersInfo.updateStatusDB(Integer.parseInt(request.getParameter("orderID")),
                            request.getParameter("orderStatus"));
//                            request.getParameter("userID"),
//                            request.getParameter("orderTotal"),
        } catch (Exception e) {
            e.printStackTrace();
        }
        /****************************************************************************
         * THIS WILL BE UPDATE ORDERS INSTANTIATION
         *
         * // INSTANTIATE ORDERS HERE
         * ***************************************************************************/

        Orders o1 = new Orders();
        o1.getOrders();
        HttpSession ses1;
        ses1 = request.getSession();
        ses1.setAttribute("order1", o1); // Places Processors ID into the session

        /******************************************************************************
         * INSTANTIATE Orders HERE TO LOOP BACK AROUND TO THE ChangeOrderStatus INFO PAGE
         * ****************************************************************************/

        Orders o2 = o1.aList.ordArr[0];           //instantiate an Orders List call
        ses1.setAttribute("ordersList", o2);      //Pass the info to the ChangeOrdStatPage.jsp



        /******************************************************************************************
         * Use RequestDispatcher to forward to the next .jsp  RECALL PAGE FOR UPDATED INFO
         * ****************************************************************************************/
        // STEP 6 Use RequestDispatcher to forward to the next .jsp  RECALL PAGE FOR UPDATED INFO
        RequestDispatcher rd = request.getRequestDispatcher("/ChangeOrdStatPage.jsp"); // Calls/Opens Orders Status check/change page
        rd.forward(request, response);
    }
}