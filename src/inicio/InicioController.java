package inicio;

import usuarios.*;

public class InicioController {
    InicioView vista;
    
    public InicioController(){
        System.out.println("> Pantalla de Inicio");
        System.out.println(" - BIENVENIDO - ");
        vista = new InicioView();
        asignarFunciones();
        
    }
    
    private void asignarFunciones(){
        
        //Funcion del boton para ingresar a usuarios
        vista.btnPaseUsuario.addActionListener((e) -> {
                  
            UsuariosController controladorUser = new UsuariosController();
            vista.f.dispose();
            
        });
        
    }
    
}
