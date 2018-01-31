package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class feuillage {

    private int id_feuillage;
    private String libelle_feuillage;

    public feuillage(int id_feuillage, String libelle_feuillage) {
        this.id_feuillage = id_feuillage;
        this.libelle_feuillage = libelle_feuillage;
    }

    public int getId_feuillage() {
        return id_feuillage;
    }

    public void setId_feuillage(int id_feuillage) {
        this.id_feuillage = id_feuillage;
    }

    public String getLibelle_feuillage() {
        return libelle_feuillage;
    }

    public void setLibelle_feuillage(String libelle_feuillage) {
        this.libelle_feuillage = libelle_feuillage;
    }
}
