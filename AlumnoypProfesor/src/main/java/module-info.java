module com.datapars.alumnoypprofesor {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.datapars.alumnoypprofesor to javafx.fxml;
    exports com.datapars.alumnoypprofesor;
}
