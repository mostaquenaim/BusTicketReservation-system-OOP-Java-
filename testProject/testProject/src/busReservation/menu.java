package busReservation;


public class menu extends Adminwork {

    String adminName = "Admin";
    String adminPass = "admin";
    public menu()
    {
    }
    public menu(String name,String pass)
    {
        this.adminName=name;
        this.adminPass=pass;
    }


    public void setAdminName(String name)
    {
        this.adminName = name;
    }
    public void setAdminPass (String pass)
    {
        this.adminPass = pass;
    }
    public String getAdminName ()
    {
        return adminName;
    }
    public String getAdminPass ()
    {
        return adminPass;
    }

}




