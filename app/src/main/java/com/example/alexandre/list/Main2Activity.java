package com.example.alexandre.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Main2Activity";  //A QUOI CA SET

    private Button mBtVisite;
    private Button mBtEnfant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bindViews();
        mBtVisite.setOnClickListener(this);
        mBtEnfant.setOnClickListener(this);

    }

    private void bindViews() {
        mBtVisite = (Button) findViewById(R.id.btVisite);
        mBtEnfant = (Button) findViewById(R.id.btEnfant);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btVisite:
                Intent appel = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(appel);
                //CHARGER L ACTIVITE ICI
                break;

            case R.id.btEnfant:
                //CHARGER L ACTIVITE ICI
                break;
        }
    }
}
