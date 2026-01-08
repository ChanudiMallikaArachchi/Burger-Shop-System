import java.util.ArrayList;

public class Model {
    public static ArrayList<Orders> orders = new ArrayList<>();

    public static void addOrder(Orders order) {
        orders.add(order);
    }

    public static ArrayList<Orders> getOrders() {
        return orders;
    }
}







//import java.util.ArrayList;
//
//public class Model {
//    public static ArrayList<Orders> orders = new ArrayList<>();
//
//    public static void addOrder(Orders order) {
//        orders.add(order);
//    }
//
//    public static ArrayList<Orders> getOrders() {
//        return orders;
//    }
//}


