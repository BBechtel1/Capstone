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
 * The Cards class is used for accessing the Cards info table
 *************************************************************************************************/
public class Cards {

    /*************************************************************************************************
     * Cards Properties
     *************************************************************************************************/
    private String ProdID;
    private String Occasion;
    private String Price;


    /*************************************************************************************************
     * Cards Set Properties to empty values
     *************************************************************************************************/
    public Cards() {
        ProdID = "";
        Occasion = "";
        Price = "";
    }

    /*************************************************************************************************
     * Cards Constructor
     *************************************************************************************************/
    public Cards(String cardProdID, String cardOccasion, String cardPrice) {
        ProdID = cardProdID;
        Occasion = cardOccasion;
        Price = cardPrice;
    }

    /*************************************************************************************************
     * Cards Get and Set Properties
     *************************************************************************************************/

    public void setcardProdID(String cardProdID) {
        ProdID = cardProdID;
    }

    public String getcardProdID() {
        return ProdID;
    }

    public void setcardsOccasion(String cardOccasion) {
        Occasion = cardOccasion;
    }

    public String getcardsOccasion() {
        return Occasion;
    }

    public void setcardsPrice(String cardPrice) {
        Price = cardPrice;
    }

    public String getcardsPrice() {
        return Price;
    }


    /*************************************************************************************************
     * Cards Display Method
     *************************************************************************************************/
    public void display() {
        System.out.println("ProductID = " + getcardProdID());
        System.out.println("Occasion = " + getcardsOccasion());
        System.out.println("Card Price = " + getcardsPrice());
    }

    //==============================================SelectDB=============================================

    /*************************************************************************************************************
     * The Cards SelectDb pulls for a display or output function Cards by ProdID for the CardsInfoPage
     *************************************************************************************************************/
    public void selectDB(int cardProdID) {
        ProdID = String.valueOf(cardProdID);
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB1.accdb");
            //Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/JAVA3 FinalProj./DentistsOffice/src/DentistOfficeMDB.mdb");
            // -------Execute SQL Statement----------

            // Use this to print out columns in the database table Cards"
//            DatabaseMetaData metaData = con.getMetaData();
//            String tableName = "Cards"; // Replace with your table name
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
            String sql = "SELECT * FROM Cards where ProductID = " + ProdID;

            ResultSet result = stmt.executeQuery(sql);
            //Advances query to next row
            result.next();
            //---------Process ResultSet rs----------
            setcardProdID(result.getString(1));
            setcardsOccasion(result.getString(2));
            setcardsPrice(result.getString(3));

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException | SQLException el) {
//            System.out.println(el);
        } // End Try Catch
    }  // END selectDB


    //======================================INSERT DB====================================================

    /*************************************************************************************************
     * The Cards insertDb insertDB inputs info to the database from the user
     *************************************************************************************************/
    public void insertDB(String cardProdID, String cardOccasion, String cardPrice) {
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB1.accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            // =========================================INSERT STATEMENT==============================================================
            String sql = "INSERT INTO Cards (ProductID, Occasion, Price) " +
                    "values('" + cardProdID + "'," + "'" + cardOccasion + "'," + "'" + cardPrice + "')";
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
     * The Cards updateDB places the information into the Cards data table by ProdID for the CardInfoPage
     ***************************************************************************************************************/
    public void updateDB(int cardProdID, String cardOccasion, String cardPrice) {
        ProdID = String.valueOf(cardProdID);
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB1.accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            //String sql = String.format("UPDATE Users SET PassWord = 'blue1234' where UserId = 1");
            String sql = String.format("UPDATE Cards SET "
                    + "Occasion = '%s' "
                    + ",Price = '%s' "
                    + "WHERE ProductID = %s", cardOccasion, cardPrice, ProdID);
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
     * The Cards deleteDB deletes cards from the cards data table by cardProdID for the user
     ******************************************************************************************************/
    public void deleteDB(String cardProdID) {
        try {
            //----------------Load DB Driver #1 ----------------------
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //------------------Connect #2----------------------------
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "/Users/blainebechtel/Desktop/Capstone/Capstone/src/GreetingCardsDB1.accdb");

            // -------Execute SQL Statement----------
            Statement stmt = con.createStatement();
            String sql = "Delete from Cards where(ProductID = '" + cardProdID + "')";
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


//    public void getOrders() {
//        Statement st = con.createStatement();
//        ResultSet res = st.executeQuery("SELECT * FROM  Orders");
//        while (res.next()) {
//            int i = res.getInt("ID");
//            String s = res.getString("name");
//            System.out.println(i + "\t\t" + s);
//        }
//        con.close();
//    }
    // YOU MUST NOTE THE } BELOW OUT TO TEST WITH THE MAIN(STRING ARGS) BELOW
}// =====================================END CARDS CLASS========================================

/******************************************************************************************************
 * Testing section of the Cards data functions that were used to verify each function worked
 ******************************************************************************************************/

// ---------------Test--------------------//All These Work
//   public static void main(String[] args) {

//        Cards d2 = new Cards();//       d2.insertDB("6", "Easter", "10.00");
//
//        Cards d3 = new Cards();
//        d3.updateDB(6, "Hannukah", "25.00");
//
//        Cards d5 = new Cards();
//        d5.deleteDB("6");

//       Cards d4 = new Cards();
//        d4.selectDB(5);
//        d4.display();
//
//    } //End Main for testing
//}//Testing End Main


