package gymmet;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Customerlist {
    public ArrayList<Customerinfo> lista;
    public Customerlist() {
        lista = new ArrayList<Customerinfo>();
    }
    public void ReadFile() {
    lista.clear();
    // rensar listan innan vi läser in filen på nytt

        String line;

        try {

            BufferedReader bfr = new BufferedReader(new FileReader("src/members.txt"));

            while ((line = bfr.readLine()) != null) {
                Customerinfo ci = new Customerinfo();
                ci.data = line;
                if ((line = bfr.readLine()) != null) {
                    ci.paidDate = LocalDate.parse(line);
                }
                lista.add(ci);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getCustomerStatus(String value) {
        for (Customerinfo ci : lista) {
            if (ci.data.toLowerCase().contains(value.toLowerCase())) {
                if (ci.paidDate.until(LocalDate.now()).getYears() < 1) {
                    logCustomerVisit(ci);
                    return "Authorised";
                } else {
                return "Expired"; }
            }
        }
        return "Unauthorised";
    }
    public void logCustomerVisit(Customerinfo ci) {
        try {FileWriter activity = new FileWriter("src/visitor.txt", true);
            activity.write(ci.data + "\n" + LocalDate.now() + "\n");
            activity.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

