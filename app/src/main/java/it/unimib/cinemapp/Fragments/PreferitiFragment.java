package it.unimib.cinemapp.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
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
import it.unimib.cinemapp.Util.GestorePreferiti;
import it.unimib.cinemapp.Util.PreferitiRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreferitiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PreferitiFragment extends Fragment {

   private List<Film> filmList;
   private FilmMultipliRecyclerViewAdapter adapter;
   private Context context;
    public PreferitiFragment() {
    }

    public static PreferitiFragment newInstance() {
        PreferitiFragment fragment = new PreferitiFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preferiti, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        toolbar.setTitle(R.string.preferenze);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<String> ids= GestorePreferiti.leggiElenco(context);


        RecyclerView recyclerView=view.findViewById(R.id.RecyclerViewPreferiti);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
        PreferitiRecyclerViewAdapter preferitiRecyclerViewAdapter= new PreferitiRecyclerViewAdapter(ids,
                new PreferitiRecyclerViewAdapter.OnItemClickListener() {
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
        recyclerView.setAdapter(preferitiRecyclerViewAdapter);
    }
}