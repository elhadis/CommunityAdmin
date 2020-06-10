package com.rgbat.communityadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonWrk,buttonProduct,buttonApartment,buttonKids,
    buttonFamilies,buttonHelps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        buttonWrk = findViewById(R.id.post_work);
        buttonProduct = findViewById(R.id.product);
        buttonApartment = findViewById(R.id.apartment);
        buttonFamilies = findViewById(R.id.families);
        buttonHelps = findViewById(R.id.helps);
        buttonKids = findViewById(R.id.Kids_classes);

        buttonKids.setOnClickListener(this);
        buttonHelps.setOnClickListener(this);
        buttonFamilies.setOnClickListener(this);
        buttonProduct.setOnClickListener(this);
        buttonApartment.setOnClickListener(this);
        buttonWrk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v .getId()){
            case R.id.post_work:
                Intent intent = new Intent(getBaseContext(),PostWorkActivity.class);
                startActivity(intent);
                break;
            case R.id.Kids_classes:
                Intent kids = new Intent(getBaseContext(),KidsActivity.class);
                startActivity(kids);
                break;
            case R.id.helps:
                Intent intent1 = new Intent(getBaseContext(),HelpsActivity.class);
                startActivity(intent1);
                break;
            case R.id.apartment:
                Intent apartmentIntent = new Intent(getBaseContext(),ApartmentActivity.class);
                startActivity(apartmentIntent);

        }

    }
}
