module com.datapars.tablaxdigito {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datapars.tablaxdigito to javafx.fxml;
    exports com.datapars.tablaxdigito;
}
