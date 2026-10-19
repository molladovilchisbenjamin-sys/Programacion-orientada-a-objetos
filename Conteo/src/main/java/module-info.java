module com.datapars.conteo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datapars.conteo to javafx.fxml;
    exports com.datapars.conteo;
}
