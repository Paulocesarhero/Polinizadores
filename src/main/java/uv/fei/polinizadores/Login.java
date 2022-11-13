package uv.fei.polinizadores;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import uv.fei.bussinesslogic.UsuarioDAO;
import uv.fei.domain.Singleton;
import uv.fei.domain.Usuario;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login implements Initializable {

    @FXML
    private CheckBox checkBoxShowPassword;
    @FXML
    private PasswordField fieldPassword2;
    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField passwordField;
    @FXML
    private Label labelRegistrar;

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonEntrarInvitado;

    @FXML
    void labelOlvidarClic(ActionEvent event) {

    }

    @FXML
    void buttonLoginClic(ActionEvent event) {
        if(!areItemsEmpty()){
            logging();
        }
        else {
            JOptionPane.showMessageDialog(null,"Por favor, llena todos los campos");
        }
    }

    @FXML
    void buttonEntrarInvitadoClic(ActionEvent event) {

    }

    @FXML
    void labelRegistrarClic(ActionEvent event) {

    }
    @FXML
    void passwordFieldListenner(ActionEvent event) {
        labelRegistrar.setText(fieldPassword2.getText());
    }
    @FXML
    void checkBoxShow_OnAction(ActionEvent event) {
        fieldPassword2.setVisible(!checkBoxShowPassword.selectedProperty().getValue());
        fieldPassword2.setEditable(!checkBoxShowPassword.selectedProperty().getValue());
        passwordField.setEditable(checkBoxShowPassword.selectedProperty().getValue());
        passwordField.setVisible(checkBoxShowPassword.selectedProperty().getValue());
    }

    private boolean areItemsEmpty(){
        boolean flag = false;
        if (fieldPassword2.getText().isEmpty() || fieldEmail.getText().isEmpty()) {
            flag = true;
        }
        return flag;
    }
    private void logging(){
        String contrasenia = fieldPassword2.getText();
        String email = fieldEmail.getText();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        boolean result = false;
        try {
            result = usuarioDAO.login(email, contrasenia);
            if (!result) {
                JOptionPane.showMessageDialog(null,"Contraseña o correo electronico incorrecto");
            }else{
                JOptionPane.showMessageDialog(null,"Bienvenido "+ Singleton.getUserName() );
                openWindowMenu();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fieldPassword2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                passwordField.setText(fieldPassword2.getText());
            }
        });
        passwordField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                fieldPassword2.setText(passwordField.getText());
            }
        });
    }
    private void openWindowMenu(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("RegistrarPublicacion.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) this.buttonLogin.getScene().getWindow();
            stage.setTitle("Registrar Publicacion");
            stage.setScene(scene);
            stage.show();
        }catch(IOException ioException){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ioException);
        }
    }
}
