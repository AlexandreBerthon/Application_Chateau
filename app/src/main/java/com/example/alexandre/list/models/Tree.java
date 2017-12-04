package com.example.alexandre.list.models;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by Alexandre on 07/11/2017.
 */

public class Tree {

    private Drawable d;
    private String pseudo;
    private String text;

    public Tree(Drawable d, String pseudo, String text) {
        this.d = d;
        this.pseudo = pseudo;
        this.text = text;
    }

    public Drawable getD() { return d; }

    public void setD(Drawable d) {
        this.d = d;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
