package uv.fei.polinizadores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldPassword;
    @FXML
    private Label labelRegistrar;

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonEntrarInvitado;

    @FXML
    private Label labelOlvidar;

    @FXML
    void labelOlvidarClic(ActionEvent event) {


    }

    @FXML
    void buttonLoginClic(ActionEvent event) {
        if(areItemsEmpty()){

        }
    }

    @FXML
    void buttonEntrarInvitadoClic(ActionEvent event) {
        labelOlvidar.setText("hola");

    }

    @FXML
    void labelRegistrarClic(ActionEvent event) {

    }

    private boolean areItemsEmpty(){
        boolean flag = false;
        if (fieldPassword.getText().isEmpty() || fieldEmail.getText().isEmpty()) {
            flag = true;
        }
        return flag;
    }

}
