public class User{
    private String userName;
    private double walletBalance;

    public User(String userName,double walletBalance){
        this.userName=userName;
        this.walletBalance=walletBalance;
    }

    //getter methods
    public String getUserName(){
        return userName;
    }
    public double getWalletBalance(){
        return walletBalance;
    }

    // adding money to wallet
    public void deposit(double amount){
        if(amount>0){
            walletBalance += amount;
            System.out.println(" "+amount+" deposited successfully");
        }
        else{
            System.out.println("Invalid amount.Please enter a positive amount");


        }
        }
        // deduct money from wallet
        public boolean withdraw(double amount){
            if(amount>0 && amount<=walletBalance){
                walletBalance -=amount;
                System.out.println(" "+amount+" withdrawn successfully");
                return true;
            }
            else{
                System.out.println("Invalid amount or insufficient amount");
                return false;            }
        }
        // display user details 
        public void displayUserDetails(){
            
        }
    }
