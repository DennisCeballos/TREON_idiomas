package ejercicios;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Ejercicio;

public class EtipoB extends EjercicioController{
    ArrayList<String[]> opcionesApoyo;
    ArrayList<JButton> listaBotones;
    Color colores[];
    int colorNativo;
    int colorExterno;
    
    public EtipoB(Ejercicio data){
        super(data);
        opcionesApoyo = new ArrayList<>();
        listaBotones = new ArrayList<>();
        System.out.println(" - Preparandolo en tipo >B<");
        
        colores = new Color[3];
        colores[0] = Color.CYAN; colores[1] = Color.YELLOW; colores[2] = Color.green;
    }
    
    public void recibirCambiar(JPanel panel){
        
        //Para crear el ejercicio de tipo A es necesario hacer primero
        //las siguientes funciones de la clase padre
        elegirIdioma();
        elegirOpcionClave(); //Este no es necesario del todo, pero el shuffle final es util
        
        //Las opciones del otro idioma hay que pasarlo a la lista secundaria
        for (String[] x: opciones){
            opcionesApoyo.add(x);
        }
        Collections.shuffle(opcionesApoyo);
        
        //Agregar los elementos necesarios respectivos
        JLabel lblEnunciado = new JLabel("¡Conecta las opciones iguales!" );
        lblEnunciado.setBounds(50, 50, 200, 20);
        panel.add(lblEnunciado);        
        
        //Botones de idiomaNativo [0]
        JButton bt1 = new JButton();
        bt1 = configurarBoton(bt1, 0, opciones.get(0)[0], 0);
        listaBotones.add(bt1);
        panel.add(bt1);
        
        JButton bt2 = new JButton();
        bt2 = configurarBoton(bt2, 1, opciones.get(1)[0], 0);
        listaBotones.add(bt2);
        panel.add(bt2);
        
        JButton bt3 = new JButton();
        bt3 = configurarBoton(bt3, 2, opciones.get(2)[0], 0);
        listaBotones.add(bt3);
        panel.add(bt3);
        
        
        /*
                            RETO
                POR SI QUIERES ANADIR 4 OPCIONES ACA
        */
        
        //JButton bt4 = new JButton();
        //bt4 = configurarBoton(bt4, 3, opciones.get(2)[0], 0);
        //panel.add(bt4);
        
        
        //Botones de IdiomaExtranjero[1]
        JButton bt5 = new JButton();
        bt5 = configurarBoton(bt5, 0, opcionesApoyo.get(0)[1], 1);
        listaBotones.add(bt5);
        panel.add(bt5);
        
        JButton bt6 = new JButton();
        bt6 = configurarBoton(bt6, 1, opcionesApoyo.get(1)[1], 1);
        panel.add(bt6);
        listaBotones.add(bt6);
        
        JButton bt7 = new JButton();
        bt7 = configurarBoton(bt7, 2, opcionesApoyo.get(2)[1], 1);
        listaBotones.add(bt7);
        panel.add(bt7);
        
        /*
                    DEL RETO
        */
        //JButton bt8 = new JButton();
        //bt8 = configurarBoton(bt8, 3, opcionesApoyo.get(2)[1], 1);
        //panel.add(bt8);
        
    }
    
    
    //Controla las configuraciones necesrias de cada Boton
    //Recibe el Boton mismo, su nro, la opcion de encima y el idioma (o sea la columna que pertenece)
    private JButton configurarBoton(JButton btn, int pos, String rpta, int idioma){
        
        //Agregar el texto
        btn.setText(rpta);
        
        //Cada que se aprete el boton, ____________
        btn.addActionListener((e) -> {    
            
                    //Le pone backgroundColor
            //Si es del idioma 0Nativo
            if (idioma==0){
                
                if (btn.getBackground().toString().equals("javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]")){
                    btn.setBackground( this.colores[this.colorNativo] );
                    this.colorNativo+=1;
                }
            
            //Si es del idioma 1Extranjero
            } else {
                if (btn.getBackground().toString().equals("javax.swing.plaf.ColorUIResource[r=238,g=238,b=238]")){
                    btn.setBackground( this.colores[this.colorExterno] );
                    this.colorExterno+=1;
                }
            }
            
        });
        
        //Funcion de posicion Y: a+(pos*b)
        //      a:posicion del primer boton 0;   b:separacion entre botones del mismo idioma
        //Funcion de posicion X: a+(idioma*b)
        //      a:posicion del primer boton 0;   b:separacion entre botones de distinto idioma
        btn.setBounds((180*idioma)+80, 150+(pos*80), 120, 50);
        
        return btn;
    }
    
    @Override
    public int calificarEjercicio() {
        
        try {
            String[] revisar = new String[6];
            float ptj=0;

            //Agrupa en la lista revisar los pares de opciones del mismo color
            int i = 0;
            for ( int j =0 ; j<=2; j++ ){
                i = j*2;
                for ( JButton x: this.listaBotones ){
                    if ( x.getBackground().equals( this.colores[j] ) ){
                        revisar[i] = (x.getText());
                        i = i+1;
                    }
                }
            }

            //Por el orden de los botones, los primeros 3 siempre seran del idioma nativo
            String comparar = "";
            for ( i = 0; i<=(int)revisar.length-2; i=i+2){

                //Encontrar el mismo elemento entre las opciones
                //guardar el elemento del idioma opuesto
                for ( String[] x: this.opciones ){
                    if ( x[0].equals( revisar[i] )){
                        comparar = x[1];
                        break;
                    }
                }

                //Si es la comparacion correcta
                if (revisar[i+1].equals( comparar )){  ptj+=1.7;  }
            }

            System.out.println(" - Se califica el ejercicio tipo B con "+ptj);
            return (int)ptj;
            
        } catch (Exception e) {
            System.out.println(" - Se debe seleccionar todas las opciones del ejercicioB");
            return 0;
        }
    }
    
    
    
}
