public class Main {
    public static void main(String[] args) {

        Order order1 = new Order();
        Order order2 = new Order();

        Order orderName1 = new Order("Mario");
        Order orderName2 = new Order("Luigi");
        Order orderName3 = new Order("Peach");

        Item item1 = new Item("Mocha", 1);
        Item item2 = new Item("Cappuccino",2);
        Item item3 = new Item("Dirp Coffee",3);
        Item item4 = new Item("Latte", 4);

        order1.addItem(item1);
        order1.addItem(item2);
        orderName1.addItem(item3);
        orderName1.addItem(item4);

        order1.display();
        orderName1.display();

        order1.setReady(true);
        orderName1.setReady(false);

        System.out.println(order1.getStatusMessage());
        System.out.println(orderName1.getStatusMessage());

        System.out.println(order1.getOrderTotal());
    }
}