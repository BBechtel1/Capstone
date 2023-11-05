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
 * The Users class is used for accessing the Dentists info database files
 *************************************************************************************************/
public class Users {

    /*************************************************************************************************
     * Instantiate Appointment Array in the Dentists class
     *************************************************************************************************/
    //public AppointmentsList aList = new AppointmentsList();

    //==================For Testing==============================================
//    public Appointments a1 = new Appointments();

    /*************************************************************************************************
     * Users Properties
     *************************************************************************************************/
    private String UserID;
    private String FirstName;
    private String LastName;
    private String Address;
    private String Email;
    private String Password;
    private String Type;

    /*************************************************************************************************
     * Users Set Properties to empty values
     *************************************************************************************************/
    public Users() {
        UserID = "";
        FirstName = "";
        LastName = "";
        Address = "";
        Email = "";
        Password = "";
        Type = "";
    }

    /*************************************************************************************************
     * Users Constructor
     *************************************************************************************************/
    public Users(String uID, String uFirstName, String uLastName, String uEmail, String uAddress, String uPassWd, String uType) {
        UserID = uID;
        FirstName = uFirstName;
        LastName = uLastName;
        Email = uEmail;
        Address = uAddress;
        Password = uPassWd;
        Type = uType;
    }

    /*************************************************************************************************
     * Users Get and Set Properties
     *************************************************************************************************/

    public void setuserID(String uID) {
        UserID = uID;
    }

    public String getuserID() {
        return UserID;
    }

    public void setuserFirstName(String uFirstName) {
        FirstName = uFirstName;
    }

    public String getuserFirstName() {
        return FirstName;
    }

    public void setuserLastname(String uLastName) {
        LastName = uLastName;
    }

    public String getuserLastName() {
        return LastName;
    }

    public void setuserEmail(String uEmail) {
        Email = uEmail;
    }

    public String getuserEmail() {
        return Email;
    }

    public void setuserAddress(String uAddress) {
        Address = uAddress;
    }

    public String getuserAddress() {
        return Address;
    }

    public void setuserPassWd(String uPassWd) {
        Password = uPassWd;
    }

    public String getuserPassWd() {
        return Password;
    }

    public void setuserType(String uType) {
        Type = uType;
    }

    public String getuserType() {
        return Type;
    }

    /*************************************************************************************************
     * Users Display Method
     *************************************************************************************************/
    public void display() {
        System.out.println("User ID = " + getuserID());
        System.out.println("User First Name = " + getuserFirstName());
        System.out.println("User Last Name = " + getuserLastName());
        System.out.println("User E-mail = " + getuserAddress());
        System.out.println("User Address = " + getuserEmail());
        System.out.println("User PassWord = " + getuserPassWd());
        System.out.println("User Type = " + getuserType());
    }

    //==============================================SelectDB=============================================

    /*************************************************************************************************************
     * The Users SelectDb pulls for a display or output function Dentists by UsersID for the UsersPage
     *************************************************************************************************************/
    public void selectDB(int uID) {
        UserID = String.valueOf(uID);
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");
            // -------Execute SQL Statement----------

//             This was a mix-up data entry Passoword " Had to print out columns in the database table Users"
            DatabaseMetaData metaData = con.getMetaData();
            String tableName = "Users"; // Replace with your table name

            // Retrieve column information
            ResultSet columns = metaData.getColumns(null, null, tableName, null);

            // Iterate through the result set to display column details
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String dataType = columns.getString("TYPE_NAME");
                int columnSize = columns.getInt("COLUMN_SIZE");
                boolean isNullable = columns.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
                System.out.println("Column Name: " + columnName);
                System.out.println("Data Type: " + dataType);
                System.out.println("Column Size: " + columnSize);
                System.out.println("Nullable: " + isNullable);
                System.out.println("------------------------");
            }


            Statement stmt = con.createStatement();
            // Select all User information from User database Where id is equal to referenced dID
            String sql = "SELECT * FROM Users where UserID = " + UserID;

            ResultSet result = stmt.executeQuery(sql);
            //Advances query to next row
            result.next();
            //---------Process ResultSet rs----------
            setuserID(result.getString(1));
            setuserFirstName(result.getString(2));
            setuserLastname(result.getString(3));
            setuserEmail(result.getString(4));
            setuserAddress(result.getString(5));
            setuserPassWd(result.getString(6));
            setuserType(result.getString(7));
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException | SQLException el) {
//            System.out.println(el);
        } // End Try Catch
    }  // END selectDB


    //======================================INSERT DB====================================================

    /*************************************************************************************************
     * The Users insertDB inputs info to the database from the user
     *************************************************************************************************/
    public void insertDB(String uID, String uFirstName, String uLastName, String uAddress, String uEmail, String uPassWd, String uType) {
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            // =========================================INSERT STATEMENT==============================================================
            String sql = "INSERT INTO Users (UserID, FirstName, LastName, Address, Email, Passoword, Type) " +
                    "values('" + uID + "'," + "'" + uFirstName + "'," + "'" + uLastName + "'," + " " + "'" + uAddress + "'," + "'" + uEmail + "'," + "'" + uPassWd + "'," + "'" + uType + "')";
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
     * The Users updateDB places the information into the Users data table by UsersID for the UsersInfoPage
     ***************************************************************************************************************/
    public void updateDB(int uID, String uFirstName, String uLastName, String uEmail, String uAddress, String uPassWd,
                         String uType) {
        UserID = String.valueOf(uID);
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            //String sql = String.format("UPDATE Users SET PassWord = 'blue1234' where UserId = 1");
            String sql = String.format("UPDATE Users SET "
                    + "FirstName = '%s' "
                    + ",LastName = '%s' "
                    + ",Email = '%s' "
                    + ",Address = '%s' "
                    + ",PassoWord = '%s' "
                    + ",Type = '%s' "
                    + "WHERE UserID = %s", uFirstName, uLastName, uEmail, uAddress, uPassWd, uType, UserID);
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
     * The Users deleteDB deletes appointments from the Users data table by UsersID for the user
     ******************************************************************************************************/
    public void deleteDB(String uID) {
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            String sql = "Delete from Users where(UserID = '" + uID + "')";
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


    //=================================GET ORDERS INFO AND PASS TO ORDER PROCESSING PAGE=================================

    /*****************************************************************************************************************
     * The OrderProcess getOrders places the information into the orders data table
     * by orderProcess UserID for the OrderInfoPage ArrayList
     ****************************************************************************************************************/


    //ALL THE CALLS WILL CHANGE HERE TO PASS THE VALUES FROM THE ORDERS TABLE TO THE PROCESS PAGE

//    public void getOrders(String id) {
//        setuserID(id);
//
//        try {
//            //----------------Load DB Driver #1 ----------------------
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            //------------------Connect #2----------------------------
//            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB (1).accdb");

//            // -------Execute SQL Statement----------
//            Statement stmt = con.createStatement();
//            String sql = "Select * from Appointments where dentId = '" + getuserID() + "'";
////            String sql = "SELECT * FROM Appointments where dentId = '" + id + "'";
//            System.out.println(sql);
//            ResultSet result = stmt.executeQuery(sql);  //JUMPS OUT FROM HERE
//
//            //-----LOCAL VARIABLES----//
//            String patID;
//            Appointments a1;
//
////            //------WHILE LOOP TO LOOP THROUGH EACH Appointment LINKED TO THE Dentists ID---//
//            while (result.next()) {
//                patID = result.getString(3);
//                System.out.println("patient ID = " + patID);
//                a1 = new Appointments();
//                a1.addApptList(patID);
//                a1.display();
//
//                //----ADD THE ARRAY TO THE ARRAY LIST---//
//                aList.addAppointments(a1);
//
//            }
//            //----------Close DB Connection----------
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();

//        } //End Try Catch
//    } // End getOrders
//
    // YOU MUST NOTE THE "}" BELOW OUT TO TEST WITH THE MAIN(STRING ARGS) BELOW
}// =====================================END USERS CLASS========================================

/******************************************************************************************************
 * Testing section of the Dentists data functions that were used to verify each function worked
 ******************************************************************************************************/

// ---------------Test--------------------//All These Work
//    public static void main(String[] args) {
//
//
//        Users t1 = new Users("U401", "Diana", "Prince", "Somewhere over the rainbow" , "WWisAdcCharacter@dc.net", "WW#1", "Customer");
//        t1.selectDB("0");
//        t1.display();

////        //t1.getAppointments("D201");


//        Users d2 = new Users();
//            d2.insertDB("401", "Diana", "Prince", "Somewhere over the rainbow" , "WWisAdcCharacter@dc.net", "blue135", "Customer");
//        //d2.insertDB("D402", "FWord", "Yak", "Mouth", "notreal@boringme.com", "601");
//        //d2.insertDB("D403", "PWord", "Rootin", "Shootin", "yoSimmity@gmail.com", "600");
//
//        Users d3 = new Users();
//        d3.updateDB(1, "John", "Harris", "jharris@gmail.com", "1111 Lake Dr Acworth, Ga 30101", "blue123", "Customer");
//
//        Users d1 = new Users();
//        d1.selectDB(1);
//        d1.display();

//        Users d4 = new Users();
//        d4.selectDB(401);
//        d4.display();

//        Users d4 = new Users();
//        d4.deleteDB(401);

//    } //End Main for testing
//}//Testing End Main
