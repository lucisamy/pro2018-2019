/*ENUNCIADO:
1.- Crea un array de diez posiciones de números con valores pedidos por teclado. 
A continuación muestra un menú con las siguientes opciones:
- Mostrar el contenido de todas las posiciones.
- Mostrar el contenido de una posición concreta.
. Modificar el contenido de una posición concreta.
- Vaciar el contenido de una posición concreta.
- Calcular la suma y la media de todos los números
- Ordenar los números de mayor a menor.
*/
package proarrays1;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class ProArrays1 {

    //variables globales
        //declaro y creo el array
    private static int[] array = new int[10];
    private static int num;
    //variable que usaremos para menú.
    private static int opcion;    
    public static void main(String[] args) {
        //datos de entrada: 
        //mientras queden posiciones en el array seguimos pidiendo números.
        JOptionPane.showMessageDialog(null,"Teclea 10 números uno por uno");
        for(int x=0;x<array.length;x++){
            agregarAlArray(x);//agregamos el número al array en esa posición.
        }
        //mostramos menú:
        mostrarMenu();
    }
    public static void agregarAlArray(int x){
        num = Integer.parseInt(JOptionPane.showInputDialog("Teclea un número"));
        array[x]=num;
    }
    public static void mostrarMenu(){
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Menú:\n"+
                                            "teclea el número de la opción a elegir:\n" +
                                               "1.- Mostrar el contenido de todas las posiciones.\n"+
                                               "2.- Mostrar el contenido de una posición concreta.\n"+
                                               "3.- Modificar el contenido de una posición concreta.\n"+
                                               "4.- Vaciar el contenido de una posición concreta.\n"+
                                               "5.- Calcular la suma y la media de todos los números.\n"+
                                               "6.- Ordenar los números de mayor a menor.\n"+
                                               "7.- Salir"));
        
        //segun la opción escogida ejecutamos uno u otro método.
        while(opcion!=7){
            switch(opcion){
                case 1:
                    mostrarContenidoTodos();
                break;
                case 2:
                    mostrarContenidoPosicion();
                break;
                case 3:
                    modificarPosicion();
                break;
                case 4:
                    vaciarPosicion();
                break;
                case 5:
                    sumaYMedia();
                break;
                case 6:
                    ordenarNumeros();
                break;
                case 7:
                break;
            }
        }
    }
    public static void mostrarContenidoTodos(){
        String cadena="";
        for(int x=0;x<array.length;x++){
            cadena= cadena + "posicion"+ x + ": " + array[x]+"\n";
        }
        JOptionPane.showMessageDialog(null,cadena);
        mostrarMenu();
    }
    public static int tecleaPosicion(){
        //si coloco boolean error=true; aquí: luego no cambia a false y se mantiene en la repetitiva.
        //si coloco boolean error=false; aquí: el while no se cumple y entra al do, no seria necesario el else en ese caso.
        //si no inicializo la variable se haría así:
        /*
        boolean error;
        int x=0;
        do{
            x = Integer.parseInt(JOptionPane.showInputDialog("teclea una posicion"));
            if(x>=array.length){
                JOptionPane.showMessageDialog(null,"solo hay 10 posiciones que van de 0 a 9");
                error=true;
            }
            else{ 
                error=false; //el valor de esta variable es false solo dentro del else.
            }
        }
        while(error==true);//se fija en el valor de la variable. teniendo prioridad el valor asignado fuera de las llaves.
        return x;
        */
        //para controlar que se coloca una posicion correcta. que existe esa posicion
        boolean error=false;
        int x=0;
        do{
            x = Integer.parseInt(JOptionPane.showInputDialog("teclea una posicion"));
            if(x>=array.length){
                JOptionPane.showMessageDialog(null,"solo hay 10 posiciones que van de 0 a 9");
                error=true;
            }
        }
        while(error==true);//se fija en el valor de la variable. teniendo prioridad el valor asignado fuera de las llaves.
        return x;
    }
    public static void mostrarContenidoPosicion(){
        int x = tecleaPosicion();
        JOptionPane.showMessageDialog(null,"contenido de la posicion " + x + ": " + array[x]);
        mostrarMenu();
    }
    public static void modificarPosicion(){
        int x = tecleaPosicion();
        agregarAlArray(x);
        JOptionPane.showMessageDialog(null, "posicion " + x + " modificada");
        mostrarMenu();
    }
    public static void vaciarPosicion(){
        int x = tecleaPosicion();
        //para "vaciar" debemos rellenar con 0, -1 o null(si se ha usado la clase Integer)
        array[x]=0;
        mostrarMenu();
    }
    public static void sumaYMedia(){
        float suma=0;
        for(int x=0;x<array.length;x++){
            //suma = array[x] + array[x+1];
            suma = suma + array[x];
        }
        float media = suma/array.length; //int/int no puede dar float. uno de ellos debe ser float.
        JOptionPane.showMessageDialog(null,"la suma de todos los números es: " + suma + "\n"+
                                        "y la media es: " + media);
        mostrarMenu();
    }
    public static void ordenarNumeros(){
        Arrays.sort(array);
        JOptionPane.showMessageDialog(null, "array ordenado");
        mostrarMenu();
    }
}
