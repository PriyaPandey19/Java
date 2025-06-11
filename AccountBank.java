
// import java.util.*;
// import java.io.File;
// import java.io.FileWriter;

// class Account{
// String type;
// double amount;
// private String name;
// private int accNumber;
// private double balance;
// private List<String> transaction;


// public Account(String name,int accNumber,double balance,String type,double amount){
// this.accNumber = accNumber;
// this.name = name;
// this.balance = balance;
// this.type = type;
//  this.amount = amount;
//  this.transaction = new ArrayList<>();
//  transaction.add("Account created with balance 0");
// }


// public void deposit(int amount){         //deposit amount
//  if(amount > 0){
//     balance += amount;
//     transaction.add("Deposited: "+ amount+", New Balance: "+balance);
//     System.out.println("Deposited successfully");
//  }
//  else{
//     System.out.println("Invalid deposit amount");
//  }
// }


// public void withdraw(int amount){      //withdraw function
//  if(amount > 0 && amount <= balance){
//     balance -= amount;
//     transaction.add("Withdrwa "+ amount+", New Balance: "+balance);
//     System.out.println("withdraw  successfully");
//  }
//  else{
//     System.out.println("Insufficient balance");
//  }
// }

// public void viewTransaction(){      //transaction history
// if(transaction.isEmpty()){
//   System.out.println("no transaction found");  
// }
// else{
//     System.out.println("Transaction history");
//     for(String t : transaction){
//         System.out.println(t);
//     }
// }
// }

// public void checkBalance(){              //check balance
//     System.out.println("Balnce is "+ balance);
// }



// public void saveAccountTofile() {
//     try {
//         File file = new File("Account.txt");
//         if (!file.exists()) {
//             file.createNewFile();  
//         }

//         FileWriter writer = new FileWriter(file);  

//         writer.write("Name: " + name + "\n");
//         writer.write("Account Number: " + accNumber + "\n");
//         // writer.write("Balance: " + balance + "\n");
//         // writer.write("Account Type: " + type + "\n");
//         // writer.write("Transaction History:\n");
        
//         // for (String t : transaction) {
//         //     writer.write(t + "\n");
//         // }

//         writer.close();
//         System.out.println("File saved successfully.");  
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
// }

// }
import java.util.*;
import java.io.File;
import java.io.FileWriter;public class AccountBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        int accNumber = 1001;
        double balance = 10000;
        String type = "Savings";

        Account ab = new Account(name, accNumber, balance, type);

        while (true) {
            System.out.println("\nATM Menu------");
            System.out.println("1. Deposit amount");
            System.out.println("2. Withdraw amount");
            System.out.println("3. Transaction History");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int c = sc.nextInt();

            switch (c) {
                case 1:
                    System.out.println("Enter the deposit amount:");
                    int depAmount = sc.nextInt();
                    ab.deposit(depAmount);
                    break;

                case 2:
                    System.out.println("Enter the withdrawal amount:");
                    int withAmount = sc.nextInt();
                    ab.withdraw(withAmount);
                    break;

                case 3:
                    ab.viewTransaction();
                    break;

                case 4:
                    ab.checkBalance();
                    break;

                case 5:
                    ab.saveAccountTofile();
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


class Account {
    private String name;
    private int accNumber;
    private double balance;
    private String type;
    private List<String> transaction;

    public Account(String name, int accNumber, double balance, String type) {
        this.name = name;
        this.accNumber = accNumber;
        this.balance = balance;
        this.type = type;
        this.transaction = new ArrayList<>();
        transaction.add("Account created with balance: " + balance);
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            transaction.add("Deposited: " + amount + ", New Balance: " + balance);
            System.out.println("Deposited successfully");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transaction.add("Withdrawn: " + amount + ", New Balance: " + balance);
            System.out.println("Withdrawn successfully");
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public void viewTransaction() {
        if (transaction.isEmpty()) {
            System.out.println("No transactions found");
        } else {
            System.out.println("Transaction History:");
            for (String t : transaction) {
                System.out.println(t);
            }
        }
    }

    public void checkBalance() {
        System.out.println("Balance is: " + balance);
    }

    public void saveAccountTofile() {
        try {
            File file = new File("Account.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file);

            writer.write("Name: " + name + "\n");
            writer.write("Account Number: " + accNumber + "\n");
            writer.write("Balance: " + balance + "\n");
            writer.write("Account Type: " + type + "\n");
            writer.write("Transaction History:\n");

            for (String t : transaction) {
                writer.write(t + "\n");
            }

            writer.close();
            System.out.println("Account details saved successfully to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving to file.");
            e.printStackTrace();
        }
    }
}


  







    public class AccountBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        int accNumber = 1001;
        double balance = 10000;
        String type = "Savings";

        Account ab = new Account(name, accNumber, balance, type);

        while (true) {
            System.out.println("\nATM Menu------");
            System.out.println("1. Deposit amount");
            System.out.println("2. Withdraw amount");
            System.out.println("3. Transaction History");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int c = sc.nextInt();

            switch (c) {
                case 1:
                    System.out.println("Enter the deposit amount:");
                    int depAmount = sc.nextInt();
                    ab.deposit(depAmount);
                    break;

                case 2:
                    System.out.println("Enter the withdrawal amount:");
                    int withAmount = sc.nextInt();
                    ab.withdraw(withAmount);
                    break;

                case 3:
                    ab.viewTransaction();
                    break;

                case 4:
                    ab.checkBalance();
                    break;

                case 5:
                    ab.saveAccountTofile();
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}



    