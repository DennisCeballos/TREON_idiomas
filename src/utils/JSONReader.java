package utils;

import java.io.*;
import java.util.*;
import models.Ejercicio;
import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONReader {
    public JSONArray getJSONbyPath(String pathname) {
        JSONParser parser = new JSONParser();
        try {
            File file = new File(pathname);
            Object obj = parser.parse(new FileReader(file));
            JSONArray jsonArray = (JSONArray)obj;
            return jsonArray;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Ejercicio getEjercicioAleatorio(String pathname){
        
        //Crea un JSONArray donde se almacenan todos los ejercicios guardados en un archivo
        JSONArray listEjercicios = getJSONbyPath(pathname);
        
        //Elige de forma aleatoria un ejercicio del archivo
        int index = new Random().nextInt(listEjercicios.size());
        JSONObject ejercicio = (JSONObject) listEjercicios.get(index);

        //--Todo este bloque se encarga de transofmar los datos del JSONObjetct a un Ejercicio
        JSONArray opciones = (JSONArray) ejercicio.get("opciones");
        List<String[]> opcionesMatrix = new ArrayList<>();
        for( int i=0; i < opciones.size(); i++ ){
            String[] list = new String[opciones.size()];
            JSONArray opcion = (JSONArray) opciones.get(i);
            for( int k=0; k < opcion.size(); k++ ){
                list[k] = (String) opcion.get(k);
            }
            opcionesMatrix.add(list);
        }
        List<String> arrayTipos = new ArrayList<>();
        JSONArray tipos = (JSONArray) ejercicio.get("tipos");

        for( int i=0; i < tipos.size(); i++ ){
            arrayTipos.add((String) tipos.get(i));
        }
        
        Ejercicio objEjercicio = new Ejercicio((String) ejercicio.get("id"), (ArrayList<String[]>) opcionesMatrix, (ArrayList<String>) arrayTipos, (Boolean) ejercicio.get("isFrase"));
        //--Todo este bloque se encarga de transofmar los datos del json a un objeto tipo Ejercicio
        
        //Retorna el Ejercicio creado
        return objEjercicio;
    }
}