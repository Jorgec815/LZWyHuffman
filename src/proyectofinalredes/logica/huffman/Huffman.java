
package proyectofinalredes.logica.huffman;

import java.util.PriorityQueue;

public class Huffman {
    
    private String tabla;
    
    public String getCodificar(String texto) {
        
        int[] tFrecu = new int[256];

        for (char c : texto.toCharArray()) {
            tFrecu[c]++;
        }

        Arbol arbolBinario = contruirArbol(tFrecu);

        System.out.println(arbolBinario);
        
        tabla = "TABLA DE CODIGOS\n";
        System.out.println("TABLA DE CODIGOS");
        tabla += "SÍMBOLO\tFRECUENCIA\tCÓDIGO\n";
        System.out.println("SÍMBOLO\tFRECUENCIA\tCÓDIGO");
        imprimir(arbolBinario, new StringBuffer());
        
        String cod = codificar(arbolBinario, texto);
        
        tabla += "\nCODIFICACION\n";
        System.out.println("\nCODIFICACION");
        tabla += cod+"\n";
        System.out.println(cod); 
        tabla += "\n\nDECODIFICACION\n";
        System.out.println("\n\nDECODIFICACION");
        tabla += decodificar(arbolBinario, cod);
        System.out.println(decodificar(arbolBinario, cod));
        return tabla;
    }

    
    
    public static Arbol contruirArbol(int[] tFrecu) {

        PriorityQueue<Arbol> colaArboles = new PriorityQueue<Arbol>();

        for (int i = 0; i < tFrecu.length; i++) {
            if (tFrecu[i] > 0) {
                colaArboles.offer(new Hoja(tFrecu[i], (char) i));
            }
        }

        while (colaArboles.size() > 1) {
            Arbol a = colaArboles.poll();
            Arbol b = colaArboles.poll();

            colaArboles.offer(new Nodo(a, b));
        }
        return colaArboles.poll();
    }

    public static String codificar(Arbol arbol, String texto) {
        assert arbol != null;

        String codificacion = "";
        for (char c : texto.toCharArray()) {
            codificacion += (encontrarCodigos(arbol, new StringBuffer(), c));
        }
        return codificacion;
    }

    public static String decodificar(Arbol arbol, String codificacion) {

        String decod = "";
        Nodo node = (Nodo) arbol;
        for (char code : codificacion.toCharArray()) {
            if (code == '0') {
                if (node.left instanceof Hoja) {
                    decod += ((Hoja) node.left).valor;
                    node = (Nodo) arbol;
                } else {
                    node = (Nodo) node.left;
                }
            } else if (code == '1') {
                if (node.right instanceof Hoja) {
                    decod += ((Hoja) node.right).valor;
                    node = (Nodo) arbol;
                } else {
                    node = (Nodo) node.right;
                }
            }
        }
        return decod;
    }

    public void imprimir(Arbol arbol, StringBuffer imp) {
        if (arbol instanceof Hoja) {
            Hoja leaf = (Hoja) arbol;
            
            tabla+=leaf.valor + "\t" + leaf.frecuencia + "\t" + imp+"\n";
            System.out.println(leaf.valor + "\t" + leaf.frecuencia + "\t\t" + imp);

        } else if (arbol instanceof Nodo) {
            Nodo node = (Nodo) arbol;

            imp.append('0');
            imprimir(node.left, imp);
            imp.deleteCharAt(imp.length() - 1);

            imp.append('1');
            imprimir(node.right, imp);
            imp.deleteCharAt(imp.length() - 1);
        }
    }

    public static String encontrarCodigos(Arbol arbol, StringBuffer cod, char x) {

        if (arbol instanceof Hoja) {
            Hoja leaf = (Hoja) arbol;

            if (leaf.valor == x) {
                return cod.toString();
            }

        } else if (arbol instanceof Nodo) {
            Nodo node = (Nodo) arbol;

            cod.append('0');
            String left = encontrarCodigos(node.left, cod, x);
            cod.deleteCharAt(cod.length() - 1);

            cod.append('1');
            String right = encontrarCodigos(node.right, cod, x);
            cod.deleteCharAt(cod.length() - 1);

            if (left == null) {
                return right;
            } else {
                return left;
            }
        }
        return null;
    }

}
