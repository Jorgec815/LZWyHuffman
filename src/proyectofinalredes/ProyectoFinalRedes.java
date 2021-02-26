
package proyectofinalredes;

import proyectofinalredes.logica.LZW;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import proyectofinalredes.presentacion.controlador.Controlador;
import proyectofinalredes.presentacion.vistas.VistaCodificar;
import proyectofinalredes.presentacion.vistas.VistaComprimir;
import proyectofinalredes.presentacion.vistas.VistaDescomprimir;
import proyectofinalredes.presentacion.vistas.VistaInicial;


public class ProyectoFinalRedes {
    
    private static VistaInicial vistaInicial = new VistaInicial();
    private static VistaComprimir vistaComprimir = new VistaComprimir();
    private static VistaDescomprimir vistaDescomprimir = new VistaDescomprimir();
    private static VistaCodificar vistaCodificar = new VistaCodificar();

    
    private static Controlador controlador = new Controlador();
    
    
    
    
    static Scanner sc = new Scanner(System.in);
    static Scanner sn = new Scanner(System.in);
    static LZW algoritmo = new LZW();
    
    
    public static void iniciarControlador(){
        controlador.setVistaIncial(vistaInicial);
        controlador.setVistaComprimir(vistaComprimir);
        controlador.setVistaDescomprimir(vistaDescomprimir);
        controlador.setVistaCodificar(vistaCodificar);
        controlador.init();
    }
    
    
    public static void main(String[] args) {
        
        iniciarControlador();
        
        vistaInicial.init();
    }
    
    public static void comprimir(){
        String texto;
        System.out.println("Ingerese el texto a comprimir:");
        texto = sn.nextLine();
        char[] cadena = texto.toCharArray();
    }
    
    public static void descomprimir(){
        String codigo;
        ArrayList<Integer> codigoViejo = new ArrayList<Integer>();
        System.out.println("ingrese el código separado por comas (ejemplo: 1,15.3)");
        codigo = sn.nextLine();
        char[] cod = codigo.toCharArray();
        for(int i=0; i<cod.length;i++){
            if(cod[i]!= 44){
                codigoViejo.add(Character.getNumericValue(cod[i]));
            }
        }
        
    }
    
}
