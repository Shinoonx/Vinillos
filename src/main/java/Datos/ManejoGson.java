package Datos;

import Dominio.Vinyl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ManejoGson {
    private static final String RUTA_ARCHIVO = "src/main/java/Datos/Vinyls";
    private Gson gson;

    public ManejoGson() {
        gson = new Gson();
    }

    public void guardarColeccion(ArrayList<Vinyl> coleccion) {
        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO)) {
            gson.toJson(coleccion, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Vinyl> cargarColeccion() {
        try (FileReader reader = new FileReader(RUTA_ARCHIVO)) {
            Type tipoColeccion = new TypeToken<ArrayList<Vinyl>>() {}.getType();
            ArrayList<Vinyl> coleccion = gson.fromJson(reader, tipoColeccion);
            return coleccion != null ? coleccion : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
