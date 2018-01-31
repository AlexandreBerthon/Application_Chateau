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

        //------------------------------------------------------------------------------------------
        lieu lieu1 = new lieu(1,"Jardin Anglais");
        lieu lieu2 = new lieu(2,"Cour du château");

        long lieu1_id = db.createLieu(lieu1);
        long lieu2_id = db.createLieu(lieu2);

        Log.d("Compteur de lieux", "Lieux: " + db.getAllLieu().size());

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