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

    public void agregraLibro(){
        System.out.println("Ingresa el titulo del libro");
        String titulo = sc.nextLine();
        System.out.println("Ingresa el nombre del autor del libro");
        String autor = sc.nextLine();
        System.out.println("Ingresa el genero del libro");
        String genero = sc.nextLine();
        System.out.println("Ingresa el ano de publicacion del libro");
        short anhoPublicacion = sc.nextShort();
        boolean seIngreso = false;
        if ( (titulo != null && autor != null && genero != null) ){
            if (Short.valueOf(anhoPublicacion).toString().length() == 4){
                    seIngreso = this.libros.add(new Libro(titulo, autor, genero, anhoPublicacion));
            }
        }
        if (seIngreso) System.out.println("El libro se agrego a la Biblioteca de forma exitosa!");
        else System.out.println("El libro no se agrego a la Biblioteca, revisa que no exista y los requisitos para agregarlo");
    }

    public void agregraLibro(String titulo, String autor, String genero, short anhoPublicacion){
        if ( (titulo != null && autor != null && genero != null) ){
            if (Short.valueOf(anhoPublicacion).toString().length() == 4){
                this.libros.add(new Libro(titulo, autor, genero, anhoPublicacion));
            }
        }
    }

    public void eliminarLibro(){
        System.out.print("Ingrese el titulo del libro que desea eliminar: ");
        String titulo = sc.next();
        if (titulo != null){
            for (Libro libro: this.libros) {
                if ( libro.getTitulo().equals(titulo) ){
                    this.libros.remove(libro);
                    System.out.println("Se elimino el libro exitosamente");
                    break;
                }
            }
        }
    }

    public void mostrarLibros(){
        for (Libro libro: this.libros){
            System.out.println(libro.toString() + "\n");
        }
    }

    public void buscarLibro(){
        System.out.println("Por medio de cual criterio desea buscar el libro: \n1. Autor \n2. Titulo");
        System.out.print("Elija una opcion: ");
        int opiconDeBusqueda = sc.nextInt();
        switch (opiconDeBusqueda) {
            case 1 -> busquedaPorAutor();
            case 2 -> busquedaPorTitulo();
        }
    }

    public void busquedaPorAutor(){
        System.out.print("Ingrese el autor del libro que busca: ");
        String busquedaAutor = sc.nextLine();
        int coincidencias = 0;
        if (busquedaAutor != null){
            for (Libro libro: this.libros) {
                if (libro.getAutor().equals(busquedaAutor)) {
                    System.out.println(libro);
                    coincidencias++;
                }
            }
            System.out.println("Se han encontrado " + coincidencias + " libros en la biblioteca: " + this.nombre +  ", de acuerdo a su criterio de busqueda");
        } else System.out.println("Su criterio de busqueda no puede estar vacio");
    }

    public void busquedaPorTitulo(){
        System.out.print("Ingrese el titulo del libro que busca: ");
        String busquedaTitulo = sc.nextLine();
        int coincidencias = 0;
        if (busquedaTitulo != null){
            for (Libro libro: this.libros) {
                if (libro.getTitulo().equals(busquedaTitulo)) {
                    System.out.println(libro);
                    coincidencias++;
                }
            }
            System.out.println("Se han encontrado " + coincidencias + " libros en la biblioteca: " + this.nombre +  ", de acuerdo a su criterio de busqueda");
        } else System.out.println("Su criterio de busqueda no puede estar vacio");
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
