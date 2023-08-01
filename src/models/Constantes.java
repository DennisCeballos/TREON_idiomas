package models;

import java.awt.Color;
import java.awt.Point;

public class Constantes {
        
    public static int[] SIZE_PANTALLA = {515,750};
    public static Color COLOR_FONDO = new java.awt.Color(168, 230, 255);
    public static Point POSICION_PANTALLA = new Point(450, 0);

    public static Point getPOSICION_PANTALLA() {
        return POSICION_PANTALLA;
    }
    
    public int[] getSIZE_PANTALLA(){
        return SIZE_PANTALLA;
    }

    public static Color getCOLOR_FONDO() {
        return COLOR_FONDO;
    }
    
}
