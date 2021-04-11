package com.essoft.citysymbolsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView cityNameText=findViewById(R.id.cityNameTxt);
        TextView conutryNameText=findViewById(R.id.countryNameTxt);

        Intent intent = getIntent();
        String cityName= intent.getStringExtra("city");
        String countryName= intent.getStringExtra("country");
        cityNameText.setText(cityName);
        conutryNameText.setText(countryName);
        Singleton singleton =Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());
    }
}