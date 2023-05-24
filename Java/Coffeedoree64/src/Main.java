import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        CoffeeKiosk order1 = new CoffeeKiosk();

        order1.addMenuItem("banana",2);
        order1.addMenuItem("coffee",1.50);
        order1.addMenuItem("latte",4.50);
        order1.addMenuItem("cappuccino", 3);
        order1.addMenuItem("muffin",4);

        order1.newOrder();
    }
}
