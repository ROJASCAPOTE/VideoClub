package Controlador;

import Eventos.CatalogoFilmEventoTeclado;
import Eventos.CatalogoPeliculasListener;
import Eventos.CatalogoPeliculasMouseListener;
import Modelo.Actor;
import Modelo.Category;
import Modelo.Dao.DAOManager;
import Modelo.Film;
import ModeloGUI.CatalogoPeliculaTablaModelo;
import Vista.FrmCatalogoPeliculas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CatalogoPeliculasController {

    private FrmCatalogoPeliculas vista;
    private DAOManager modelo;
    private CatalogoPeliculaTablaModelo modeloCatalogoPeliculas;
    private boolean p;

    public CatalogoPeliculasController(FrmCatalogoPeliculas vista, DAOManager modelo) {
        this.vista = vista;
        this.modelo = modelo;

        vista.addMouseListenerCatalogoPeliculas(new CatalogoPeliculasMouseListener(this));
        vista.addListenerBtnSeleccionar(new CatalogoPeliculasListener(this));
        vista.addListenerBtnConsultar(new CatalogoPeliculasListener(this));
        vista.addaddKeyListener(new CatalogoFilmEventoTeclado(this));
        ArrayList<Category> listCategory;
        listCategory = modelo.getCategoriaDAO().listadoCategory();
        vista.cargarCategorias(listCategory);
    }

    public void detallePelucula() {
        int filaSeleccionada = vista.getTablaCatalogoPeliculas().getSelectedRow();
        if (filaSeleccionada != -1) {
            int film_id = (int) vista.getTablaCatalogoPeliculas().getValueAt(filaSeleccionada, 0);
            Film film = modelo.getFilmDAO().getFilm(film_id);
            ArrayList<Actor> listActores = modelo.getActorDAO().getListFilmActor(film.getFilmId());
            ArrayList<Category> listCategory = modelo.getCategoriaDAO().getFilmCategory(film.getFilmId());
            film.setListActoresFilm(listActores);
            film.setListCategoryFilm(listCategory);
            vista.cargarInformacionPelicula(film);
        } else {
            vista.gestionMensajes("Debe buscar una pelicula",
                    "Confirmación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarPorCodigoNombre() {
        int codigo = 0;
        String titulo = "";
        String film_id = vista.getTextBuscarTituloCodigo();
        try {
            codigo = Integer.parseInt(film_id);
        } catch (NumberFormatException e) {
        }
        if (codigo > 0) {
            ArrayList<Film> listaPeliculas;
            listaPeliculas = modelo.getFilmDAO().getListFilm(codigo, "");
            modeloCatalogoPeliculas = new CatalogoPeliculaTablaModelo(listaPeliculas);
            vista.setModel(modeloCatalogoPeliculas);
        } else {
            titulo = vista.getTextBuscarTituloCodigo();
            ArrayList<Film> listaPeliculas;
            listaPeliculas = modelo.getFilmDAO().getListFilm(0, titulo);
            modeloCatalogoPeliculas = new CatalogoPeliculaTablaModelo(listaPeliculas);
            vista.setModel(modeloCatalogoPeliculas);
        }

    }


    public void consultarCatalogoPeliculas() {
        ArrayList<Film> listaPeliculas;
        listaPeliculas = modelo.getFilmDAO().getListFilm(0, "");
        modeloCatalogoPeliculas = new CatalogoPeliculaTablaModelo(listaPeliculas);
        vista.setModel(modeloCatalogoPeliculas);
    }

    public void buscarPelicula() {
       buscarPorCodigoNombre();
    }

    public void abrirFilmActor() {
        vista.abrirFilmActor();
    }

    public void abrirFilmCategory() {
        vista.abrirFilmCategory();
    }

}
