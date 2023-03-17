package busReservation;

public class Registration {
    protected String name;
    protected String address;
    protected String city;
    protected String email1;
    protected String mobileNo;
    protected String gender;
    protected String password1;
    protected String emailXpass = "0";
    protected int totalSeats = 0;
    protected static String[] busNames;
    protected int busSelect;
    protected int destinationSelect;
    protected static String[] destinationName;
    protected int payment;
    protected int uniqueCode;
    protected int duePayment = 0;
    static int[][] available;
    protected Customer user1;
    static int count = 0;



    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getEmail1() {
        return email1;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword1() {
        return password1;
    }

    public void setDestinationSelect(int destinationSelect) {
        this.destinationSelect = destinationSelect;
    }

    public int getDestinationSelect() {
        return destinationSelect;
    }

    public void setUniqueCode(int uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public int getUniqueCode() {
        return uniqueCode;
    }



}
