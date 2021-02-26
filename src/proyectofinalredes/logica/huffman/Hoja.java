
package proyectofinalredes.logica.huffman;
class Hoja extends Arbol {
    public final char valor; 
 
    public Hoja(int frecuencia, char val) {
        super(frecuencia);
        valor = val;
    }
}