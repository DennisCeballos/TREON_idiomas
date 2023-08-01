package ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JPanel;
import models.Ejercicio;

public abstract class EjercicioController {
    
    Ejercicio data;
    ArrayList<String[]> opciones;
    int idOpcionClave;
    int idioma;
    String opcionClave;
    String rptaIn;
    
    
    public abstract void recibirCambiar(JPanel panel);
    
    public EjercicioController(Ejercicio data){
        System.out.println(" -Creando ejercicio de id: "+data.getId());
        this.data = data;
        
        //Inicializar las variables necesarias
        this.opciones = new ArrayList<>();
        rptaIn = "";
    }
    
    public void elegirIdioma(){
        Random ran = new Random();
        idioma = ran.nextInt(2);
    }
    
    //Elige la opcion clave, la correcta
    //Como tambien guarda y desordena las opciones alternativa (en la ArrayList opciones)
    public void elegirOpcionClave(){
        Random ran = new Random();
        
        //Definir las opciones a elegir
        //Se crean 3 int aleatorios diferentes
        int[] numAleatorios = {-1,-1,-1};
        
        numAleatorios[0] = ran.nextInt(data.getOpciones().size() );
        
        while (numAleatorios[1]==-1){
            numAleatorios[1] = ran.nextInt(data.getOpciones().size() );
            if (numAleatorios[0]==numAleatorios[1]){
                numAleatorios[1]=0;
            }
        }
        while (numAleatorios[2]==-1){
            numAleatorios[2] = ran.nextInt(data.getOpciones().size() );
            if (numAleatorios[0]==numAleatorios[2] || numAleatorios[1]==numAleatorios[2]){
                numAleatorios[2]=0;
            }
        }
        
        //Se selecciona y guarda la opcion clave entre los 3
        idOpcionClave = numAleatorios[0];
        opcionClave = data.getOpciones().get(idOpcionClave)[idioma];
        
        //Finalmente agrega las opciones a la lista
        try {
            opciones.add(data.getOpciones().get(numAleatorios[0]) );
            opciones.add(data.getOpciones().get(numAleatorios[1]) );
            opciones.add(data.getOpciones().get(numAleatorios[2]) );
        } catch (Exception e) {
            System.out.println(" + \"No siempre se tendran mas de 3 opciones\" en ejercicioController");
            System.out.println("");
        }
        
        //Shuffle a la lista
        Collections.shuffle(opciones);
    }
    
    //Desordena la lista de opciones
    public void shuffleOpciones(){
        System.out.println("Por ahora nada de funcion shuffle sola");
    }
    
    
    //Revisa que la opcion clave guardada sea la misma que la rptaInput
    public int calificarEjercicio(){
        
        //Evaluar si la rpta ingresada es la misma que:
        //                          la opcion del idioma contrario con la opcionClave del ejercicio
        try {
            if (this.rptaIn.trim().equals(this.data.getOpciones().get(idOpcionClave)[1-idioma])){
                System.out.println(" - Se compara " + this.data.getOpciones().get(idOpcionClave)[1-idioma] + " con " + this.rptaIn + " devuelve true"); //Debug
                return 5;
            } else {
                System.out.println(" - Se compara " + this.data.getOpciones().get(idOpcionClave)[1-idioma] + " con " + this.rptaIn + " devuelve false");//Debug
                return 0;
            }
        } catch (Exception e){
            System.out.print(" +No se pudo calificar el ejercicio de id " + this.data.getId());
            System.out.println(" + Con opcion clave " + this.opcionClave);
            return 0;
        }
    }
}
