package puntaje;

import idioma.IdiomasController;
import models.Usuario;

public class PuntajeController {
    
    PuntajeView vista;
    Usuario currentUser;
    
    
    public PuntajeController(int progreso, String idioma, String modulo, Usuario usuario){
        this.currentUser = usuario;

        System.out.println(" > Mostrando puntaje de Sesion");
        
        vista = new PuntajeView();
        vista.lblResultados.setText("Conseguiste " + progreso + "pts en la sesion "+ modulo +" del idioma "+ idioma);
        
        vista.btnVolver.addActionListener((e) -> {
            IdiomasController idiomasController = new IdiomasController(this.currentUser);
            vista.f.dispose();
        });
    }
    
}
