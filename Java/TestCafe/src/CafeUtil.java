import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;


public class CafeUtil {
    Scanner scanner = new Scanner(System.in);
    public int getStreakGoal (){
        int sum = 0;
        for (int i = 0; i < 11; i++){
            sum += i;
        }
        return sum;
    }
    int getStreakGoal(int numWeeks){
        int sum = 0;
        for (int i = 1; i<=numWeeks; i++){
            sum += i;
        }
        return sum;
    }

    double getOrderTotal(double[] prices){
        double sum = 0.0;
        for (int i = 0; i < prices.length; i++){
            sum += prices[i];
        }
        return sum;
    }

    void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i+" "+menuItems.get(i));
        }
    }

    boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        boolean bool ;
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        if(menuItems.size() == prices.size()){
            for (int i = 0; i < menuItems.size(); i++){
                String currency = format.format(prices.get(i));
                System.out.println(i+" "+menuItems.get(i)+" "+currency);
            }
            bool = true;
        }
        else{
            bool = false;
        }
        return bool;
    }

    void addCustomers(ArrayList<String> customer){

        //Sensei Bonus
        ArrayList<String> multipleCustomers = new ArrayList<>();
        String userName = new String();
        while (!userName.equals("q")){
            System.out.println("PLease Enter your name/s (Enter q when finished): \n");
            userName = scanner.next();
            if (!userName.equals("q")){
                multipleCustomers.add(userName);
            }
        }
        for (int i = 0; i< multipleCustomers.size(); i++){
            System.out.println("Hello "+ multipleCustomers.get(i));
        }


        int customerInFront = 0;
        for (int i = 0; i< customer.size(); i++){
            customerInFront += i;
        }
        System.out.println("There's "+customerInFront+" people in front of you");
        if (!userName.equals("q")){
            customer.add(userName);
        }
        //print list
        for (int i = 0; i< customer.size(); i++){
            System.out.println(customer.get(i));
        }
    }


    void printPriceChart(String product, double price, int maxQuantity){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        for (int i = 1; i <= maxQuantity; i++){
            double price1 = price * i;
            String currency = format.format(price1);
            double discount = 0.50;
            if (i>=2){
                price1 = price1 -(discount * (i-1));
                currency = format.format(price1);
                System.out.format("\n"+i+" - "+ (currency));
            }
            else {
                System.out.format("\n"+i+" - "+ (currency));
            }
        }
    }
}
