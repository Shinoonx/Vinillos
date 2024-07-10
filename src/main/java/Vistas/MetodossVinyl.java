package Vistas;

import Dominio.Coleccion;
import Dominio.Vinyl;

import javax.swing.*;
import java.util.ArrayList;

public class MetodossVinyl {
    private Coleccion collection;

    public MetodossVinyl() {
        collection = new Coleccion();
    }

    public void addVinyl(String artist, String title, int year, JTextArea displayArea, JLabel statusLabel, JTextField... fields) {
        try {
            year = Integer.parseInt(fields[2].getText());
        } catch (NumberFormatException e) {
            statusLabel.setText("El año debe ser un número.");
            return;
        }
        Vinyl vinyl = new Vinyl(artist, title, year);
        if (collection.agregarVinilo(vinyl)) {
            statusLabel.setText("Vinilo agregado exitosamente.");
            clearInputFields(fields);
        } else {
            statusLabel.setText("La colección está llena.");
        }
    }

    public void searchVinyl(String query, JTextArea displayArea, JLabel statusLabel) {
        Vinyl result = collection.buscarPorArtista(query);
        if (result == null) {
            result = collection.buscarPorTitulo(query);
        }
        if (result != null) {
            displayArea.setText(result.toString());
            statusLabel.setText("Vinilo encontrado.");
        } else {
            displayArea.setText("");
            statusLabel.setText("No se encontró el vinilo.");
        }
    }

    public void removeVinyl(String query, JTextArea displayArea, JLabel statusLabel) {
        Vinyl result = collection.buscarPorArtista(query);
        if (result != null && collection.eliminarVinilo(result.getArtista(), result.getTitulo())) {
            statusLabel.setText("Vinilo eliminado.");
        } else {
            statusLabel.setText("No se encontró el vinilo para eliminar.");
        }
    }

    public void showCount(JTextArea displayArea) {
        int count = collection.obtenerCantidadVinilos();
        displayArea.setText("Total de vinilos: " + count);
    }

    public void showAvailableSpace(JTextArea displayArea) {
        int space = collection.obtenerEspacioDisponible();
        displayArea.setText("Espacios disponibles: " + space);
    }

    public void showAllVinyls(JTextArea displayArea) {
        ArrayList<Vinyl> vinyls = collection.obtenerTodosVinilos();
        StringBuilder sb = new StringBuilder();
        for (Vinyl v : vinyls) {
            sb.append(v.toString()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void clearInputFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
}
