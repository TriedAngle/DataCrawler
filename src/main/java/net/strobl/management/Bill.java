package net.strobl.management;

import java.util.ArrayList;

public class Bill {
    private int billID;
    private String project;
    private int amountInCent;
    private double amount;
    private boolean isIntake;
    private boolean isDigital;
    private boolean isPaid;
    private String dateOfOrder;
    private String dateOfReceive;
    private String dateOfPayment;
    private String orderedBy;
    private String seller;
    private ArrayList<String> items;
    private String reason;
    private double realAmount;

    public Bill(int billID, String project, int amountInCent, boolean isIntake, boolean isDigital, boolean isPaid, String dateOfOrder, String dateOfReceive, String dateOfPayment, String orderedBy, String seller, ArrayList<String> items, String reason) {
        this.billID = billID;
        this.project = project;
        this.amountInCent = amountInCent;
        this.isIntake = isIntake;
        this.isDigital = isDigital;
        this.isPaid = isPaid;
        this.dateOfOrder = dateOfOrder;
        this.dateOfReceive = dateOfReceive;
        this.dateOfPayment = dateOfPayment;
        this.orderedBy = orderedBy;
        this.seller = seller;
        this.items = items;
        this.reason = reason;

        double temp = (double) amountInCent;
        temp /= 100;
        amount = temp;
        if(isIntake){
            realAmount = amount;
        }else {
            realAmount = -amount;
        }
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getAmountInCent() {
        return amountInCent;
    }

    public void setAmountInCent(int amountInCent) {
        this.amountInCent = amountInCent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isIntake() {
        return isIntake;
    }

    public void setIntake(boolean intake) {
        isIntake = intake;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getDateOfReceive() {
        return dateOfReceive;
    }

    public void setDateOfReceive(String dateOfReceive) {
        this.dateOfReceive = dateOfReceive;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(double realAmount) {
        this.realAmount = realAmount;
    }
}
