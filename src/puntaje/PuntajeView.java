package puntaje;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import models.Constantes;

public class PuntajeView {
    
    JFrame f;
    JButton btnVolver;
    JLabel lblFelicidades, lblFinSesion, lblResultados, lblDenuevo;
    
    public PuntajeView(){
        f = new JFrame("Puntaje de sesion");
        
        lblFelicidades = new JLabel("-_- FELICIDADES -_-");
        lblFelicidades.setBounds(0, 200, 515, 20);
        lblFelicidades.setHorizontalAlignment(0);
        f.add(lblFelicidades);
        
        lblFinSesion = new JLabel("Acabaste la sesion");
        lblFinSesion.setBounds(0, 220, 515, 20);
        lblFinSesion.setHorizontalAlignment(0);
        f.add(lblFinSesion);
        
        lblResultados = new JLabel();
        lblResultados.setBounds(0, 300, 515, 20);
        lblResultados.setHorizontalAlignment(0);
        lblResultados.setText("Conseguiste ____pts en la sesion ____ del idioma ___");
        f.add(lblResultados);
        
        lblDenuevo = new JLabel();
        lblDenuevo.setBounds(0, 350, 515, 20);
        lblDenuevo.setHorizontalAlignment(0);
        lblDenuevo.setText("Puedes volver a intentarlo cuando quieras");
        f.add(lblDenuevo);
        
        btnVolver = new JButton("Nueva Sesion");
        btnVolver.setBounds(25, 600, 250, 50);
        f.add(btnVolver);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setLocation( Constantes.POSICION_PANTALLA );
        f.setDefaultCloseOperation(3);
    }
    
}
