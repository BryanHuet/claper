package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


//TODO liste des films recherchés (lecture d'un fichier de sauvegarde (save d'une recherche de film à faire dans le LoadingActivity ou lors des result dans la MainActivity))
// Attention à faire gaffe au bouton retour, car cette activité sera utilisé par la MainActivity et la SecondActivity.
public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }
}