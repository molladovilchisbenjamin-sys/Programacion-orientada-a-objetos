module com.datapars.compraprod {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datapars.compraprod to javafx.fxml;
    exports com.datapars.compraprod;
}
