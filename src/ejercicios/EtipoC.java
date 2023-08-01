package ejercicios;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import models.Ejercicio;

public class EtipoC extends EjercicioController{
    
    public EtipoC(Ejercicio data){
        super(data);
        System.out.println(" - Preparandolo en tipo >C<");
    }
    
    
    public void recibirCambiar(JPanel panel){
        
        //Para crear el ejercicio de tipo A es necesario hacer primero
        //las siguientes funciones de la clase padre
        elegirIdioma();
        elegirOpcionClave();
        
        JLabel lblEnunciado = new JLabel("¿Como se traduce *" + opcionClave + "* ?" );
        lblEnunciado.setBounds(50, 200, 200, 20);
        panel.add(lblEnunciado);
        
        //Se crean y agregan los elementos necesarios
        JTextField tf = new JTextField();
        tf.setToolTipText("Ingresa solo una palabra con primera mayuscula");
        //Utilizado para rebiri cada que se hace un cambio
        tf.addCaretListener((e) -> {  
            //System.out.println(" - Esta escrito en el TextField " + tf.getText());        //Debug
            this.rptaIn = tf.getText();
        });
        
        tf.setBounds(80, 250, 300, 50);
        panel.add(tf);
        
    }
    
}
