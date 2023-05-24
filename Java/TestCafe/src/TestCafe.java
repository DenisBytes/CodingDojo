import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil testCafeUtil = new CafeUtil();

        int totalDrinks = testCafeUtil.getStreakGoal();
        System.out.println(totalDrinks);

        int streakGoal = testCafeUtil.getStreakGoal(10);

        double[] pricesCoffee = new double[4];
        pricesCoffee[0] = 1;
        pricesCoffee[1] = 2;
        pricesCoffee[2] = 3;
        pricesCoffee[3] = 4;
        double orderTotal = testCafeUtil.getOrderTotal(pricesCoffee);

        System.out.println(orderTotal);

        ArrayList<String> listMenuItems = new ArrayList<>();
        listMenuItems.add("drip coffee");
        listMenuItems.add("cappuccino");
        listMenuItems.add("latte");
        listMenuItems.add("mocha");

        testCafeUtil.displayMenu(listMenuItems);

        ArrayList<Double> listMenuPrices = new ArrayList<>();
        listMenuPrices.add(1.50);
        listMenuPrices.add(3.50);
        listMenuPrices.add(4.50);
        listMenuPrices.add(3.50);

        ArrayList<String> customers = new ArrayList<>();
        customers.add("Jack");
        customers.add("Leo");
        customers.add("Mark");

        //testCafeUtil.addCustomers(customers);

        // NINJA BONUS
        // SENSEI BONUS
        //testCafeUtil.printPriceChart("Colombian Coffee Grounds", 2D, 4);


        // SENSEI BONUS

        boolean bool = testCafeUtil.displayMenu(listMenuItems,listMenuPrices);
        System.out.println(bool);






        // System.out.println(streakGoal);
        // System.out.println(orderTotal);
        // testCafeUtil.displayMenu(listMenuItems);
        // testCafeUtil.addCustomers(customers);

    }
}