package com.bayufajariyanto.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Tampil extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseHandler db;
    private List<Modal> ListNotes = new ArrayList<Modal>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        db = new DatabaseHandler(this);

        adapter_off = new CustomListAdapter(this, ListNotes);
        mListView = (ListView) findViewById(R.id.list);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListNotes.clear();

        List<Modal> text = db.ReadNotes();
        for(Modal t:text){
            Modal Judul = new Modal();
            Judul.setId(t.getId());
            Judul.setText(t.getText());
            ListNotes.add(Judul);

            if((ListNotes.isEmpty())){
                Toast.makeText(this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            }else{

            }

        }


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Object o = mListView.getItemAtPosition(position);
        Modal obj_itemDetails = (Modal)o;

        String Sid = obj_itemDetails.getId();
        String Stext = obj_itemDetails.getText();

        Intent goUpdate = new Intent(Tampil.this, Update.class);
        goUpdate.putExtra("Id",Sid);
        goUpdate.putExtra("Text",Stext);
        startActivity(goUpdate);


    }
}
