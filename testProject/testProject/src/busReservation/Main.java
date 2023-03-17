package busReservation;


import java.util.Scanner;

public class Main  extends Customer{

    public static void main(String[] args) throws InterruptedException {
        Welcome obj=new Welcome();
        obj.welcome();
        available = new int[7][6];
        for (int o = 1; o <= 6; o++) {
            for (int i = 1; i < 6; i++) {
                available[o][i] = 20;
            }
        }

        String[] bus = new String[10];
        String[] destin = new String[10];
        busDetails(bus);
        destinationDeails(destin);

        Customer obj0=new Customer("naim",0,"bb","Dhaka","888","88","mle","jj");
        Customer obj2=new Customer();

        Customer obj1=new Customer("jjj",1,"hh","gg","naim@gmail.com","gg","gg","gg");
        obj2.addUserToUserArrAy(obj0);
        obj2.addUserToUserArrAy(obj1);

        Login admin=new Login();

        Admin admin1=new Admin();

        Adminwork work=new Adminwork();
        while (true) {

            Scanner scan2 = new Scanner(System.in);
            System.out.println("\t\t\tChoose one\n\t1.Customer\n\t2.Admin\n\t3.Exit");
            String choice=scan2.nextLine();
            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") ) {
                System.out.println("Please select 1/2/3 - ");
                choice = scan2.nextLine();
            }
            if(choice.equals("1")) {

                for (int i = 0; i < user.length; i++) {
                    if (user[i] != null) {
                        while(true)
                        {
                            System.out.println("\t\t\tChoose one\n\t1.Login\n\t2.Register\n\t3.Exit");
                            String choose = scan2.nextLine();
                            while (!choose.equals("1") && !choose.equals("2") && !choose.equals("3") && !choose.equals("4")) {
                                System.out.println("Please select 1/2/3 - ");
                                choose = scan2.nextLine();
                            }
                            if (choose.equals("1"))
                                obj2.userLogin();
                            else if (choose.equals("2"))
                                obj2.userRegister();
                            else if (choose.equals("3")) {
                                obj2.exit();
                                break;
                            }
                        }

                        break;
                    }

                }
            }



            else if (choice.equals("2")) {
                boolean flag=false;
                for (int j = 0; j < user.length; j++) {
                    if (user[j] != null) {
                        admin1.insertAccount(user[j]);
                        flag = true;
                    }
                }
                admin.login();
                if(flag) {}
                else System.out.println("404");



            }
            else break;
        }
    }
}

