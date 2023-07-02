package it.unimib.cinemapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import it.unimib.cinemapp.Model.Film;
import it.unimib.cinemapp.Model.FilmApiResponse;
import it.unimib.cinemapp.R;
import it.unimib.cinemapp.Util.APICalls;
import it.unimib.cinemapp.Util.FilmMultipliRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EsitoRicercaFragment extends Fragment {

    private List<Film> listFilm;
    private FilmMultipliRecyclerViewAdapter adapter;

    public EsitoRicercaFragment(List<Film> listFilm) {
        this.listFilm = listFilm;
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_elenco, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        RecyclerView recyclerView=view.findViewById(R.id.recyclerViewRisultati);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
        FilmMultipliRecyclerViewAdapter filmMultipliRecyclerViewAdapter= new FilmMultipliRecyclerViewAdapter(listFilm,
                new FilmMultipliRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onFilmClick(Film film) {
                        APICalls.findFilmById(film.getID()).enqueue(new Callback<FilmApiResponse>() {
                            @Override
                            public void onResponse(Call<FilmApiResponse> call, Response<FilmApiResponse> response) {
                                getParentFragmentManager().beginTransaction().replace(
                                                R.id.fragmentContainerView,
                                                new FilmSingoloFragment(film.espandi(response.body())),
                                                "mostra_film_fragment")
                                        .addToBackStack("mostra_film_fragment_tag")
                                        .commit();
                            }

                            @Override
                            public void onFailure(Call<FilmApiResponse> call, Throwable t) {
                                Snackbar.make(view, "errore", Snackbar.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(filmMultipliRecyclerViewAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}