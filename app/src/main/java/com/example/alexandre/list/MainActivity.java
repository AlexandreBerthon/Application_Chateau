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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TreeListFragment.OnTreeListClickListener, MapFragment.OnMapClickListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = "MainActivity";

    private Button mBtMap;
    private Button mBtTreeList;
    private Fragment mMapFragment;
    private Fragment mTreeFragment;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;

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


    //-------------------------------------POUR FILTRE----------------------------------------------
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String sSelected=adapterView.getItemAtPosition(position).toString();
        Toast.makeText(this, sSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    //----------------------------------------------------------------------------------------------
}