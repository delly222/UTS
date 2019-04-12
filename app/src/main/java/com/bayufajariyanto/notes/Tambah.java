package com.bayufajariyanto.notes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Tambah extends AppCompatActivity {
    private DatabaseHandler db;
    private EditText Etext;
    private String Stext;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        db = new DatabaseHandler(this);

        Etext = (EditText) findViewById(R.id.text);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Stext = String.valueOf(Etext.getText());

                if(Stext.equals("")){
                    Etext.requestFocus();
                    Toast.makeText(Tambah.this, "Silakan isi catatan", Toast.LENGTH_SHORT).show();
                }else{
                    Etext.setText("");
                    Toast.makeText(Tambah.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateText(new Modal(null, Stext));
                }
            }
        });



    }


}
