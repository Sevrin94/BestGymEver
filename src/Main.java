import gymmet.Customerlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customerlist kl = new Customerlist();
        kl.ReadFile();

        searchCustomer(kl);
    }

    public static void searchCustomer(Customerlist cl) {
        System.out.print("Insert name or social security number: ");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        System.out.println(cl.getCustomerStatus(a));
        
    }
}