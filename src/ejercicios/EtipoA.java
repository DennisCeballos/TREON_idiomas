package ejercicios;

import java.awt.Color;
import javax.swing.JPanel;
import models.Ejercicio;       //SE IMPORTA LOS EJERCICIOS
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class EtipoA extends EjercicioController{
    
    public EtipoA(Ejercicio data){
        super(data);
        System.out.println(" - Preparandolo en tipo >A<"); //Debug
        this.rptaIn = "";
    } 
    
    //Recibe un JPanel para editarlo, y hacerlo funcional
    public void recibirCambiar(JPanel panel){
        
        //Para crear el ejercicio de tipo A es necesario hacer primero
        //las siguientes funciones de la clase padre
        elegirIdioma();
        elegirOpcionClave();
        
        //Agregar los elementos necesarios respectivos
        JLabel lblEnunciado = new JLabel("¿Como se traduce *" + opcionClave + "* ?" );
        lblEnunciado.setBounds(50, 50, 200, 20);
        panel.add(lblEnunciado);
        
        //Se crea el radio button con parametro:
        //                                  de la lista opciones, el primer elemento, en el idioma opuesto al elegido
        JRadioButton rb1 = new JRadioButton(opciones.get(0)[1-idioma]);
        rb1 = configurarRadioBoton(rb1, 0, opciones.get(0)[1-idioma]);
        panel.add(rb1);
        
        JRadioButton rb2 = new JRadioButton(opciones.get(1)[1-idioma]);
        rb2 = configurarRadioBoton(rb2, 1, opciones.get(1)[1-idioma]);
        panel.add(rb2);
        
        JRadioButton rb3 = new JRadioButton(opciones.get(2)[1-idioma]);
        rb3 = configurarRadioBoton(rb3, 2, opciones.get(2)[1-idioma]);
        panel.add(rb3);
        
        //JRadioButton rb4 = new JRadioButton(opciones.get(3)[idioma]);
        //rb4 = configurarRadioBoton(rb4, 3);
        //panel.add(rb4);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        //bg.add(rb4);
        
    }
    
    //Controla las configuraciones necesrias de cada RadioButton
    //Recibe el radioButton, la posicion del mismo y la opcion de encima
    private JRadioButton configurarRadioBoton(JRadioButton rb, int pos, String rpta){
        
        //Cada que se aprete el boton, se asigna ese nombre a la rpta
        rb.addActionListener((e) -> {    
            this.rptaIn = rpta;
            //System.out.println(" - Se elige la opcion " + rpta );    //Debug
        });
        
        //Le pone backgroundColor
        rb.setBackground(Color.CYAN);
        
        //Funcion de posicion Y: a+(pos*b)
        //      a:posicion del primer boton 0;   b:separacion entre botones
        rb.setBounds(80, 150+(pos*80), 150, 20);
        
        return rb;
    }
}
