package com.example.alexandre.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alexandre.list.fragments.MapFragment;
import com.example.alexandre.list.fragments.TreeListFragment;
import com.example.alexandre.list.helper.databasehelper;
import com.example.alexandre.list.model.autre_element;
import com.example.alexandre.list.model.feuillage;
import com.example.alexandre.list.model.genre;
import com.example.alexandre.list.model.lieu;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TreeListFragment.OnTreeListClickListener, MapFragment.OnMapClickListener{

    private static final String TAG = "MainActivity";

    private Button mBtMap;
    private Button mBtTreeList;
    private Fragment mMapFragment;
    private Fragment mTreeFragment;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        mBtMap.setOnClickListener(this);
        mBtTreeList.setOnClickListener(this);

        mMapFragment = MapFragment.newInstance("arg1", "arg2");
        mTreeFragment = TreeListFragment.newInstance("arg1", "arg2");
        loadFragment(mTreeFragment);

        //----------------------------------------NAV BAR-------------------------------------------
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //------------------------------------------------------------------------------------------

        //-------------------------------------INSTANCES--------------------------------------------

        db = new databasehelper(getApplicationContext());

        lieu lieu1 = new lieu(1,"Cour d'honneur");
        lieu lieu2 = new lieu(2,"Jardin anglais");
        lieu lieu3 = new lieu(3,"Forêt et clairière");
        lieu lieu4 = new lieu(4,"Côté sud");
        lieu lieu5 = new lieu(5,"Bosquet du couchant");
        lieu lieu6 = new lieu(6,"Ile");
        lieu lieu7 = new lieu(7,"Vers la chapelle");
        lieu lieu8 = new lieu(8,"Jardin anglais terrasse");
        lieu lieu9 = new lieu(9,"Jardin anglais haut");
        lieu lieu10 = new lieu(10,"Captage d'eau");
        lieu lieu11 = new lieu(11,"Forêt");
        lieu lieu12 = new lieu(12,"Promenade du couchant");
        lieu lieu13 = new lieu(13,"Prairie");
        lieu lieu14 = new lieu(14,"Aile sud du château");
        lieu lieu15 = new lieu(15,"Depuis la prairie");
        lieu lieu16 = new lieu(16,"Depuis le jardin anglais");
        lieu lieu17 = new lieu(17,"Depuis les noyers");
        lieu lieu18 = new lieu(18,"Depuis la forêt");
        lieu lieu19 = new lieu(19,"Depuis l'ex souche du cedre");
        lieu lieu20 = new lieu(20,"Depuis l'érable boulle");

        long lieu1_id = db.createLieu(lieu1);
        long lieu2_id = db.createLieu(lieu2);
        long lieu3_id = db.createLieu(lieu3);
        long lieu4_id = db.createLieu(lieu4);
        long lieu5_id = db.createLieu(lieu5);
        long lieu6_id = db.createLieu(lieu6);
        long lieu7_id = db.createLieu(lieu7);
        long lieu8_id = db.createLieu(lieu8);
        long lieu9_id = db.createLieu(lieu9);
        long lieu10_id = db.createLieu(lieu10);
        long lieu11_id = db.createLieu(lieu11);
        long lieu12_id = db.createLieu(lieu12);
        long lieu13_id = db.createLieu(lieu13);
        long lieu14_id = db.createLieu(lieu14);
        long lieu15_id = db.createLieu(lieu15);
        long lieu16_id = db.createLieu(lieu16);
        long lieu17_id = db.createLieu(lieu17);
        long lieu18_id = db.createLieu(lieu18);
        long lieu19_id = db.createLieu(lieu19);
        long lieu20_id = db.createLieu(lieu20);

        Log.d("Compteur de lieux", "Lieux: " + db.getAllLieu().size());


        feuillage feuillage1 = new feuillage(1,"Persistant");
        feuillage feuillage2 = new feuillage(2,"Caduc");
        feuillage feuillage3 = new feuillage(3,"Conifère");

        long feuillage1_id = db.createFeuillage(feuillage1);
        long feuillage2_id = db.createFeuillage(feuillage2);
        long feuillage3_id = db.createFeuillage(feuillage3);

        genre genre1 = new genre(1, "Buxus");
        genre genre2 = new genre(2, "Platanus");
        genre genre3 = new genre(3, "Rhus");
        genre genre4 = new genre(4, "Taxus");
        genre genre5 = new genre(5, "Ilex");
        genre genre6 = new genre(6, "Aesculus");
        genre genre7 = new genre(7, "Juglans");
        genre genre8 = new genre(8, "Cedrus");
        genre genre9 = new genre(9, "Ulmus");
        genre genre10 = new genre(10, "Prunus");
        genre genre11 = new genre(11, "Acer");
        genre genre12 = new genre(12, "Elaeagnus");
        genre genre13 = new genre(13, "Celtis");
        genre genre14 = new genre(14, "Fraxinus");
        genre genre15 = new genre(15, "Sophora");
        genre genre16 = new genre(16, "Fagus");
        genre genre17 = new genre(17, "Salix");
        genre genre18 = new genre(18, "Quercus");
        genre genre19 = new genre(19, "Parrotia");

        long genre1_id = db.createGenre(genre1);
        long genre2_id = db.createGenre(genre2);
        long genre3_id = db.createGenre(genre3);
        long genre4_id = db.createGenre(genre4);
        long genre5_id = db.createGenre(genre5);
        long genre6_id = db.createGenre(genre6);
        long genre7_id = db.createGenre(genre7);
        long genre8_id = db.createGenre(genre8);
        long genre9_id = db.createGenre(genre9);
        long genre10_id = db.createGenre(genre10);


        autre_element ae1 = new autre_element(1, "Bob", "Moche", "C'est doux et moelleux");
        autre_element ae2 = new autre_element(2, "John", "Beau", "Ca pue grave");

        long ae2_id = db.createAutreElement(ae1);
        long ae3_id = db.createAutreElement(ae2);
        long ae4_id = 6; //= db.createAutreElement(ae2);
        long ae5_id = 5; //= db.createAutreElement(ae2);
        long ae6_id = 4; //= db.createAutreElement(ae2);
        long ae7_id = 3; //= db.createAutreElement(ae2);
        long ae8_id = 9; //= db.createAutreElement(ae2);

        Log.d("Compteur d'a_e", "Compteur: " + db.getAllautreElements().size());

        List<lieu> allLieux = db.getAllLieu();
        for (lieu lieu : allLieux) {
            Log.d("ID","Value: " + lieu.getId_lieu());
            Log.d("Nom du lieu", lieu.getLibelle_lieu());
        }

        List<autre_element> allAe = db.getAllautreElements();
        for(autre_element ae : allAe) {
            Log.d("ID ae", "val: "+ae.getId_autre_element());
            Log.d("ID Lieu", "val: " + ae.getId_lieu());
            Log.d("Nom ae", ae.getNom_atre_element());
            Log.d("Description", ae.getDescription_autre_element());
            Log.d("Vue", ae.getVue_sur_autre_element());
        }


        db.closeDB();

        //------------------------------------------------------------------------------------------
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        //Arrayadapter avec tableau de res
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filter_array, android.R.layout.simple_spinner_item);

        //On choisi le layout a utiliser
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //On applique l'adapter au spinner
        spinner.setAdapter(adapter);

        //On applique le on item selected au spinner
        //spinner.setOnItemSelectedListener(this);
        return true;
    }


    private void bindViews() {
        mBtMap = (Button) findViewById(R.id.btMap);
        mBtTreeList = (Button) findViewById(R.id.btTree);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btMap:
                loadFragment(mMapFragment);
                break;

            case R.id.btTree:
                loadFragment(mTreeFragment);
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    @Override
    public void onTreeListClick() {
        Log.e(TAG, "onTreeListClick: click !");
    }

    @Override
    public void onMapClick() {
        Log.e(TAG, "onMapClick: click !");
    }

}