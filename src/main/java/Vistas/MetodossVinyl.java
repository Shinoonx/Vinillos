package Vistas;

import Dominio.Colleccion;
import Dominio.Vinyl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MetodossVinyl {
    private Colleccion collection;
    private JTextArea displayArea;
    private JTextField artistField, titleField, yearField, searchField;
    private JLabel statusLabel;

    public MetodossVinyl() {
        collection = new Colleccion();


    }

    public void addVinyl(String artist, String title, int year, JTextArea displayArea, JLabel statusLabel, JTextField... fields) {
        try {
            year = Integer.parseInt(fields[2].getText());
        } catch (NumberFormatException e) {
            statusLabel.setText("El año debe ser un número.");
            return;
        }
        Vinyl vinyl = new Vinyl(artist, title, year);
        if (collection.addVinyl(vinyl)) {
            statusLabel.setText("Vinilo agregado exitosamente.");
            clearInputFields(fields);
        } else {
            statusLabel.setText("La colección está llena.");
        }
    }

    public void searchVinyl(String query, JTextArea displayArea, JLabel statusLabel) {
        Vinyl result = collection.searchByArtist(query);
        if (result == null) {
            result = collection.searchByTitle(query);
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
        Vinyl result = collection.searchByArtist(query);
        if (result != null && collection.removeVinyl(result.getArtist(), result.getTitle())) {
            statusLabel.setText("Vinilo eliminado.");
        } else {
            statusLabel.setText("No se encontró el vinilo para eliminar.");
        }
    }

    public void showCount(JTextArea displayArea) {
        int count = collection.getVinylCount();
        displayArea.setText("Total de vinilos: " + count);
    }

    public void showAvailableSpace(JTextArea displayArea) {
        int space = collection.getAvailableSpace();
        displayArea.setText("Espacios disponibles: " + space);
    }

    public void showAllVinyls(JTextArea displayArea) {
        ArrayList<Vinyl> vinyls = collection.getAllVinyls();
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

