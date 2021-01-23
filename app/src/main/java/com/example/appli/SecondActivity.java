package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {

    TextView title;
    ImageView imageView;
    Button btDescription;
    String id;
    String titre;
    String description;
    String filmURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialisation des attributs;
        imageView = findViewById(R.id.image_result);
        btDescription = findViewById(R.id.btn_description);
        title = findViewById(R.id.titre);

        if (getIntent().getStringExtra("intentName") != null && getIntent().getStringExtra("intentName").equals("Loader")) {
            if (id == null || titre == null || description == null || filmURL == null) {
                id = getIntent().getStringExtra("filmId");
                titre = getIntent().getStringExtra("filmName");
                description = getIntent().getStringExtra("filmDescription");
                filmURL = getIntent().getStringExtra("filmURL");
            }

            try {
                InputStream ims = getAssets().open(filmURL);
                Drawable d = Drawable.createFromStream(ims, null);
                imageView.setImageDrawable(d);
                title.setText(titre);
                ims.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* TODO Plus nécessaire de tester les affichages des images importer/prise, je vais faire la partie db et faker l'affichage d'images pré-sauvegarder.
        String previousActivity = "ThirdActivity";
        if (getParentActivityIntent() != null) {
            previousActivity = (String) getIntent().getExtras().getString("fromActivity");
        }


        if (previousActivity.equals("MainActivity")) {
            // On récupère l'image passé en argument dans la redirection de la 1ère activity.
            Bitmap passedImage = (Bitmap) getIntent().getParcelableExtra("bmp_img");
            String pathFile = (String) getIntent().getExtras().getString("filePath");
            if (passedImage != null) {
                imageView.setImageBitmap(passedImage);
            } else imageView.setImageBitmap(BitmapFactory.decodeFile(pathFile));
        }
         */
        eventDescription();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("id", id);
        savedInstanceState.putString("titre", titre);
        savedInstanceState.putString("description", description);
        savedInstanceState.putString("filmURL", filmURL);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        id = savedInstanceState.getString("id");
        titre = savedInstanceState.getString("titre");
        description = savedInstanceState.getString("description");
        filmURL = savedInstanceState.getString("filmURL");
    }

    public void eventDescription() {
        // Clicklistener sur le bouton qui redirige vers une 3ème activity.
        btDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ThirdActivity.class);
                intent.putExtra("filmId", id);
                intent.putExtra("filmName", titre);
                intent.putExtra("filmDescription", description);
                intent.putExtra("filmURL", filmURL);
                startActivity(intent);
                // onPause();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}