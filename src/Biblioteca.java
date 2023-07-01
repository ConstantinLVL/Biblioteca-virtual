import java.util.HashSet;
import java.util.Scanner;

/**
 * La clase "Biblioteca" representa una biblioteca con atributos como nombre, ciudad y un conjunto de libros representado
 * por un HashSet. La clase proporciona métodos para interactuar con la biblioteca, como agregar libros, eliminar libros,
 * mostrar los libros disponibles y buscar libros por autor o título.
 * @author David M.
 */
public class Biblioteca {

    private String nombre;
    private String ciudad;
    private HashSet<Libro> libros = new HashSet<>();
    private final Scanner sc = new Scanner(System.in);

    /**
     * Este constructor recibe dos parametros que inicializan los atributos de la clase Biblioteca e instancia un objeto
     * de tipo Biblioteca si las entradas son validas.
     * @author David M.
     * @param nombre Este parametro inicializa el atributo nombre de la clase Biblioteca cuando se quiere instanciar un objeto a partir de esta clase
     * @param ciudad Este parametro inicializa el atributo ciudad de la clase Biblioteca cuando se quiere instanciar un objeto a partir de esta clase
     */

    public Biblioteca(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    /**
     * Este metodo agrega un objeto Libro al HashSet del objeto Biblioteca que lo llama, dentro de su implementacion pide
     * ingresar por consola los atributos para crear un Libro y valida que las entradas sean validas para realizar la
     * insercion con el metodo add.
     * @author David M.
     * @param bibliotecaActual Este parametro que viene desde la clase Main en el metodo menuDeOpciones, se toma dentro de este metodo para llamar al metodo menuDeOpcion de la clase Main y pasarselo como parametro nuevamente.
     */
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

    /**
     * Este metodo agrega un objeto Libro al HashSet del objeto Biblioteca que lo llama, dentro de su implementacion valida
     * que las entradas que vienen desde el llamado sean validas y luego procede a agregar el objeto Libro al HashSet con el
     * metodo add - (este metodo solo se usa para ingresar manualmente objetos de tipo Libro al HashSet en el metodo Main)
     * @param titulo Este parametro inicializa el atributo titulo de la clase Libro cuando se quiere instanciar un objeto a partir de esta clase.
     * @param autor Este parametro inicializa el atributo autor de la clase Libro cuando se quiere instanciar un objeto a partir de esta clase.
     * @param genero Este parametro inicializa el atributo genero de la clase Libro cuando se quiere instanciar un objeto a partir de esta clase.
     * @param anhoPublicacion Este parametro inicializa el atributo anhoPublicacion de la clase Libro cuando se quiere instanciar un objeto a partir de esta clase.
     * @author David M.
     */
    public void agregraLibro(String titulo, String autor, String genero, short anhoPublicacion){
        if ( (titulo != null && autor != null && genero != null) ){
            if (Short.valueOf(anhoPublicacion).toString().length() == 4){
                this.libros.add(new Libro(titulo, autor, genero, anhoPublicacion));
            }
        }
    }

    /**
     * Este metodo elimina del HashSet un objeto Libro buscandolo por medio de su titulo, antes de proceder a eliminarlo
     * con el metodo remove verifica que el Libro exista dentro del HashSet.
     * @param bibliotecaActual Este parametro que viene desde la clase Main en el metodo menuDeOpciones, se toma dentro de este metodo para llamar al metodo menuDeOpcion de la clase Main y pasarselo como parametro nuevamente.
     * @author David M.
     */
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

    /**
     * Este metodo itera con un foreach el HashSet que contiene los objetos Libros, imprime todos los atributos de cada
     * objeto Libro formateados con el metodo toString.
     * @param bibliotecaActual Este parametro que viene desde la clase Main en el metodo menuDeOpciones, se toma dentro de este metodo para llamar al metodo menuDeOpcion de la clase Main y pasarselo como parametro nuevamente.
     * @author David M.
     */
    public void mostrarLibros(Biblioteca bibliotecaActual){
        for (Libro libro: this.libros){
            System.out.println("#----------------#");
            System.out.print(libro.toString() + "\n");
        }
        Main.menuDeOPciones(bibliotecaActual);
    }

    /**
     * Este metodo es la puerta de entrada a dos metodos de esta clase mediante un bloque swich donde se podra escoger que
     * metodo se quiere usar, busquedaPorAutor o busquedaPorTitulo para buscar algun libro dentro del HasMap de la Biblioteca
     * que los llama.
     * @param bibliotecaActual Este parametro que viene desde la clase Main en el metodo menuDeOpciones, se toma dentro de este metodo para llamar a cualquiera de los dos metodos opcionales que se pueden llamar desde este metodo, y pasarselo como parametro para que actuen en la misma Biblioteca que llama a este metodo.
     * @author David M.
     */
    public void buscarLibro(Biblioteca bibliotecaActual){
        System.out.println("Por medio de cual criterio desea buscar el libro: \n1. Autor \n2. Titulo");
        System.out.print("Elija una opcion: ");
        int opcionDeBusqueda = sc.nextInt();
        switch (opcionDeBusqueda) {
            case 1 -> busquedaPorAutor(bibliotecaActual);
            case 2 -> busquedaPorTitulo(bibliotecaActual);
            default -> {
                System.err.println("La opcion elegida no es valida, el programa se terminara");
                System.exit(0);
            }
        }
    }

    /**
     * Este metodo busca un Libro dentro del HashMap de la Biblioteca que lo llama con el nombre del autor como criterio de
     * busqueda.
     * @param bibliotecaActual Este parametro que viene desde la clase Main en el metodo menuDeOpciones, se toma dentro de este metodo para llamar al metodo menuDeOpcion de la clase Main y pasarselo como parametro nuevamente.
     * @author David M.
     */
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

    /**
     * Este metodo busca un Libro dentro del HashMap de la Biblioteca que lo llama con el titulo del libro como criterio de
     * busqueda.
     * @param bibliotecaActual Este parametro que viene desde la clase Main en el metodo menuDeOpciones, se toma dentro de este metodo para llamar al metodo menuDeOpcion de la clase Main y pasarselo como parametro nuevamente.
     * @author David M.
     */
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
}
