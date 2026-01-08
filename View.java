import java.util.Scanner;
public class View {

    Scanner scr = new Scanner(System.in);
    int cho1;
    ControlLogic obj2 = new ControlLogic();

    View(){

        String[] choice1 = {"Place Order","Serch Best Customer","Serch Order","Serch Customer","View Orders","Updade Order Details","Exit"};

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|                             iHungry Burger                                    |");
        System.out.println("---------------------------------------------------------------------------------");

        for (int choice = 0; choice < choice1.length; choice++) {
            System.out.println("[" + (choice + 1) + "]" + choice1[choice] );
        }

        System.out.println("");

        System.out.println("Enter An Option Continue > ");
        cho1 = scr.nextInt();

        step1();

    }



//public View(String orderID, String customerId, String customerName, int burgerQuantity, float tot) {
//    System.out.println("-----------------------------------------------------------------");
//    System.out.println("|                       PLACE ORDER                             |");
//    System.out.println("-----------------------------------------------------------------");
//    System.out.println("");
//    System.out.println("ORDER ID - B"+orderID);
//    System.out.println("=====================");
//    System.out.println("");
//    System.out.println("Enter Customer ID(Phone No.): "+customerId);
//    System.out.println("Customer Name : "+customerName);
//    System.out.println("Burger Quantity : "+burgerQuantity);
//    System.out.println("Total Value : "+tot);
//    System.out.println("");
//}


//Set Methods Using Switch
public void step1() {
    switch (cho1){
        case 1:
            obj2.placeOrder();
            break;

        case 2:
            obj2.serchBestCustomer();
            break;

        case 3:
            obj2.searchOrder();
            break;

        case 4:
            obj2.serchCustomer();
            break;

        case 5:
            obj2.viewOrders();
            break;

        case 6:
            obj2.updateOrderDetails();
            break;

        case 7:
            exit();
            break;

        default:
            System.out.println("Invalied Choice Number,Please Try Again");

    }

}


//Place order method
public void placeOrder() {
    System.out.println("Hello Case 1");
}


//serch best customer method
public void serchBestCustomer(){
    System.out.println("Hello Case 2");
}


//serch order method
public void serchOrder(){
    System.out.println("Hello Case 3");
}


//serch customer method
public void serchCustomer(){
    System.out.println("Hello Case 4");
}


//view orders method
public void viewOrders(){
    System.out.println("Hello Case 5");
}


//update order details method
public void updadeOrderDetails(){
    System.out.println("Hello Case 6");
}

public void exit(){
    System.out.println("Hello Case 7");
}




// console clear
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }


}
