
package proyectofinalredes.logica.huffman;

abstract class Arbol implements Comparable<Arbol> {
    public final int frecuencia;
   
    public Arbol(int freq) { 
    	frecuencia = freq; 
    }
    
    public int compareTo(Arbol arbol) {
        return frecuencia - arbol.frecuencia;
    }
}