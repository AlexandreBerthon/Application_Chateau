package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class element_photographique {

    private int id_element_photographique;
    private int id_lieu;
    private String vue_element_photographique;
    private String commentaire;
    private float posx_element_photographique;
    private float posy_element_photographique;
    private String photo_element_photographique;

    public element_photographique() {
    }

    public element_photographique(int id_element_photographique, int id_lieu, String vue_element_photographique, String commentaire, float posx_element_photographique, float posy_element_photographique, String photo_element_photographique) {
        this.id_element_photographique = id_element_photographique;
        this.id_lieu = id_lieu;
        this.vue_element_photographique = vue_element_photographique;
        this.commentaire = commentaire;
        this.posx_element_photographique = posx_element_photographique;
        this.posy_element_photographique = posy_element_photographique;
        this.photo_element_photographique = photo_element_photographique;
    }

    public int getId_element_photographique() {
        return id_element_photographique;
    }

    public void setId_element_photographique(int id_element_photographique) {
        this.id_element_photographique = id_element_photographique;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public String getVue_element_photographique() {
        return vue_element_photographique;
    }

    public void setVue_element_photographique(String vue_element_photographique) {
        this.vue_element_photographique = vue_element_photographique;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public float getPosx_element_photographique() {
        return posx_element_photographique;
    }

    public void setPosx_element_photographique(float posx_element_photographique) {
        this.posx_element_photographique = posx_element_photographique;
    }

    public float getPosy_element_photographique() {
        return posy_element_photographique;
    }

    public void setPosy_element_photographique(float posy_element_photographique) {
        this.posy_element_photographique = posy_element_photographique;
    }

    public String getPhoto_element_photographique() {
        return photo_element_photographique;
    }

    public void setPhoto_element_photographique(String photo_element_photographique) {
        this.photo_element_photographique = photo_element_photographique;
    }

    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
    }
}
