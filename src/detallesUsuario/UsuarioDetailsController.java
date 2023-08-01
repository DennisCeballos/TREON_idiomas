package detallesUsuario;

import idioma.IdiomasController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import usuarios.UsuariosController;
import utils.JSONReader;

public class UsuarioDetailsController {
    UsuarioDetailsView vista;
    ArrayList<Usuario> listaUsuarios;
    
    public UsuarioDetailsController(Usuario currentUser){
        vista = new UsuarioDetailsView(currentUser);
        
        //Inicializar la lista de todos los usuarios
        listaUsuarios = new ArrayList<>();
        JSONReader jsonReader = new JSONReader();
        JSONArray jsonArray = jsonReader.getJSONbyPath("Usuarios/usuarios.json");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Usuario usuario = new Usuario((Long) jsonObject.get("id"),(String) jsonObject.get("nombre"), (JSONArray) jsonObject.get("puntajes"));
            listaUsuarios.add(usuario);
        }
        
        
        //Crear el string con los records
        String records = "";
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (currentUser.getId().equals(listaUsuarios.get(i).getId()))  {
                for (int j = 0; j < listaUsuarios.get(i).getPuntajes().size(); j++) {
                    records += "Puntaje no " + (j + 1) + ": " + listaUsuarios.get(i).getPuntajes().get(j) + "\n";
                }
            }
        }
        vista.taRecords.setText(records);
        
        //Funcionalidad al boton Editar
        vista.btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Usuario usuarioEncontrado = listaUsuarios.get(Math.toIntExact(currentUser.getId() - 1));
                if (usuarioEncontrado == null) {
                    JOptionPane.showMessageDialog(vista.f, "Usuario no encontrado");
                } else if (currentUser.getNombre().equals(usuarioEncontrado.getNombre())){
                    String newFileContent = "";
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        boolean isLastItem = i == (listaUsuarios.size() - 1);
                        if (i == 0) {
                            newFileContent += "[";
                        }

                        if (usuarioEncontrado.getId().equals(listaUsuarios.get(i).getId())){
                            newFileContent += "{" +
                                    "\"id\":" +listaUsuarios.get(i).getId() + "," +
                                    "\"nombre\":" + "\"" + vista.txfNombre.getText().trim() + "\"" + "," +
                                    "\"puntajes\":" + listaUsuarios.get(i).getPuntajes();
                        } else {
                            newFileContent += "{" +
                                    "\"id\":" +listaUsuarios.get(i).getId() + "," +
                                    "\"nombre\":" + "\"" +listaUsuarios.get(i).getNombre() + "\"" + "," +
                                    "\"puntajes\":" + listaUsuarios.get(i).getPuntajes();
                        }

                        if (isLastItem) {
                            newFileContent += "}]";
                        } else {
                            newFileContent += "},";
                        }
                    }
                    System.out.println(newFileContent);
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
                    currentUser.setNombre(vista.txfNombre.getText().trim());
                }
            }
        });
        
        //Funcionalidad al boton Regresar
        vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdiomasController idiomasController = new IdiomasController(currentUser);
                vista.f.dispose();
            }
        });
        
        //Funcionalidad al boton Eliminar
        vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Usuario usuarioEncontrado = listaUsuarios.get(Math.toIntExact(currentUser.getId() - 1));
                if (usuarioEncontrado == null) {
                    JOptionPane.showMessageDialog(vista.f, "Usuario no encontrado");
                } else if (currentUser.getNombre().equals(usuarioEncontrado.getNombre())){
                    String newFileContent = "";
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        boolean isLastItem = i == (listaUsuarios.size() - 1);
                        if (i == 0) {
                            newFileContent += "[";
                        }

                        if (usuarioEncontrado.getId().equals(listaUsuarios.get(i).getId())){
                            newFileContent += "";

                        } else {
                            newFileContent += "{" +
                                    "\"id\":" +listaUsuarios.get(i).getId() + "," +
                                    "\"nombre\":" + "\"" +listaUsuarios.get(i).getNombre() + "\"" + "," +
                                    "\"puntajes\":" +listaUsuarios.get(i).getPuntajes() ;
                            ;
                        }

                        if (isLastItem) {
                            System.out.println(newFileContent);
                            if (newFileContent.substring(newFileContent.length() - 1).equals(",")) {
                                System.out.println("Last item has comma");
                                newFileContent = newFileContent.substring(0, newFileContent.length() - 1);
                                newFileContent += "]";
                            } else {
                                newFileContent += "}]";
                            }
                        } else {
                            if (usuarioEncontrado.getId().equals(listaUsuarios.get(i).getId())) {
                                newFileContent += "";
                            } else {
                                newFileContent += "},";
                            }
                        }
                    }
                    System.out.println(newFileContent);

                     String listaUsuariosString = newFileContent.toString();
                    JOptionPane.showMessageDialog(vista.f, "Usuario eliminado");

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
                    UsuariosController usuariosController = new UsuariosController();
                    vista.f.dispose();
                }
            }
        });

        
        
    }
    
}
