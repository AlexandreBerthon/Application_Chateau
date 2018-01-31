package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class type_botanique {

    private int id_type_botanique;
    private String libelle_type_botanique;

    public type_botanique(int id_type_botanique, String libelle_type_botanique) {
        this.id_type_botanique = id_type_botanique;
        this.libelle_type_botanique = libelle_type_botanique;
    }

    public int getId_type_botanique() {
        return id_type_botanique;
    }

    public void setId_type_botanique(int id_type_botanique) {
        this.id_type_botanique = id_type_botanique;
    }

    public String getLibelle_type_botanique() {
        return libelle_type_botanique;
    }

    public void setLibelle_type_botanique(String libelle_type_botanique) {
        this.libelle_type_botanique = libelle_type_botanique;
    }
}
