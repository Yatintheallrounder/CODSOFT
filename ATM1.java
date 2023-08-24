package Special;
import java.util.*;
class ATM {
    private double balance;
    Scanner src = new Scanner(System.in);
    ATM(double initialbalance) {
        this.balance = initialbalance;
    }
    public int Display() {
        System.out.println("Press 1 to check balance:");
        System.out.println("Press 2 to deposit money:");
        System.out.println("Press 3 to withdraw money:");
        System.out.println("Press 4 to Exit");
        int a= src.nextInt();
        return a;
    }
    public void checkBalance() {
        System.out.println("Your current account balance is " + balance);
    }
    public void Deposit() {
        System.out.println("Enter the amount which you want to add");
        double a = src.nextInt();
        balance = balance + a;
        System.out.println("Deposit Successful! Current balance= " + balance);
    }
    public void Withdraw() {
        System.out.println("Enter the amount you want to withdraw");
        double a = src.nextInt();
        if (a > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance = balance - a;
            System.out.println("Withdraw Successful! Current balance= " + balance);
        }
    }
}
   public class ATM1 {
       public static void main(String[] args) {
           System.out.println("Welcome to this ATM Machine");
           System.out.println("Enter the current balance of your account");
           Scanner src = new Scanner(System.in);
           double amount = src.nextInt();
           ATM obj = new ATM(amount);
           while (true) {
               int a = obj.Display();
               switch (a) {
                   case 1:
                       obj.checkBalance();
                       break;
                   case 2:
                       obj.Deposit();
                       break;
                   case 3:
                       obj.Withdraw();
                       break;
                   case 4:
                       System.out.println("Exiting....");
                       System.exit(0);
                   default:
                       System.out.println("Invalid Choice");
               }
           }
       }
   }