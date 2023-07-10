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

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import it.unimib.cinemapp.Model.Film;
import it.unimib.cinemapp.Model.FilmApiResponse;
import it.unimib.cinemapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreferitiRecyclerViewAdapter extends RecyclerView.Adapter<PreferitiRecyclerViewAdapter.FilmPrefViewHolder>{
    public interface OnItemClickListener{
        void onFilmClick(Film film);
    }
    private final List<String> IDList;
    private final PreferitiRecyclerViewAdapter.OnItemClickListener onItemClickListener;

    public PreferitiRecyclerViewAdapter(List<String> IDs, PreferitiRecyclerViewAdapter.OnItemClickListener onItemClickListener){
        this.IDList=IDs;
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public PreferitiRecyclerViewAdapter.FilmPrefViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item_layout, parent,false);
        return new PreferitiRecyclerViewAdapter.FilmPrefViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreferitiRecyclerViewAdapter.FilmPrefViewHolder holder, int position) {
        try {
            holder.bind(IDList.get(position));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getItemCount() {
        if(IDList != null){
            return IDList.size();
        }
        else {return 0;}
    }



    public class FilmPrefViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView textViewTitolo;
        private final TextView textViewDescrizione;
        private final ImageView imageView;
        private Film film;

        public FilmPrefViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitolo=itemView.findViewById(R.id.textViewtTitolo);
            textViewDescrizione=itemView.findViewById(R.id.textViewDescrizione);
            imageView=itemView.findViewById(R.id.poster);
            itemView.setOnClickListener(this);

        }
        public void bind(String id) throws IOException {
            //FilmApiResponse fonte= APICalls.findFilmById(id).execute().body();
            APICalls.findFilmById(id).enqueue(new Callback<FilmApiResponse>() {
                @Override
                public void onResponse(Call<FilmApiResponse> call, Response<FilmApiResponse> response) {
                    film= new Film(response.body());
                    textViewTitolo.setText(film.getTitolo());
                    textViewDescrizione.setText(film.getDescrizione());
                    //setupImmagine(film);
                    if (film.getURLimmagine() != null) {
                        new DownloadImageTask(imageView).execute(film.getURLimmagine());
                    }
                }

                @Override
                public void onFailure(Call<FilmApiResponse> call, Throwable t) {
                    //Snackbar.make(view, "errore", Snackbar.LENGTH_SHORT).show();
                }
            });

            //immagine placeholder
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onFilmClick(film);
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
