public class Person {
    private int edad;
    private int peso;
    private String nombre;
    private int dni;
    public static int cantidadInstancias = 0;

    public Person(int edad, int peso, String nombre, int dni) {
        this.edad = edad;
        this.peso = peso;
        this.nombre = nombre;
        this.dni = dni;
        cantidadInstancias++;
    }
    public Person(String nombre, int dni) {
        this.edad = edad;
        this.peso = peso;
        this.nombre = nombre;
        this.dni = dni;
        cantidadInstancias++;
    }
    /*public int getcantidadInstancias() {
        return cantidadInstancias;
    }*/
}
