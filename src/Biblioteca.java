import java.util.HashSet;

public class Biblioteca {

    private String nombre;
    private String ciudad;
    private HashSet<Libro> libros = new HashSet<>();

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

}
