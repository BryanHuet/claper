package com.example.appli.db;

public class Acteur {

    private String id;
    private String nom;
    private String description;
    private String pathImage;

    public Acteur(String id, String nom, String description, String pathImage) {
        id = id;
        nom = nom;
        description = description;
        pathImage = pathImage;
    }

    public String getId() { return id; }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getPathImage() {
        return pathImage;
    }
}
