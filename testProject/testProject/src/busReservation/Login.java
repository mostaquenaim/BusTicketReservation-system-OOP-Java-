package busReservation;

import java.util.Scanner;
public class Login extends menu{
    private String[]name;
    private String[]pass;


    public void login()
    {

        String name[]=new String[7];
        String pass[]=new String[7];

        name[0]="1";
        name[1]="Naim";
        name[2]="Tahmid";
        name[3]="Shahadat";
        name[4]="Ikra";
        name[5]="Sajjad";
        name[6]="Laboni";

        pass[0]="1";
        pass[1]="Borishal";
        pass[2]="Janina";
        pass[3]="Noakhailla";
        pass[4]="Monda";
        pass[5]="Sylheti";
        pass[6]="Pabna";


        Scanner inputs=new Scanner(System.in);
        System.out.print("Admin username: ");
        String usernameIn=inputs.nextLine();
        System.out.print("Admin password: ");
        String passwordIn=inputs.nextLine();
        for(int i=0;i<name.length;i++)
        {
            if(usernameIn.equals(name[i]) && passwordIn.equals(pass[i]))
            {
                System.out.println("\t\tWelcome to the admin zone");
                work();
                break;
            }
            else if(i+1==name.length)
            {
                System.out.println("\t\tEmail and password did not match\n\t1.Try again\t\t2.Exit");
                String choose=inputs.nextLine();
                while(!choose.equals("1") && !choose.equals("2"))
                {
                    System.out.println("Choose 1 or 2");
                    choose=inputs.nextLine();
                }
                if(choose.equals("1"))
                    login();
                break;
            }
        }
    }


}