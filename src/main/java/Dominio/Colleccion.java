package Dominio;

import java.util.ArrayList;

public class Colleccion {

    private ArrayList<Vinyl> collection;
    private final int MAX_SIZE = 100;

    public Colleccion() {
        collection = new ArrayList<>(MAX_SIZE);
    }

    public boolean addVinyl(Vinyl vinyl) {
        if (collection.size() < MAX_SIZE) {
            collection.add(vinyl);
            return true;
        }
        return false;
    }

    public Vinyl searchByArtist(String artist) {
        for (Vinyl v : collection) {
            if (v.getArtist().equalsIgnoreCase(artist)) {
                return v;
            }
        }
        return null;
    }

    public Vinyl searchByTitle(String title) {
        for (Vinyl v : collection) {
            if (v.getTitle().equalsIgnoreCase(title)) {
                return v;
            }
        }
        return null;
    }

    public boolean removeVinyl(String artist, String title) {
        for (Vinyl v : collection) {
            if (v.getArtist().equalsIgnoreCase(artist) && v.getTitle().equalsIgnoreCase(title)) {
                collection.remove(v);
                return true;
            }
        }
        return false;
    }

    public int getVinylCount() {
        return collection.size();
    }

    public int getAvailableSpace() {
        return MAX_SIZE - collection.size();
    }

    public ArrayList<Vinyl> getAllVinyls() {
        return collection;
    }
}

