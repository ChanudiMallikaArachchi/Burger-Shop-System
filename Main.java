
public class Main {
    public static void main(String[] args) {
        // Add sample orders to simulate database
        Model.addOrder(new Orders("B0001", "0123456789", "John", 4, 2000,1 ));
        Model.addOrder(new Orders("B0002", "0715590262", "Kedy", 3, 1500,2 ));
        Model.addOrder(new Orders("B0003", "0321456987", "Keyden", 2, 1000,3));

        View obj1 = new View();
        obj1.step1();
    }
}
