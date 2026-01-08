import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class ControlLogic {
    Scanner scr = new Scanner(System.in);

    // create new id
    public static String generateNextOrderId() {
        int max = 0;

        for (Orders o : Model.getOrders()) {
            String id = o.getOrderId();  // B0003
            int num = Integer.parseInt(id.substring(1)); // 3
            if (num > max) {
                max = num;
            }
        }

        int next = max + 1;
        return String.format("B%04d", next);
    }


//--------------------------------------------Place Order---------------------------------------------------

    public void placeOrder() {
        int repeat = 1;
        int tot = 0;

        System.out.println("-----------------------------------------------------------------");
        System.out.println("|                       PLACE ORDER                             |");
        System.out.println("-----------------------------------------------------------------");

        while (repeat == 1) {
            // Call the ID generator
            String orderID = generateNextOrderId();
            System.out.println("Your Order ID : " + orderID);

            // Get Customer ID
            String customerID;
            String customerName = null;
            while (true) {
                System.out.print("Enter Your Customer ID (Mobile Number): ");
                customerID = scr.next();
                if (customerID.length() == 10 && customerID.startsWith("0")) break;
                else System.out.println("Invalid. Try Again.");
            }


            // Check if customer exists
            boolean customerFound = false;
            for (Orders order : Model.getOrders()) {
                if (customerID.equals(order.getCustomerId())) {
                    customerName = order.getCustomerName();
                    customerFound = true;
                    break;
                }
            }

            if (!customerFound) {
                System.out.print("Enter Your Name: ");
                customerName = scr.next();
            }

            // Burger Quantity
            System.out.print("Enter Burger Quantity: ");
            int burgerQuantity = scr.nextInt();

            // Status
            System.out.println("Order Status:\n1. PREPARING\n2. DELIVERED\n3. CANCEL");
            int orderStatus = scr.nextInt();

            //----------- Calculate Total -----------
            int burgerPrice = 500;
            if (orderStatus > 0) {
                tot = burgerPrice * burgerQuantity;
            } else {
                System.out.println("Order Cancelled");
            }


            // ----------- Confirm Order -----------
            System.out.println("Are you confirming the order?");
            System.out.println("1. YES");
            System.out.println("2. NO");
            int confirm = scr.nextInt();

            String orderId = generateNextOrderId();

            if (confirm == 1) {
                Orders newOrder = new Orders(orderId, customerID, customerName, burgerQuantity, tot, orderStatus);

                Model.addOrder(newOrder);
                System.out.println("Your order has been placed successfully.");
                System.out.println("Total Bill is Rs. " + tot);
            } else {
                System.out.println("Order not entered into the system.");
            }

            System.out.println("Do you want to place another order?\n1. YES\n2. NO");
            repeat = scr.nextInt();

            if (repeat == 2) {
                View obj3 = new View();
            }
        }
    }


//---------------------------------------------Serch Best Customer-----------------------------------------------

    public void serchBestCustomer() {
        int repeat = 1;
        float max = 0;

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|                              Best Customer                                    |");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Customer ID:                          Name:                             Total   ");

        for (Orders o : Model.getOrders()) {
            float bill = o.getBill();
            String cID = o.getCustomerId();
            String cName = o.getCustomerName();

            while (bill > max) {
                max = bill;
            }

            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(cID + "                            " + cName + "                              " + bill);
        }

        System.out.println("---------------------------------------------------------------------------------");

        System.out.println("Do you want to go back main menu?\n1. YES\n2. NO");
        repeat = scr.nextInt();

        if (repeat == 1) {
            View obj3 = new View();
        }
    }


//-------------------------------------------------Serch Order Details-----------------------------------------------------------


    public void searchOrder() {

        int repeat = 1;

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("|                                   Search Order Details                                     |");
        System.out.println("----------------------------------------------------------------------------------------------");

        while (repeat == 1) {

            System.out.print("Enter Order ID: ");
            String inputID = scr.next();

            boolean found = false;

            for (Orders o : Model.getOrders()) {

                if (o.getOrderId().equals(inputID)) {
                    found = true;

                    String status;
                    switch (o.getOrderStatus()) {
                        case 1:
                            status = "PREPARING";
                            break;
                        case 2:
                            status = "DELIVERED";
                            break;
                        default:
                            status = "CANCEL";
                    }

                    System.out.println("Order ID:     Customer ID:      Name:       Quantity:       Order Value:        Order Status:");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    System.out.println(
                            o.getOrderId() + "   " + o.getCustomerId() + "   " +
                                    o.getCustomerName() + "   " +
                                    o.getBurgerQuantity() + "   " +
                                    o.getBill() + "   " +
                                    status
                    );
                    System.out.println("----------------------------------------------------------------------------------------------");

                    break; // Exit loop after finding the order
                }
            }

            if (!found) {
                System.out.println("Order not found!");
            }

            System.out.println("Do you want to search another order?");
            System.out.println("1. YES");
            System.out.println("2. NO");
            repeat = scr.nextInt();
        }

        if (repeat == 2) {
            new View(); // go back
        }
    }


//-------------------------------------------------Serch Customer Details-----------------------------------------------------------


    public void serchCustomer() {
        int repeat = 1;

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("|                                  Search Customer Details                                    |");
        System.out.println("----------------------------------------------------------------------------------------------");

        int inputCID;

        while (repeat == 1) {

            boolean found = false;

            System.out.println("----------------------------------");
            System.out.println("Enter customer ID : ");
            inputCID = scr.nextInt();

            for (Orders order : Model.orders) {
                int cID = Integer.parseInt(String.valueOf(order.getCustomerId()));

                if (inputCID == cID) {

                    found = true;
                    System.out.println("Order ID   : " + order.getOrderId());
                    System.out.println("Customer   : " + order.getCustomerName());
                    System.out.println("Bill       : " + order.getBill());
                    System.out.println("----------------------------------");

                }
            }


            if (found) {
                System.out.println("Do you want search another customer details ? \n 1. yes \n 2. No");
                repeat = scr.nextInt();
            } else {
                System.out.println("This customer ID not added yet....\n Do you want search another customer details ? \n 1. yes \n 2. No");
                repeat = scr.nextInt();
            }
        }

        if (repeat != 1) {
            new View();
        }

    }


    //------------------------------------------------------View Order List------------------------------------------------------------------

    public void viewOrders() {

        int repeat = 1;

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("|                                     View Order List                                        |");
        System.out.println("----------------------------------------------------------------------------------------------");


        while (repeat == 1) {
            System.out.println("1.Preparing Orders \n2.Delivered Orders \n3.Cancel Order\n\n Enter Option Number To Continue : ");
            int input1 = scr.nextInt();

            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("  OrderID             CustomerID            Name           Quantity         Order Value   ");
            System.out.println("------------------------------------------------------------------------------------------");

            for (Orders order : Model.orders) {
                int orderStatus = order.getOrderStatus();

                if (orderStatus == input1) {
                    System.out.println("   " + order.getOrderId() + "    " + order.getCustomerId() + "       " + order.getCustomerName() + "         " + order.getBurgerQuantity() + "      " + order.getBill());
                    System.out.println("------------------------------------------------------------------------------------------");

                    repeat = 2;
                }
            }

            if (repeat == 1) {
                System.out.println("Order details are not found....\n   Do you want search another order list ? \n1.Yes \n2.No");
                repeat = scr.nextInt();
            } else {
                System.out.println("\nDo you want search another order list ? \n1.Yes \n2.No");
                repeat = scr.nextInt();
            }
        }

        if (repeat != 1) {
            new View();
        }

    }


    //-------------------------------------------------Update Order Details-----------------------------------------------------------

    public void updateOrderDetails() {

        int repeat = 1;
        int burgerPrice = 500;
        boolean found = false;

        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("|                                   Update Order Details                                     |");
        System.out.println("----------------------------------------------------------------------------------------------");

        while (repeat == 1) {

            System.out.println("Enter Order ID : ");
            String oID = scr.next();

            for (Orders order : Model.orders) {

                if (order.getOrderId().equals(oID)) {
                    int oStatus = order.getOrderStatus();
                    found = true;

                    switch (oStatus) {

                        case 1:

                            System.out.println("Order ID : " + order.getOrderId());
                            System.out.println("Customer ID : " + order.getCustomerId());
                            System.out.println("Name : " + order.getCustomerName());
                            System.out.println("Quantity : " + order.getBurgerQuantity());
                            System.out.println("Order Value : " + order.getBill());
                            System.out.println("Status : Preparing");

                            System.out.println("What do you want to update ?\n      1.Quantity\n      2.Status");
                            System.out.println("Enter your option : ");
                            int x = scr.nextInt();

                            switch (x) {
                                case 1:
                                    System.out.println("Quantity update");
                                    System.out.println("===============");

                                    System.out.println("\nOrder ID : " + order.getOrderId());
                                    System.out.println("\nCustomer ID : " + order.getCustomerId());
                                    System.out.println("Name : " + order.getCustomerName());

                                    System.out.println("Enter your quantity update value : ");
                                    int value = scr.nextInt();

                                    System.out.println("Order status quantity successfully");

                                    System.out.println("New order quantity : " + value);
                                    order.setBurgerQuatity(value);
                                    System.out.println("New order value : " + value * burgerPrice);
                                    order.setBill(value*burgerPrice);

                                    System.out.println("Do you want to update another order details? \n1.Yes \n2.No");
                                    repeat = scr.nextInt();

                                    break;


                                case 2:
                                    System.out.println("Status update");
                                    System.out.println("=============");

                                    System.out.println("\nOrder ID : " + order.getOrderId());
                                    System.out.println("\nCustomer ID : " + order.getCustomerId());
                                    System.out.println("Name : " + order.getCustomerName());

                                    System.out.println("1.Preparing \n2.Delivered \n3.Canel");
                                    System.out.println("Enter new order status : ");
                                    int status = scr.nextInt();

                                    System.out.println("Order status update successfully");
                                    order.setOrderStatus(status);

                                    String y;
                                    switch (status) {
                                        case 1:
                                            System.out.println("New order status : Preparing");
                                            break;

                                        case 2:
                                            System.out.println("New order status : Delivered");
                                            break;

                                        case 3:
                                            System.out.println("New order status : Cancel");
                                            break;

                                        default:
                                            System.out.println("Invalid number.Do you want update another order details\n1.Yes \n2.No");
                                            repeat = scr.nextInt();
                                    }


                                    System.out.println("Do you want to update another order details? \n1.Yes \n2.No");
                                    repeat = scr.nextInt();


                            }
                            break;

                        case 2:

                            System.out.println("This order is already delivered...You can not update this order...");
                            System.out.println("Do you want update another order details.\n1,Yes \n2.No");
                            repeat = scr.nextInt();
                            break;

                        case 3:

                            System.out.println("This order is already cancelled...You can not update this order...");
                            System.out.println("Do you want update another order details.\n1,Yes \n2.No");
                            repeat = scr.nextInt();
                            break;

                        default:

                            System.out.println("Invalid number..Do you want update another order details\n1.Yes \n2.No");
                            repeat = scr.nextInt();
                    }
                }
            }
            if (!found) {
                System.out.println("Invalid Order ID. Try again.");
            }        }

        if (repeat != 1) {
            new View();
        }
    }
}














//                    if(order.getOrderStatus() == 2){
////                        System.out.println("This order is already delivered...You can not update this order...");
////                        System.out.println("Do you want update another order details.\n1,Yes \n2.No");
////                        repeat = scr.nextInt();
//
//                    }else{
//
//                        if(order.getOrderStatus() == 3) {
////                            System.out.println("This order is already cancelled...You can not update this order...");
////                            System.out.println("Do you want update another order details.\n1,Yes \n2.No");
////                            repeat = scr.nextInt();
////                        }else{
////
////                            System.out.println("Order ID : " + order.getOrderId());
////                            System.out.println("Customer ID : " + order.getCustomerId());
////                            System.out.println("Name : " + order.getCustomerName());
////                            System.out.println("Quantity : " + order.getBurgerQuantity());
////                            System.out.println("Order Value : " + order.getBill());
////                            System.out.println("Status : Preparing");
////
////                            System.out.println("What do you want to update ?\n      1.Quantity\n      2.Status");
////                            System.out.println("Enter your option : ");
////                            int x = scr.nextInt();
////
////                            switch(x){
////                                case 1 :
////                                    System.out.println("Quantity update");
////                                    System.out.println("===============");
////
////                                    System.out.println("\nOrder ID : " + order.getOrderId());
////                                    System.out.println("\nCustomer ID : " +order.getCustomerId());
////                                    System.out.println("Name : " + order.getCustomerName());
////
////                                    System.out.println("Enter your quantity update value : ");
////                                    int value = scr.nextInt();
////
////                                    System.out.println("Update order quantity success fully");
////
////                                    System.out.println("New order quantity : " + value);
////                                    System.out.println("New order value : " + value * burgerPrice);
////
////                                    System.out.println("Do you want to update another order details? \n1.Yes \n2.No");
////                                    repeat = scr.nextInt();
////
////                                    break;
////
////
////                                case 2 :
////                                    System.out.println("Status update");
////                                    System.out.println("=============");
////
////                                    System.out.println("\nOrder ID : " + order.getOrderId());
////                                    System.out.println("\nCustomer ID : " +order.getCustomerId());
////                                    System.out.println("Name : " + order.getCustomerName());
////
////                                    System.out.println("1.Preparing \n2.Delivered \n3.Canel");
////                                    System.out.println("Enter new order status : ");
////                                    int status = scr.nextInt();
////
////                                    System.out.println("Update order quantity success fully");
////
////                                    String y;
////                                    switch (status){
////                                        case 1 :
////                                             y = "Preparing";
////                                            break;
////
////                                        case 2 :
////                                             y = "Delivered";
////                                            break;
////
////                                        case 3 :
////                                             y = "Cancel";
////                                            break;
////
////                                        default:
////                                            System.out.println("Invalied number.Do you want update another order details\n1.Yes \n2.No");
////                                            repeat = scr.nextInt();
////                                    }
////
////                                    System.out.println("New order status : " + y);
////
////                                    System.out.println("Do you want to update another order details? \n1.Yes \n2.No");
////                                    repeat = scr.nextInt();
////
////
////                            }
////
////                            }
//                    }//














