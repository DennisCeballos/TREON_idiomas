package usuarioNuevo;

import models.Constantes;
import javax.swing.*;

public class NewUsuarioView {
    JFrame f;
    JLabel lblTitle;
    JLabel lblNombre;
    JTextField txfNombre;
    JButton btnAgregar;
    JButton btnRegresar;
    

    public NewUsuarioView(){
        f = new JFrame("Nuevo Usuario");
        
        lblTitle = new JLabel("Añadir usuario");
        lblTitle.setBounds(30, 20, 100, 30);
        
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(30, 100, 100, 30);
        
        txfNombre = new JTextField();
        txfNombre.setBounds(30, 150, 200, 40);
        
        btnAgregar= new JButton("Agregar");
        btnAgregar.setBounds(200, 300, 200, 40);
        
        btnRegresar= new JButton("Regresar");
        btnRegresar.setBounds(200, 400, 200, 40);

        f.add(lblTitle);
        f.add(lblNombre);
        f.add(txfNombre);
        f.add(btnAgregar);
        f.add(btnRegresar);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setLocation( Constantes.POSICION_PANTALLA );
        f.setDefaultCloseOperation(3);
    }
}
