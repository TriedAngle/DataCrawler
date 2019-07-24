package net.strobl.management;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DataManager {
    private String databaseType;
    private String url, username, password, table;
    private String jdbcDriver;
    private Connection connection;
    private ArrayList<Bill> bills = new ArrayList<>();
    private ArrayList<String> columnNames = new ArrayList<>();
    private ArrayList<String> tableNames = new ArrayList<>();
    private boolean connected;
    String home = System.getProperty("user.home");

    DataManager() {
    }

    DataManager(String databaseType, String url, String username, String password) {
        this.databaseType = databaseType;
        this.url = url;
        this.username = username;
        this.password = password;
        setDriver();
    }

    DataManager(String databaseType, String url, String username, String password, String table) {
        this.databaseType = databaseType;
        this.url = url;
        this.username = username;
        this.password = password;
        this.table = table;
        setDriver();
    }

    private void setDriver() {
        switch (databaseType) {
            case "MySQL":
                jdbcDriver = "com.mysql.jdbc.Driver";
                break;
            case "PostgreSQL":
                jdbcDriver = "org.postgresql.Driver";
                break;
            default:
                System.out.println("Case does not exist");
                return;
        }

        try {
            Class.forName(jdbcDriver);
            System.out.println("successfully init Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("could not init Driver");
        }

    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("successfully connected to database");
            connected = true;
        } catch (SQLException e) {
            System.out.println("could not connected to database");
            connected = false;
        }
    }

    public void readAllBills() {
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                int billID = rs.getInt("id");
                String project = rs.getString("projectname");
                int amountInCent = rs.getInt("amountincent");
                boolean isIntake = rs.getBoolean("isintake");
                boolean isDigital = rs.getBoolean("isdigital");
                boolean isPaid = rs.getBoolean("ispaid");
                String dateOfOrder = rs.getString("dateorder");
                String dateOfReceive = rs.getString("datereceived");
                String dateOfPayment = rs.getString("datepayment");
                String orderedBy = rs.getString("orderedby");
                String seller = rs.getString("seller");
                Array sqlItemArray = rs.getArray("items");
                String[] itemArray = (String[]) sqlItemArray.getArray();
                ArrayList<String> observableItems = new ArrayList<>(Arrays.asList(itemArray));
                String reason = rs.getString("reason");

                bills.add(new Bill(billID, project, amountInCent, isIntake, isDigital, isPaid, dateOfOrder, dateOfReceive, dateOfPayment, reason, orderedBy, seller, observableItems));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Could not fetch bills");
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

    public void readColumnNames() {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, table, null);

            while (resultSet.next()) {
                columnNames.add(resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readTableNames() {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "%", null);

            while (resultSet.next()) {
                tableNames.add(resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCredentials(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
        setDriver();
    }

    public void setCredentials(String url, String username, String password, String table) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public boolean isConnected() {
        return connected;
    }

    public ArrayList<Bill> getBills(){
        return bills;
    }

    public ArrayList<String> getTableNames() {
        return tableNames;
    }

    public ArrayList<String> getColumnNames() {
        return columnNames;
    }
}
