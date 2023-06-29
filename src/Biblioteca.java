import java.util.HashSet;
import java.util.Scanner;

public class Biblioteca {

    private String nombre;
    private String ciudad;
    private HashSet<Libro> libros = new HashSet<>();

    public Biblioteca(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public void agregraLibro(String titulo,String autor, String genero, short anhoPublicacion){
        boolean seIngreso = false;
        if ( (titulo != null && autor != null && genero != null) ){
            if (Short.valueOf(anhoPublicacion).toString().length() == 4){
                    seIngreso = this.libros.add(new Libro(titulo, autor, genero, anhoPublicacion));
            }
        }
        if (seIngreso) System.out.println("El libro se agrego a la Biblioteca de forma exitosa!");
        else System.out.println("El libro no se agrego a la Biblioteca, revisa que no exista y los requisitos para agregarlo");
    }

    public void eliminarLibro(String titulo){
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
            System.out.println(libro.toString());
        }
    }

    public void buscarLibro(String busqueda){
        Scanner sc = new Scanner(System.in);
        int opiconDeBusqueda = sc.nextInt();
        switch (opiconDeBusqueda) {
            case 1 -> busquedaPorAutor();
            case 2 -> busquedaPorTitulo();
        }
    }

    public void busquedaPorAutor(){
        Scanner sc = new Scanner(System.in);
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
            System.out.println("Se han encontrado " + coincidencias + " libros de acuerdo a su criterio de busqueda");
        } else System.out.println("Su criterio de busqueda no puede estar vacio");
    }

    public void busquedaPorTitulo(){
        Scanner sc = new Scanner(System.in);
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
            System.out.println("Se han encontrado " + coincidencias + " libros de acuerdo a su criterio de busqueda");
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
