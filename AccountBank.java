
import java.util.Scanner;

public class AccountBank {
    
    public static int deposit(int amt, int balance){
        System.out.print("Your deposited amount is ");
        return balance + amt;
    }

    public static int withdraw(int amt, int balance){
        System.out.print("Your withdrwal amount is ");
        return balance - amt;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  your name");
        String name = sc.nextLine();
        int amt = 1000;
        int withdraw = 100;

        int balance=200;
        int accNumber = 10*amt+200+50;
        System.out.println("Welcome, " + name + "!");  
        System.out.println("Your acc number is "+ accNumber);
        System.out.println("Your balance is: " + balance);
        System.out.println(deposit(amt, balance));
        System.out.println(withdraw(withdraw, balance));

    }
}
