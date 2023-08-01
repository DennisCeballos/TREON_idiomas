package usuarios;

import models.Constantes;
import javax.swing.*;

public class UsuariosView {
    JFrame f;
    JButton btnPaseIdioma, btnAddUsuario;

    public UsuariosView(){
        f = new JFrame("Seleccion de Usuario");

        btnAddUsuario = new JButton();
        btnAddUsuario.setBounds(280, 600, 150, 50);
        btnAddUsuario.setText("Añadir usuario");
        f.add(btnAddUsuario);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setLocation( Constantes.POSICION_PANTALLA );
        f.setDefaultCloseOperation(3);
    }

}
