package Classes;

import java.util.Scanner;

public class ItemPrice{


    public double itemprice = 0;

    public double itemPrice(final int foodItem, Scanner input) {
        if (foodItem == 1) {
            System.out.println("You Have Ordered Burger");
            itemprice = 250;
        }
        if (foodItem == 2) {
            System.out.println("You Have Ordered French Fries");
            itemprice = 100;
        }
        if (foodItem == 3) {
            System.out.println("You Have Ordered Drinks");
            itemprice = 50;
        }
        Quantity qua = new Quantity();
        return qua.quantity(itemprice, input);
    }
}
