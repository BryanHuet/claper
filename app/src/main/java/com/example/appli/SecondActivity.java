package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView;
    Button btDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialisation des attributs;
        imageView = findViewById(R.id.image_result);
        btDescription = findViewById(R.id.btn_description);

        // On récupère l'image passé en argument dans la redirection de la 1ère activity.
        Bitmap passedImage = (Bitmap) getIntent().getParcelableExtra("bmp_img");
        imageView.setImageBitmap(passedImage);

        // Clicklistener sur le bouton qui redirige vers une 3ème activity.
        btDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}