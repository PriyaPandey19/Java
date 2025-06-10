
import java.util.*;

class Account{
String type;
double amount;
private String name;
private int accNumber;
private double balance;
private List<String> transaction;


public Account(String name,int accNumber,double balance,String type,double amount){
this.accNumber = accNumber;
this.name = name;
this.balance = balance;
this.type = type;
 this.amount = amount;
 this.transaction = new ArrayList<>();
 transaction.add("Account created with balance 0");
}


public void deposit(int amount){         //deposit amount
 if(amount > 0){
    balance += amount;
    transaction.add("Deposited: "+ amount+", New Balance: "+balance);
    System.out.println("Deposited successfully");
 }
 else{
    System.out.println("Invalid deposit amount");
 }
}


public void withdraw(int amount){      //withdraw function
 if(amount > 0 && amount <= balance){
    balance -= amount;
    transaction.add("Withdrwa "+ amount+", New Balance: "+balance);
    System.out.println("withdraw  successfully");
 }
 else{
    System.out.println("Insufficient balance");
 }
}

public void viewTransaction(){      //transaction history
if(transaction.isEmpty()){
  System.out.println("no transaction found");  
}
else{
    System.out.println("Transaction history");
    for(String t : transaction){
        System.out.println(t);
    }
}
}

public void checkBalance(){              //check balance
    System.out.println("Balnce is "+ balance);
}

}

public class AccountBank {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  your name");
        String name = sc.nextLine();

        System.out.println("ATM Menu------");
        System.out.println("1. deposit amount");
        System.out.println("2. withdraw amount");
        System.out.println("3. Transaction History");
        System.out.println("4. Check balance");
        System.out.println("5. Exit");

        System.out.println("Enter your choice:");
        int c = sc.nextInt();

        int accNumber = 1001;
        double balance = 10000;
        String type = "Savings";
        int amount = 0;
        Account ab = new Account(name, accNumber, balance, type, amount);

        switch (c) {
        case 1:
        long startDeposit = System.currentTimeMillis();
        System.out.println("Enter the deposit amount:");
        int depAmount = sc.nextInt();
        ab.deposit(depAmount);
        long endDeposit = System.currentTimeMillis();
        System.out.println("Deposit operation time: " + (endDeposit - startDeposit) + " ms");
        break;
            case 2:
                long startDeposit1 = System.currentTimeMillis();
                System.out.println("Enter the withdrawal amount:");
                int withAmount = sc.nextInt();
                ab.withdraw(withAmount);
                long endDeposit1 = System.currentTimeMillis();
               System.out.println("Withdrawal operation time: " + (endDeposit1 - startDeposit1) + " ms");
                break;
            case 3:
                 long startDeposit2 = System.currentTimeMillis();
                 ab.viewTransaction();
                  long endDeposit2 = System.currentTimeMillis();
                  System.out.println("Withdrawal operation time: " + (endDeposit2 - startDeposit2) + " ms");
                break;
            case 4:
             long startDeposit3 = System.currentTimeMillis();
                ab.checkBalance();
             long endDeposit3 = System.currentTimeMillis();    
             System.out.println("Withdrawal operation time: " + (endDeposit3- startDeposit3) + " ms");

                break;
            case 5:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}

    