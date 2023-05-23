import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Crea la lista de personas
        List<Persona> personas = new ArrayList<>();

        // Crea 5 objetos de tipo Persona con nombres y apellidos aleatorios
        Random rand = new Random();
        String[] nombres = {"Juan", "María", "José", "Ana", "Pedro", "Sofía", "Miguel", "Laura", "Diego", "Lucía"};
        String[] apellidos = {"González", "Rodríguez", "Martínez", "Pérez", "Sánchez", "García", "López", "Fernández", "Moreno", "Jiménez"};

        for (int i = 0; i < 5; i++) {
            String nombre = nombres[rand.nextInt(nombres.length)];
            String apellido = apellidos[rand.nextInt(apellidos.length)];
            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            personas.add(persona);
        }

        // Ordenar lista alfabéticamente por nombre
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });

        // Mostrar lista ordenada por nombre
        System.out.println("Ordenado por nombre:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " " + persona.getApellido());
        }
        System.out.println("--------------------------");

        // Ordenar lista alfabéticamente por apellido
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getApellido().compareTo(p2.getApellido());
            }
        });

        // Mostrar lista ordenada por apellido
        System.out.println("Ordenado por apellido:");
        for (Persona persona : personas) {
            System.out.println(persona.getApellido() + ", " + persona.getNombre());
        }
        System.out.println("--------------------------");

        // Ordenar lista inversamente por apellido
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p2.getApellido().compareTo(p1.getApellido());
            }
        });

        // Mostrar lista ordenada inversamente por apellido
        System.out.println("Ordenado inversamente por apellido:");
        for (Persona persona : personas) {
            System.out.println(persona.getApellido() + ", " + persona.getNombre());
        }
        System.out.println("--------------------------");
    }

}