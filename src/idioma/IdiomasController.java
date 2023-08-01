package idioma;

import models.Idioma;
import models.Usuario;
import modulo.ModulosController;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import static java.lang.Math.floor;
import java.util.ArrayList;
import javax.swing.*;

import detallesUsuario.UsuarioDetailsController;
import usuarios.UsuariosController;

public class IdiomasController {
    IdiomasView vista;
    ArrayList<Idioma> listaIdiomas;
    ArrayList<JButton> listaBotones;
    JLabel lblcurrentUser;
    Usuario currentUser;

    public IdiomasController(Usuario usuario){
        System.out.println("> Abriendo lista de Idiomas para elegir desde el usuario " + usuario.getNombre());
        
        this.currentUser = usuario;
        vista = new IdiomasView();
        listarIdiomas();
        addBtnsIdiomas();
        vista.btnVolver.addActionListener((e) -> {
            
            UsuariosController usuarioController = new UsuariosController();
            vista.f.dispose();
            
        });
        vista.f.repaint();
        
    }
    
    //Accede a los archivos, y lista los idiomas guardados
    private void listarIdiomas(){
        listaIdiomas = new ArrayList<>();
        
        //Crear una lista de instancias idiomas
        File carpetaIdiomas = new File("Idiomas");
        
        //Recorrer los elementos dentro de la carpeta idiomas, y que solo se añadan aquellos que son directorios
        for( File x: carpetaIdiomas.listFiles() ){
            if (x.isDirectory()){
                
                listaIdiomas.add( new Idioma( x.getName(), x.getPath()+"/imagen.png" ) );
                //System.out.println(x.getName());     
                //System.out.println(""+x.getPath()+"/imagen.png");     PA DEBUG
            }
        }
        
        if (listaIdiomas.isEmpty()){ vista.lblDisculpas.setVisible(true); }
        
    }
    
    //Agregar los botones a la pantalla
    private void addBtnsIdiomas(){      
        
        //Se crean los botones de acuerdo a cada elemento de la lista
        
        //La variable i es un parametro para la ubicacion de los botones
        int i = 0;
        for (Idioma x: listaIdiomas){
            JButton boton = new JButton();
            
            //Asignar nombre e imagen de acuerdo a los datos de la lista
            boton.setText( x.getNombre() );
            boton.setIcon(new ImageIcon( x.getImagen() ));
            
            //Ubicar el boton en pantalla
            boton.setBounds( (225*i)%450+50, (int) (150*floor(i/2))+50, 175, 100);
            
            //Ubicar el texto en medio de la imagen
            boton.setIconTextGap(-105);
            
            //Darle funcionalidad al boton
            boton.addActionListener((e) -> {
                
                //Crear una pantalla de modulo
                ModulosController moduloController = new ModulosController( x.getNombre(), this.currentUser );
                //Eliminar la actual
                vista.f.dispose();
                
            });
            
            //Se añade el boton a la lista de la pantalla y a la pantalla
            vista.listaBotones.add(boton);
            vista.f.add(boton);
            //vista.f.setComponentZOrder(boton, 0);
            i += 1;
        }
        lblcurrentUser = new JLabel(this.currentUser.getNombre());
        lblcurrentUser.setBounds(400, 600, 100, 50);
        lblcurrentUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UsuarioDetailsController usuarioDetailsController = new UsuarioDetailsController(currentUser);
                vista.f.dispose();
            }
        });
        vista.f.add(lblcurrentUser);

    }
    

    
}
