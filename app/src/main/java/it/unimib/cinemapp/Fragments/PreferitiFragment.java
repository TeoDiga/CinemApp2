package it.unimib.cinemapp.Fragments;

import android.content.Context;
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
import it.unimib.cinemapp.Util.GestorePreferiti;

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
        ArrayList<String> ids= GestorePreferiti.leggiElenco(context);

        RecyclerView recyclerView=view.findViewById(R.id.recyclerViewRisultati);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false);
    }
}