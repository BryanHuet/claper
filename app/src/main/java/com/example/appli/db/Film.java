package com.example.appli.db;

import com.example.appli.db.Acteur;

import java.util.HashSet;

public class Film {

    private String titre;
    private String pathImage;
    private String description;
    private HashSet<Acteur> acteurs;

    public Film(String titre, String pathImage, String description, HashSet<Acteur> acteurs) {
        titre = titre;
        pathImage = pathImage;
        description = description;
        acteurs = acteurs;
    }

    public String getTitre() {
        return titre;
    }

    public String getPathImage() {
        return pathImage;
    }

    public String getDescription() {
        return description;
    }

    public HashSet<Acteur> getActeurs() {
        return acteurs;
    }
}
