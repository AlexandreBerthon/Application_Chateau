package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class nom {

    private int id_nom;
    private String libelle_nom;

    public nom(int id_nom, String libelle_nom) {
        this.id_nom = id_nom;
        this.libelle_nom = libelle_nom;
    }

    public int getId_nom() {
        return id_nom;
    }

    public void setId_nom(int id_nom) {
        this.id_nom = id_nom;
    }

    public String getLibelle_nom() {
        return libelle_nom;
    }

    public void setLibelle_nom(String libelle_nom) {
        this.libelle_nom = libelle_nom;
    }
}
