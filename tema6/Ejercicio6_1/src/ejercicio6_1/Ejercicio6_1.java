/*Enunciado:
    Escribe un programa que pida los datos necesarios para calcular la
    longitud de una circunferencia (2 * PI * radio), su area ( PI * radio *
    radio) y el volumen de una esfera ( 4 * PI * radio * radio * radio / 3)

*/
package ejercicio6_1;

import MisClases.Circunferencia;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucía
 */
public class Ejercicio6_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Creación objeto Circunferencia
        Circunferencia c1 = new Circunferencia();
        //pedimos radio
        c1.setRadio(Float.parseFloat(JOptionPane.showInputDialog("Teclea el radio de la circunferencia")));
        /*todos los resultados los queremos mostrar redondeados y no con tantos decimales:
            Para redondear usaremos DecimalFormat
        */
        DecimalFormat formato1 = new DecimalFormat("#.00");
        //para aplicar este formato se usa el método format
        //calcular longitud, area y volumen:
        JOptionPane.showMessageDialog(null, "la longitud es " + formato1.format(c1.longitud()) + "\n" +
                                            "el area es " + formato1.format(c1.area())+ "\n" +
                                            "el volumen es " + formato1.format(c1.volumen())+ "\n");
    }
}
