
package proyectofinalredes.presentacion.vistas;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import proyectofinalredes.presentacion.plantilla.PlantillaPrincipal;

public class VistaInicial extends PlantillaPrincipal{
    
    private JButton btnComprimir;
    private JButton btnDescomprimir;
    private JButton btnCodificar;
    private JLabel lblTitulo;
    
    private Font fuente;
    
    
    public VistaInicial(){
        lblTitulo = new JLabel();
        btnComprimir = new JButton();
        btnCodificar = new JButton();
        btnDescomprimir = new JButton();
        fuente = new Font("Times New Roman", Font.PLAIN,35);
    }

    @Override
    public void addComponentes() {
        add(lblTitulo);
        add(btnCodificar);
        add(btnComprimir);
        add(btnDescomprimir);
    }

    @Override
    public void setPropiedadesComponentes() {
        setPropiedadesBtnCodificar();
        setPropiedadesBtnComprimir();
        setPropiedadesBtnDescomprimir();
        setPropiedadesLblTitulo();
    }
    
    
    public void setPropiedadesLblTitulo(){
        lblTitulo.setLocation(350, 100);
        lblTitulo.setSize(300,50);
        lblTitulo.setFont(fuente);
        lblTitulo.setText("¿Qué desea realizar?");
    }
    
    public void setPropiedadesBtnComprimir(){
        btnComprimir.setLocation(350, 200);
        btnComprimir.setSize(300, 100);
        btnComprimir.setFont(fuente);
        btnComprimir.setText("Comprimir");
    }
    
    public void setPropiedadesBtnDescomprimir(){
        btnDescomprimir.setLocation(350, 350);
        btnDescomprimir.setSize(300, 100);
        btnDescomprimir.setFont(fuente);
        btnDescomprimir.setText("Descomprimir");
    }
    
    public void setPropiedadesBtnCodificar(){
        btnCodificar.setLocation(350, 500);
        btnCodificar.setSize(300,100);
        btnCodificar.setFont(fuente);
        btnCodificar.setText("Codificar");
    }
    
    
    public void addController(ActionListener listener){
        btnCodificar.addActionListener(listener);
        btnComprimir.addActionListener(listener);
        btnDescomprimir.addActionListener(listener);
    }

    public JButton getBtnComprimir() {
        return btnComprimir;
    }

    public JButton getBtnCodificar() {
        return btnCodificar;
    }

    public JButton getBtnDescomprimir() {
        return btnDescomprimir;
    }
    
    
    
    
}
