package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//TODO Réfléchir sur la gestion et la sauvegarde des états entre les différentes redirection + la liaison des parents de l'activity 4 qui va être le fils de 1 et de 3.

//TODO liste des films recherchés (save sur un fichier json chaque film trouvé)
public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }
}