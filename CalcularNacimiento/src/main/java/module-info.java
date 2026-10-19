module com.benaak.calcularnacimiento {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.benaak.calcularnacimiento to javafx.fxml;
    exports com.benaak.calcularnacimiento;
}
