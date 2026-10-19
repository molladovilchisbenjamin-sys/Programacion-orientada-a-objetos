module com.datapars.figuras {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datapars.figuras to javafx.fxml;
    exports com.datapars.figuras;
}
