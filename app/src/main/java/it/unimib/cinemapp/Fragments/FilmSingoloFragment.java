package it.unimib.cinemapp.Fragments;

import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.like.LikeButton;
import com.like.OnLikeListener;

import it.unimib.cinemapp.Model.Film;
import it.unimib.cinemapp.R;
import it.unimib.cinemapp.Util.DownloadImageTask;
import it.unimib.cinemapp.Util.GestorePreferiti;


public class FilmSingoloFragment extends Fragment {
    private Film film;
    private TextView textViewtitolo;
    private TextView textViewtrama;
    private TextView textViewRegista;
    private TextView textViewCast;
    private TextView textViewGenere;
    private TextView textViewDurata;
    private TextView textViewSceneggiatore;
    private TextView textViewAnno;
    private TextView textViewPaese;
    private TextView textViewCompagnia;
    private TextView textViewBudget;
    private TextView textViewBoxOffice;
    private TextView textViewPremi;
    private TextView textViewCritica;
    private TextView textViewUtenti;

    private ImageView imageViewLocandina;
    private Context context;

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

        boolean preferito = GestorePreferiti.isPreferito(context, film);
        film.setPreferito(preferito);

        return inflater.inflate(R.layout.fragment_film_singolo, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar2);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewtitolo=view.findViewById(R.id.Titolo);
        textViewtrama=view.findViewById(R.id.Trama);
        textViewRegista=view.findViewById(R.id.textViewRegista);
        textViewCast=view.findViewById(R.id.textViewCast);
        textViewDurata=view.findViewById(R.id.textViewLength);
        textViewGenere=view.findViewById(R.id.textViewGenere);
        textViewSceneggiatore=view.findViewById(R.id.textViewSceneggiatore);
        textViewAnno=view.findViewById(R.id.textViewAnno);
        textViewPaese=view.findViewById(R.id.textViewPaese);
        textViewCompagnia=view.findViewById(R.id.textViewCompagnia);
        textViewBudget=view.findViewById(R.id.textViewBudget);
        textViewBoxOffice=view.findViewById(R.id.textViewIncassi);
        textViewPremi=view.findViewById(R.id.textViewPremi);
        textViewCritica=view.findViewById(R.id.textViewCrtitica);
        textViewUtenti=view.findViewById(R.id.textViewUtenti);

        imageViewLocandina = view.findViewById(R.id.Locandina);

        textViewtitolo.setText(film.getTitolo());
        textViewtrama.setText(film.getTrama());
        textViewRegista.setText(film.getRegista());
        textViewCast.setText(film.getCast());
        textViewSceneggiatore.setText(film.getSceneggiatore());
        textViewGenere.setText(film.getGenere());
        textViewDurata.setText(film.getDurata());
        textViewCompagnia.setText(film.getCompagnia());
        textViewPaese.setText(film.getPaese());
        textViewAnno.setText(film.getAnno());
        textViewUtenti.setText(film.getVotoUtenti());
        textViewBudget.setText(film.getBudget());
        textViewCritica.setText(film.getVotoProfessionisti());
        textViewPremi.setText(film.getPremi());
        textViewBoxOffice.setText(film.getIncassi());

        new DownloadImageTask(imageViewLocandina).execute(film.getURLimmagine());


        final LikeButton miPiace= view.findViewById(R.id.likeButton);
        miPiace.setLiked(film.isPreferito());

        miPiace.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                film.setPreferito(true);
                GestorePreferiti.aggiungi(context, film);
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                film.setPreferito(false);
                GestorePreferiti.rimuovi(context, film);
            }
        });



    }
}