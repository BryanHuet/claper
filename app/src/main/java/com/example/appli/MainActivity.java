package com.example.appli;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // Initialisation des attributs.
    ImageView imageView;
    Button btOpen;
    Button btImport;
    Button btHistorique;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des attributs;
        imageView = findViewById(R.id.image_view);
        btOpen = findViewById(R.id.bt_open);
        btImport = findViewById(R.id.bt_import);
        btHistorique = findViewById(R.id.bt_historique);

        // Requête pour la permission caméra
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {
                    Manifest.permission.CAMERA
            },
                    100);
        }

        // Listener sur le bouton Clap !.
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvre la Camera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

        // Listener sur le bouton import.
        btImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        // Listener sur le bouton historique.
        btHistorique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FourthActivity.class);
                startActivity(intent);
            }
        });

    }

    // Résultat de l'activité (on récupère l'image et redirige vers la seconde Activity avec l'image en argument).
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Cas où on prend une photo
        if (requestCode == 100 && null != data) {
            // Get l'image Capturé
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            // Redirige vers la SecondActivity (là il faudrait lancer l'IA et rediriger vers une nouvelle activité avec des données en arguments résultants de celle-ci)
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("bmp_img", captureImage); // On met en argument l'image histoire d'avoir un exemple à afficher sur la 2ème activity
            startActivity(intent);
        } //TODO afficher l'image suite à un import pour test. (cas où on importe)
        else if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            // Redirige vers la SecondActivity (là il faudrait lancer l'IA et rediriger vers une nouvelle activité avec des données en arguments résultants de celle-ci)
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("bmp_img", BitmapFactory.decodeFile(picturePath)); // On met en argument l'image histoire d'avoir un exemple à afficher sur la 2ème activity
            startActivity(intent);
        }
    }
}