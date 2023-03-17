package busReservation;

import java.util.Scanner;

public class Customer extends Registration implements methods{

    protected static Customer user[] = new Customer[50];


    public Customer() {
    }

    public Customer(String Name, int uniqueCode, String address, String city, String email1, String mobileNo, String gender, String password1) {

        this.name = Name;
        this.address = address;
        this.city = city;
        this.email1 = email1;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.password1 = password1;
        this.uniqueCode = uniqueCode;
    }

    public static void busDetails(String[] bus) {
        busNames = bus;
        busNames[1] = "HANIF EXPRESS";
        busNames[2] = "JOLIL EXPRESS";
        busNames[3] = "ROADKING";
        busNames[4] = "JATRA";
        busNames[5] = "LMAO BUS";
    }

    public static void destinationDeails(String[] destination) {
        destinationName = destination;
        destinationName[1] = "DHAKA-BORISHAL";
        destinationName[2] = "BORISHAAL-DHAKA";
        destinationName[3] = "DHAKA-SYLHET";
        destinationName[4] = "SYLHET-DHAKA";
        destinationName[5] = "DHAKA-CHATTOGRAM";
        destinationName[6] = "CHATTOGRAM-DHAKA";
    }

    public void destination() {

        System.out.println("***************************************");

        System.out.println("DESTINATIONS  |  AVAILABLE BUSES  |  TICKET PRICE(tk)");
        System.out.println("***************************************");
        for (int i = 1; i < 7; i++) {
            System.out.println(i + "." + destinationName[i] + "  |      5      |     450");
        }
        System.out.println("***************************************");
        System.out.println("***************************************\n");
    }

    public void booking() {
        Scanner inputs0 = new Scanner(System.in);
        boolean flag=false;

        System.out.print("Enter your unique id : ");
        int idIn = inputs0.nextInt();
        for (int i = 0; i < user.length; i++) {
            if (user[i] != null)
            {
                if (idIn == user[i].getUniqueCode()) {
                    destination();
                    System.out.println("Choose one -");
                    user[i].destinationSelect = inputs0.nextInt();
                    while (user[i].destinationSelect> 6) {
                        System.out.println("Choose between 1 to 6 [you can choose one destination from this id] ");
                        user[i].destinationSelect = inputs0.nextInt();
                    }
                    if (user[i].destinationSelect > 0 && user[i].destinationSelect < 7) {
                        System.out.println("***************************************");
                        System.out.println("    BUS     |    SEATS ");
                        System.out.println("***************************************");
                        for(int j=1;j<=5;j++) {
                            System.out.println(j +"."+ busNames[j] + " |  " + available[user[i].destinationSelect][j]);
                           /* System.out.println("2." + busNames[2] + " |  " + available[user[i].destinationSelect][2]);
                            System.out.println("3." + busNames[3] + "      |  " + available[user[i].destinationSelect][3]);
                            System.out.println("4." + busNames[4] + "         |  " + available[user[i].destinationSelect][4]);
                            System.out.println("5." + busNames[5] + "      |  " + available[user[i].destinationSelect][5]);*/
                        }
                        System.out.println("***************************************");
                        System.out.println("***************************************\n");
                        System.out.println("Choose one [you can choose one bus from this id]-");
                        user[i].busSelect = inputs0.nextInt();
                        while(user[i].busSelect<1 || user[i].busSelect>5)
                        {
                            System.out.print("Please choose from 1 to 5 : ");
                            user[i].busSelect = inputs0.nextInt();
                        }
                        System.out.print("How many seats do you want to book? ");
                        int bookedSeat = inputs0.nextInt();
                        while(bookedSeat>available[user[i].destinationSelect][user[i].busSelect])
                        {
                            System.out.println("\t\tSorry! Only "+available[user[i].destinationSelect][user[i].busSelect]+" seat(s) available ");
                            System.out.println("Please choose from 0 to "+available[user[i].destinationSelect][user[i].busSelect]+" : ");
                            bookedSeat = inputs0.nextInt();
                        }
                        int due = bookedSeat * 450;
                        user[i].duePayment += due;
                        user[i].totalSeats += bookedSeat;

                        System.out.print("\n\t\t\tThanks for booking !\n ");
                        available[user[i].destinationSelect][user[i].busSelect] -= bookedSeat;
                    }
                    flag=true;
                    break;
                }
            }

        }
        if(flag) {}
        else {
            Scanner one=new Scanner(System.in);
            System.out.print("User not found\n\tPress 0 to try again : ");
            String select=one.nextLine();
            if(select.equals("0")) booking();
        }

    }

    public void billing() {
        Scanner billInput = new Scanner(System.in);
        System.out.print("Enter your unique ID : ");

        boolean flag=false;

        int idIn = billInput.nextInt();
        for (int i = 0; i < user.length; i++) {
            if (user[i] != null) {
                if (idIn == user[i].getUniqueCode()) {
                    System.out.println("\t\t\t***************************************");
                    System.out.println("\t\t\t**        PASSENGER'S DETAILS        **");
                    System.out.println("\t\t\t***************************************");
                    System.out.println("\t\t\t\t USERNME : " + user[i].getName());
                    System.out.println("\t\t\t\t DESTINATION : " + destinationName[user[i].destinationSelect]);
                    System.out.println("\t\t\t\t BUS : " + busNames[user[i].busSelect]);
                    System.out.println("\t\t\t\t SEATS BOOKED : " + user[i].totalSeats);
                    System.out.println("\t\t\t\t DUE PAYMENT : " + user[i].duePayment + " taka only");
                    System.out.println("\t\t\t***************************************");
                    System.out.println("\t\t\t***************************************\n");
                    System.out.println("\t\tDo you want to pay now? [y/n]");
                    String ans = billInput.nextLine();
                    while (!ans.equals("y") && !ans.equals("n")) {
                        System.out.print("Please choose y or n : ");
                        ans = billInput.nextLine();
                    }
                    if (ans.equals("y")) {
                        System.out.println("Enter the amount you want to pay now : ");
                        user[i].payment = billInput.nextInt();
                        if (user[i].payment <= user[i].duePayment) {
                            user[i].duePayment -= user[i].payment;
                            System.out.println("\t\t\nThanks for paying !");
                        } else {
                            int left = user[i].payment - user[i].duePayment;

                            user[i].duePayment = 0;
                            System.out.println("\t\t\nThanks for paying ! Here is your change " + left + "taka.");

                        }

                    }
                    flag=true;
                    break;

                }
            }

        }
        if(flag) {}
        else {
            Scanner one=new Scanner(System.in);
            System.out.print("User not found\n\tPress 0 to try again : ");
            String select=one.nextLine();
            if(select.equals("0")) billing();
        }

    }

    public void customerView() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your unique ID : ");
        int idIn = input.nextInt();
        boolean flag=false;
        for (int i = 0; i < user.length; i++) {
            if (user[i] != null)
            {
                if (idIn == user[i].getUniqueCode()) {
                    System.out.println("\t\t\t***************************************");
                    System.out.println("\t\t\t**        PASSENGER'S DETAILS        **");
                    System.out.println("\t\t\t***************************************");
                    System.out.println("\t\tNAME : " + user[i].getName());
                    System.out.println("\t\tMobile no. : " + user[i].getMobileNo());
                    System.out.println("\t\tDESTINATION : " + destinationName[user[i].destinationSelect]);
                    System.out.println("\t\tBUS : " + busNames[user[i].busSelect]);
                    System.out.println("\t\tSEAT BOOKED : " + user[i].totalSeats);
                    int bill = user[i].totalSeats * 450;
                    System.out.println("\t\tBILL : " + bill + " taka");
                    System.out.println("\t\tBILL PAID : " + user[i].payment + " taka");
                    int change;
                    if (bill < user[i].payment)
                        change = user[i].payment - bill;
                    else change = 0;
                    System.out.println("\t\tCHANGE : " + change + " taka");
                    System.out.println("\t\tDUE : " + user[i].duePayment + " taka");
                    if (user[i].duePayment == 0)
                        System.out.println("\t\tSTATUS : PAID");
                    else System.out.println("\t\tSTATUS : UNPAID");
                    System.out.println("\t\t\t***************************************");
                    System.out.println("\t\t\t***************************************");
                    flag=true;
                    break;
                }
            }
        }
        if(flag) {}
        else {
            Scanner one=new Scanner(System.in);

            System.out.println("User not found\n\tPress 0 to try again :  \t");
            String select=one.nextLine();
            if(select.equals("0")) customerView();
        }

    }

    public void userRegister() {
        for(int j=0;j<user.length;j++)
        {
            if(user[j]!=null)
                uniqueCode=user[j].uniqueCode;
        }

        Scanner inputs = new Scanner(System.in);

        boolean flag=false;

        boolean check=true;

        for (int i = 0; i < user.length; i++) {
            if (user[i] == null) {
                user[i] = new Customer();
                System.out.println("\n\t\t\tONLINE CUSTOMER REGISTRATION");
                System.out.print("\tUser Name :");
                user[i].setName(inputs.nextLine());
                System.out.print("\tEmail :");
                user[i].setEmail1(inputs.nextLine());
                while(check) {
                    boolean check2=false;
                    for (int o = 0; o < i; o++) {
                        if(user[o].getEmail1().equals(user[i].getEmail1()))
                        {
                            check2=true;
                            System.out.println("Email is already registered.\n\tTry different email : ");
                            user[i].setEmail1(inputs.nextLine());
                            break;
                        }
                    }
                    if(check2) {}
                    else check=false;

                }


                System.out.print("\tConfirm email :");
                String email2 = inputs.nextLine();
                while (!user[i].email1.equals(email2)) {
                    System.out.print("\t\tEmail did not match!\n\tConfirm email :");
                    email2 = inputs.nextLine();
                }
                System.out.print("\tPassword (view enabled) :");
                user[i].setPassword1(inputs.nextLine());
                System.out.print("\tRetype password  :");
                String password2 = inputs.nextLine();
                while (!user[i].password1.equals(password2)) {
                    System.out.print("\t\tPassword didn't match!\n\tRetype password  :");
                    password2 = inputs.nextLine();
                }
                System.out.println("\nPERSONAL DETAILS");
                System.out.println("\tGender-\n\t\t1.Male \t2.Female");
                user[i].setGender(inputs.nextLine());
                while (!user[i].gender.equals("male") && !user[i].gender.equals("female")) {
                    System.out.print("Please choose male or female : ");
                    user[i].setGender(inputs.nextLine());
                }


                System.out.print("\tMobile no. :");
                user[i].setMobileNo(inputs.nextLine());
                System.out.print("\tAddress :");
                user[i].setAddress(inputs.nextLine());
                System.out.print("\tCity :");
                user[i].setCity(inputs.nextLine());
                user[i].emailXpass = user[i].email1 + user[i].password1;

                uniqueCode++;
                user[i].setUniqueCode(uniqueCode);

                System.out.println("\n\t\t\tSuccessfully registered! Your unique code is " + user[i].getUniqueCode());

                System.out.println("\n\t\tDetails\n");
                System.out.println("Name : " + user[i].getName());
                System.out.println("Email : " + user[i].getEmail1());
                System.out.println("Gender : " + user[i].getGender());
                System.out.println("Mobile no. : " + user[i].getMobileNo());
                System.out.println("Address : " + user[i].getAddress());
                System.out.println("City : " + user[i].getCity());
                System.out.println("Unique code : " + user[i].getUniqueCode());

                count = i;
                flag=true;

                break;
            }

        }
        if(flag) {}
        else System.out.print("REGISTRATION FULL :( :( !");


    }

    public void userLogin() {
        Scanner scan1 = new Scanner(System.in);
        System.out.print("\nHave you registered? [y/n] ");
        String ans = scan1.nextLine();
        while (!ans.equals("y") && !ans.equals("n")) {
            System.out.print("Please choose y or n : ");
            ans = scan1.nextLine();
        }
        if (ans.equals("n")) {
            System.out.println("Please register first\n");
            userRegister();
        }

        System.out.println("\n\t\t\tOnline customer login");
        System.out.print("\tEmail :");
        String emailIn = scan1.nextLine();
        System.out.print("\tPassword :");
        String passwordIn = scan1.nextLine();

        boolean flag=false;

        for (int i = 0; i <user.length; i++) {

            if(user[i]!=null) {

                if (emailIn.equals(user[i].email1) && passwordIn.equals(user[i].password1)) {
                    reservation();
                    flag = true;
                    break;
                }
            }
        }
        if(flag) {}
        else {
            Scanner one=new Scanner(System.in);

            System.out.print("User not found\n\tPress 0 to try again : ");
            String select=one.nextLine();
            if(select.equals("0")) userLogin();
        }
    }


    public void reservation() {

        Scanner scan1 = new Scanner(System.in);

        System.out.println("********************************************");
        System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
        System.out.println("********************************************");
        System.out.println("** [1] Destination                        **");
        System.out.println("** [2] Booking                            **");
        System.out.println("** [3] Billing                            **");
        System.out.println("** [4] View                               **");
        System.out.println("** [5] Food                               **");
        System.out.println("** [6] Exit                               **");
        System.out.println("********************************************");
        System.out.println("********************************************\n");
        System.out.print("ENTER CHOICE: ");
        int choice = scan1.nextInt();
        if (choice == 1)
            destination();
        else if (choice == 2)
            booking();
        else if (choice == 3)
            billing();
        else if (choice == 4)
            customerView();
        else if (choice==5) {
            Classes.Food f = new Classes.Food();
            System.out.println("FOOD TOTAL COST-->"+f.sum);

        }
        else if (choice == 6) {
            exit();

        }


        Continue();


    }

    public void Continue() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want continue? [y/n]");
        String choose = input.nextLine();
        while (!choose.equals("y") && !choose.equals("n")) {
            System.out.println("Please select y or n - ");
            choose = input.nextLine();
        }
        if (choose.equals("y"))
            reservation();
    }


    public int exit() {
        return 0;
    }

    public void addUserToUserArrAy(Customer user1) {
        for (int i = 0; i < user.length; i++) {
            if (user[i] == null) {
                user[i] = user1;
                break;
            }
        }
    }
}
