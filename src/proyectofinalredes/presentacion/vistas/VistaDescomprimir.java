
package proyectofinalredes.presentacion.vistas;

import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import proyectofinalredes.presentacion.plantilla.PlantillaPrincipal;

public class VistaDescomprimir extends PlantillaPrincipal{
    private final JLabel lblTexto;
    private final JTextArea txtTexto;
    private final JScrollPane spTexto;
    private final JButton btnDescomprimir;
    private final JButton btnInicio;
    private final Font fuente;
    
    public VistaDescomprimir(){
        lblTexto = new JLabel();
        txtTexto = new JTextArea();
        spTexto = new JScrollPane(txtTexto);
        spTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        btnDescomprimir = new JButton();
        btnInicio = new JButton();
        fuente = new Font("Times New Roman", Font.PLAIN,25);
    }

    @Override
    public void addComponentes() {
        add(lblTexto);
        add(spTexto);
        add(btnDescomprimir);
        add(btnInicio);
    }

    @Override
    public void setPropiedadesComponentes() {
        setPropiedadesLblTexto();
        setPropiedadesTxtTexto();
        setPropiedadesSpTexto();
        setPropiedadesBtnDescomprimir();
        setPropiedadesBtnInicio();
    }
    
    public void setPropiedadesLblTexto(){
        lblTexto.setLocation(300, 100);
        lblTexto.setSize(400,50);
        lblTexto.setFont(fuente);
        lblTexto.setText("Seleccione el Archivo a descomprimir");
    }
    
    public void setPropiedadesTxtTexto(){
        txtTexto.setLocation(250, 200);
        txtTexto.setSize(500, 300);
        txtTexto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtTexto.setLineWrap(true);
        txtTexto.setFont(fuente);
        txtTexto.setWrapStyleWord(true);
        txtTexto.setEditable(false);
    }
    
    public void setPropiedadesSpTexto(){
        spTexto.setLocation(250, 200);
        spTexto.setSize(500, 300);
        spTexto.setBackground(WHITE);
    }
    
    public void setPropiedadesBtnDescomprimir(){
        btnDescomprimir.setLocation(375, 550);
        btnDescomprimir.setSize(250, 50);
        btnDescomprimir.setFont(fuente);
        btnDescomprimir.setText("Descomprimir");
    }
    
    public void setPropiedadesBtnInicio(){
        btnInicio.setLocation(100, 650);
        btnInicio.setSize(250, 50);
        btnInicio.setFont(fuente);
        btnInicio.setText("Inicio");
    }

    public JButton getBtnDescomprimir() {
        return btnDescomprimir;
    }
    
    public JTextArea getTxtTexto() {
        return txtTexto;
    }

    public JButton getBtnInicio() {
        return btnInicio;
    }
    
    public void addController(ActionListener listener){
        btnDescomprimir.addActionListener(listener);
        btnInicio.addActionListener(listener);
    }
    
}
