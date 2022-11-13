package uv.fei.polinizadores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import uv.fei.bussinesslogic.PublicacionDAO;
import uv.fei.domain.Publicacion;
import uv.fei.domain.Singleton;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegistrarPublicacion implements Initializable {

    @FXML
    private Button buttonPublish;
    @FXML
    private Label labelAutor;
    @FXML
    private TextField tituloField;

    @FXML
    private Button buttonCancel;

    @FXML
    private HTMLEditor htmlEditor;


    @FXML
    void buttonPublish_Clicked(ActionEvent event) {
        registrarNuevapublicacion();
    }

    @FXML
    void ButtonCancel_Clicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelAutor.setText(String.valueOf(Singleton.getUserName()));


    }
    public void registrarNuevapublicacion() {
        DateFormat fecha = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss z");
        Publicacion publicacion = new Publicacion();
        publicacion.setFecha(fecha.toString());
        publicacion.setTitulo(tituloField.getText());
        publicacion.setDescripcion(htmlEditor.getHtmlText().toString());
        publicacion.setFecha(fecha.format(new Date()));
        publicacion.setIdUsuario(Singleton.getId());
        publicacion.setEstado(false);
        publicacion.setReferencia("");
        publicacion.setId(1003);

        try {
            PublicacionDAO publicacionDAO = new PublicacionDAO();
            if (publicacionDAO.registrarPublicacion(publicacion)){
                JOptionPane.showMessageDialog(null,"La publicacion se ha registrado exitosamente");
            }else {
                JOptionPane.showMessageDialog(null,"No se ha podido registrar la publicacion");
            }
        }
         catch (SQLException e) {
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
             JOptionPane.showMessageDialog(null,e);
        }
    }
}