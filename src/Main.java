import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Biblioteca bibliotecaBarcelona = new Biblioteca("Biblioteca publica de Barcelona", "Barcelona");
        bibliotecaBarcelona.agregraLibro("La sombra del viento", "Carlos Ruiz Zafón", "Misterio", (short) 2001);
        bibliotecaBarcelona.agregraLibro("1984", "George Orwell", "Ciencia ficción", (short) 1949);
        bibliotecaBarcelona.agregraLibro("El código Da Vinci", "Dan Brown", "Suspense", (short) 2003);
        bibliotecaBarcelona.agregraLibro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", (short) 1967);
        bibliotecaBarcelona.agregraLibro("El alquimista", "Paulo Coelho", "Ficción espiritual", (short) 1988);
        bibliotecaBarcelona.agregraLibro("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía", (short) 1997);
        bibliotecaBarcelona.agregraLibro("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela", (short) 1605);
        bibliotecaBarcelona.agregraLibro("Orgullo y prejuicio", "Jane Austen", "Romance", (short) 1813);
        bibliotecaBarcelona.agregraLibro("El señor de los anillos", "J.R.R. Tolkien", "Fantasía épica", (short) 1954);
        bibliotecaBarcelona.agregraLibro("Crónica de una muerte anunciada", "Gabriel García Márquez", "Novela", (short) 1981);

        Biblioteca bibliotecaBarranquilla = new Biblioteca("Biblioteca publica de Barranquilla", "Barranquilla");
        bibliotecaBarranquilla.agregraLibro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", (short) 1967);
        bibliotecaBarranquilla.agregraLibro("El beso de la mujer araña", "Manuel Puig", "Ficción", (short) 1976);
        bibliotecaBarranquilla.agregraLibro("La sombra del viento", "Carlos Ruiz Zafón", "Misterio", (short) 2001);
        bibliotecaBarranquilla.agregraLibro("El amor en los tiempos del cólera", "Gabriel García Márquez", "Novela", (short) 1985);
        bibliotecaBarranquilla.agregraLibro("Ficciones", "Jorge Luis Borges", "Ficción", (short) 1944);
        bibliotecaBarranquilla.agregraLibro("Cien sonetos de amor", "Pablo Neruda", "Poesía", (short) 1959);
        bibliotecaBarranquilla.agregraLibro("Rayuela", "Julio Cortázar", "Ficción", (short) 1963);
        bibliotecaBarranquilla.agregraLibro("Los detectives salvajes", "Roberto Bolaño", "Novela", (short) 1998);
        bibliotecaBarranquilla.agregraLibro("Pedro Páramo", "Juan Rulfo", "Novela", (short) 1955);
        bibliotecaBarranquilla.agregraLibro("La fiesta del chivo", "Mario Vargas Llosa", "Novela histórica", (short) 2000);

        System.out.println("En que ciudad te encuentras? \n1. Barcelona \n2. Barranquilla");
        int ciudad = sc.nextInt();

        switch (ciudad) {
            case 1 -> menuDeOPciones(bibliotecaBarcelona);
            case 2 -> menuDeOPciones(bibliotecaBarranquilla);
            default -> {
                System.err.println("La opcion elegida no es valida, el programa se terminara");
                System.exit(0);
            }
        }
    }

    public static void menuDeOPciones(Biblioteca ciudadBiblioteca){
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de opciones: " +
                "\n1. Agregar un libro" +
                "\n2. Eliminar un libro." +
                "\n3. Buscar libro" +
                "\n4. Mostar todos los libros");

        System.out.print("Que desea realizar: ");
        int opcion = sc.nextInt();

        switch (opcion){
            case 1 -> ciudadBiblioteca.agregraLibro(ciudadBiblioteca);
            case 2 -> ciudadBiblioteca.eliminarLibro(ciudadBiblioteca);
            case 3 -> ciudadBiblioteca.buscarLibro(ciudadBiblioteca);
            case 4 -> ciudadBiblioteca.mostrarLibros(ciudadBiblioteca);
            default -> {
                System.err.println("La opcion elegida no es valida, el programa terminara");
                System.exit(0);
            }
        }
    }

}
