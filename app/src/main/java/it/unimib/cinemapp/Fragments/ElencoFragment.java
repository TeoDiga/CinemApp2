package it.unimib.cinemapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import it.unimib.cinemapp.Model.Film;
import it.unimib.cinemapp.R;
import it.unimib.cinemapp.Util.FilmMultipliRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ElencoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElencoFragment extends Fragment {

    private List<Film> listFilm;
    private FilmMultipliRecyclerViewAdapter adapter;

    public ElencoFragment() {
        // Required empty public constructor
    }
    public static ElencoFragment newInstance() {
        ElencoFragment fragment = new ElencoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listFilm= new ArrayList<>();
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

        RecyclerView recyclerView=view.findViewById(R.id.recyclerViewRisultati);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
        FilmMultipliRecyclerViewAdapter filmMultipliRecyclerViewAdapter= new FilmMultipliRecyclerViewAdapter(listFilm,
                new FilmMultipliRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onFilmClick(Film film) {
                        //lanciare il nuovo fragment
                    }
                });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(filmMultipliRecyclerViewAdapter);
    }
}