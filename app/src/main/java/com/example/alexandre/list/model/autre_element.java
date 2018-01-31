package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class autre_element {

    private int id_autre_element;
    private int id_lieu;
    private String nom_atre_element;
    private String vue_sur_autre_element;
    private String description_autre_element;

    public autre_element() {
    }

    public autre_element(int id_lieu, String nom_atre_element, String vue_sur_autre_element, String description_autre_element) {
        this.id_lieu = id_lieu;
        this.nom_atre_element = nom_atre_element;
        this.vue_sur_autre_element = vue_sur_autre_element;
        this.description_autre_element = description_autre_element;
    }

    public autre_element(int id_autre_element, int id_lieu, String nom_atre_element, String vue_sur_autre_element, String description_autre_element) {
        this.id_autre_element = id_autre_element;
        this.id_lieu = id_lieu;
        this.nom_atre_element = nom_atre_element;
        this.vue_sur_autre_element = vue_sur_autre_element;
        this.description_autre_element = description_autre_element;
    }

    public int getId_autre_element() {
        return id_autre_element;
    }

    public void setId_autre_element(int id_autre_element) {
        this.id_autre_element = id_autre_element;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public String getNom_atre_element() {
        return nom_atre_element;
    }

    public void setNom_atre_element(String nom_atre_element) {
        this.nom_atre_element = nom_atre_element;
    }

    public String getVue_sur_autre_element() {
        return vue_sur_autre_element;
    }

    public void setVue_sur_autre_element(String vue_sur_autre_element) {
        this.vue_sur_autre_element = vue_sur_autre_element;
    }

    public String getDescription_autre_element() {
        return description_autre_element;
    }

    public void setDescription_autre_element(String description_autre_element) {
        this.description_autre_element = description_autre_element;
    }

    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
    }
}
