package busReservation;

import  java.util.Scanner;

public class Admin extends Customer {

    Customer[] listOfAccounts = new Customer[50];

    public void insertAccount(Customer acc){
        for(int i=0;i<listOfAccounts.length;i++){
            if(listOfAccounts[i]==null){
                listOfAccounts[i]=acc;
                //System.out.println("Inserted");
                break;
            }
        }
    }

    public void deleteAccount(Customer acc){
        for(int i=0;i<user.length;i++){
            if(user[i]==acc){
                user[i]=null;
                System.out.println("Removed");
                break;
            }
        }
    }

    public void updateAccount(Customer acc){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<user.length;i++){
            if(user[i]==acc){
                System.out.println("\t\t\t********************************************");
                System.out.println("\t\t\t\t\t\t\t CUSTOMER UPDATE");
                System.out.println("\t\t\t********************************************");
                System.out.println("Previous one will show in bracket");
                System.out.print("\tName (" + user[i].getName()+") : ");
                user[i].setName(sc.nextLine());
                System.out.print("\tEmail ("+user[i].getEmail1()+") : ");
                user[i].setEmail1(sc.nextLine());
                System.out.print("\tMobile no. ("+user[i].getMobileNo()+") : ");
                user[i].setMobileNo(sc.nextLine());
                System.out.println("Updated");
                break;
            }
        }
    }

}