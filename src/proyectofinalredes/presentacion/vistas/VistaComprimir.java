
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

public class VistaComprimir extends PlantillaPrincipal{
    
    private final JLabel lblTexto;
    private final JTextArea txtTexto;
    private final JScrollPane spTexto;
    private final JButton btnComprimir;
    private final JButton btnAbrir;
    private final Font fuente;
    
    public VistaComprimir(){
        lblTexto = new JLabel();
        txtTexto = new JTextArea();
        spTexto = new JScrollPane(txtTexto);
        spTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        btnComprimir = new JButton();
        btnAbrir = new JButton();
        fuente = new Font("Times New Roman", Font.PLAIN,25);
    }

    @Override
    public void addComponentes() {
        add(lblTexto);
        add(spTexto);
        add(btnComprimir);
        add(btnAbrir);
    }

    @Override
    public void setPropiedadesComponentes() {
        setPropiedadesLblTexto();
        setPropiedadesTxtTexto();
        setPropiedadesSpTexto();
        setPropiedadesBtnComprimir();
        setPropiedadesBtnAbrir();
    }
    
    public void setPropiedadesLblTexto(){
        lblTexto.setLocation(350, 100);
        lblTexto.setSize(300,50);
        lblTexto.setFont(fuente);
        lblTexto.setText("Ingrese el texto a comprimir");
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
    
    public void setPropiedadesBtnComprimir(){
        btnComprimir.setLocation(450, 650);
        btnComprimir.setSize(100, 50);
        btnComprimir.setText("Comprimir");
    }
    
    public void setPropiedadesBtnAbrir(){
        btnAbrir.setLocation(850, 500);
        btnAbrir.setSize(100, 50);
        btnAbrir.setText("Abrir...");
    }

    public JButton getBtnComprimir() {
        return btnComprimir;
    }

    public JButton getBtnAbrir() {
        return btnAbrir;
    }
    
    public JTextArea getTxtTexto() {
        return txtTexto;
    }

    
    public void addController(ActionListener listener){
        btnComprimir.addActionListener(listener);
        btnAbrir.addActionListener(listener);
    }
    
    
    
}
