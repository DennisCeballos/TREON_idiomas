package usuarios;

import usuarioNuevo.NewUsuarioController;
import idioma.IdiomasController;
import models.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.JSONReader;

import javax.swing.*;
import java.util.ArrayList;
import static java.lang.Math.floor;

public class UsuariosController {
    UsuariosView usuariosView;
    ArrayList<Usuario> listaUsuarios;
    ArrayList<JButton> listaBotones;

    public UsuariosController(){
        System.out.println("> Abriendo lista de usuarios a elegir");
        usuariosView = new UsuariosView();
        listarUsuarios();
        addBtnsUsuarios();
        
        //Darle funcionalidad al boton de addUsuario
        //Darle funcionalidad al botonAddUsuario
        usuariosView.btnAddUsuario.addActionListener( e-> {
            NewUsuarioController newUsuarioController = new NewUsuarioController();
            usuariosView.f.dispose();
        });
    }

    //Lista los usuarios registrados, leyendo del archivo
    private void listarUsuarios(){
        listaUsuarios = new ArrayList<>();
        JSONReader jsonReader = new JSONReader();
        JSONArray jsonArray = jsonReader.getJSONbyPath("Usuarios/usuarios.json");
        //System.out.println(jsonArray); //Debug
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Usuario usuario = new Usuario((Long) jsonObject.get("id"), (String) jsonObject.get("nombre"));
            listaUsuarios.add(usuario);
        }
    }

    //Agrega un boton por cada usuario
    private void addBtnsUsuarios(){

        int i = 0;
        for (Usuario x: listaUsuarios){
            JButton boton = new JButton();
            boton.setText( x.getNombre() );
            boton.setBounds( (225*i)%450+50, (int) (150*floor(i/2))+50, 175, 100);
            boton.setIconTextGap(-105);
            boton.addActionListener((e) -> {
                IdiomasController idiomasController = new IdiomasController(x);
                usuariosView.f.dispose();
            });

            usuariosView.f.add(boton);
            i += 1;
        }

    }
    
}
