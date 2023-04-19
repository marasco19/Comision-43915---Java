public class NumeroFlotanteRamos {
    public static void main(String[] args) {
        /* defino una variable double */
        double doubleNumber = 30.56;
        /* casteo la variable para quedarme con la parte entera */
        int intPart = (int) doubleNumber;
        /* imprimo el numero original */
        System.out.println("Numero Double: " + intPart);
        /* imprimo la parte entera */
        System.out.println("Parte entera: " + intPart);
        /* imprimo la parte decimal */
        System.out.println("Parte decimal: " + (doubleNumber - intPart));
    }
}

