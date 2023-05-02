public class Employee extends Person {
    private int vacations;
    private float salary;
    private int hoursWorked;

    public Employee(int age, float weight, String name, String dni, int vacations, float salary, int hoursWorked) {
        super(age, weight, name, dni);
        this.vacations = vacations;
        this.salary = salary;
        this.hoursWorked = hoursWorked;
    }

    public Employee(String name, String dni) {
        super(name, dni);
    }

    public void clockHours(int hours) {
        hoursWorked += hours;
    }

    // Override del método toString() de la clase Object
    @Override
    public String toString() {
        return super.toString() + ", vacations=" + vacations + ", salary=" + salary + ", hoursWorked=" + hoursWorked;
    }
}