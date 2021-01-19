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

        // Initialisation des attributs;
        imageView = findViewById(R.id.image_result);
        btDescription = findViewById(R.id.btn_description);

        Bitmap passedImage = (Bitmap) getIntent().getParcelableExtra("bmp_img");
        imageView.setImageBitmap(passedImage);



        btDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ThirdActivity.class);
                startActivity(intent);

            }
        });
    }
}