/**
 * La clase "Libro" representa un libro con atributos como título, autor, género y año de publicación. Esta clase proporciona
 * métodos para acceder a algunos de los atributos del libro y formatear la información del libro para su visualización.
 * @author David M.
 */
public class Libro {

    private String titulo;
    private String autor;
    private String genero;
    private short anhoPublicacion;

    public Libro(String titulo, String autor, String genero, short anhoPublicacion){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anhoPublicacion = anhoPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    /**
     * Este metodo sobreescrito formatea la salida de los atributos de un objeto Libro.
     * @return Devuelve la informacion de un objeto Libro formateada lista para imprimirse en consola.
     * @author David M.
     */
    @Override
    public String toString() {
        return "Titulo: " + titulo +
                "\nAutor: " + autor +
                "\nGenero: " + genero +
                "\nAño de publicacion: " + anhoPublicacion + "\n";
    }
}
