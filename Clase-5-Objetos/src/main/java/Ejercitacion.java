import java.lang.Math;
import java.lang.String;
public class Ejercitacion {
    public int randomNumber(int min, int max){
        int numero = (int)(Math.random()*max+min);
        return numero;
    }
    private int compareNumbers(int param1, int param2, int param3){
        int resultado=0;
        if(param1 < param2 && param1 < param2){
            resultado = param1;
        }else{
            if (param2 < param1 && param2 < param3) {
                resultado = param2;
            } else {
                if (param3 < param1 && param3 < param2) {
                    resultado = param3;
                }
            }
        }
        return resultado;
    }
    public int countWords(String s) {
        int contador = 1, pos;
        s = s.trim(); //eliminar los posibles espacios en blanco al principio y al final
        if (s.isEmpty()) { //si la cadena está vacía
            contador = 0;
        } else {
            pos = s.indexOf(" "); //se busca el primer espacio en blanco
            while (pos != -1) {   //mientras que se encuentre un espacio en blanco
                contador++;    //se cuenta una palabra
                pos = s.indexOf(" ", pos + 1); //se busca el siguiente espacio en blanco
            }                                     //a continuación del actual
        }
        return contador;
    }

    public void compoundInterest(int capitalInicial, int interes, int periodos) {
        double interesCalculado = (double)interes/100;
        double monto = capitalInicial * Math.pow((1 + (interesCalculado/12)), 12 * periodos);
        double cinterest = monto - capitalInicial;
        System.out.println("interes calculado " + interesCalculado);
        System.out.println("Interes compuesto despues de " + periodos + " years: "+cinterest);
        System.out.println("monto despues de " + periodos + " years: "+monto);
    }
}


