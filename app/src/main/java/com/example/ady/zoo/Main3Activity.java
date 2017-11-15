package com.example.ady.zoo;

import android.database.Cursor;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private boolean isinsert;
    private DataBaseHelper database;
    private TextView tvtrying;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String keytodisplay = "";



        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        keytodisplay = bundle.getString("magic");
        tvtrying = findViewById(R.id.trying);
        tvtrying.setText(" ");
        tvtrying.setText(keytodisplay);
        populatedatabase ();
        List<String> CategoriesClicked = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.rvdisplay);

        Cursor result = database.getallgata(keytodisplay);
        if (result.getCount() == 0){
            tvtrying.setText("Data Base Failed");
            return;
        }
        while(result.moveToNext()){
            CategoriesClicked.add(result.getString(0));
            //tvtrying.append(result.getString(0));
            //tvtrying.append("\n");
        }

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        Recycleadapter recycleadapter = new Recycleadapter(CategoriesClicked);





    }
    public void populatedatabase (){
        String[] Categories = {"Invertebrates","Fish","Amphibians","Reptiles","Birds","Mammals"};
        String [] Invertebrates =
                {"Confused Flour Beetle", "Darkling Beetle", "African Jewel Beetle",
                        "Bees","Honey Pot Ant", "Leaf Cutter Ant"};
        String [] Fish =
                {"Bonito", "Pompano", "Red Bream",
                        "Seabass","Red Mullet", "Sole"};
        String [] Amphibians =
                {"American Bullfrog", "Tomato Frog", "Alligator Newt",
                        "Giant Marine Toad","Emperor Newt", "Tiger Salamander"};
        String [] Reptiles =
                {"Chinese Alligator", "Green Iguana", "Leopard Gecko",
                        "Ball Python","Boelen's Python", "King Cobra"};
        String [] Birds =
                {"Tufted Puffin", "Cattle Egret", "White Ibis",
                        "White Faced Ibis","King Penguin", "Bali Mynah"};
        String [] Mammals =
                {"Me", "You", "HE",
                        "She","We", "They"};
        database = new DataBaseHelper(Main3Activity.this);




        for(int j = 0; j< Mammals.length;j++){
            isinsert = database.insertData(Invertebrates[j],Fish[j],Amphibians[j],Reptiles[j],Birds[j],Mammals[j]);
            if (isinsert)
                Toast.makeText(Main3Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Main3Activity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
            }

        }
    }

