package com.aashiq.mvprecyclerviewretrofit.Home;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aashiq.mvprecyclerviewretrofit.Model.Film;
import com.aashiq.mvprecyclerviewretrofit.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;



class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private ArrayList<Film> films;
    private OnFilmItemClickListener onFilmItemClickListener;

    FilmAdapter(ArrayList<Film> films,OnFilmItemClickListener onFilmItemClickListener)
    {
        this.films  = films;
        this.onFilmItemClickListener = onFilmItemClickListener;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_film_item,parent,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, final int position) {
        holder.title.setText(films.get(position).getTitle() + films.get(position).getEpisode_Id());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: " + films.get(position).getTitle() + " Clicked");
                onFilmItemClickListener.onFilmClick(films.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (films==null)
        {
            return 0;
        }
        else
        return films.size();
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    class FilmViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        FilmViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    interface OnFilmItemClickListener
    {
        void onFilmClick(Film film);
    }
}
