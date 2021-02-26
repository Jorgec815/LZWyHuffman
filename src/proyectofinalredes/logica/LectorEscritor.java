
package proyectofinalredes.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyectofinalredes.presentacion.plantilla.PlantillaPrincipal;

public class LectorEscritor {
    
    private JFileChooser selectorArchivos;
    private JFileChooser guardaArchivos;
    private FileReader lector;
    private FileWriter escritor;
    private PrintWriter pw;
    private BufferedReader br;
    private File archivo;
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
    
    
    public LectorEscritor(){
        selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selectorArchivos.setFileFilter(filter);
        guardaArchivos = new JFileChooser();
        guardaArchivos.setFileFilter(filter);
    }
    
    public ArrayList leerParaDescomprimir(PlantillaPrincipal vista){
        int resultado = selectorArchivos.showOpenDialog(vista);
        if(resultado == JFileChooser.APPROVE_OPTION){
            ArrayList<String[]> datos = new ArrayList<>();
            archivo = selectorArchivos.getSelectedFile();
            try {
                lector = new FileReader(archivo);
                br = new BufferedReader(lector);
                String[] diccionario = br.readLine().split(",");
                String[] codigo = null;
                br.mark(100000);
                char[] cod = br.readLine().toCharArray();
                if(cod.length<1025){
                    br.reset();
                    codigo = br.readLine().split(",");
                }else{
                    String codigo2 = "";
                    br.reset();
                    while(br.readLine()!=null){
                        br.reset();
                        codigo2 += br.readLine();
                        br.mark(100000);
                    }
                    codigo = codigo2.split(",");
                }
                datos.add(codigo);
                datos.add(diccionario);
                return datos;
            } catch (IOException ex) {
                ex.printStackTrace();
            }finally{
                try{
                    if(lector!=null){
                    lector.close();
                    }
                }catch(IOException ex){
                    ex.printStackTrace();
                }
                
            }
        }else{
            JOptionPane.showMessageDialog(vista, "Por favor seleccione un archivo");
        }
        return null;
    }
    
    public String leerParaCodificar(PlantillaPrincipal vista){
        String texto = "";
        int resultado = selectorArchivos.showOpenDialog(vista);
        if(resultado == JFileChooser.APPROVE_OPTION){
            archivo = selectorArchivos.getSelectedFile();
            try {
                lector = new FileReader(archivo);
                br = new BufferedReader(lector);
                int c=br.read();
                while(c!=-1) {
                    char letra=(char)c;       
                    texto+=letra;
                    c=br.read();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }finally{
                try{
                    if(lector!=null){
                    lector.close();
                    }
                }catch(IOException ex){
                    ex.printStackTrace();
                }
                
            }
        }else{
            JOptionPane.showMessageDialog(vista, "Por favor seleccione un archivo");
        }
        return texto;
    }
    
    public String abrir(PlantillaPrincipal vista, JTextArea txtTexto){
        String texto ="";
        int resultado = selectorArchivos.showOpenDialog(vista);
        if(resultado == JFileChooser.APPROVE_OPTION){
            archivo = selectorArchivos.getSelectedFile();
            try {
                lector = new FileReader(archivo);
                int c = lector.read();
                while(c!=-1) {
                    char letra=(char)c;       
                    texto+=letra;
                    c=lector.read();
                }
            }catch (IOException ex) {
                ex.printStackTrace();
            }finally{
                try{
                    if(null!= lector){
                        lector.close();
                    }
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }else{
            JOptionPane.showMessageDialog(vista, "Por favor seleccione un archivo");
        }
        return texto;
    }
    
    public void guardarCompresion(PlantillaPrincipal vista, String codigoArchivo, String diccionarioArchivo){
        int opcion = guardaArchivos.showSaveDialog(vista);
            if(opcion == JFileChooser.APPROVE_OPTION){
                archivo = guardaArchivos.getSelectedFile();
                try{
                    escritor = new FileWriter(archivo);
                    pw = new PrintWriter(escritor);
                    pw.println(diccionarioArchivo);
                    pw.println(codigoArchivo);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }finally{
                    try{
                        if(null!=escritor){
                            escritor.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
    }
}
