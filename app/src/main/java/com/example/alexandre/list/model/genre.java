package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class genre {

    private int id_genre;
    private String libelle_genre;

    public genre(int id_genre, String libelle_genre) {
        this.id_genre = id_genre;
        this.libelle_genre = libelle_genre;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public String getLibelle_genre() {
        return libelle_genre;
    }

    public void setLibelle_genre(String libelle_genre) {
        this.libelle_genre = libelle_genre;
    }
}
