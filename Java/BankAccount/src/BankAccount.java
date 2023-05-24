import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;

    private static int accountsCount = 0;

    private static double totalBalance = 0;
    private String accountNumber;

    public BankAccount(){
        accountsCount ++;
        accountNumber = createAccountNumber();
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }
    public int getAccountsCount(){
        return accountsCount;
    }
    public double getTotalBalance(){
        return totalBalance;
    }

    public void depositMoney (String accountChoice, double amount){
        if (accountChoice.equals("c")){
            checkingBalance += amount;
        }
        else if (accountChoice.equals("s")){
            savingBalance += amount;
        }
        totalBalance += amount;
    }

    public void depositBothAccount(double cAmount,double sAmount){
        checkingBalance = cAmount;
        savingBalance = sAmount;
        // only once because one already in constructor
        accountsCount++;
        totalBalance *= cAmount + sAmount;
    }

    public void withdrawMoney(String accountChoice,double amount){
        if(accountChoice.equals("c")){
            if(checkingBalance >= amount){
                checkingBalance -= amount;
                System.out.println(getCheckingBalance());
            }
            else{
                System.out.println("can't withdraw that much from checking Account! Balance not enough");
            }
        }
        else if(accountChoice.equals("s")){
            if(savingBalance >= amount){
                savingBalance -= amount;
                System.out.println(getSavingBalance());
            }
            else{
                System.out.println("can't withdraw that much from saving Account! Balance not enough");
            }
        }
        totalBalance -= amount;
    }

    public void withdrawBothAccount (double cAmount, double sAmount){
        if(checkingBalance >= cAmount){
            checkingBalance -= cAmount;
            System.out.println(getCheckingBalance());
        }
        else{
            System.out.println("can't withdraw that much from checking Account! Balance not enough");
        }
        if(savingBalance >= sAmount){
            savingBalance -= sAmount;
            System.out.println(getSavingBalance());
        }
        else{
            System.out.println("can't withdraw that much from saving Account! Balance not enough");
        }
        savingBalance -= sAmount;
        totalBalance -= cAmount+sAmount;
    }

    public String createAccountNumber(){
        String accountNumber ="";
        Random random = new Random();
        for (int i= 0; i<10; i++){
            accountNumber += random.nextInt(10);
        }
        return accountNumber;
    }
}