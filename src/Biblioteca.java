import java.util.HashSet;
import java.util.Scanner;

public class Biblioteca {

    private String nombre;
    private String ciudad;
    private HashSet<Libro> libros = new HashSet<>();
    private Scanner sc = new Scanner(System.in);

    public Biblioteca(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public void agregraLibro(Biblioteca bibliotecaActual){
        System.out.print("Ingresa el titulo del libro: ");
        String titulo = sc.nextLine();
        System.out.print("Ingresa el nombre del autor del libro: ");
        String autor = sc.nextLine();
        System.out.print("Ingresa el genero del libro: ");
        String genero = sc.nextLine();
        System.out.print("Ingresa el año de publicacion del libro (4 digitos): ");
        short anhoPublicacion = sc.nextShort();
        boolean seIngreso = false;
        if ( (titulo != null && autor != null && genero != null) ){
            if (Short.valueOf(anhoPublicacion).toString().length() == 4){
                    seIngreso = this.libros.add(new Libro(titulo, autor, genero, anhoPublicacion));
            }
        }
        if (seIngreso) System.out.println("El libro se agrego a la Biblioteca de forma exitosa!\n");
        else System.err.println("El libro no se agrego a la Biblioteca, revisa que no exista y que hayas proporcionado la informacion correcta\n");
        Main.menuDeOPciones(bibliotecaActual);
    }

    public void agregraLibro(String titulo, String autor, String genero, short anhoPublicacion){
        if ( (titulo != null && autor != null && genero != null) ){
            if (Short.valueOf(anhoPublicacion).toString().length() == 4){
                this.libros.add(new Libro(titulo, autor, genero, anhoPublicacion));
            }
        }
    }

    public void eliminarLibro(Biblioteca bibliotecaActual){
        System.out.print("Ingrese el titulo del libro que desea eliminar: ");
        String titulo = sc.nextLine();
        if (titulo != null){
            for (Libro libro: this.libros) {
                if ( libro.getTitulo().equals(titulo) ){
                    this.libros.remove(libro);
                    System.out.println("Se elimino el libro exitosamente!\n");
                    break;
                }
            }
        }
        Main.menuDeOPciones(bibliotecaActual);
    }

    public void mostrarLibros(Biblioteca bibliotecaActual){
        for (Libro libro: this.libros){
            System.out.println("#----------------#");
            System.out.print(libro.toString() + "\n");
        }
        Main.menuDeOPciones(bibliotecaActual);
    }

    public void buscarLibro(Biblioteca bibliotecaActual){
        System.out.println("Por medio de cual criterio desea buscar el libro: \n1. Autor \n2. Titulo");
        System.out.print("Elija una opcion: ");
        int opiconDeBusqueda = sc.nextInt();
        switch (opiconDeBusqueda) {
            case 1 -> busquedaPorAutor(bibliotecaActual);
            case 2 -> busquedaPorTitulo(bibliotecaActual);
            default -> {
                System.err.println("La opcion elegida no es valida, el programa se terminara");
                System.exit(0);
            }
        }
    }

    public void busquedaPorAutor(Biblioteca bibliotecaActual){
        System.out.print("Ingrese el autor del libro que busca: ");
        sc.nextLine(); // Consumir el carácter de nueva línea pendiente
        String busquedaAutor = sc.nextLine();
        int coincidencias = 0;

        if (busquedaAutor != null){
            for (Libro libro: this.libros) {
                if (libro.getAutor().equals(busquedaAutor)) {
                    System.out.println();
                    System.out.println(libro);
                    coincidencias++;
                }
            }
            System.out.println("Se han encontrado " + coincidencias + " libro(s) en la biblioteca: " + this.nombre +  ", de acuerdo a su criterio de busqueda\n");
        } else System.out.println("Su criterio de busqueda no puede estar vacio\n");
        Main.menuDeOPciones(bibliotecaActual);
    }

    public void busquedaPorTitulo(Biblioteca bibliotecaActual){
        System.out.print("Ingrese el titulo del libro que busca: ");
        sc.nextLine(); // Consumir el carácter de nueva línea pendiente
        String busquedaTitulo = sc.nextLine();
        int coincidencias = 0;
        if (busquedaTitulo != null){
            for (Libro libro: this.libros) {
                if (libro.getTitulo().equals(busquedaTitulo)) {
                    System.out.println();
                    System.out.println(libro);
                    coincidencias++;
                }
            }
            System.out.println("Se han encontrado " + coincidencias + " libro(s) en la biblioteca: " + this.nombre +  ", de acuerdo a su criterio de busqueda\n");
        } else System.out.println("Su criterio de busqueda no puede estar vacio\n");
        Main.menuDeOPciones(bibliotecaActual);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

}
