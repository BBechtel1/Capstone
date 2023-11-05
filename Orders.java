package Business;
//-------------------------------------------------------------------
//       Created by IntelliJ IDEA.
//        User: blainebechtel CAPSTONE
//        Date: 09/16/23
//        Time: 9:08 AM
//        To change this template use File | Settings | File Templates.
// ---------------------------------------------------------------------/

import java.sql.*;

/*************************************************************************************************
 * The Orders class is used for accessing the Orders table
 *************************************************************************************************/
public class Orders {

    /*************************************************************************************************
     * Instantiate Appointment Array in the Dentists class
     *************************************************************************************************/
    public OrdersList aList = new OrdersList();

    /*************************************************************************************************
     * Orders Properties
     *************************************************************************************************/
    private String OrderID;
    private String UserID;
    private String OrderTotal;

    /*************************************************************************************************
     * Orders Set Properties to empty values
     *************************************************************************************************/
    public Orders() {
        OrderID = "";
        UserID = "";
        OrderTotal = "";
    }

    /*************************************************************************************************
     * Orders Constructor
     *************************************************************************************************/
    public Orders(String orderID, String uID, String ordTotal) {
        OrderID = orderID;
        UserID = uID;
        OrderTotal = ordTotal;

    }

    /*************************************************************************************************
     * Orders Get and Set Properties
     *************************************************************************************************/

    public void setordID(String orderID) {
        OrderID = orderID;
    }

    public String getordID() {return OrderID;}

    public void setuserID(String uID) {
        UserID = uID;
    }

    public String getuserID() {
        return UserID;
    }

    public void setorderTotal(String ordTotal) {
        OrderTotal = ordTotal;
    }

    public String getorderTotal() {
        return OrderTotal;
    }

    /*************************************************************************************************
     * Orders Display Method
     *************************************************************************************************/
    public void display() {
        System.out.println("OrderID = " + getordID());
        System.out.println("UserID = " + getuserID());
        System.out.println("Order Total = " + getorderTotal());
/*        System.out.println("Order Status = " + getorderStatus());     */

    }

    //==============================================SelectDB=============================================

    /*************************************************************************************************************
     * The Orders SelectDb pulls for a display or output function Orders by ordID for the OrdersInfoPage
     *************************************************************************************************************/
    public void selectDB(int orderID) {
        OrderID = String.valueOf(orderID);
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");
            // -------Execute SQL Statement----------

//            //Use this to print out columns in the database table Orders"
//            DatabaseMetaData metaData = con.getMetaData();
//            String tableName = "Orders"; // Replace with your table name
//
//            // Retrieve column information
//            ResultSet columns = metaData.getColumns(null, null, tableName, null);
//
//            // Iterate through the result set to display column details
//            while (columns.next()) {
//                String columnName = columns.getString("COLUMN_NAME");
//                String dataType = columns.getString("TYPE_NAME");
//                int columnSize = columns.getInt("COLUMN_SIZE");
//                boolean isNullable = columns.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
//                System.out.println("Column Name: " + columnName);
//                System.out.println("Data Type: " + dataType);
//                System.out.println("Column Size: " + columnSize);
//                System.out.println("Nullable: " + isNullable);
//                System.out.println("------------------------");
//            }

            Statement stmt = con.createStatement();
            // Select all Dentist information from Dentists database Where id is equal to referenced dID
            String sql = "SELECT * FROM Orders where OrderID = " + OrderID;

            ResultSet result = stmt.executeQuery(sql);
            //Advances query to next row
            result.next();
            //---------Process ResultSet rs----------
            setordID(result.getString(1));
            setuserID(result.getString(2));
            setorderTotal(result.getString(3));

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException | SQLException el) {
//            System.out.println(el);
        } // End Try Catch
    }  // END selectDB


    //======================================INSERT DB====================================================

    /*************************************************************************************************
     * The Orders insertDB inputs info to the database orders table from the user
     *************************************************************************************************/
    public void insertDB(String orderID, String uID, String ordTotal) {
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            // =========================================INSERT STATEMENT==============================================================
            String sql = "INSERT INTO Orders (OrderID, UserID, OrderTotal) " +
                    "values('" + orderID + "'," + "'" + uID + "'," + "'" + ordTotal + "')";
            System.out.println(sql);
            int t1 = stmt.executeUpdate(sql);
            if (t1 == 1) {
                System.out.println("Insert IS Gooooood!!");
            } else {
                System.out.println("Insert WAS A NO GO!!");
            }
            //----------Close DB Connection----------
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException | SQLException el) {
//            System.out.println(el);
        } //End Try Catch
    } // End insertDB

    //=======================================UPDATE DB===================================================

    /****************************************************************************************************************
     * The Orders updateDB places the information into the Orders data table by OrderID for the OrderInfoPage
     ***************************************************************************************************************/
    public void updateDB(int orderID, String uID, String ordTotal) {
        OrderID = String.valueOf(orderID);
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            //String sql = String.format("UPDATE Users SET PassWord = 'blue1234' where UserId = 1");
            String sql = String.format("UPDATE Orders SET "
                    + "UserID = '%s' "
                    + ",OrderTotal = '%s' "
                    + "WHERE OrderID = %s", uID, ordTotal, OrderID);
            System.out.println(sql);
            int t1 = stmt.executeUpdate(sql);
            if (t1 == 1) {
                System.out.println("Update IS Gooooood!!");
            } else {
                System.out.println("Update WAS A NO GO!!");
            }
            //----------Close DB Connection----------
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException | SQLException el) {
//            System.out.println(el);
        } // End try Catch
    } // End updateDB

    //========================================DELETE DB==================================================

    /******************************************************************************************************
     * The Orders deleteDB deletes orders from the Orders data table by OrderID for the user
     ******************************************************************************************************/
    public void deleteDB(String orderID) {
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            String sql = "Delete from Orders where(OrderID = '" + orderID + "')";
            System.out.println(sql);
            int t1 = stmt.executeUpdate(sql);
            if (t1 == 1) {
                System.out.println("Delete IS Gooooood!!");
            } else {
                System.out.println("Delete WAS A NO GO!!");
            }
            //----------Close DB Connection----------
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException | SQLException el) {
//            System.out.println(el);
        } // End Try Catch
    }// END DELETE DB
    //=========================================GET Appointments Schedule FOR DENTIST ID=================================

    /*****************************************************************************************************************
     * The USERS getOrders places the information into the orders data table
     * for all the orders in it
     ****************************************************************************************************************/

    public void getOrders() {

        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            String sql = "Select * from Orders ";
                    //where dentId = '" + getuserID() + "'";
//            String sql = "SELECT * FROM Appointments where dentId = '" + id + "'";
            System.out.println(sql);
            ResultSet result = stmt.executeQuery(sql);  //JUMPS OUT FROM HERE

            //-----LOCAL VARIABLES----//
            String orderID;
            Orders a1;
//            //------WHILE LOOP TO LOOP THROUGH EACH ORDER BY USERID ---//
            while (result.next()) {
                orderID = result.getString(1);
                //System.out.println("OrderID = " + orderID);
                a1 = new Orders();
                a1.selectDB(Integer.parseInt(orderID));
//                a1.display();

                //----ADD THE ARRAY TO THE ARRAY LIST---//
                aList.addOrders(a1);
            }
            aList.displayList();
            //----------Close DB Connection----------
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } //End Try Catch
    } // End getAppointments

     //YOU MUST NOTE THE } BELOW OUT TO TEST WITH THE MAIN(STRING ARGS) BELOW
}// =====================================END USERS CLASS========================================

/******************************************************************************************************
 * Testing section of the Orders data functions that were used to verify each function worked
 ******************************************************************************************************/

// ---------------Test--------------------//All These Work
//    public static void main(String[] args) {
//
//
//        Orders d1 = new Orders();
//        d1.getOrders();
//        d1.display();
//
//        Orders d2 = new Orders();
//        d2.insertDB("6", "8675", "25.00");
//
//        Orders d3 = new Orders();
//        d3.updateDB(6, "309", "3");

//        Orders d5 = new Orders();
//        d5.deleteDB("6");

//        Orders d4 = new Orders();
//        d4.selectDB(6);
//        d4.display();

//    } //End Main for testing
//} //Testing End Main

