package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class nom_commun {

    private int id_nom_commun;
    private String libelle_nom_commun;

    public nom_commun(int id_nom_commun, String libelle_nom_commun) {
        this.id_nom_commun = id_nom_commun;
        this.libelle_nom_commun = libelle_nom_commun;
    }

    public int getId_nom_commun() {
        return id_nom_commun;
    }

    public void setId_nom_commun(int id_nom_commun) {
        this.id_nom_commun = id_nom_commun;
    }

    public String getLibelle_nom_commun() {
        return libelle_nom_commun;
    }

    public void setLibelle_nom_commun(String libelle_nom_commun) {
        this.libelle_nom_commun = libelle_nom_commun;
    }
}
