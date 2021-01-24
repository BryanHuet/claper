package com.example.appli.filmRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appli.R;
import com.example.appli.db.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

// Adapter avec le strict minimum requis pour adapter les objets Acteur en item d'une RecyclerView.
//TODO retrait de la description et gestion d'évènement cliquable qui afficherai un popup/une card.
public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    ArrayList<Film> films;
    public FilmAdapter() {
        films = new ArrayList<Film>();
    }

    public void setData(ArrayList<Film> f) {
        films = f;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View filmView = layoutInflater.inflate(R.layout.recycler_row, parent, false);
        return new FilmViewHolder(filmView);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        Film film = films.get(position);
        Picasso.get().load("file:///android_asset/"+film.getImageURL()).into(holder.image);
        holder.title.setText(film.getName());
        holder.body.setText(film.getDescription());

    }

    @Override
    public int getItemCount() {
        return films.size();
    }
}
