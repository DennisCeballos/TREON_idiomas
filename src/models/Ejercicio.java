package models;

import java.util.ArrayList;

public class Ejercicio {
    
    String id;
    ArrayList<String[]> opciones;
    ArrayList<String> tipo;
    boolean isFrase;

    
    //Constructores
    public Ejercicio(String id, boolean isFrase) {
        this.opciones = new ArrayList<>();
        this.tipo = new ArrayList<>();
        this.id = id;
        this.isFrase = isFrase;
    }
    
    public Ejercicio(String id, ArrayList<String[]> opciones, ArrayList<String> tipo, boolean isFrase) {
        this.id = id;
        this.opciones = opciones;
        this.tipo = tipo;
        this.isFrase = isFrase;
    }
    
    
    //Setters y getters
    public void agregarOpcion(String[] opt){
        this.opciones.add(opt);
    }
    
    public void agregarTipo(String typo){
        this.tipo.add(typo);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String[]> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<String[]> opciones) {
        this.opciones = opciones;
    }

    public ArrayList<String> getTipo() {
        return tipo;
    }

    public void setTipo(ArrayList<String> tipo) {
        this.tipo = tipo;
    }

    public boolean isIsFrase() {
        return isFrase;
    }

    public void setIsFrase(boolean isFrase) {
        this.isFrase = isFrase;
    }
}