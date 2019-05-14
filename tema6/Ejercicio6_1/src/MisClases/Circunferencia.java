/*Enunciado:
    Escribe un programa que pida los datos necesarios para calcular la
    longitud de una circunferencia (2 * PI * radio), su area ( PI * radio *
    radio) y el volumen de una esfera ( 4 * PI * radio * radio * radio / 3)

*/
package MisClases;

/**
 *
 * @author Lucía
 */
public class Circunferencia {
    //atributos de la clase
    private float radio;
    //constructor vacío
    public Circunferencia(){      
    }
    //constructor con parámetro
    public Circunferencia(float radio){
        this.radio= radio;
    }
    //getter y setter
    public float getRadio(){
        return radio;
    }
    public void setRadio(float radio){
        this.radio = radio;
    }
    //métodos para calcular longitud,área y volumen
    // (2 * PI * radio)
    //( PI * radio * radio)
    //( 4 * PI * radio * radio * radio / 3)
    /*Math.pow para elevar un número
        esta función devuelve tipo de datos double*/
    public float longitud(){
       float longitud = (float)(2*Math.PI*radio);
       return longitud;
    }
    public double area(){
        double area = Math.PI*Math.pow(radio, 2);
        return area;
    }
    public double volumen(){
        double volumen = (4* Math.PI* Math.pow(radio, 3))/3;
        return volumen;
    }
}

