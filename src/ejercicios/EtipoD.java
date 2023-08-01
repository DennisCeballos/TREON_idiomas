package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Ejercicio;

public class EtipoD extends EjercicioController{
    
    ArrayList<String> partes;
    
    int sumaRpta;
    int posicion;
    int lineaRpta;
    ArrayList<String> listaRpta;
    
    public EtipoD(Ejercicio data){
        super(data);
        System.out.println(" - Preparandolo en tipo >D<");
        
        partes = new ArrayList<>();
        listaRpta = new ArrayList<>();
    }
    
    
    @Override
    public void recibirCambiar(JPanel panel){
        
        //Para crear el ejercicio de tipo A es necesario hacer primero
        //las siguientes funciones de la clase padre
        elegirIdioma();
        elegirOpcionClave();
        
        //Agregar los elementos necesarios
        JLabel lblEnunciado = new JLabel("Ordena la siguiente oracion:");
        lblEnunciado.setBounds( 50, 50, 200, 20 );
        panel.add(lblEnunciado);
        
        JLabel lblFrase = new JLabel();
        lblFrase.setBounds( 0, 120, panel.getWidth(), 20 );
        lblFrase.setHorizontalAlignment(0);
        lblFrase.setText( this.opcionClave );
        panel.add(lblFrase);
        
        //Crear las palabras que se mostraran en botones, obtenido de la opcioin clave en el idioma opuesto
        partes.addAll(Arrays.asList( this.data.getOpciones().get( this.idOpcionClave )[1-idioma].split(" ") ));
        Collections.shuffle(partes);
        
        //Crear los botones para formar la frase
        int linea = 0;
        int suma = 0;
        for (String x: partes){
            
            //Se crea un boton por cada frase
            JButton nb = new JButton();
            nb.setText(x);
            nb.setLocation(50+suma, 280+20*linea);
            nb.setSize(nb.getMinimumSize());
            suma = suma + nb.getWidth();
            
            //Darle funcionalidad al boton
            nb.addActionListener((e) -> {
                
                //Cada que se aprete el boton:
                //Se ubica este mismo boton en la ubc necesaria y se quita su actionListener
                nb.setLocation(50+this.sumaRpta, 200+20*this.lineaRpta);
                this.sumaRpta += nb.getWidth();
                this.rptaIn += " " + nb.getText();
                nb.removeActionListener(nb.getActionListeners()[0]);
                
            });
            
            panel.add(nb);
        }
        panel.repaint();
        
    }
    
}
