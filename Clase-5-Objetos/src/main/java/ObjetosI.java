import java.util.ArrayList;
import java.util.List;

public class ObjetosI  {
    public static void main(String[] args) {
        //ver == en primitivos
        int a = 1;
        int b = 2;
        System.out.println(a==b);
        //Metodo equals
        // en listas ya esta implementado
        List<String> lista1 = new ArrayList<>();
        lista1.add("Joaquin");
        List<String> lista2 = new ArrayList<>();
        lista1.add("Joaquin");
        System.out.println(lista1.equals(lista2));

        Perro dogui = new Perro();
        //Seteamos las variales de instancia para el objeto dogui que es una instancia de Perro
        dogui.setRaza("Doberman");
        dogui.setNombre("Dogui");
        dogui.setTamanio(95);
        System.out.println(dogui.getNombre());

        Perro doguiDuplicado = new Perro();
        //Seteamos las variales de instancia para el objeto dogui que es una instancia de Perro
        doguiDuplicado.setRaza("Doberman");
        doguiDuplicado.setNombre("Dogui");
        doguiDuplicado.setTamanio(95);
        System.out.println(doguiDuplicado.getNombre());


        System.out.println(dogui.equals(doguiDuplicado));

        System.out.println(dogui.hashCode());
        System.out.println(doguiDuplicado.hashCode());


        Perro dogui2 = new Perro (92,"Dogui2", "Doberman");
        System.out.println(dogui2.toString());


        Gato michi = new Gato();
        michi.setAlimentoPreferido("Gati");
        System.out.println("El alimento preferido es: "+ michi.getAlimentoPreferido());

        Animal tigre = new Animal();
        tigre.setAmistoso(false);
        tigre.setCantidadPatas(4);

        System.out.println(tigre.toString());
        /* ejercicio 1*/
        Ejercitacion ej1 = new Ejercitacion();
        /*System.out.println(ej1.randomNumber(1,10));*/
        /* ejercicio 2*/
       /* System.out.println(ej1.compareNumbers(144,62,135));*/
       /* ejercicio 3 */
        /*System.out.println(ej1.countWords("hola mi nombre"));*/
        /* ejercicio 4*/
        /*ej1.compoundInterest(2000,8,5);*/
        /*ejercicio 5*/
        /*Counter ej5 = new Counter();
        ej5.add();
        ej5.add();
        ej5.add();
        ej5.decrement();
        ej5.print();*/
        /*ejercicio 6*/
        Person persona1 = new Person(41,82,"Mariano Ramos",28562543);
        Person persona2 = new Person("Martin Ramos",55222333);
        System.out.println("Cantidad de personas creadas: " + Person.cantidadInstancias);
        /*ejercicio 7*/


    }
}
