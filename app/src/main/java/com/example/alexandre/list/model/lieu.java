package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class lieu {

    private int id_lieu;
    private String libelle_lieu;

    public lieu() {
    }

    public lieu(String libelle_lieu) {
        this.libelle_lieu = libelle_lieu;
    }

    public lieu(int id_lieu, String libelle_lieu) {
        this.id_lieu = id_lieu;
        this.libelle_lieu = libelle_lieu;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
    }

    public String getLibelle_lieu() {
        return libelle_lieu;
    }

    public void setLibelle_lieu(String libelle_lieu) {
        this.libelle_lieu = libelle_lieu;
    }
}
