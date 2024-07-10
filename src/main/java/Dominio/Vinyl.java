package Dominio;

public class Vinyl {
    private String artista;
    private String titulo;
    private int ano;

    public Vinyl(String artista, String titulo, int ano) {
        this.artista = artista;
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getArtista() {
        return artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Artista: " + artista + ", Título: " + titulo + ", Año: " + ano;
    }
}
