package Dominio;

public class Vinyl {
    private String Artista;
    private String titulo;
    private int anio;

    public Vinyl(String artist, String title, int year) {
        this.Artista = artist;
        this.titulo = title;
        this.anio = year;
    }

    public String getArtist() {
        return Artista;
    }

    public String getTitle() {
        return titulo;
    }

    public int getYear() {
        return anio;
    }

    @Override
    public String toString() {
        return "Artista: " + Artista + ", Título: " + titulo + ", Año: " + anio;
    }
}
