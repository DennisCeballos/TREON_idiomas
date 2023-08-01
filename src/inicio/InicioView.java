package inicio;

import javax.swing.ImageIcon;
import models.Constantes;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InicioView {
    //Iniciar variables de pantalla
    JFrame f;
    JButton btnPaseUsuario;
    JLabel lblLogo;
    JLabel lblPractica;
    
    public InicioView(){
        //Configurar elementos de la vista
        f = new JFrame("BIENVENIDO A TREON");
        
        lblLogo = new JLabel();
        lblLogo.setIcon( new ImageIcon("Idiomas/logo.png"));
        lblLogo.setBounds(120, 100, 260, 300);
        lblLogo.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 30));
        lblLogo.setText("TREON");
        lblLogo.setHorizontalTextPosition(0);
        lblLogo.setVerticalTextPosition(3);
        f.add(lblLogo);
        
        lblPractica = new JLabel("Practica Idiomas");
        lblPractica.setBounds(200, 380, 260, 50);
        f.add(lblPractica);
        
        btnPaseUsuario = new JButton("Ingresar");
        btnPaseUsuario.setBounds(150, 500, 200, 50);
        f.add(btnPaseUsuario);
        
        
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setBackground(new java.awt.Color(168, 230, 255));
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setLocation( Constantes.POSICION_PANTALLA );
        f.setDefaultCloseOperation(3);
    }
    
}
