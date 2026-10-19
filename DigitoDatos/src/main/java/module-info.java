module com.datapars.digitodatos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datapars.digitodatos to javafx.fxml;
    exports com.datapars.digitodatos;
}
