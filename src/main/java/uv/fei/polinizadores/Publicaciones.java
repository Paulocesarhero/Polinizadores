package uv.fei.polinizadores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import uv.fei.bussinesslogic.PublicacionDAO;
import uv.fei.domain.Publicacion;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Publicaciones implements Initializable {
    public ComboBox comboEstado;
    public TableView<Publicacion> tablaPublicaciones;
    public TableColumn<Publicacion, String> columnaNombretable;
    public TableColumn<Publicacion, Integer> columnaId;
    public TableColumn<Publicacion, CheckBox> columnaEstado;
    public Button btnGuardar;
    private List<Publicacion> listaPublicaciones = new ArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarListaPublicaciones();
        llenarTabla();
    }
    public void clicGuardar(ActionEvent actionEvent) {
        boolean flag = false;
        boolean message = true;
        boolean unassignation = false;
        String studentStaffNumber = "";
        PublicacionDAO publicacionDAO = new PublicacionDAO();
        Publicacion publicacion = new Publicacion();

        for (int i = 0; i < tablaPublicaciones.getItems().size(); i++){
            unassignation = tablaPublicaciones.getItems().get(i).isEstado();
            publicacion = tablaPublicaciones.getSelectionModel().getSelectedItem();
            //Metodo para guardar las publicaciones
            try {
                publicacionDAO.actualizarPublicacion(publicacion);
            } catch (SQLException e) {
                System.out.println("No se pudo actualizar la publicacion con id "+publicacion.getId());
            }
        }
    }

    private void llenarListaPublicaciones(){
        PublicacionDAO publicacionDAO = new PublicacionDAO();

        try {
            listaPublicaciones = publicacionDAO.obtenerPublicaciones();
        } catch (SQLException e) {
            System.out.println("No se puede acceder a la base de datos");
        }
    }

    private void llenarTabla(){
        columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaNombretable.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnaEstado.setEditable(true);

        ObservableList<Publicacion> observableList = FXCollections.observableList(listaPublicaciones);
        tablaPublicaciones.setItems(observableList);
        tablaPublicaciones.setEditable(false);
    }

}
