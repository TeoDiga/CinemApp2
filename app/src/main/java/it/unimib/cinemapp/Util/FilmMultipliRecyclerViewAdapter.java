package it.unimib.cinemapp.Util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;
import java.util.List;

import it.unimib.cinemapp.Model.Film;
import it.unimib.cinemapp.R;

public class FilmMultipliRecyclerViewAdapter extends RecyclerView.Adapter<FilmMultipliRecyclerViewAdapter.FilmViewHolder>{
    public interface OnItemClickListener{
        void onFilmClick(Film film);
    }
    private final List<Film> filmList;
    private final OnItemClickListener onItemClickListener;

    public FilmMultipliRecyclerViewAdapter(List<Film> films, OnItemClickListener onItemClickListener){
        this.filmList=films;
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item_layout, parent,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.bind(filmList.get(position));
    }

    @Override
    public int getItemCount() {
        if(filmList != null){
            return filmList.size();
        }
        else {return 0;}
    }



    public class FilmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView textViewTitolo;
        private final TextView textViewDescrizione;
        private final ImageView imageView;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitolo=itemView.findViewById(R.id.textViewtTitolo);
            textViewDescrizione=itemView.findViewById(R.id.textViewDescrizione);
            imageView=itemView.findViewById(R.id.poster);
            itemView.setOnClickListener(this);

        }
        public void bind(Film film){
            textViewTitolo.setText(film.getTitolo());
            textViewDescrizione.setText(film.getDescrizione());
            //setupImmagine(film);
            if (film.getURLimmagine() != null) {
                new DownloadImageTask(imageView).execute(film.getURLimmagine());
            }
            //immagine placeholder
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onFilmClick(filmList.get(getAdapterPosition()));
        }
        void setupImmagine(Film film) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = null;
                        url = new URL(film.getURLimmagine());
                        Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                        imageView.setImageBitmap(image);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        }
    }

}
