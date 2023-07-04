package it.unimib.cinemapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import it.unimib.cinemapp.Model.Film;
import it.unimib.cinemapp.R;


public class FilmSingoloFragment extends Fragment {
    private Film film;
    private TextView textViewtitolo;
    private TextView textViewtrama;
    public FilmSingoloFragment(Film film){
        this.film=film;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_singolo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar2);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewtitolo=view.findViewById(R.id.Titolo);
        textViewtrama=view.findViewById(R.id.Trama);

        textViewtitolo.setText(film.getTitolo());
        textViewtrama.setText(film.getTrama());

        final Button miPiace= view.findViewById(R.id.bottonePreferito);
        miPiace.setOnClickListener(v -> {
            if(film.isPreferito()){
                Snackbar.make(view, film.getTitolo()+" non ti piace più", Snackbar.LENGTH_SHORT).show();
                film.setPreferito(false);
                return;
            }
            else{
                Snackbar.make(view, "ti piace "+film.getTitolo(), Snackbar.LENGTH_SHORT).show();
                film.setPreferito(true);
                return;
            }
        });


    }
}