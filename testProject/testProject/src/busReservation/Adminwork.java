package busReservation;

import java.util.Scanner;

public class Adminwork extends Admin {
    public void work() {
        while (true) {
            Scanner scan2 = new Scanner(System.in);

            System.out.println("\n\t1.Update customer account\n\t2.Delete customer account\n\t3.View customer details\n\t4.Exit");
            String select = scan2.nextLine();
            while (!select.equals("1") && !select.equals("2") && !select.equals("3") && !select.equals("4")) {
                System.out.println("Please select 1/2/3/4");
                select = scan2.nextLine();
            }
            if (select.equals("1"))
                update();
            else if (select.equals("2"))
                delete();
            else if (select.equals("3"))
                customerView();
            else break;
        }
    }
    public void update() {
        Scanner inputs = new Scanner(System.in);
        Scanner inputi = new Scanner(System.in);

        System.out.print("Please enter the customer's unique code to update: ");
        int unique = inputi.nextInt();
        boolean flg=false;

        for (int i = 0; i <user.length; i++) {
            if(user[i]!=null)
            {
                if (unique == user[i].uniqueCode) {
                    updateAccount(user[i]);

                } else if (i == count) {
                    System.out.println("Unique code does not match with any account\n\t1.Try again\t\t2.Exit");
                    String choose = inputs.nextLine();
                    while (!choose.equals("1") && !choose.equals("2")) {
                        System.out.println("Choose 1 or 2");
                        choose = inputs.nextLine();
                    }
                    if (choose.equals("1")) update();
                    break;
                }
            }
        }

    }
    public void delete()
    {
        Scanner in=new Scanner(System.in);
        Scanner ins=new Scanner(System.in);
        System.out.print("Please enter the customer's unique code to delete: ");
        int input=in.nextInt();
        boolean flag=false;
        for(int i=0;i<user.length;i++)
        {
            if(user[i]!=null) {
                if (input == user[i].uniqueCode) {

                    deleteAccount(user[i]);

                    flag=true;
                    break;
                }
            }
        }
        if(flag)
        {
           // System.out.print("We found the user");
        }
        else System.out.println("We could not find the user");
    }
}

