package Dominio;

import Datos.ManejoGson;

import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Vinyl> coleccion;
    private final int TAMANO_MAXIMO = 100;
    private ManejoGson manejoGson;

    public Coleccion() {
        manejoGson = new ManejoGson();
        coleccion = manejoGson.cargarColeccion();
        if (coleccion == null) {
            coleccion = new ArrayList<>(TAMANO_MAXIMO);
        }
    }

    public boolean agregarVinilo(Vinyl vinilo) {
        if (coleccion.size() < TAMANO_MAXIMO) {
            coleccion.add(vinilo);
            manejoGson.guardarColeccion(coleccion);
            return true;
        }
        return false;
    }

    public Vinyl buscarPorArtista(String artista) {
        for (Vinyl v : coleccion) {
            if (v.getArtista().equalsIgnoreCase(artista)) {
                return v;
            }
        }
        return null;
    }

    public Vinyl buscarPorTitulo(String titulo) {
        for (Vinyl v : coleccion) {
            if (v.getTitulo().equalsIgnoreCase(titulo)) {
                return v;
            }
        }
        return null;
    }

    public boolean eliminarVinilo(String artista, String titulo) {
        for (Vinyl v : coleccion) {
            if (v.getArtista().equalsIgnoreCase(artista) && v.getTitulo().equalsIgnoreCase(titulo)) {
                coleccion.remove(v);
                manejoGson.guardarColeccion(coleccion);
                return true;
            }
        }
        return false;
    }

    public int obtenerCantidadVinilos() {
        return coleccion.size();
    }

    public int obtenerEspacioDisponible() {
        return TAMANO_MAXIMO - coleccion.size();
    }

    public ArrayList<Vinyl> obtenerTodosVinilos() {
        return coleccion;
    }
}