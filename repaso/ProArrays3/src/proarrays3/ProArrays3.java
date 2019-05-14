/*
Crea un array de caracteres que contenga de la ‘A’ a la ‘Z’ (solo las mayúsculas).
Después, ve pidiendo posiciones del array por teclado y si la posición es correcta, se
añadirá el carácter de esa posición a una cadena que se mostrará al final, se dejará de
insertar cuando se introduzca un -1.
 */
package proarrays3;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class ProArrays3 {
    private static char [] abecedario = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','X','Y','Z'};
    public static void main(String[] args) {
        //rellenarArrayAbecedario();?
        boolean error=false;
        int posicion = 0;
        do{
            String cadena = null;
            posicion = Integer.parseInt(JOptionPane.showInputDialog(null,"teclea posicion"));
            while(posicion<abecedario.length&&posicion!=-1){  
                cadena = crearCadena(posicion);
                JOptionPane.showMessageDialog(null, "posicion guardada");
            }
            if(posicion == -1){
                if(cadena.isEmpty()==false){
                    JOptionPane.showMessageDialog(null, cadena);
                }
                else{
                error = false;}
            }
            else{
                error=true;
                JOptionPane.showMessageDialog(null, "posicion invalida. Escriba una posicion válida del abecedario. \n"+
                                                    "Escriba -1 para terminar.");
            }
        }
        while(error==true);
        //salir();
        
    }
    public static String crearCadena(int p){
        String cadena="";
        char letra = abecedario[p]; //obtenemosContenidoPosicion
        cadena = cadena + letra;
        return cadena;
    }
        
        
        
    
}
