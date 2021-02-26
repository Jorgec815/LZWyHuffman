
package proyectofinalredes.logica.huffman;

class Nodo extends Arbol {
    public final Arbol left, right; 
 
    public Nodo(Arbol i, Arbol d) {
        super(i.frecuencia + d.frecuencia);
        left = i;
        right = d;
    }
}