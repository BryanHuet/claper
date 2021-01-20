package com.example.appli.db;

public class Acteur {

    private String nom;
    private String prenom;
    private String description;
    private String pathImage;

    public Acteur(String nom, String prenom, String description, String pathImage) {
        nom = nom;
        prenom = prenom;
        description = description;
        pathImage = pathImage;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDescription() {
        return description;
    }

    public String getPathImage() {
        return pathImage;
    }
}
