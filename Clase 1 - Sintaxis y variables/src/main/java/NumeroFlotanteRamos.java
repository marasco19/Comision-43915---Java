public class NumeroFlotanteRamos {
    public static void main(String[] args) {
        double doubleNumber = 26.45;
        int intPart = (int) doubleNumber;
        System.out.println("Double Number: " + intPart);
        System.out.println("Integer Part: " + intPart);
        System.out.println("Decimal Part: " + (doubleNumber - intPart));
    }

}
