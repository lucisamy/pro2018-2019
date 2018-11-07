
package ejercicio3_1;

import javax.swing.JOptionPane;

public class Ejercicio3_1 {

    /**
     * @param args the command line arguments
     */
    
    /*ENUNCIADO:
        Introducir por teclado el numero de horas trabajadas por un empleado
        e imprimir el sueldo que le corresponde cobrar teniendo en cuenta 
        que cada hora normal se paga a 10 euros y cada hora extra a 15.
        Las horas extras son aquellas superiores a las cuarenta.
        En algunos casos, a la nomina calculada hay que sumarle un plus de 
        100 euros segun el estado civil y el nivel de estudios del empleado. 
        Esta ultima información también la obtendremos a través del teclado. 
        El estado civil puede ser S de soltero, C de casado, V de viudo y D de
        divorciado (S C V D ).
        El nivel de estudios puede ser P de primario, M de medio y S de
        superior (P M S).
        Llevan el plus de 100 euros las siguientes combinaciones: SP VS SM
        CS VP SS DS.
    */
    
    //VARIABLES GLOBALES (datos de entrada)
    static String nombre;
    static int horas;
    static char estadoCivil;
    static char nivelEstudios;
    
    public static void main(String[] args) {
        // TODO code application logic here

        //Guardaremos los datos de entrada y los validaremos en una función
        solicitarDatos();
        //Calculamos el sueldo en otra funcion:las variables que necesita serán globales
        float sueldo=calcularDatos();
        JOptionPane.showMessageDialog(null, "El sueldo de " + nombre + " es de " + sueldo + " euros");

    }
    
    public static void solicitarDatos(){
        //REPETITIVA para valores de entrada erróneos
        boolean error;
        nombre=JOptionPane.showInputDialog("Introducir nombre de empleado");
        //hora inválida: debe ser un número mayor a 0
        do
        {
            try
            {   //datos de entrada
                horas=Integer.parseInt(JOptionPane.showInputDialog("Introduce horas del trabajador"));
                //validación de datos
                if(horas<0)
                    throw new HoraInvalidaException();
                error= false;
            }
            catch (HoraInvalidaException|NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Hora inválida");
                error=true;
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Problema");
                error=true;                
            }
        }
        while(error==true);
        //estado civil inválido: solo debe ser una letra en mayúscula
        do
        { 
            try
            {
                estadoCivil=JOptionPane.showInputDialog("Tecle estado civil del trabajador: "
                    + "El estado civil puede ser S de soltero, C de casado, V de viudo y D de" +
                    " divorciado (S C V D ).").charAt(0);
                if(estadoCivil!='S'&&estadoCivil!='C'&&estadoCivil!='V'&&estadoCivil!='D')
                    throw new EstadoCivilInvalidoException();
                error=false;
            }
            catch (EstadoCivilInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, "Estado civil inválido: Teclear una de las opciones sgtes (S C V D )");
                error=true;
            }
        }
        while(error==true);
        //nivel de estudios inválido
        do
        {
            try
            {
                nivelEstudios=JOptionPane.showInputDialog("Tecle el nivel de estudios del trabajador:" 
                    + "El nivel de estudios puede ser P de primario," + " M de medio y " 
                    + "S de superior (P M S).").charAt(0);
                if(nivelEstudios=='P'||nivelEstudios=='M'||nivelEstudios=='S')
                    error=false;
                else throw new NivelEstudiosInvalidoException();
            }
            catch (NivelEstudiosInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, "Nivel de estudios inválido: Teclear una de las opciones sgtes (P M S)");
                error=true; 
            }
        }
        while(error==true);
    }
    public static float calcularDatos(){
        //constantes a usar en el cálculo:
        final float COSTO_HORA_NORMAL = 10;
        final float COSTO_HORA_EXTRA = 15;
        final float PLUS = 100;
        //variable de esta función que se devolverá a main:
        float sueldo;
        //SUELDO BASE
        //horas normales
        if(horas<=40)
            sueldo = horas * COSTO_HORA_NORMAL;
        //horas extras
        else
            sueldo = (horas - 40) * COSTO_HORA_EXTRA;
        //PLUS
        if(nivelEstudios=='S'||(estadoCivil=='V'&&nivelEstudios=='P'))
            sueldo = sueldo + PLUS;
        return sueldo;
    }
          
}
