/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalredes.presentacion.plantilla;

import java.awt.Color;
import javax.swing.JFrame;

public abstract class PlantillaPrincipal extends JFrame{
    
    public abstract void addComponentes();
    
    public abstract void setPropiedadesComponentes();
    
    
    //constructor donde está la imagen del escudo el colegio para que se muestre en todas las ventanas además de intanciar el panel en el que
    //se muestra la imagen del escudo del colegio
    public PlantillaPrincipal(){
    }
    
    
    /*
    Aquí se le da un tamaño al escudo del colegio y se agrega a la ventana.
    También se llaman los métodos abtractos que utilizará cada ventana para agregar sus componentes
    además de configurarlos
    */
    
    public void init() {
        setPropiedades();
        setPropiedadesComponentes();
        addComponentes();
    }
    
    /*
    Aquí se configurar las propiedades generales de la plantilla para que todas las ventanas decendientes sea iguales
    con respecto al tamaño, ubicación y color
    */
    public void setPropiedades(){
        setLocation(450, 75);
        //El layout es para configurar de manera manual cada componente de la ventana 
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(1024, 768);
        setResizable(false);
        setVisible(true);
    }
    
}
