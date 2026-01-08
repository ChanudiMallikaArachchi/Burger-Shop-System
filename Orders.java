public class Orders {
    private String orderId;
    private String customerId;
    private String customerName;
    private int burgerQuantity;
    private float bill;
    private int orderStatus;
    private String status;

    public Orders(String orderId, String customerId, String customerName, int burgerQuantity, float bill, int status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.burgerQuantity = burgerQuantity;
        this.bill = bill;
        this.orderStatus = status;
        //setOrderStatus(orderStatus);
    }

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public int getBurgerQuantity() { return burgerQuantity; }
    public float getBill() { return bill; }
    public int getOrderStatus(){
        return orderStatus;
    }

    public int setBurgerQuatity(int value){
        return value;
    }

    public float setBill(float bill){
        return bill;
    }

    public int orderStatus(int status){
        return status;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
        if (orderStatus == 1) status = "Preparing";
        else if (orderStatus == 2) status = "Delivered";
        else status = "Cancelled";
    }

    public String toString() {
        return orderId + " | " + customerId + " | " + customerName + " | Qty: " + burgerQuantity + " | Rs. " + bill + " | " + status;
    }
}












//public class Orders {
//
//    Orders(String b0003, String number, String keden, int quantity, int bill, String preparing){
//
//    }
//    private String orderId;
//    private String customerId;
//    private String customerName;
//    private int burgerQuantity;
//    private float bill;
//    private int orderStatus;
//    private String status;
//
//
//    Orders(String orderId, String customerId, String customerName, int quantity, float bill, int orderStatus){
//        this.orderId = orderId;
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.burgerQuantity = burgerQuantity;
//        this.bill = bill;
//        this.orderStatus = orderStatus;
//    }
//
//    public String getOrderId() {
//        return orderId;
//    }
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public int getBurgerQuantity() {
//        return burgerQuantity;
//    }
//
//
//    public float getBill() {
//        return bill;
//    }
//
//    public int getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(int orderStatus) {
//        this.orderStatus = orderStatus;
//
//        if(orderStatus == 1){
//            status = "Peparing";
//        }else if(orderStatus == 2){
//            status = "Delivered";
//        }else {
//            status = "Cancel";
//        }
//    }
//
//    public String toString() {
//        return "Orders{" +
//                "orderId='" + orderId + '\'' +
//                ", customerId='" + customerId + '\'' +
//                ", customerName='" + customerName + '\'' +
//                ", burgerQuantity=" + burgerQuantity +
//                ", bill=" + bill +
//                ", orderStatus=" + orderStatus +
//                ", status='" + status + '\'' +
//                '}';
//    }
//
//}


