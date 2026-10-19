module com.datapars.fabula {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datapars.fabula to javafx.fxml;
    exports com.datapars.fabula;
}
