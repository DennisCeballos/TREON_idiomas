package models;

import org.json.simple.JSONArray;

import java.util.ArrayList;

public class Usuario {
    private Long id;
    private String nombre;
    private JSONArray puntajes;

    public Usuario(Long id, String nombre, JSONArray puntajes) {
        this.id = id;
        this.nombre = nombre;
        this.puntajes = puntajes;
    }

    public Usuario(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JSONArray getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(JSONArray puntajes) {
        this.puntajes = puntajes;
    }
}
