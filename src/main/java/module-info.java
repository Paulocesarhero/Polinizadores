module uv.fei.polinizadores {
    requires javafx.controls;
    requires javafx.fxml;


    opens uv.fei.polinizadores to javafx.fxml;
    exports uv.fei.polinizadores;
}