package sesion;

import java.awt.Color;
import javax.swing.JButton;
import models.Constantes;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SesionView {
    JFrame f;
    JPanel p1, p2, p3, p4;
    JButton btnEvaluar;
    JLabel lblListo;
    JLabel lblProgreso;
    
    public SesionView(){
        f = new JFrame("Sesion de ejercicios");
        
        lblProgreso = new JLabel("Progreso:");
        lblProgreso.setBounds(50,30,200,50);
        lblProgreso.setVisible(true);
        f.add(lblProgreso);
        
        lblListo = new JLabel("¡Revisa tu puntaje a contrinuacion!");
        lblListo.setBounds(150, 350, 200, 40);
        lblListo.setVisible(false);
        f.add(lblListo);
        
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(20, 80, 460, 550);
        p1.setVisible(true);
        p1.setBackground(Color.getHSBColor(0, 240, 40)); //Aplicar una lambda aca, Color.getHSBColor( Color.HSBtoRGB() )
        f.add(p1);
        
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(20, 80, 460, 550);
        p2.setVisible(false);
        p2.setBackground(Color.getHSBColor(40, 140, 30)); //Aplicar una lambda aca, Color.getHSBColor( Color.HSBtoRGB() )
        f.add(p2);
        
        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(20, 80, 460, 550);
        p3.setVisible(false);
        p3.setBackground(Color.getHSBColor(40, 40, 40)); //Aplicar una lambda aca, Color.getHSBColor( Color.HSBtoRGB() )
        f.add(p3);
        
        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBounds(20, 80, 460, 550);
        p4.setVisible(false);
        p4.setBackground(Color.getHSBColor(0, 240, 40)); //Aplicar una lambda aca, Color.getHSBColor( Color.HSBtoRGB() )
        f.add(p4);
        
        btnEvaluar = new JButton("Comprobar");
        btnEvaluar.setBounds(340, 650, 150, 50);
        f.add(btnEvaluar);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setLocation( Constantes.POSICION_PANTALLA );
        f.setDefaultCloseOperation(3);
    }
    
}
