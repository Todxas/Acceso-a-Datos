package JSON;

public class Videojuego {
    private String titulo;
    private String plataforma;
    private int anio;

    public Videojuego(){
    }

    public Videojuego(String titulo, String plataforma, int anio){
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anio = anio;
    }
    @Override
    public String toString(){
        return "Titulo: " + titulo + ", Plataforma: " + plataforma + ", Anio: " + anio;
    }
}
