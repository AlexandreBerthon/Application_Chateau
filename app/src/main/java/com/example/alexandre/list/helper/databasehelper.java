package com.example.alexandre.list.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.alexandre.list.model.autre_element;
import com.example.alexandre.list.model.element_botanique;
import com.example.alexandre.list.model.element_photographique;
import com.example.alexandre.list.model.feuillage;
import com.example.alexandre.list.model.genre;
import com.example.alexandre.list.model.lieu;
import com.example.alexandre.list.model.nom;
import com.example.alexandre.list.model.nom_commun;
import com.example.alexandre.list.model.type_botanique;

/**
 * Created by simon on 18/12/2017.
 */

public class databasehelper extends SQLiteOpenHelper{

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "SassenageAndroid";

    // Table Names
    private static final String TABLE_AUTRE_ELEMENT = "autre_element";
    private static final String TABLE_ELEMENT_PHOTOGRAPHIQUE = "element_photographique";
    private static final String TABLE_GENRE = "genre";
    private static final String TABLE_FEUILLAGE = "feuillage";
    private static final String TABLE_TYPE_BOTANIQUE = "type_botanique";
    private static final String TABLE_ELEMENT_BOTANIQUE = "element_botanique";
    private static final String TABLE_NOM = "nom";
    private static final String TABLE_NOM_COMMUN = "nom_commun";
    private static final String TABLE_LIEU = "lieu";

    // AUTRE_ELEMENT Table - column names
    private static final String KEY_ID_AUTRE_ELEMENT = "id_autre_element";
    private static final String KEY_ID_LIEU_AUTRE_ELEMENT = "id_lieu";
    private static final String KEY_NOM_AUTRE_ELEMENT = "nom_autre_element";
    private static final String KEY_VUE_SUR_AUTRE_ELEMENT = "vue_sur_autre_element";
    private static final String KEY_DESCRIPTION_AUTRE_ELEMENT = "description_autre_element";

    // ELEMENT_PHOTOGRAPHIQUE Table - column names
    private static final String KEY_ID_ELEMENT_PHOTOGRAPHIQUE = "id_element_photographique";
    private static final String KEY_ID_LIEU_ELEMENT_PHOTOGRAPHQIUE = "id_lieu";
    private static final String KEY_VUE_ELEMENT_PHOTOGRPAHIQUE = "vue_element_photographique";
    private static final String KEY_COMMENTAIRE = "commentaire";
    private static final String KEY_POSX_ELEMENT_PHOTOGRAPHIQUE = "posx_element_photographique";
    private static final String KEY_POSY_ELEMENT_PHOTOGRAPHIQUE = "posy_element_photographique";
    private static final String KEY_PHOTO_ELEMENT_PHOTOGRAPHIQUE = "photo_element_photographique";

    // GENRE table - column names
    private static final String KEY_ID_GENRE = "id_genre";
    private static final String KEY_LIBELLE_GENRE = "libelle_genre";

    // FEUILLAGE table - column names
    private static final String KEY_ID_FEUILLAGE = "id_feuillage";
    private static final String KEY_LIBELLE_FEUILLAGE = "libelle_feuillage";

    // TYPE table - column names
    private static final String KEY_ID_TYPE_BOTANIQUE = "id_type_botanique";
    private static final String KEY_LIBELLE_TYPE_BOTANIQUE = "libelle_type_botanique";

    // ELEMENT_BOTANIQUE table - column names
    private static final String KEY_ID_ELEMENT_BOTANIQUE = "id_element_botanique";
    private static final String KEY_ID_TYPE_BOTANIQUE_ELEMENT_BOTANIQUE = "id_type_botanique";
    private static final String KEY_ID_NOM_COMMUN_ELEMENT_BOTANIQUE = "id_nom_commun";
    private static final String KEY_ID_FEUILLAGE_ELEMENT_BOTANIQUE = "id_feuillage";
    private static final String KEY_ID_NOM_ELEMENT_BOTANIQUE = "id_nom";
    private static final String KEY_ID_LIEU_ELEMENT_BOTANIQUE = "id_lieu";
    private static final String KEY_ID_GENRE_ELEMENT_BOTANIQUE = "id_genre";
    private static final String KEY_PERIMETRE_ELEMENT_BOTANIQUE = "perimetre_element_botanique";
    private static final String KEY_DIAMETRE_ELEMENT_BOTANIQUE = "diametre_element_botanique";
    private static final String KEY_HAUTEUR_ELEMENT_BOTANIQUE = "hauteur_element_botanique";
    private static final String KEY_ANNEE_PLANTATION_ELEMENT_BOTANIQUE = "annee_plantation_element_botanique";
    private static final String KEY_REMARQUE_ELEMENT_BOTANIQUE = "remarque_element_botanique";
    private static final String KEY_POSX_ELEMENT_BOTANIQUE = "posx_element_botanique";
    private static final String KEY_POSY_ELEMENT_BOTANIQUE = "posy_element_botanique";
    private static final String KEY_PHOTO_ELEMENT_BOTANIQUE = "photo_element_botanique";
    private static final String KEY_TEXTE_PRESENTATION_ELEMENT_BOTANIQUE = "texte_presentation_element_botanique";
    private static final String KEY_VUE_ELEMENT_BOTANIQUE = "vue_element_botanique";
    private static final String KEY_EST_UNE_INFO = "est_une_info";

    // NOM Table - column names
    private static final String KEY_ID_NOM = "id_nom";
    private static final String KEY_LIBELLE_NOM = "libelle_nom";

    // NOM_COMMUN Table - column names
    private static final String KEY_ID_NOM_COMMUN = "id_nom_commun";
    private static final String KEY_LIBELLE_NOM_COMMUN = "libelle_nom_commun";

    // LIEU Table - column names
    private static final String KEY_ID_LIEU = "id_lieu";
    private static final String KEY_LIBELLE_LIEU = "libelle_lieu";

    //********Table Create Statements********//
    // AUTRE_ELEMENT table create statement
    private static final String CREATE_TABLE_AUTRE_ELEMENT =
            "CREATE TABLE " + TABLE_AUTRE_ELEMENT
            + "("
            + KEY_ID_AUTRE_ELEMENT + " INTEGER PRIMARY KEY,"
            + KEY_ID_LIEU_AUTRE_ELEMENT + " INTEGER,"
            + KEY_NOM_AUTRE_ELEMENT + " TEXT,"
            + KEY_VUE_SUR_AUTRE_ELEMENT + " TEXT,"
            + KEY_DESCRIPTION_AUTRE_ELEMENT + " TEXT,"
            + "FOREIGN KEY(" + KEY_ID_LIEU_AUTRE_ELEMENT + ")"
            + " REFERENCES " + TABLE_LIEU + "(" + KEY_ID_LIEU + ")"
            + ");";


    // ELEMENT_PHOTOGRAPHIQUE table create statement
    private static final String CREATE_TABLE_ELEMENT_PHOTOGRAPHIQUE =
            "CREATE TABLE " + TABLE_ELEMENT_PHOTOGRAPHIQUE
            + "("
            + KEY_ID_ELEMENT_PHOTOGRAPHIQUE + " INTEGER PRIMARY KEY,"
            + KEY_ID_LIEU_ELEMENT_PHOTOGRAPHQIUE + " INTEGER,"
            + KEY_VUE_ELEMENT_PHOTOGRPAHIQUE + " TEXT,"
            + KEY_COMMENTAIRE + " TEXT,"
            + KEY_POSX_ELEMENT_PHOTOGRAPHIQUE + " REAL,"
            + KEY_POSY_ELEMENT_PHOTOGRAPHIQUE + " REAL,"
            + KEY_PHOTO_ELEMENT_PHOTOGRAPHIQUE + " TEXT,"
            + "FOREIGN KEY(" + KEY_ID_LIEU_ELEMENT_PHOTOGRAPHQIUE + ")"
            + " REFERENCES " + TABLE_LIEU + "(" + KEY_ID_LIEU + ")"
            + ");";

    // GENRE table create statement
    private static final String CREATE_TABLE_GENRE =
            "CREATE TABLE " + TABLE_GENRE
            + "("
            + KEY_ID_GENRE + " INTEGER PRIMARY KEY,"
            + KEY_LIBELLE_GENRE + " TEXT"
            + ");";

    // FEUILLAGE table create statement
    private static final String CREATE_TABLE_FEUILLAGE =
            "CREATE TABLE " + TABLE_FEUILLAGE
            + "("
            + KEY_ID_FEUILLAGE + " INTEGER PRIMARY KEY,"
            + KEY_LIBELLE_FEUILLAGE + " TEXT"
            + ");";

    //TYPE_BOTANIQUE table create statement
    private static final String CREATE_TABLE_TYPE_BOTANIQUE =
            "CREATE TABLE " + TABLE_TYPE_BOTANIQUE
            + "("
            + KEY_ID_TYPE_BOTANIQUE + " INTEGER PRIMARY KEY,"
            + KEY_LIBELLE_TYPE_BOTANIQUE + " TEXT"
            + ");";

    // ELEMENT_BOTANIQUE table create statement
    private static final String CREATE_TABLE_ELEMENT_BOTANIQUE =
            "CREATE TABLE " + TABLE_ELEMENT_BOTANIQUE
            + "("
            + KEY_ID_ELEMENT_BOTANIQUE + " INTEGER PRIMARY KEY,"
            + KEY_ID_TYPE_BOTANIQUE_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_ID_NOM_COMMUN_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_ID_FEUILLAGE_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_ID_NOM_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_ID_LIEU_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_ID_GENRE_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_PERIMETRE_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_DIAMETRE_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_HAUTEUR_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_ANNEE_PLANTATION_ELEMENT_BOTANIQUE + " INTEGER,"
            + KEY_REMARQUE_ELEMENT_BOTANIQUE + " TEXT,"
            + KEY_POSX_ELEMENT_BOTANIQUE + " REAL,"
            + KEY_POSY_ELEMENT_BOTANIQUE + " REAL,"
            + KEY_PHOTO_ELEMENT_BOTANIQUE + " TEXT,"
            + KEY_TEXTE_PRESENTATION_ELEMENT_BOTANIQUE + " TEXT,"
            + KEY_VUE_ELEMENT_BOTANIQUE + " TEXT,"
            + KEY_EST_UNE_INFO + " NUMERIC,"
            + "FOREIGN KEY(" + KEY_ID_TYPE_BOTANIQUE_ELEMENT_BOTANIQUE + ")"
            + " REFERENCES " + TABLE_TYPE_BOTANIQUE + "(" + KEY_ID_TYPE_BOTANIQUE + "),"
            + "FOREIGN KEY(" + KEY_ID_NOM_COMMUN_ELEMENT_BOTANIQUE + ")"
            + " REFERENCES " + TABLE_NOM_COMMUN + "(" + KEY_ID_NOM_COMMUN + "),"
            + "FOREIGN KEY(" + KEY_ID_FEUILLAGE_ELEMENT_BOTANIQUE + ")"
            + " REFERENCES " + TABLE_FEUILLAGE + "(" + KEY_ID_FEUILLAGE + "),"
            + "FOREIGN KEY(" + KEY_ID_NOM_ELEMENT_BOTANIQUE + ")"
            + " REFERENCES " + TABLE_NOM + "(" + KEY_ID_NOM + "),"
            + "FOREIGN KEY(" + KEY_ID_LIEU_ELEMENT_BOTANIQUE + ")"
            + " REFERENCES " + TABLE_LIEU + "(" + KEY_ID_LIEU + "),"
            + "FOREIGN KEY(" + KEY_ID_GENRE_ELEMENT_BOTANIQUE + ")"
            + " REFERENCES " + TABLE_GENRE + "(" + KEY_ID_GENRE + ")"
            + ");";

    // NOM table create statement
    private static final String CREATE_TABLE_NOM =
            "CREATE TABLE " + TABLE_NOM
            + "("
            + KEY_ID_NOM + " INTEGER PRIMARY KEY,"
            + KEY_LIBELLE_NOM + " TEXT"
            + ");";

    // NOM_COMMUN table create statement
    private static final String CREATE_TABLE_NOM_COMMUN =
            "CREATE TABLE " + TABLE_NOM_COMMUN
            + "("
            + KEY_ID_NOM_COMMUN + " INTEGER PRIMARY KEY,"
            + KEY_LIBELLE_NOM_COMMUN + " TEXT"
            + ");";

    // LIEU table create statement
    private static final String CREATE_TABLE_LIEU =
            "CREATE TABLE " + TABLE_LIEU
            + "("
            + KEY_ID_LIEU + " INTEGER PRIMARY KEY,"
            + KEY_LIBELLE_LIEU + " TEXT"
            + ");";

    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating tables
        db.execSQL(CREATE_TABLE_LIEU);
        db.execSQL(CREATE_TABLE_NOM_COMMUN);
        db.execSQL(CREATE_TABLE_NOM);
        db.execSQL(CREATE_TABLE_TYPE_BOTANIQUE);
        db.execSQL(CREATE_TABLE_FEUILLAGE);
        db.execSQL(CREATE_TABLE_GENRE);
        db.execSQL(CREATE_TABLE_AUTRE_ELEMENT);
        db.execSQL(CREATE_TABLE_ELEMENT_PHOTOGRAPHIQUE);
        db.execSQL(CREATE_TABLE_ELEMENT_BOTANIQUE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIEU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOM_COMMUN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TYPE_BOTANIQUE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FEUILLAGE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GENRE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AUTRE_ELEMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ELEMENT_PHOTOGRAPHIQUE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ELEMENT_BOTANIQUE);
        // create new tables
        onCreate(db);
    }

    //***********************************************************************************//
    //                                     METHODS                                       //
    //***********************************************************************************//

    //----------- AUTRE_ELEMENT table methods -----------//

    // Create an AUTRE_ELEMENT
    public long createAutreElement(autre_element autre_element) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_LIEU_AUTRE_ELEMENT, autre_element.getId_lieu());
        values.put(KEY_NOM_AUTRE_ELEMENT, autre_element.getNom_atre_element());
        values.put(KEY_VUE_SUR_AUTRE_ELEMENT, autre_element.getVue_sur_autre_element());
        values.put(KEY_DESCRIPTION_AUTRE_ELEMENT, autre_element.getDescription_autre_element());

        long autre_element_id = db.insert(TABLE_AUTRE_ELEMENT, null, values);

        return autre_element_id;
    }

    // Get all AUTRE_ELEMENT
    public List<autre_element> getAllautreElements() {
        List<autre_element> autresElements = new ArrayList<autre_element>();
        String selectQuery = "SELECT * FROM " + TABLE_AUTRE_ELEMENT;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through rows + adding to list
        if(cursor.moveToFirst()) {
            do {
                autre_element ae = new autre_element();

                ae.setId_autre_element(cursor.getInt(cursor.getColumnIndex(KEY_ID_AUTRE_ELEMENT)));
                ae.setId_lieu(cursor.getInt(cursor.getColumnIndex(KEY_ID_LIEU_AUTRE_ELEMENT)));
                ae.setNom_atre_element(cursor.getString(cursor.getColumnIndex(KEY_NOM_AUTRE_ELEMENT)));
                ae.setVue_sur_autre_element(cursor.getString(cursor.getColumnIndex(KEY_VUE_SUR_AUTRE_ELEMENT)));
                ae.setDescription_autre_element(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION_AUTRE_ELEMENT)));

                autresElements.add(ae);
            } while (cursor.moveToNext());
        }

        return autresElements;
    }



    // updating an AUTRE_ELEMENT
    public int updateAutreElement(autre_element ae) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_LIEU, ae.getId_lieu());
        values.put(KEY_NOM_AUTRE_ELEMENT, ae.getNom_atre_element());
        values.put(KEY_VUE_SUR_AUTRE_ELEMENT, ae.getVue_sur_autre_element());
        values.put(KEY_DESCRIPTION_AUTRE_ELEMENT, ae.getDescription_autre_element());

        return db.update(TABLE_AUTRE_ELEMENT, values, KEY_ID_AUTRE_ELEMENT + " = ?",
                new String[] {
                    String.valueOf(ae.getId_autre_element())
                });
    }

    // deleting an AUTRE_ELEMENT
    public void deleteAutreElement(long ae_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_AUTRE_ELEMENT, KEY_ID_AUTRE_ELEMENT + " = ?",
                new String[] {
                    String.valueOf(ae_id)
                });
    }


    //----------- ELEMENT_PHOTOGRAPHIQUE table methods -----------//

    // creating ELEMENT_PHOTOGRAPHIQUE
    public long createElementPhotographique(element_photographique ep) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_ELEMENT_PHOTOGRAPHIQUE, ep.getId_lieu());
        values.put(KEY_VUE_ELEMENT_PHOTOGRPAHIQUE, ep.getVue_element_photographique());
        values.put(KEY_COMMENTAIRE, ep.getCommentaire());
        values.put(KEY_POSX_ELEMENT_PHOTOGRAPHIQUE, ep.getPosx_element_photographique());
        values.put(KEY_POSY_ELEMENT_PHOTOGRAPHIQUE, ep.getPosy_element_photographique());
        values.put(KEY_PHOTO_ELEMENT_PHOTOGRAPHIQUE, ep.getPhoto_element_photographique());

        long ep_id = db.insert(TABLE_ELEMENT_PHOTOGRAPHIQUE, null, values);

        return ep_id;
    }

    // getting all ELEMENT_PHOTOGRAPHIQUE
    public List<element_photographique> getAllElementsPhotographiques() {
        List<element_photographique> elementsPhotographiques = new ArrayList<element_photographique>();
        String selectQuery = "SELECT * FROM " + TABLE_ELEMENT_PHOTOGRAPHIQUE;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                element_photographique ep = new element_photographique();

                ep.setId_element_photographique(cursor.getInt(cursor.getColumnIndex(KEY_ID_ELEMENT_PHOTOGRAPHIQUE)));
                ep.setId_lieu(cursor.getInt(cursor.getColumnIndex(KEY_ID_LIEU_ELEMENT_PHOTOGRAPHQIUE)));
                ep.setVue_element_photographique(cursor.getString(cursor.getColumnIndex(KEY_VUE_ELEMENT_PHOTOGRPAHIQUE)));
                ep.setCommentaire(cursor.getString(cursor.getColumnIndex(KEY_COMMENTAIRE)));
                ep.setPosx_element_photographique(cursor.getFloat(cursor.getColumnIndex(KEY_POSX_ELEMENT_PHOTOGRAPHIQUE)));
                ep.setPosy_element_photographique(cursor.getFloat(cursor.getColumnIndex(KEY_POSY_ELEMENT_PHOTOGRAPHIQUE)));
                ep.setPhoto_element_photographique(cursor.getString(cursor.getColumnIndex(KEY_PHOTO_ELEMENT_PHOTOGRAPHIQUE)));

                elementsPhotographiques.add(ep);
            } while (cursor.moveToNext());
        }

        return elementsPhotographiques;
    }

    // updating an ELEMENT_PHOTOGRAPHIQUE
    public int updateElementPhotographique(element_photographique ep) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_LIEU_ELEMENT_PHOTOGRAPHQIUE, ep.getId_lieu());
        values.put(KEY_VUE_ELEMENT_PHOTOGRPAHIQUE, ep.getVue_element_photographique());
        values.put(KEY_COMMENTAIRE, ep.getCommentaire());
        values.put(KEY_POSX_ELEMENT_PHOTOGRAPHIQUE, ep.getPosx_element_photographique());
        values.put(KEY_POSY_ELEMENT_PHOTOGRAPHIQUE, ep.getPosy_element_photographique());
        values.put(KEY_PHOTO_ELEMENT_PHOTOGRAPHIQUE, ep.getPhoto_element_photographique());

        return db.update(TABLE_ELEMENT_PHOTOGRAPHIQUE, values, KEY_ID_ELEMENT_PHOTOGRAPHIQUE + " = ?",
                new String[] {
                    String.valueOf(ep.getId_element_photographique())
                });
    }

    // deleting an ELEMENT_PHOTOGRAPHIQUE
    public void deleteElementPhotographique(long ep_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ELEMENT_PHOTOGRAPHIQUE, KEY_ID_ELEMENT_PHOTOGRAPHIQUE + " = ?",
                new String[] {
                    String.valueOf(ep_id)
                });
    }

    //----------- ELEMENT_BOTANIQUE table methods -----------//
    // creating an ELEMENT_BOTANIQUE
    public long createElementBotanique(element_botanique eb) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_TYPE_BOTANIQUE_ELEMENT_BOTANIQUE, eb.getId_type());
        values.put(KEY_ID_NOM_COMMUN_ELEMENT_BOTANIQUE, eb.getId_nom_commun());
        values.put(KEY_ID_FEUILLAGE_ELEMENT_BOTANIQUE, eb.getId_feuillage());
        values.put(KEY_ID_NOM_ELEMENT_BOTANIQUE, eb.getId_nom());
        values.put(KEY_ID_LIEU_ELEMENT_BOTANIQUE, eb.getId_lieu());
        values.put(KEY_ID_GENRE_ELEMENT_BOTANIQUE, eb.getId_genre());
        values.put(KEY_PERIMETRE_ELEMENT_BOTANIQUE, eb.getPerimetre_element_botanique());
        values.put(KEY_DIAMETRE_ELEMENT_BOTANIQUE, eb.getDiametre_element_botnanique());
        values.put(KEY_HAUTEUR_ELEMENT_BOTANIQUE, eb.getHauteur_element_botanique());
        values.put(KEY_ANNEE_PLANTATION_ELEMENT_BOTANIQUE, eb.getAnnee_plantation_element_botanique());
        values.put(KEY_REMARQUE_ELEMENT_BOTANIQUE, eb.getRemarque_element_botanique());
        values.put(KEY_POSX_ELEMENT_BOTANIQUE, eb.getPosx_element_botanique());
        values.put(KEY_POSY_ELEMENT_BOTANIQUE, eb.getPosy_element_botanique());
        values.put(KEY_PHOTO_ELEMENT_BOTANIQUE, eb.getPhoto_element_botanique());
        values.put(KEY_TEXTE_PRESENTATION_ELEMENT_BOTANIQUE, eb.getTexte_presentation_element_botanique());
        values.put(KEY_EST_UNE_INFO, eb.isEst_une_info());
        values.put(KEY_VUE_ELEMENT_BOTANIQUE, eb.getVue_element_botanique());

        long eb_id = db.insert(TABLE_ELEMENT_BOTANIQUE, null, values);

        return eb_id;
    }

    // getting all ELEMENT_BOTANIQUE
    public List<element_botanique> getAllElementsBotaniques() {
        List<element_botanique> ebs = new ArrayList<element_botanique>();
        String selectQuery = "SELECT * FROM " + TABLE_ELEMENT_BOTANIQUE;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                element_botanique eb = new element_botanique();
                eb.setId_element_botanique(cursor.getInt(cursor.getColumnIndex(KEY_ID_ELEMENT_BOTANIQUE)));
                eb.setId_type(cursor.getInt(cursor.getColumnIndex(KEY_ID_TYPE_BOTANIQUE_ELEMENT_BOTANIQUE)));
                eb.setId_nom_commun(cursor.getInt(cursor.getColumnIndex(KEY_ID_NOM_COMMUN_ELEMENT_BOTANIQUE)));
                eb.setId_feuillage(cursor.getInt(cursor.getColumnIndex(KEY_ID_FEUILLAGE_ELEMENT_BOTANIQUE)));
                eb.setId_nom(cursor.getInt(cursor.getColumnIndex(KEY_ID_NOM_ELEMENT_BOTANIQUE)));
                eb.setId_lieu(cursor.getInt(cursor.getColumnIndex(KEY_ID_LIEU_ELEMENT_BOTANIQUE)));
                eb.setId_genre(cursor.getInt(cursor.getColumnIndex(KEY_ID_GENRE_ELEMENT_BOTANIQUE)));
                eb.setPerimetre_element_botanique(cursor.getInt(cursor.getColumnIndex(KEY_PERIMETRE_ELEMENT_BOTANIQUE)));
                eb.setDiametre_element_botnanique(cursor.getInt(cursor.getColumnIndex(KEY_DIAMETRE_ELEMENT_BOTANIQUE)));
                eb.setHauteur_element_botanique(cursor.getInt(cursor.getColumnIndex(KEY_HAUTEUR_ELEMENT_BOTANIQUE)));
                eb.setAnnee_plantation_element_botanique(cursor.getInt(cursor.getColumnIndex(KEY_ANNEE_PLANTATION_ELEMENT_BOTANIQUE)));
                eb.setRemarque_element_botanique(cursor.getString(cursor.getColumnIndex(KEY_REMARQUE_ELEMENT_BOTANIQUE)));
                eb.setPosx_element_botanique(cursor.getFloat(cursor.getColumnIndex(KEY_POSX_ELEMENT_BOTANIQUE)));
                eb.setPosy_element_botanique(cursor.getFloat(cursor.getColumnIndex(KEY_POSY_ELEMENT_BOTANIQUE)));
                eb.setPhoto_element_botanique(cursor.getString(cursor.getColumnIndex(KEY_PHOTO_ELEMENT_BOTANIQUE)));
                eb.setTexte_presentation_element_botanique(cursor.getString(cursor.getColumnIndex(KEY_TEXTE_PRESENTATION_ELEMENT_BOTANIQUE)));
                boolean info = cursor.getInt(cursor.getColumnIndex(KEY_EST_UNE_INFO)) > 0;
                eb.setEst_une_info(info);
                eb.setVue_element_botanique(cursor.getString(cursor.getColumnIndex(KEY_VUE_ELEMENT_BOTANIQUE)));

                ebs.add(eb);
            } while (cursor.moveToNext());
        }

        return ebs;
    }

    //updating ELEMENT_BOTANIQUE
    public int updateElementBotanique(element_botanique eb) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID_TYPE_BOTANIQUE_ELEMENT_BOTANIQUE, eb.getId_type());
        values.put(KEY_ID_NOM_COMMUN_ELEMENT_BOTANIQUE, eb.getId_nom_commun());
        values.put(KEY_ID_FEUILLAGE_ELEMENT_BOTANIQUE, eb.getId_feuillage());
        values.put(KEY_ID_NOM_ELEMENT_BOTANIQUE, eb.getId_nom());
        values.put(KEY_ID_LIEU_ELEMENT_BOTANIQUE, eb.getId_lieu());
        values.put(KEY_ID_GENRE_ELEMENT_BOTANIQUE, eb.getId_genre());
        values.put(KEY_PERIMETRE_ELEMENT_BOTANIQUE, eb.getPerimetre_element_botanique());
        values.put(KEY_DIAMETRE_ELEMENT_BOTANIQUE, eb.getDiametre_element_botnanique());
        values.put(KEY_HAUTEUR_ELEMENT_BOTANIQUE, eb.getHauteur_element_botanique());
        values.put(KEY_ANNEE_PLANTATION_ELEMENT_BOTANIQUE, eb.getAnnee_plantation_element_botanique());
        values.put(KEY_REMARQUE_ELEMENT_BOTANIQUE, eb.getRemarque_element_botanique());
        values.put(KEY_POSX_ELEMENT_BOTANIQUE, eb.getPosx_element_botanique());
        values.put(KEY_POSY_ELEMENT_BOTANIQUE, eb.getPosy_element_botanique());
        values.put(KEY_PHOTO_ELEMENT_BOTANIQUE, eb.getPhoto_element_botanique());
        values.put(KEY_TEXTE_PRESENTATION_ELEMENT_BOTANIQUE, eb.getTexte_presentation_element_botanique());
        values.put(KEY_EST_UNE_INFO, eb.isEst_une_info());
        values.put(KEY_VUE_ELEMENT_BOTANIQUE, eb.getVue_element_botanique());

        return db.update(TABLE_ELEMENT_BOTANIQUE, values, KEY_ID_ELEMENT_BOTANIQUE + " = ?",
                new String[] {
                    String.valueOf(eb.getId_element_botanique())
                });
    }

    // deleting ELEMENT_BOTANIQUE
    public void deleteElementBotanique(long eb_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ELEMENT_BOTANIQUE, KEY_ID_ELEMENT_BOTANIQUE + " = ?",
                new String[] {
                    String.valueOf(eb_id)
                });
    }


    //----------- LIEU table methods -----------//
    // creating LIEU
    public long createLieu(lieu lieu) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_LIEU, lieu.getLibelle_lieu());

        long lieu_id=0;

        db.beginTransaction();
        try {
            lieu_id = db.insertOrThrow(TABLE_LIEU, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(LOG, e.getMessage());
        } finally {
            db.endTransaction();
        }


        return lieu_id;
    }

    // getting all LIEU
    public List<lieu> getAllLieu() {
        List<lieu> lieux = new ArrayList<lieu>();
        String selectQuery = "SELECT * FROM " + TABLE_LIEU;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                lieu lieu = new lieu();
                lieu.setId_lieu(cursor.getInt(cursor.getColumnIndex(KEY_ID_LIEU)));
                lieu.setLibelle_lieu(cursor.getString(cursor.getColumnIndex(KEY_LIBELLE_LIEU)));

                lieux.add(lieu);
            } while (cursor.moveToNext());
        }
        return lieux;
    }

    //get one LIEU
    public lieu getOneLieu(int idLieuElement) {
        lieu Lieu = new lieu();
        String selectQuery = "SELECT " + KEY_LIBELLE_LIEU + " FROM " + TABLE_LIEU
                + " WHERE " + KEY_ID_LIEU + " = " + idLieuElement;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                Lieu.setLibelle_lieu(cursor.getString(cursor.getColumnIndex(KEY_LIBELLE_LIEU)));
            } while (cursor.moveToNext());
        }
        return Lieu;
    }

    //Create Feuillage
    public long createFeuillage(feuillage feuillage) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_FEUILLAGE, feuillage.getLibelle_feuillage());

        long feuillage_id=0;

        db.beginTransaction();
        try {
            feuillage_id = db.insertOrThrow(TABLE_FEUILLAGE, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(LOG, e.getMessage());
        } finally {
            db.endTransaction();
        }


        return feuillage_id;
    }

    //Create Genre
    public long createGenre(genre genre) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_GENRE, genre.getLibelle_genre());

        long genre_id=0;

        db.beginTransaction();
        try {
            genre_id = db.insertOrThrow(TABLE_GENRE, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(LOG, e.getMessage());
        } finally {
            db.endTransaction();
        }


        return genre_id;
    }

    //Create Nom
    public long createNom(nom nom) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_NOM, nom.getLibelle_nom());

        long nom_id=0;

        db.beginTransaction();
        try {
            nom_id = db.insertOrThrow(TABLE_NOM, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(LOG, e.getMessage());
        } finally {
            db.endTransaction();
        }


        return nom_id;
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }


    public long createType_botanique(type_botanique type_botanique) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_NOM, type_botanique.getLibelle_type_botanique());

        long type_botanique_id=0;

        db.beginTransaction();
        try {
            type_botanique_id = db.insertOrThrow(TABLE_TYPE_BOTANIQUE, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(LOG, e.getMessage());
        } finally {
            db.endTransaction();
        }


        return type_botanique_id;
    }

    public long createNom_commun(nom_commun nom_commun) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LIBELLE_NOM_COMMUN, nom_commun.getLibelle_nom_commun());

        long nom_commun_id=0;

        db.beginTransaction();
        try {
            nom_commun_id = db.insertOrThrow(TABLE_NOM_COMMUN, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(LOG, e.getMessage());
        } finally {
            db.endTransaction();
        }


        return nom_commun_id;
    }
}
