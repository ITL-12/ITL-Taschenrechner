module dev.zanex.itltaschenrechner {
    requires javafx.controls;
    requires javafx.fxml;

    opens dev.zanex.ui to javafx.fxml;
    exports dev.zanex.itltaschenrechner;
}