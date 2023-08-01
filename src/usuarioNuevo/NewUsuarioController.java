package usuarioNuevo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import models.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import usuarios.UsuariosController;
import utils.JSONReader;

public class NewUsuarioController {
    NewUsuarioView vista;
    ArrayList<Usuario> listaUsuarios;
    
    public NewUsuarioController(){
        vista = new NewUsuarioView();
        
        listaUsuarios = new ArrayList<>();
        
        //Darle funcionalidad al boton de regresar
        vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuariosController usuarioController = new UsuariosController();
                vista.f.dispose();
            }
        });
        
        
        //Darle funcionalidad al boton de agregar usuario
        this.vista.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONReader jsonReader = new JSONReader();
                JSONArray jsonArray = jsonReader.getJSONbyPath("Usuarios/usuarios.json");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    Usuario usuario = new Usuario((Long) jsonObject.get("id"),(String) jsonObject.get("nombre"), (JSONArray) jsonObject.get("puntajes"));
                    listaUsuarios.add(usuario);
                }
                Usuario usuario = new Usuario((long) (listaUsuarios.size() + 1), vista.txfNombre.getText().trim());
                listaUsuarios.add(usuario);
                String newFileContent = "";
                for (int i = 0; i < listaUsuarios.size(); i++) {
                    boolean isLastItem = i == (listaUsuarios.size() - 1);
                    if (i == 0) {
                        newFileContent += "[";
                    }

                    if (listaUsuarios.get(i).getPuntajes() != null) {
                        newFileContent += "{" +
                                "\"id\":" +listaUsuarios.get(i).getId() + "," +
                                "\"nombre\":" + "\"" +listaUsuarios.get(i).getNombre() + "\"" + ',' +
                                "\"puntajes\":"  + listaUsuarios.get(i).getPuntajes()
                        ;
                    } else {
                        newFileContent += "{" +
                                "\"id\":" +listaUsuarios.get(i).getId() + "," +
                                "\"nombre\":" + "\"" +listaUsuarios.get(i).getNombre() + "\"" + ',' +
                                "\"puntajes\":"  + "[]";
                    }

                    if (isLastItem) {
                        newFileContent += "}]";
                    } else {
                        newFileContent += "},";
                    }
                }
                String listaUsuariosString = newFileContent.toString();

                File usuarioFile = new File("Usuarios/usuarios.json");
                try {
                    FileOutputStream usuarioFileStream = new FileOutputStream(usuarioFile, false);
                    usuarioFileStream.write(listaUsuariosString.getBytes());
                    usuarioFileStream.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                UsuariosController usuarioController = new UsuariosController();
                vista.f.dispose();
            }
        });
        
        
    }
    
}
