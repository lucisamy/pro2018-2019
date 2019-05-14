/*
Crea un array de números de un tamaño indicado por teclado, el array contendrá
números aleatorios entre 1 y 300. A continuación, muestra los números que acaben en un
dígito que nosotros le indiquemos por teclado, estos deben guardarse en un nuevo array. 
*/
package proarrays2;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class ProArrays2 {
    private static Integer[] array;
    private static char ultimod;
    public static void main(String[] args) {
        pedirLongitud();
        generarNumeros();
        String [] narray = buscarUltimoDigito();
        mostrarNuevoArray(narray);
    }
    public static void pedirLongitud(){
        int n = Integer.parseInt(JOptionPane.showInputDialog("Teclea la longitud del array"));
        array = new Integer [n];
    }   
    public static void generarNumeros(){
        int max = 301;
        for(int x=0;x<array.length;x++){
            Random r = new Random();
            Integer n;
            do{
            n = r.nextInt(max);//este método excluye al max, retorna entre 0 y 300 incluido.
            array[x]=n;  
            }
            while(n==0);
            System.out.println(n);
        }
    }
    public static String[] buscarUltimoDigito(){
        //ultimod = Integer.parseInt(JOptionPane.showInputDialog("teclea el último digito"));
        ultimod = JOptionPane.showInputDialog("teclea el último digito").charAt(0); //char
        String [] narray = null;
        int contador = 0;
        for(int x= 0;x<array.length;x++){
            String nro = array[x].toString(); //convertimos el contenido de la posicion en string
           int ultimap = nro.length() - 1;
           //solo quiero crear y mostrar el array si hay al menos un numero que coincida con el ultimo digito.
           //si el ultimo digito coincide con el tecleado y es el primero creamos el array y agregamos este número al nuevo array
           if(nro.charAt(ultimap)== ultimod && contador==0){
             narray = new String [array.length];
             narray[0] = nro;
             contador++; //una vez creado y encontrado el primer número nos aseguramos que no vuelva a repetirse sumando al contador.
             //se podria haber hecho con variable booleana??
           }
           else{
               if(nro.charAt(ultimap)==ultimod){
                   narray[contador] = nro;
                   contador ++;
               }
               /*if(nro.charAt(ultimap)== ultimod){
                    for(int y= 1;y<narray.length;y++){
                        narray[y] = nro;
                    }
               } ESTO ESTÁ MAL. ESTARIA PONIENDO UN UNICO NUMERO EN TODAS LAS POSICIONES (EXCEPTO 0)DEL ARRAY NUEVO
               */
           }
        }
        return narray;
    }
    public static void mostrarNuevoArray(String[]narray){
        String cadena="";
        // ESTO ESTÁ MAL! nullPointerException
        if(narray == null){
            JOptionPane.showMessageDialog(null, "no se encontró ningun número terminado en "+ ultimod );
        }
        else{
            for(int y=0;y<narray.length;y++){
                cadena= cadena + "posicion "+ y + ": " + narray[y]+"\n";
            }
            JOptionPane.showMessageDialog(null,cadena);
        }
    }
}


//problema de recorrer el segundo array: método buscarUltimoDigito
/*  1.se teclea el digito a buscar.
    2.recorremos el primer array: 
        -para cada posicion del array obtenemos el ultimo digito de ese número mediante conversión a String.
        -comparamos este nro con el digito a buscar.
        -si lo encontramos y es la primera vez que lo encontramos creamos array y agregamos este nro al array en la primera posicion
        -si lo encontramos pero no es la primera vez no creamos array, pero agregamos al array en la sgte posicion
        -si no lo encontramos (null) no creamos array y mostramos mensaje de que no se encontró.
    
*/