package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.appli.db.Film;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.appli.db.Utils;

// Activité "invisible" (qui se doit de l'être) pour les utilisateurs qui va permettre de faire la transition entre les données de la db JSON et la 2ème activity.
public class LoadingActivity extends AppCompatActivity {

    private Film film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        film = parseRandomMovieFromJSON();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("intentName", "Loader");
        intent.putExtra("filmId", film.getId());
        intent.putExtra("filmName", film.getName());
        intent.putExtra("filmURL", film.getImageURL());
        intent.putExtra("filmDescription", film.getDescription());
        ArrayList<String> newList = new ArrayList<>(film.getActeurs().size());
        for (Integer myInt : film.getActeurs()) {
            newList.add(String.valueOf(myInt));
        }
        intent.putStringArrayListExtra("filmActeurs", newList);
        startActivity(intent);
    }

    // Parsing de JSON en objet grace à la librairie Gson. (dépendance si besoin sur le fichier build.gradle)
    public Film parseRandomMovieFromJSON() {
        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "films.json");
        // Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listFilmType = new TypeToken<List<Film>>() { }.getType();

        List<Film> users = gson.fromJson(jsonFileString, listFilmType);

        Random r = new Random();
        int randIndex = r.nextInt(users.size());
        return users.get(randIndex);
    }
}