package Jvaprojects;

import java.util.Scanner;

class BankAccount {

    String name;
    String username;
    String password;
    String AccountNumber;
    float balance = 10000f;
    int transactions =0;
    String transactionHistory = "";
    
    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name: ");
        this.name = sc.nextLine();
        System.out.println("\nEnter your Username: ");
        this.username = sc.nextLine();
        System.out.println("\nEnter your password: ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number: ");
        this.AccountNumber = sc.nextLine();
        System.out.println("\nRegisteration is Successful. Please login in the Bank Account.");

    }
    public boolean login(){
        boolean islogin = false;
        Scanner sc = new Scanner(System.in);
        while (!islogin) {
            System.out.println("\nEnter your username:");
            String Username = sc.nextLine();
            if (Username.equals(username)) {
              while (!islogin) {
                System.out.println("\nEnter your password: ");
                 String Password = sc.nextLine();
                 if (Password.equals(password)) {
                    System.out.println("\nLogin Successful"); 
                    islogin = true;                   
                 }
                 else{
                    System.out.println("\nIncorrect Password");

                 }  

              }  
                            
            }
            else{
                System.out.println("\nUsername not found ");

            }
        }
        return islogin;

    }
    public void withdraw(){
        System.out.println("\nEnter the Amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance>= amount ){
                transactions++;
                balance-=amount;
                System.out.println("\nWithdral Successful.");
                String str = amount+ "Rs Withdrawnn";
                transactionHistory = transactionHistory.concat(str);


            }
            else{
                System.out.println("\nInsufficient Balance.");

            }
        }catch(Exception e){

        }
    }
    public void deposit(){
        System.out.println("\nEnter the Amount to deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(amount<= 10000f ){
                transactions++;
                balance+=amount;
                System.out.println("\nDeposit Successful.");
                String str = amount+ "Rs Deposited\n";
                transactionHistory = transactionHistory.concat(str);


            }
            else{
                System.out.println("\nSorry.The limit is 10000.");

            }
        }catch(Exception e){
            
        }
    }
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name: ");
        String receipent = sc.nextLine();
        System.out.println("\nEnter Amount to transfer: ");

        float amount = sc.nextFloat();
        try{
            if (balance>= amount) {
                
            
            if(amount<= 50000f ){
                transactions++;
                balance-=amount;
                System.out.println("\nSuccessfullu Transfered to the" + receipent);
                String str = amount+ "Rs transferred to\t" +receipent+"\n";
                transactionHistory = transactionHistory.concat(str);


            }
            else{
                System.out.println("\nSorry.The limit is 50000.");

            }
       }else{
        System.out.println("Insufficient Bbalnce.");

       } }catch(Exception e){
            
        }
    }
    public void checkbalance(){
      System.out.println("\n"+balance+"Rs");
    }
    public void transHistory(){
        if(transactions==0){
            System.out.println("No Transactions happened");

        }
        else{
            System.out.println("\n" +transactionHistory);
        }
    }
}
public class ATMInterface {
    public static int takenIntegerInput(int limit ){
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try  {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if ( flag && input>limit || input<1) {
                    System.out.println("Choose the number between 1 to" +limit);
                      flag = false;

                }

            } catch (Exception e) {
                System.out.println("Enter only interger value.");
                 flag = false;

            }
        }
        return input;

    }
    public static void main(String[] args) {
        System.out.println("\n*********WELCOME TO STATE BANK OF INDIA INTERFACE********");
        System.out.println("Choose one option: ");
        System.out.println("\n1- Register\n2-exit");
        int Choose = takenIntegerInput(2);

        if (Choose ==1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("Enter your choice: ");
                System.out.println("\n1- login\n2-exit");
                int ch = takenIntegerInput(2);
                if (ch==1) {
                    if(b.login()){
                       System.out.println("\n*********************WELCOME BACK"+b.name+"*********************");
                       boolean isFinished = false;
                       while (!isFinished)
                       {
                        System.out.println("Choose one option: ");
                        System.out.println("\n1- Withdraw\n2-Deposit\n3-Transfer\n4-Check Balance\n5-Transaction History\n6- Exit");
                        int c = takenIntegerInput(6);
                         switch (c) {
                            case 1:
                                b.withdraw();
                                break;
                            case 2:
                                 b.deposit();
                                 break;
                             case 3:
                                 b.transfer();
                                 break;
                             case 4:
                                 b.checkbalance();
                                 break;
                             case 5:
                                 b.transHistory();
                                 break;
                             case 6:
                                 isFinished= true;
                                 break;
  
                         }   
                    }
                    }
                }else{
                    System.exit(0);
                }
            }
        }else{
            System.exit(0);
        }
    }
}
