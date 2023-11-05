package Business;

/******************************************************************************************************
 * The OrdersList builds a list of arrays for the processor orders update table
 ******************************************************************************************************/
public class OrdersList {
    //========================Properties=====================
    public int cnt;  //Number of appointments
    public Orders[] ordArr = new Orders[20];

    //========================Methods========================
    public void addOrders(Orders a1) {
        ordArr[cnt] = a1;       //This puts the new ORDER object into the array
        cnt++;                  //Increases the count through the addition of each account
    }  //End addORDERS

    //The below is for testing with the bottom main function
    public void displayList() {
        for (var i = 0; i < cnt; i++) {
            ordArr[i].display();// Business.ORDERS class has a display() method
        }// end the for loop
    }//end displayList()
}//End Business.AccountList Class
/******************************************************************************************************
 * Testing for the ORDERSList function
 ******************************************************************************************************/
//INITIAL TESTING
//public static void main(String[] args) {
////
//        Business.OrdersList alist = new Business.OrdersList();
////        Business.Orders a = new Business.Orders("Apr 4,2023, 9am", "A915", "D596", "p800");
////        Business.Appointments b = new Business.Appointments("Apr 4,2023, 10am", "A915", "D596", "p800");
////        alist.addAppointments(a);
////        alist.addAppointments(b);
////
////
//        alist.getOrders();
//        alist.displayList();
//      }//END TESTING
//
//    private void getOrders() {
//    }
//}//End main

