package com.bayufajariyanto.notes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.stetho.Stetho;


public class Update extends AppCompatActivity {
    private DatabaseHandler db;
    private String Sid, Stext;
    private EditText Etext;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        db = new DatabaseHandler(this);
        Intent i = this.getIntent();
//        Sid = i.getStringExtra("id");
        Stext = i.getStringExtra("nama");

        Etext = (EditText) findViewById(R.id.update);

        Etext.setText(Stext);

        Button btnUpdate = (Button) findViewById(R.id.update);
    }


}
