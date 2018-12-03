//arraylist
/*ENUNCIADO:
    Crea un arraylist para guardar valores de tipo real (Float o Double) que iremos
    introduciendo por teclado hasta finalizar (mientras quiera continuar).
    Posteriormente muestra un menu para que el usuario pueda realizar las
    siguientes operaciones:
    1. Visualizar el valor maximo y el mínimo.
    2. Solicitar un numero y buscarlo. Muestra un mensaje indicando si lo
    has encontrado o no.
    3. Solicitar un numero, buscarlo y borrarlo. Sino se encuentra muestra
        un mensaje de error.
    4. Convertir el arrayList en un array.
    5. Si no esta vacío, mostrar el numero de elementos que contiene.
    6. Insertar un nuevo elemento por el final.
    7. Insertar un nuevo elemento en la posicion que te indique el usuario.
    8. Borrar un elemento de una posicion concreta.
    9. Calcular la suma y la media aritmetica de los valores contenidos.
    10. Finalizar
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5_1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Excepciones.*;
import java.util.Collections;

/**
 *
 * @author Lucía
 */
public class Ejercicio5_1 {

    /**
     * @param args the command line arguments
     */
    
    //VARIABLES GLOBALES//
    //declaración del arrayList: el array es necesario en varias funciones 
    static ArrayList<Float>datosEntrada ;/*(guarda OBJETOS)*/
    /*opcion del menu*/
    static int opc;
    static float numero;/*se usa para llenar array y para pedir nuevos datos*/
    
    public static void main(String[] args) {

        //creación del array List, el arraylist guarda OBJETOS.
        datosEntrada = new ArrayList();
        //repetitiva para pedir datos de entrada mientras se elija "si" a la pregunta quieres continuar?
        int respuesta;
        //llenando array
        do{
            //añadimos elementos al array list (al final)
            /*pediremos el número en una función ya que este paso se repite en el ejercicio:
            datosEntrada.add(Float.parseFloat(JOptionPane.showInputDialog("Teclea número real")));
            (Float.parseFloat(JOptionPane.showInputDialog("Teclea número real")))-->función pedirNumero();*/
            
            datosEntrada.add(pedirNumero());
            //faltarian VALIDACIONES para el dato de entrada(try-catch)
            
            respuesta=JOptionPane.showConfirmDialog(null, "Quieres continuar?");
        }
        while(respuesta==0);
        //repetitiva para mostrar el menu hasta que se esciba 10:
        //int opc;--> VARIABLE GLOBAL
        do{
            try{
                mostrarMenu();
            //según la opción iremos a una u otra función.
            //try{-->hay que incluir a la función que tiene el throws Exception
                switch (opc){
                    case 1: maximoYMinimo();
                            break;
                    case 2: buscarNumero();
                            break;
                    case 3: buscarYBorrar();
                            break;
                    case 4: convertirEnArray();
                            break;
                    case 5: mostrarTamaño();
                            break;
                    case 6: añadirElemento();
                            break;
                    case 7: añadirEnPosicion();
                            break;
                    case 8: borrarDePosicion();
                            break;
                    case 9: sumaYMedia();
                            break;
                    case 10: 
                            break;
                    default:
                            throw new OpcionNoValidaException();
                }
            }
            catch(OpcionNoValidaException e){
                JOptionPane.showMessageDialog(null, "Opción escogida no valida, teclee número del 1 al 10");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Problemas");
                //al seleccionar cancelar o cerrar en el menú o si no colocamos nada o si colocamos una letra envez de número.
            }
        }
        while(opc!=10);
        //que hacer si se selecciona 10? mostrar mensaje de FIN? No, no es necesario.
    }
    public static Float pedirNumero(){
        //VALIDACIONES para el dato de entrada: se pide hasta que se coloca bien
        boolean error;
        do{
            try{
                /*Float elemento = Float.parseFloat(JOptionPane.showInputDialog("Teclea número real"));
                return elemento; -->elemento será variable global*/
                numero = Float.parseFloat(JOptionPane.showInputDialog("Teclea número real"));
                error=false; 
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "problemas: " + e.getMessage());
                error=true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "problemas con el número");
                error=true;
            }
        }
        while(error==true);
        //salimos de la repetitiva porque el dato introducido es correcto asi que lo devolvemos.
        return numero;
    }
    public static void mostrarMenu()throws Exception{
        //int opc;--> VARIABLE GLOBAL
        //try{
        opc= Integer.parseInt(JOptionPane.showInputDialog( "Elige una opcion: \n"+
                                "1. Visualizar el valor máximo y el mínimo de la lista.\n"+
                                "2. Buscar un número \n"+
                                "3. Buscar y borrar un número \n"+
                                "4. Convertir el arrayList en un array. \n"+
                                "5. Mostrar el numero de elementos que contiene la lista. \n"+
                                "6. Insertar un nuevo elemento por el final. \n"+
                                "7. Insertar un nuevo elemento en la posicion que se indique. \n"+
                                "8. Borrar un elemento de una posicion concreta. \n"+
                                "9. Calcular la suma y la media aritmetica de los valores contenidos. \n"+
                                "10. Finalizar"));
            //return opc;-->no se necesita al ser variable global
        //}
        /*catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas en mostrar menu");
        }*/
        /*  no se puede hacer try catch y return a la vez, ya que el catch necesitaria devolver un string
            y el menu necesita devolver un int.
            Las excepciones se tratarán en el main o en otra función.
        */
        /*return opc;--> si coloco este valor como variable global no tengo porqué usar un return en una funcion.
            cambio la funcion: public static int mostrarMenu() a public static void mostrarMenu()
        */
    }
    public static void maximoYMinimo(){
        JOptionPane.showMessageDialog(null, "El valor máximo es: " + Collections.max(datosEntrada) + "\n" +
                                        "El valor mínimo es: " + Collections.min(datosEntrada));
        //cómo se haria con una repetitiva?
    }
    public static void buscarNumero(){
        pedirNumero();//el return de esta función se guarda en una variable global
        //método contains para buscar devuelve un booleano
        if(datosEntrada.contains(numero)==true){
           JOptionPane.showMessageDialog(null, "este número sí se encuentra en el array");
        }
        else
           JOptionPane.showMessageDialog(null, "este número no se encuentra en el array");               
    }
    public static void buscarYBorrar(){
    // 3. Solicitar un numero, buscarlo y borrarlo. Sino se encuentra muestra un mensaje de error.
        visualizarArray();
        pedirNumero();//el return de esta función se guarda en una variable global
        //buscar el numero
        if(datosEntrada.contains(numero)==true){
            //borrar el número: borra el primero que encuentra con ese valor
            datosEntrada.remove(numero);
            JOptionPane.showMessageDialog(null, "el número " + numero + "ha sido borrado del array");
        }
        else
            JOptionPane.showMessageDialog(null, "este número no se encuentra en el array");
        visualizarArray();
    }
    public static void convertirEnArray(){
        //Object [] array = nombreArrayList .toArray ();
        //Float [] arrayNumeros = datosEntrada.toArray(); aviso: incompatible types Object[] cannot be converted to Float[]
        Float [] arrayNumeros = (Float[]) datosEntrada.toArray(); 
        //visualizar array!!
    }
    public static void mostrarTamaño(){
        JOptionPane.showMessageDialog(null, "El array contiene " + datosEntrada.size() + "elemntos");
        ////visualizar array!!
    }
    public static void añadirElemento(){
        datosEntrada.add(pedirNumero());
    }
    public static void añadirEnPosicion(){
        //pedir posición: VALIDAR!
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Teclea la posición en la que quieres agregar el elemento"));
        //añadir al arrayList en esa posición: si la posición no existe en el array devolver error
        datosEntrada.add(posicion, pedirNumero());
        //visualizar array!
    }
    public static void borrarDePosicion(){
        //pedir posición:VALIDAR!
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Teclea la posición del elemento que quieres borrar del arrayList"));
        //borrar de esa posición: si la posición no existe en el array devolver error
        datosEntrada.remove(posicion);
    }
    public static void sumaYMedia(){
        //suma
        float suma = 0;
        for(int x=0;x<datosEntrada.size();x++){
            suma = suma + datosEntrada.get(x);
        }
        JOptionPane.showMessageDialog(null, "la suma de todos los números es " + suma);
        //media aritmética: suma/numero de elementos
        float media = suma/datosEntrada.size();
        JOptionPane.showMessageDialog(null, "la media aritmética del array es " + media);
    }
    public static void visualizarArray(){
        //para visualizar el array debemos ir construyendo un string con lo que hay en cada posición:
        //para obtener lo que hay en una posición: String elemento = datosEntrada.get(x).toString();
        //repetitiva
        String verArray = "";
        for(int x=0;x<datosEntrada.size();x++){
            verArray = verArray + "" + datosEntrada.get(x).toString() + "";
            
        }
        System.out.println(verArray);
    }
}
        /*visualizar array!! en estas opciones del menú:
            3 (antes y después de borrar), 6,7 y 8
        */
