package net.strobl.management;

import java.sql.*;
import java.util.Vector;

public class DataManager {
    private String databaseType;
    private String url, username, password, table;
    private String jdbcDriver;
    private Connection connection;
    private Vector<String> columnNames = new Vector<>();
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

    public void readColumnNames() {
        DatabaseMetaData metaData = null;
        try {
            metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getColumns(null, null, table, null);
            while (resultSet.next()) {
                columnNames.add(resultSet.getString(4));
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

    public boolean isConnected(){
        return connected;
    }
}
