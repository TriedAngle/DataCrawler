module datacrawler.main{
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires opencsv;
    requires postgresql;

    opens net.strobl;
    opens net.strobl.management;
    opens net.strobl.frontend.general;
    opens net.strobl.frontend.windows;
}