/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2_1;

import javax.swing.JOptionPane;

/**
 *
 * @author rita
 */
public class Ejercicio2_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Ejercicio1
        Dada una cadena de caracteres mostrar por pantalla la cantidad de
        vocales que tiene.
        */
        /*Planteamiento:
            debo contar las vocales, con lo cual habrá un contador y una 
            repetitiva y habrá que establecer el límite a esta
        */
        //datos de entrada: defino la variable/Objeto de clase String
        String cadena = JOptionPane.showInputDialog("Teclea una cadena de caracteres");
        /*CORRECCION: 
            Podemos definir estas variables en la función contarVocales y solo
            pasar el objeto de tipo String "cadena"
            int tamaño = cadena.length();
            int posicion=0;
            int contador=0;
            int vocales=contarVocales(cadena,tamaño,posicion,contador);
        */ 
        
        /*llamo a una función donde haré el trabajo de comparar letra por letra
            con las vocales y contar cuántas hay, se devolverá un número*/
        int vocales=contarVocales(cadena);
        //datos de salida
        JOptionPane.showMessageDialog(null, " La cadena tiene " + vocales + " vocales");
    }
    public static int contarVocales(String cadena/*,int tamaño,int posicion,int contador*/){
        
        /*lo primero será calcular el número de posiciones que tiene esta cadena.
            creo una variable donde se guardará este dato
            uso el método length*/
        //definicion variables
        int tamaño = cadena.length();
        //contador de vocales
        int contador=0;        
        /*REPETITIVA: hago comparaciones con cada letra (cambio de posición en la cadena)
            hasta que se alcance el tamaño de la cadena (posición final)
        */
        /*creo una variable para guardar la posicion analizada en cada momento
            y la inicializo a 0
        */
        for(int posicion=0;posicion!=tamaño;posicion++){
        //comparamos cada posición con las vocales
        /*Con el método charAt reviso qué caracter es el que ocupa cada posición
            y guardo esta informacion en una variable de tipo char
        */
            char letra = cadena.charAt(posicion);
        //System.out.print(letra);
            switch (letra)
            {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    contador++;
                    break;
            }       
        }
        return contador; /*no es necesario que el nombre de la variable a 
            devolver a la función main sea el mismo mientras sea el mismo 
            tipo de datos*/
    }
} 

