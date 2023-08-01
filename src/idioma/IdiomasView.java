package idioma;

import models.Constantes;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IdiomasView {
    
    JFrame f;
    JButton btnVolver;
    JLabel lblDisculpas;
    ArrayList<JButton> listaBotones;
    
    public IdiomasView(){
        //Inicializar las variables necesarias
        listaBotones = new ArrayList<>();
        
        f = new JFrame("Seleccion de Idioma");
        
        btnVolver = new JButton("Regresar");
        btnVolver.setBounds(25, 600, 100, 50);
        f.add(btnVolver);
        
        //500x750
        lblDisculpas = new JLabel("Perdona, parece que aun  no tienes idiomas disponibles :(");
        lblDisculpas.setBounds(0, 200, 500, 50);
        lblDisculpas.setHorizontalAlignment(0); //Alinear texto al centro
        lblDisculpas.setVisible(false);
        f.add(lblDisculpas);
        
        
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setLocation( Constantes.POSICION_PANTALLA );
        f.setDefaultCloseOperation(3);
    }
    
}
