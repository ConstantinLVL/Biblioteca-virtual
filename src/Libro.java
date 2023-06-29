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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public short getAnhoPublicacion() {
        return anhoPublicacion;
    }

    public void setAnhoPublicacion(short anhoPublicacion) {
        this.anhoPublicacion = anhoPublicacion;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
                "\nAutor: " + autor +
                "\nGenero: " + genero +
                "\nAño de publicacion: " + anhoPublicacion + "\n";
    }
}
