
package proyectofinalredes.presentacion.controlador;

import proyectofinalredes.presentacion.vistas.VistaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyectofinalredes.logica.LZW;
import proyectofinalredes.logica.LectorEscritor;
import proyectofinalredes.logica.huffman.Huffman;
import proyectofinalredes.presentacion.plantilla.PlantillaPrincipal;
import proyectofinalredes.presentacion.vistas.VistaCodificar;
import proyectofinalredes.presentacion.vistas.VistaComprimir;
import proyectofinalredes.presentacion.vistas.VistaDescomprimir;

public class Controlador implements ActionListener {
    
    
    //vistas
    private VistaInicial vistaInicial;
    private VistaComprimir vistaComprimir;
    private VistaDescomprimir vistaDescomprimir;
    private VistaCodificar vistaCodificar;
    
    
    //logica
    
    private LectorEscritor le;
    private LZW algoritmoLZW;
    private Huffman algoritmoHuffman;
    
    public Controlador(){
        algoritmoLZW = new LZW();
        le = new LectorEscritor();
        algoritmoHuffman = new Huffman();
    }

    public void setVistaIncial(VistaInicial vistaIncial) {
        this.vistaInicial = vistaIncial;
    }

    public void setVistaComprimir(VistaComprimir vistaComprimir) {
        this.vistaComprimir = vistaComprimir;
    }

    public void setVistaDescomprimir(VistaDescomprimir vistaDescomprimir) {
        this.vistaDescomprimir = vistaDescomprimir;
    }

    public void setVistaCodificar(VistaCodificar vistaCodificar) {
        this.vistaCodificar = vistaCodificar;
    }
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Para la ventana inicial
        if(e.getSource() == vistaInicial.getBtnComprimir()){
            cambiarVista(vistaInicial, vistaComprimir);
        }else if(e.getSource() == vistaInicial.getBtnCodificar()){
            cambiarVista(vistaInicial, vistaCodificar);
        }else if(e.getSource() == vistaInicial.getBtnDescomprimir()){
            cambiarVista(vistaInicial, vistaDescomprimir);
        }
        
        
        //Para Comprimir
        if(e.getSource() == vistaComprimir.getBtnComprimir()){
            
            if(vistaComprimir.getTxtTexto().getText().length()==0){
                JOptionPane.showMessageDialog(vistaComprimir, "Por favor seleccione un archi con un texto válido");
            }else{
                algoritmoLZW.comprimir(vistaComprimir.getTxtTexto().getText());
                le.guardarCompresion(vistaComprimir, algoritmoLZW.getCodigoArchivo(), algoritmoLZW.getDiccionarioArchivo());
                JOptionPane.showMessageDialog(vistaComprimir, "Mensaje comprimido con éxito");
                cambiarVista(vistaComprimir, vistaInicial);
            }
        }else if(e.getSource() == vistaComprimir.getBtnAbrir()){
            vistaComprimir.getTxtTexto().setText("");
            vistaComprimir.getTxtTexto().setText(le.abrir(vistaComprimir, vistaComprimir.getTxtTexto()));
        }
        
        
        //Para descomprimir
        if(e.getSource()==vistaDescomprimir.getBtnDescomprimir()){
            vistaDescomprimir.getTxtTexto().setText("");
            vistaDescomprimir.getTxtTexto().setText(algoritmoLZW.descomprimir(le.leerParaDescomprimir(vistaComprimir)));
            JOptionPane.showMessageDialog(vistaDescomprimir, "El mensaje ha sido descomprimido");
        }
        
        
        //Para codificar
        if(e.getSource()==vistaCodificar.getBtnCodificar()){
            //System.out.println(algoritmoHuffman.getCodificar(le.leerParaCodificar(vistaCodificar)));
            vistaCodificar.getTxtTexto().setText(algoritmoHuffman.getCodificar(le.leerParaCodificar(vistaCodificar)));
        }else if(e.getSource()==vistaCodificar.getBtnInicio()){
            cambiarVista(vistaCodificar, vistaInicial);
        }
    }
    
    public void init(){
        vistaInicial.addController(this);
        vistaComprimir.addController(this);
        vistaDescomprimir.addController(this);
        vistaCodificar.addController(this);
    }
    
    public void cambiarVista(PlantillaPrincipal vistaActual, PlantillaPrincipal vistaSiguiente){
        vistaActual.dispose();
        vistaSiguiente.init();
    }
    
}
