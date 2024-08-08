import java.util.*;

class Account{
    private long acno;
    private String name;
    private double balance;

    public Account(long acno,String name,double init_deposit){
        this.acno = acno;
        this.name = name;
        this.balance = init_deposit;
        System.out.println("Your account has been created successfully");
    }

    public boolean deposit(double amount){
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount){
        if(amount>balance){
            return false;
        }
        balance -= amount;
        return true;
    }

    public long getAcNo(){
        return this.acno;
    }

    @Override
    public String toString(){
        return "Account Number : "+acno+ "\nName : "+name+"\nBalance : "+balance;
    }

    public double bal_check(){
        return balance;
    }

}

class Bank{
    private String bname;
    private static String ifsc = "CUB321";
    private List<Account> acc_holders;
    private static long count = 111111;

    public Bank(String name){
        this.bname = name;
        acc_holders = new ArrayList<>();
    }

    public void accountCreation(String name,double deposit){
        Account ac = new Account(count,name,deposit);
        acc_holders.add(ac);
        System.out.println("Account number : "+count++);
    }

    public void deposit(long acno,double amt){
        if(acc_holders.size()==0){
            System.out.println("No Accounts Found!");
            return ;
        }
        for(Account ac : acc_holders){
            if(ac.getAcNo() == acno){
                ac.deposit(amt);
                System.out.println("Deposit successfull!");
                return ;
            }
            System.out.println("Account not found in the database:(");
        }
    }

    public void withdraw(long acno,double amt){
        if(acc_holders.size()==0){
            System.out.println("No Accounts Found!");
            return ;
        }
        for(Account ac : acc_holders){
            if(ac.getAcNo() == acno){
                if(ac.withdraw(amt)){
                    System.out.println("Withdraw Successfull!\nClear balance :"+ac.bal_check());
                    return ;
                }
                else{
                    System.out.println("Insufficieant balance :"+ac.bal_check());
                    return ;
                }
            }
        }
        System.out.println("Account not found in the database:(");
    }

    public void statement(long acno){
        if(acc_holders.size()==0){
            System.out.println("No Accounts Found!");
            return ;
        }
        for(Account ac : acc_holders){
            if(ac.getAcNo() == acno){
                System.out.println(ac.toString());
                System.out.println(ifsc);
                return ;
            }
            System.out.println("Account not found in the database:(");
        }
    }

    public void allData(){
        if(acc_holders.size()==0){
            System.out.println("No Accounts Found!");
            return ;
        }
        for(Account ac : acc_holders){
            System.out.println(ac.toString());
            System.out.println("\n*********************************\n");
        }
    }
}

public class Main
{
    public static void main(String[] args){
        Bank cub = new Bank("City Union Bank");
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int ch;
        long acno;
        double dep;
        double amt;

        boolean exit = true;

        while(exit){
            //System.out.print("\033[H\033[2J");
            System.out.println("\n**********************\n1->account Creation\n2->Deposit\n3->withdraw\n4->statement\n5->AllData\n0->Exit\n**********************\n");
            ch = sc.nextInt();
            switch(ch){
                case 0:
                {
                    exit = false;
                    break;
                }

                case 1 :
                {
                    System.out.println("Enter your name : ");
                    String name = sc.next();
                    System.out.println("Enter initial deposit amount : ");
                    dep = sc.nextDouble();

                    System.out.println();
                    cub.accountCreation(name,dep);
                    break;
                }

                case 2 :
                {
                    System.out.println("Enter ur account number :");
                    acno = sc.nextInt();
                    System.out.println("Enter ur amount to be deposited :");
                    dep = sc.nextDouble();
                    System.out.println();
                    cub.deposit(acno,dep);
                    break;
                }

                case 3 :
                {
                    System.out.println("Enter ur account number :");
                    acno = sc.nextInt();
                    System.out.println("Enter ur amount to be withdrawn :");
                    amt = sc.nextDouble();
                    System.out.println();
                    cub.withdraw(acno,amt);
                    break;
                }

                case 4 :
                {
                    System.out.println("Enter ur account number :");
                    acno = sc.nextInt();
                    System.out.println();
                    cub.statement(acno);
                    break;
                }

                case 5 :
                {
                    System.out.println();
                    cub.allData();
                }
            }
        }
        System.out.println("Thank you for using our self serving kiosk!");
    }
}
