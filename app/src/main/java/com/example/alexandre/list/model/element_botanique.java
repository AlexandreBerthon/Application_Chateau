package com.example.alexandre.list.model;

/**
 * Created by simon on 18/12/2017.
 */

public class element_botanique {
    private int id_element_botanique;
    private int id_type;
    private int id_nom_commun;
    private int id_feuillage;
    private int id_nom;
    private int id_lieu;
    private int id_genre;
    private int perimetre_element_botanique;
    private int diametre_element_botnanique;
    private int hauteur_element_botanique;
    private int annee_plantation_element_botanique;
    private String remarque_element_botanique;
    private double posx_element_botanique;
    private double posy_element_botanique;
    private String photo_element_botanique;
    private String texte_presentation_element_botanique;
    private String vue_element_botanique;
    private String audio_element_botanique;
    private boolean est_une_info;

    public element_botanique() {
    }

    public element_botanique(int id_element_botanique, int id_type, int id_nom_commun, int id_feuillage, int id_nom, int id_lieu, int id_genre, int perimetre_element_botanique, int diametre_element_botnanique, int hauteur_element_botanique, int annee_plantation_element_botanique, String remarque_element_botanique, double posx_element_botanique, double posy_element_botanique, String photo_element_botanique, String texte_presentation_element_botanique, String vue_element_botanique, String audio_element_botanique, boolean est_une_info) {
        this.id_element_botanique = id_element_botanique;
        this.id_type = id_type;
        this.id_nom_commun = id_nom_commun;
        this.id_feuillage = id_feuillage;
        this.id_nom = id_nom;
        this.id_lieu = id_lieu;
        this.id_genre = id_genre;
        this.perimetre_element_botanique = perimetre_element_botanique;
        this.diametre_element_botnanique = diametre_element_botnanique;
        this.hauteur_element_botanique = hauteur_element_botanique;
        this.annee_plantation_element_botanique = annee_plantation_element_botanique;
        this.remarque_element_botanique = remarque_element_botanique;
        this.posx_element_botanique = posx_element_botanique;
        this.posy_element_botanique = posy_element_botanique;
        this.photo_element_botanique = photo_element_botanique;
        this.texte_presentation_element_botanique = texte_presentation_element_botanique;
        this.vue_element_botanique = vue_element_botanique;
        this.audio_element_botanique = audio_element_botanique;
        this.est_une_info = est_une_info;
    }

    public String getAudio_element_botanique() {
        return audio_element_botanique;
    }

    public void setAudio_element_botanique(String audio_element_botanique) {
        this.audio_element_botanique = audio_element_botanique;
    }



    public int getId_type() {
        return id_type;
    }

    public int getId_nom_commun() {
        return id_nom_commun;
    }

    public int getId_feuillage() {
        return id_feuillage;
    }

    public int getId_nom() {
        return id_nom;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public int getId_genre() {
        return id_genre;
    }

    public int getId_element_botanique() {
        return id_element_botanique;
    }

    public void setId_element_botanique(int id_element_botanique) {
        this.id_element_botanique = id_element_botanique;
    }

    public int getPerimetre_element_botanique() {
        return perimetre_element_botanique;
    }

    public void setPerimetre_element_botanique(int perimetre_element_botanique) {
        this.perimetre_element_botanique = perimetre_element_botanique;
    }

    public int getDiametre_element_botnanique() {
        return diametre_element_botnanique;
    }

    public void setDiametre_element_botnanique(int diametre_element_botnanique) {
        this.diametre_element_botnanique = diametre_element_botnanique;
    }

    public int getHauteur_element_botanique() {
        return hauteur_element_botanique;
    }

    public void setHauteur_element_botanique(int hauteur_element_botanique) {
        this.hauteur_element_botanique = hauteur_element_botanique;
    }

    public int getAnnee_plantation_element_botanique() {
        return annee_plantation_element_botanique;
    }

    public void setAnnee_plantation_element_botanique(int annee_plantation_element_botanique) {
        this.annee_plantation_element_botanique = annee_plantation_element_botanique;
    }

    public String getRemarque_element_botanique() {
        return remarque_element_botanique;
    }

    public void setRemarque_element_botanique(String remarque_element_botanique) {
        this.remarque_element_botanique = remarque_element_botanique;
    }

    public double getPosx_element_botanique() {
        return posx_element_botanique;
    }

    public void setPosx_element_botanique(float posx_element_botanique) {
        this.posx_element_botanique = posx_element_botanique;
    }

    public double getPosy_element_botanique() {
        return posy_element_botanique;
    }

    public void setPosy_element_botanique(float posy_element_botanique) {
        this.posy_element_botanique = posy_element_botanique;
    }

    public String getPhoto_element_botanique() {
        return photo_element_botanique;
    }

    public void setPhoto_element_botanique(String photo_element_botanique) {
        this.photo_element_botanique = photo_element_botanique;
    }

    public String getTexte_presentation_element_botanique() {
        return texte_presentation_element_botanique;
    }

    public void setTexte_presentation_element_botanique(String texte_presentation_element_botanique) {
        this.texte_presentation_element_botanique = texte_presentation_element_botanique;
    }

    public String getVue_element_botanique() {
        return vue_element_botanique;
    }

    public void setVue_element_botanique(String vue_element_botanique) {
        this.vue_element_botanique = vue_element_botanique;
    }

    public boolean isEst_une_info() {
        return est_une_info;
    }

    public void setEst_une_info(boolean est_une_info) {
        this.est_une_info = est_une_info;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public void setId_nom_commun(int id_nom_commun) {
        this.id_nom_commun = id_nom_commun;
    }

    public void setId_feuillage(int id_feuillage) {
        this.id_feuillage = id_feuillage;
    }

    public void setId_nom(int id_nom) {
        this.id_nom = id_nom;
    }

    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }
}
