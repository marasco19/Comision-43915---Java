import java.util.Scanner;

public class clase3 {
    public static void main(String[] args) {
        String mes;
        int numeroMes=0;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Ingresar el nombre del mes");
        mes = myObj.nextLine();
        System.out.println(mes);
        myObj.close();

        switch (mes.toLowerCase()) {
            case "enero": numeroMes = 1;
                break;
            case "febrero": numeroMes = 2;
                break;
            case "marzo": numeroMes = 3;
                break;
            case "abril": numeroMes = 4;
                break;
            case "mayo": numeroMes = 5;
                break;
            case "junio": numeroMes = 6;
                break;
            case "julio": numeroMes = 7;
                break;
            case "agosto": numeroMes = 8;
                break;
            case "septiembre": numeroMes = 9;
                break;
            case "octubre": numeroMes = 10;
                break;
            case "noviembre": numeroMes = 11;
                break;
            case "diciembre": numeroMes = 12;
                break;
            default:
                System.out.println("Nombre de mes invalido");
        }
        System.out.println("El numero de mes es "+ numeroMes);

    }
}