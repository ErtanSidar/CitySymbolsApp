package com.essoft.citysymbolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayList<String> cityNames = new ArrayList<>();
        cityNames.add("Pisa");
        cityNames.add("Eiffel");
        cityNames.add("Colosseo");
        cityNames.add("London Bridge");

        ArrayList<String> countryNames= new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colosseo=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colosseo);
        Bitmap londonBridge=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        ArrayList<Bitmap> cityImages= new ArrayList<>();
        cityImages.add(pisa);
        cityImages.add(eiffel);
        cityImages.add(colosseo);
        cityImages.add(londonBridge);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,cityNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("city",cityNames.get(position));
                intent.putExtra("country",countryNames.get(position));

                Singleton singleton= Singleton.getInstance();
                singleton.setChosenImage(cityImages.get(position));

                startActivity(intent);
            }
        });



    }
}