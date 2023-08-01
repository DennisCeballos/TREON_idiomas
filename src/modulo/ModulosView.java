package modulo;

import models.Constantes;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ModulosView {
    JFrame f;
    JButton btnVolver;
    ArrayList<JButton> listaModulos;
    
    public ModulosView(){
        f = new JFrame("Seleccion de Modulo");
        listaModulos = new ArrayList<>();
        
        btnVolver = new JButton("Regresar");
        btnVolver.setBounds(25, 600, 100, 50);
        f.add(btnVolver);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setLocation( Constantes.POSICION_PANTALLA );
        f.setDefaultCloseOperation(3);
    }
    
}
