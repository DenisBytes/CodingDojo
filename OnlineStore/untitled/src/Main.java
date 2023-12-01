import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> products = new ArrayList<>();
        products.add("egg");
        products.add("milk");
        products.add("flour");
        products.add("apple");
        products.add("banana");

        List<Double> prices = new ArrayList<>();
        prices.add(1.5);
        prices.add(2.5);
        prices.add(3.5);
        prices.add(4.5);
        prices.add(5.5);

        List<Double> cart = new ArrayList<>();

        boolean b = true;

        while (b == true){
            System.out.print("Choose Product (press q or Q to quit): "+ products+ " "+ prices+": ");
            String s = scanner.next();

            if (s.equals("q") || s.equals("Q")){
                b=false;
                break;
            }

            System.out.print("How Many? ");
            int i = scanner.nextInt();


            double productTotal = priceProductsCalculator(s,i);

            if (productTotal!=0){
                System.out.println("Product Total: "+ productTotal);
                cart.add(productTotal);
            }
            else{
                System.out.println("Enter valid product");
                continue;
            }
            double finalTotal = 0;
            for (int k = 0; k< cart.size(); k++){
                finalTotal += cart.get(k);
            }
            System.out.println("Your billing until now is: "+finalTotal);

        }

    }

    public static double priceProductsCalculator(String s, int i){
        double total = 0;
        switch (s){
            case "egg": total = 1.5 * i;
            break;
            case "milk": total= 2.5 * i;
            break;
            case "flour": total= 3.5 * i;
            break;
            case "apple": total= 4.5 * i;
            break;
            case "banana": total= 5.5 * i;
            break;
            default: total = 0;
        }
        return total;
    }
}