
package proyectofinalredes.logica;

import java.util.ArrayList;
import java.util.Arrays;

public class LZW {
    
     //Variables para la compresión
    char[] texto;
    String w;
    String k;
    String wk;
    String codigoArchivo;
    String diccionarioArchivo;
    
    //Variables para la descompresión
    String[] codigo;
    
    ArrayList<String> diccionarioDes = new ArrayList<String>();
    
    int codViejo;
    int codNuevo;
    String cadena;;
    String caracter;
    String salida;
    //Diccionario de compresión
    ArrayList<String> diccionario = new ArrayList<String>();
    //compreión final
    ArrayList<Integer> salidaCompresion = new ArrayList<Integer>();
    //Descompresión final
    ArrayList<String> salidaDescompresión = new ArrayList<String>();
    
    public LZW(){
        codigoArchivo = "";
        diccionarioArchivo ="";
    }
    
    //Métodos para la compresión del texto
    //Pasos para generar la compresión
    public void comprimir(String cadena){
        texto = cadena.toCharArray();
        generarDiccionarioBase();
        pasarDiccionarioBase();
        comprimirPrincipal();
        imprimir();
        pasarCodigo();
    }
    
    
    //Genera el diccionario base para poder empezar la compresión
    public void generarDiccionarioBase(){
        for(int i=0; i<texto.length;i++){
            if(texto[i] == ' '){
                if(!verificarExistencia("(space)")){
                    añadirElementoDiccionario("(space)");
                }
            }else if(texto[i] == '\n'){
                if(!verificarExistencia("(sl)")){
                    añadirElementoDiccionario("(sl)");
                }
            }else{
                if(!verificarExistencia(Character.toString(texto[i]))){
                    añadirElementoDiccionario(Character.toString(texto[i]));
                }
            }
        }
    }
    
    
    //añade un elemento al diccionario
    public void añadirElementoDiccionario(String cadena){
        diccionario.add(cadena);
    }
    
    //añade un elemento a la salida para después imprimirla
    public void añadirSalida(){
        for(int i=0; i<diccionario.size(); i++){
            if(diccionario.get(i).equals(w)){
                salidaCompresion.add(i);
            }
        }
    }
    
    
    //Verifica la existencia de un elemento dentro del diccionario
    public boolean verificarExistencia(String cadena){
        for (int i = 0; i < diccionario.size(); i++) {
            if(diccionario.get(i).equals(cadena)){
                return true;
            }
        }
        return false;
    }
    
    //Compresión general de la cadena de texto
    public void comprimirPrincipal(){
        int i = 0;
        w = null;
        while(i != texto.length){
            if(texto[i] == ' '){
                k = "(space)";
            }else if(texto[i] == '\n'){
                k = "(sl)";
            }else{
                k = Character.toString(texto[i]);
            }
            if(w == null){
                wk = k;
            }else{
                wk = w+k;
            }
            if(verificarExistencia(wk)){
                w = wk;
            }else{
                añadirSalida();
                añadirElementoDiccionario(wk);
                w = k;
            }
            i++;
        }
        añadirSalida();
    }
    
    //imprime la salida
    public void imprimir(){
        System.out.println(salidaCompresion);
        System.out.println("\n");
        System.out.println(diccionario);
    }
    
    public void pasarCodigo(){
        
        for (int i =0;i<salidaCompresion.size();i++){
            if(i==salidaCompresion.size()-1){
                codigoArchivo = codigoArchivo+salidaCompresion.get(i);
            }else{
                codigoArchivo = codigoArchivo+salidaCompresion.get(i)+",";
            }
        }
    }
    
    public void pasarDiccionarioBase(){
        for(int i=0;i<diccionario.size();i++){
            if(i==diccionario.size()-1){
                diccionarioArchivo = diccionarioArchivo+diccionario.get(i);
            }else{
                diccionarioArchivo = diccionarioArchivo+diccionario.get(i)+",";
            }
        }
    }

    public String getCodigoArchivo() {
        return codigoArchivo;
    }

    public String getDiccionarioArchivo() {
        return diccionarioArchivo;
    }
    
    
    //<------------------------------------------------------------------------------------------------------>
    
    //Métodos para la descompresión
    
    public String descomprimir(ArrayList<String[]> datos){
        for(int i = 0; i<datos.get(1).length;i++){
            if(datos.get(1)[i].equals("(space)")){
                diccionarioDes.add(" ");
            }else{
                diccionarioDes.add(datos.get(1)[i]);
            }
            
        }
        codigo = datos.get(0);
        codViejo = Integer.parseInt(codigo[0]);
        caracter = traducir(codViejo);
        salida = caracter;
        int i = 1;
        while (i!= codigo.length){
            codNuevo = Integer.parseInt(codigo[i]);
            if(codNuevo>=diccionarioDes.size()){
                cadena = traducir(codViejo);
                cadena = cadena+caracter;
            }else{
                cadena = traducir(codNuevo);
                
            }
            salida = salida+cadena;
            caracter = String.valueOf(cadena.toCharArray()[0]);
            diccionarioDes.add(traducir(codViejo)+caracter);
            codViejo=codNuevo;
            i++;
        }
        return salida;
    }
    
    public String traducir(int codigoTr){
        for(int i=0; i<diccionarioDes.size();i++){
            if(i == codigoTr){
                return diccionarioDes.get(i);
            }
        }
        return null;
    }
    
    
}
