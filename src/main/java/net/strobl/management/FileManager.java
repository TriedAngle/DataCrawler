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

    FileManager(Manager manager){
        this.manager = manager;
        dateFormat = new SimpleDateFormat("ss.mm.HH.dd.MM.yyyy");
    }

    public void writeData(){
        try {
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            String path = "CSVDownload" + currentDate + ".csv";
            CSVWriter writer = new CSVWriter(new FileWriter(path));

            writer.writeNext(columns.toArray(String[]::new));

            for(Bill bill : bills){
                String[] billAsArray = {
                        String.valueOf(bill.getBillID()),
                        bill.getProject(),
                        String.valueOf(bill.getRealAmount()),
                        String.valueOf(bill.isIntake()),
                        String.valueOf(bill.isDigital()),
                        String.valueOf(bill.isPaid()),
                        bill.getDateOfOrder(),
                        bill.getDateOfPayment(),
                        bill.getDateOfReceive(),
                        bill.getOrderedBy(),
                        bill.getReason()
                };
                writer.writeNext(billAsArray);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setData(ArrayList<Bill> bills, ArrayList<String> columns){
        this.bills = bills;
        this.columns = columns;
    }


}
