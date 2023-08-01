package sesion;

import ejercicios.*;
import models.Ejercicio;
import models.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.JSONReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;

import puntaje.PuntajeController;

public class SesionController {
    SesionView vista;
    String idioma;
    String modulo;
    int progreso;
    ArrayList<JPanel> listaPaneles;
    Stack<EjercicioController> listaControllers;
    Usuario currentUser;
    ArrayList<Usuario> listaUsuarios;

    //Constructor que recibe el idioma y modulo del que viene
    public SesionController(String idiom, String modul, Usuario usuario){
        System.out.println("> Abriendo sesion del modulo " + modul + " del idioma " + idiom);
        
        //Iniciar la lista de Usuarios
        listaUsuarios = new ArrayList<>();
        JSONReader jsonReader = new JSONReader();
        JSONArray jsonArray = jsonReader.getJSONbyPath("Usuarios/usuarios.json");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Usuario usuariotoAddList = new Usuario((Long) jsonObject.get("id"),(String) jsonObject.get("nombre"), (JSONArray) jsonObject.get("puntajes"));
            listaUsuarios.add(usuariotoAddList);
        }
        
        this.currentUser = usuario;
        idioma = idiom;
        modulo = modul;
        
        vista = new SesionView();
        listaControllers = new Stack<>();
        listaPaneles = new ArrayList<>();
        listaPaneles.add( vista.p4 );
        listaPaneles.add( vista.p3 );
        listaPaneles.add( vista.p2 );
        listaPaneles.add( vista.p1 );
        
        //Agregar la funcionalidad del botonEvaluar
        vista.btnEvaluar.addActionListener((e) -> {
            
            //Si el stack aun tiene elementos
            if ( !listaControllers.empty() ){

                //Agarra el ultimo elemento de la pila (eliminandolo) y lo manda calificarse,
                //al mismo tiempo setea el texto de progreso
                actualizarProgreso( listaControllers.pop().calificarEjercicio() ) ;

                //Cambia al panel siguiente
                cambiarPanel( listaControllers.size()-1 );
                vista.f.repaint();
            
            //Si ya no hay elementos
            } else {
                // Que se guarde en el usuario actual
                Usuario usuarioEncontrado = listaUsuarios.get(Math.toIntExact(currentUser.getId() - 1));

                if (currentUser.getNombre().equals(usuarioEncontrado.getNombre())) {
                    String newFileContent = "";
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        JSONArray jsonArray1 = new JSONArray();
                        for (int j = 0; j < listaUsuarios.get(i).getPuntajes().size(); j++) {
                            jsonArray1.add(listaUsuarios.get(i).getPuntajes().get(j));
                        }
                        jsonArray1.add(this.progreso);
                        boolean isLastItem = i == (listaUsuarios.size() - 1);
                        if (i == 0) {
                            newFileContent += "[";
                        }

                        if (usuarioEncontrado.getId().equals(listaUsuarios.get(i).getId())){
                            newFileContent += "{" +
                                    "\"id\":" +listaUsuarios.get(i).getId() + "," +
                                    "\"nombre\":" + "\"" + listaUsuarios.get(i).getNombre() + "\"" + "," +
                                    "\"puntajes\":" + jsonArray1;
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
                }

                //Que se cree la pantalla de puntaje
                PuntajeController puntajeController = new PuntajeController( this.progreso, this.idioma, this.modulo, this.currentUser);
                vista.f.dispose();
            }
            
        });
        

        //Definir la direccion donde extraer ejercicios
        String direccion = "Idiomas/"+idioma+"/"+modulo+"/ejercicios.json";

        //Variables para la creacion de ejercicios
        Ejercicio objPruebas;
        String typo;
        Random ran = new Random();
        for (int i = 0; i <= 3; i++) {
            
            //Se extrae un objeto ejercicio aleatorio de la direccion dada
            objPruebas = jsonReader.getEjercicioAleatorio(direccion);

            //En la variable typo se almacena temporalmente un tipoEjercicio que soporte el objPruebas
            typo = objPruebas.getTipo().get( ran.nextInt( objPruebas.getTipo().size() ) );

            //Se crea un controlador de acuerdo al tipo
            switch (typo) {
                case "A":
                    {
                        EtipoA controladorEj = new EtipoA(objPruebas);
                        listaControllers.add(controladorEj);
                        controladorEj.recibirCambiar( listaPaneles.get(i) );
                        break;
                    }
                case "B":
                    {
                        EtipoB controladorEj = new EtipoB(objPruebas);
                        listaControllers.add(controladorEj);
                        controladorEj.recibirCambiar( listaPaneles.get(i) );
                        break;
                    }
                case "C":
                    {
                        EtipoC controladorEj = new EtipoC(objPruebas);
                        listaControllers.add(controladorEj);
                        controladorEj.recibirCambiar( listaPaneles.get(i) );
                        break;
                    }
                case "D":
                    {
                        EtipoD controladorEj = new EtipoD(objPruebas);
                        listaControllers.add(controladorEj);
                        controladorEj.recibirCambiar( listaPaneles.get(i) );
                        break;
                    }
                default:
                    System.out.println("Hubo un error al verificar el tipo de ejercicio");
                    break;
            }
            //System.out.println("Se agrego un ejercicio a la lista");  //Debug
        }
        
        cambiarPanel(3);
    }
    
    //Desaparecer todos los paneles excepto el ingresado
    private void cambiarPanel(int nPanel){
        //System.out.println(" - Cambiando al panel " + nPanel); //Debug
        
        vista.p1.setVisible(false);
        vista.p2.setVisible(false);
        vista.p3.setVisible(false);
        vista.p4.setVisible(false);
        if (0<=nPanel && nPanel<=4){
            listaPaneles.get(nPanel).setVisible(true);
        } else {
            vista.lblListo.setVisible(true);
        }
    }
    
    //Funcion que actualiza el label que indica el progreso y aumenta la variable interna
    private void actualizarProgreso(int resultado){
        String msg;
        msg = vista.lblProgreso.getText()+" > " + resultado; 
        this.progreso += resultado;
        vista.lblProgreso.setText( msg );
    }
    
}
