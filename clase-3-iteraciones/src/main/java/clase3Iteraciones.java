import java.util.ArrayList;
import java.util.List;

public class clase3Iteraciones {
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();
        for (int i=0; i<10; i++){
            listaNumeros.add((int) ((Math.random() * 100) + 1));
        }
        System.out.println("La lista es " + listaNumeros);
        for(int lista: listaNumeros){
            if(!(lista % 3 == 0 && lista % 5 == 0)){
                System.out.println("los numeros multiplos de 3 y 5 son: " + lista);
            }else{
                /*System.out.println("no es multiplo de 3 ni de 5 ---->" + lista);*/
                break;
            }

        }

    }
}
