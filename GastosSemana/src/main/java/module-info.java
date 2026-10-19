module com.datapars.gastossemana {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datapars.gastossemana to javafx.fxml;
    exports com.datapars.gastossemana;
}
