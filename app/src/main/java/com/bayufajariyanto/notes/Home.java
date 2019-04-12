package com.bayufajariyanto.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.stetho.Stetho;


public class Home extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_home);
    }

    public void btnCreate(View v){
        Intent goCreate = new Intent(Home.this,Tambah.class);
        startActivity(goCreate);
    }
    public void btnRead(View v){
        Intent goRead = new Intent(Home.this,Tampil.class);
        startActivity(goRead);
    }
}
