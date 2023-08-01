package detallesUsuario;

import models.Constantes;
import models.Usuario;
import javax.swing.*;

public class UsuarioDetailsView {
    JFrame f;
    JButton btnPaseIdioma;
    JLabel lblTitle;
    JLabel lblNombre;
    JTextField txfNombre;
    JButton btnEditar;
    JButton btnRegresar;
    JButton btnEliminar;
    JTextArea taRecords;

    public UsuarioDetailsView(Usuario currentUser){

        f = new JFrame("Detalles de Usuario");
        
        lblTitle = new JLabel("Usuario");
        lblTitle.setBounds(30, 20, 100, 30);
        
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(30, 60, 100, 30);
        
        txfNombre = new JTextField(currentUser.getNombre());
        txfNombre.setBounds(30, 100, 200, 40);
        
        btnEditar= new JButton("Editar");
        btnEditar.setBounds(250, 100, 200, 40);
        
        taRecords = new JTextArea();
        taRecords.setBounds(30, 260, 450, 300);
        taRecords.setEditable(false);
        
        btnRegresar= new JButton("Regresar");
        btnRegresar.setBounds(250, 600, 200, 40);
        
        btnEliminar= new JButton("Eliminar");
        btnEliminar.setBounds(250, 150, 200, 40);
        
        
        f.add(lblTitle);
        f.add(lblNombre);
        f.add(txfNombre);
        f.add(btnEditar);
        f.add(btnRegresar);
        f.add(btnEliminar);
        f.add(taRecords);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setSize( Constantes.SIZE_PANTALLA[0], Constantes.SIZE_PANTALLA[1] );
        f.setLocation( Constantes.POSICION_PANTALLA );
        f.setDefaultCloseOperation(3);
    }
}
