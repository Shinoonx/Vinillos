package Vistas;

import Dominio.Colleccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ManejadorVinilos extends JFrame implements ActionListener, FocusListener {

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
    private  MetodossVinyl  MetodossVinyl;
    private Colleccion collection;


    public ManejadorVinilos() {
        collection = new Colleccion();
        MetodossVinyl = new MetodossVinyl();

    }
    public void PantallaAlbum() {
        setSize(600, 400);
        setTitle("Vinillos");
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

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
        statusPanel.setBorder(BorderFactory.createTitledBorder("Estado y Operaciones"));

        statusLabel = new JLabel(" ");
        statusPanel.add(statusLabel, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MetodossVinyl metodossVinyl = new MetodossVinyl();
        if (e.getSource() == btnagragarVinilo) {
            metodossVinyl.addVinyl(txfArtista.getText(), txfTitulo.getText(), Integer.parseInt(txfAño.getText()), txFdisplayArea, statusLabel, txfArtista, txfTitulo, txfAño);
        } else if (e.getSource() == btnbuscarVInillo) {
            metodossVinyl.searchVinyl(txfBuscarPorArtista.getText(), txFdisplayArea,statusLabel);
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
