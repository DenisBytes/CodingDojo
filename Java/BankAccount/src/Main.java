import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankAccount account1= new BankAccount();

        System.out.println("Checking account (c) / Saving Account (s) / Both (b): ");
        String accountChoice = scanner.nextLine();
        if(accountChoice.equals("b")){
            System.out.println("Enter Checking Account Amount: ");
            double cAmount = scanner.nextDouble();
            System.out.println("Enter Saving Account Amount: ");
            double sAmount = scanner.nextDouble();
            account1.depositBothAccount(cAmount,sAmount);
        }else if(accountChoice.equals("c") || accountChoice.equals("s")){
            System.out.println("How much?:");
            double amount = scanner.nextDouble();
            account1.depositMoney(accountChoice,amount);
        }
        else{
            System.out.println("Incorrect input!!!");
        }

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingBalance());
        System.out.println(account1.getTotalBalance());
        System.out.println(account1.getAccountsCount());
        System.out.println(account1.createAccountNumber());

        System.out.println("Would you like to withdraw? (\"yes\" or \"no\"):  ");
        String withdrawChoice = scanner.next();

        if(withdrawChoice.equals("yes")){
            if(accountChoice.equals("c")|| accountChoice.equals("s")){
                System.out.println("How much you would like to withdraw?: ");
                double withdrawAmount = scanner.nextDouble();
                account1.withdrawMoney(accountChoice,withdrawAmount);
            }
            else if(accountChoice.equals("b")){
                System.out.println("How much you would like to withdraw in checking Account?: ");
                double withdrawCaccount = scanner.nextDouble();
                System.out.println("How much you would like to withdraw in saving Account?: ");
                double withdrawSaccount = scanner.nextDouble();
                account1.withdrawBothAccount(withdrawCaccount,withdrawSaccount);
            }
        }
        else{
            System.out.println("ok good bye!");
        }
    }
}