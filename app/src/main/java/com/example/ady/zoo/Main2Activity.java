package com.example.ady.zoo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private DataBaseHelper animalsCateDATABASE;
    private ListView lvdisplayCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvdisplayCategories = findViewById(R.id.LVdisplayAniCate);
        String[] CategoriesAnimals = {"Invertebrates","Fish","Amphibians","Reptiles","Birds","Mammals"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,R.layout.listviewadapter,CategoriesAnimals);
        lvdisplayCategories.setAdapter(stringArrayAdapter);
        lvdisplayCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView itemclicked = (TextView) view;
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class);

                intent.putExtra("magic",itemclicked.getText().toString());
                startActivity(intent);
            }
        });






    }
}
