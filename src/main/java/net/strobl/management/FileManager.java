package net.strobl.management;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class FileManager {
    String home = System.getProperty("user.home");
    private DateFormat dateFormat;
    private Manager manager;

    private ArrayList<Bill> bills;
    private ArrayList<String> columns;

    FileManager(Manager manager) {
        this.manager = manager;
        dateFormat = new SimpleDateFormat("ss.mm.HH.dd.MM.yyyy");
    }

    public void writeData() {
        try {
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            String path = home + "/Downloads/" + "CSVDownload" + currentDate + ".csv";
            CSVWriter writer = new CSVWriter(new FileWriter(path));

            String[] columnArray = {"Bill ID", "Project", "Amount in Cent", "Intake", "Digital", "Paid", "Date of Order", "Date of Receive", "Date Payment", "Ordered By", "Seller", "Products", "Reason", "(Real Amount)"};
            String[] billAsArray = new String[14];
            writer.writeNext(columnArray);

            for (Bill bill : bills) {
                String products = String.join(System.getProperty("line.separator") , bill.getItems().toArray(String[]::new));
                billAsArray[0] = String.valueOf(bill.getBillID());
                billAsArray[1] = bill.getProject();
                billAsArray[2] = String.valueOf(bill.getAmountInCent());
                billAsArray[3] = String.valueOf(bill.isIntake());
                billAsArray[4] = String.valueOf(bill.isDigital());
                billAsArray[5] = String.valueOf(bill.isPaid());
                billAsArray[6] = bill.getDateOfOrder();
                billAsArray[7] = bill.getDateOfReceive();
                billAsArray[8] = bill.getDateOfPayment();
                billAsArray[9] = bill.getOrderedBy();
                billAsArray[10] = bill.getSeller();
                billAsArray[11] = products;
                billAsArray[12] = bill.getReason();
                billAsArray[13] = String.valueOf(bill.getRealAmount());

                writer.writeNext(billAsArray);
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setData(ArrayList<Bill> bills, ArrayList<String> columns) {
        this.bills = bills;
        this.columns = columns;
    }


}
