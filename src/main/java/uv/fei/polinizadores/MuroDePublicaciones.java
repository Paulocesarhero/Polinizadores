package uv.fei.polinizadores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import uv.fei.bussinesslogic.PublicacionDAO;
import uv.fei.domain.Publicacion;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class MuroDePublicaciones implements Initializable {
    public TextFlow tfPublicacion;
    public ChoiceBox<Publicacion> cbPublicaciones;
    public ImageView ivImagen;
    public Button btnVer;

    private Text titulo;
    private Text descripcion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        tfPublicacion.getChildren().removeAll(text_1,text_2);
        llenarListaDePublicaciones();
        btnVer.setDisable(false);

    }

    public void llenarListaDePublicaciones(){
        PublicacionDAO publicacionDAO = new PublicacionDAO();
        List<Publicacion> publicaciones = null;
        ObservableList<Publicacion> publicacionObservableList =
                FXCollections.observableArrayList();

        try {
            publicaciones = publicacionDAO.obtenerPublicaciones();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (publicaciones != null) {
            publicacionObservableList.addAll(publicaciones);
        }
        cbPublicaciones.setValue(publicacionObservableList.get(0));
        cbPublicaciones.getItems().addAll(publicacionObservableList);

    }
    public void seleccionarPublicacion(MouseEvent mouseEvent){

    }

    public void clicVerPublicacion(ActionEvent actionEvent) {
        tfPublicacion.getChildren().removeAll(titulo,descripcion);
        Publicacion publicacion = cbPublicaciones.getValue();
        titulo  = new Text(publicacion.getTitulo() +"\n");
        titulo.setFill(Color.BLACK);
        descripcion = new Text(publicacion.getDescripcion() + "\n");
        descripcion.setFill(Color.BLACK);
        tfPublicacion.getChildren().addAll(titulo, descripcion);
    }
}
