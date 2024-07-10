package Vistas;

import Dominio.Coleccion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ManejadorVinilos extends JFrame implements ActionListener, FocusListener {

    private Coleccion collection;
    private MetodossVinyl metodossVinyl;
    private JTextArea displayArea;
    private JTextField artistField, titleField, yearField, searchField;
    private JLabel statusLabel;

    private JPanel jpVinyl;
    private JTextField txfAño;
    private JTextField txfTitulo;
    private JTextField txfArtista;
    private JButton btnbuscarVInillo;
    private JButton btnagragarVinilo;
    private JTextArea txFdisplayArea;
    private JTextField txfBuscarPorArtista;
    private JButton btneliminarVinilo;
    private JButton btnconsultarCantidad;
    private JButton btnconstularEspaciosDisponibles;
    private JButton btnmostrarTodo;
    private JButton btnSalir;
    private JLabel lblArtista;
    private JLabel lblTitulo;
    private JLabel lblAño;
    private JLabel lblBuscarA;

    public ManejadorVinilos() {
        collection = new Coleccion();
        metodossVinyl = new MetodossVinyl();
    }

    public void PantallaAlbum() {
        setSize(600, 400);
        setTitle("Vinilos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(jpVinyl);
        setVisible(true);
        jpVinyl.setFocusable(true);
        jpVinyl.requestFocusInWindow();
        btnagragarVinilo.addActionListener(this);
        btnmostrarTodo.addActionListener(this);
        btnSalir.addActionListener(this);
        btnconstularEspaciosDisponibles.addActionListener(this);
        btneliminarVinilo.addActionListener(this);
        btnconsultarCantidad.addActionListener(this);
        btnbuscarVInillo.addActionListener(this);

        statusLabel = new JLabel(" ");
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBorder(BorderFactory.createTitledBorder("Estado y Operaciones"));
        statusPanel.add(statusLabel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnagragarVinilo) {
            String artista = txfArtista.getText();
            String titulo = txfTitulo.getText();
            String añoTexto = txfAño.getText();

            if (artista.isEmpty() || titulo.isEmpty() || añoTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int año = Integer.parseInt(añoTexto);
                metodossVinyl.addVinyl(artista, titulo, año, txFdisplayArea, statusLabel, txfArtista, txfTitulo, txfAño);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El año debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnbuscarVInillo) {
            metodossVinyl.searchVinyl(txfBuscarPorArtista.getText(), txFdisplayArea, statusLabel);
        } else if (e.getSource() == btneliminarVinilo) {
            metodossVinyl.removeVinyl(txfBuscarPorArtista.getText(), txFdisplayArea, statusLabel);
        } else if (e.getSource() == btnconsultarCantidad) {
            metodossVinyl.showCount(txFdisplayArea);
        } else if (e.getSource() == btnconstularEspaciosDisponibles) {
            metodossVinyl.showAvailableSpace(txFdisplayArea);
        } else if (e.getSource() == btnmostrarTodo) {
            metodossVinyl.showAllVinyls(txFdisplayArea);
        } else if (e.getSource() == btnSalir) {
            System.exit(0);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}
