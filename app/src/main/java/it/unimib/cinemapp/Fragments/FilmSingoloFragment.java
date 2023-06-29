package it.unimib.cinemapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.unimib.cinemapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilmSingoloFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmSingoloFragment extends Fragment {


    public static FilmSingoloFragment newInstance() {
        FilmSingoloFragment fragment = new FilmSingoloFragment();
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
        return inflater.inflate(R.layout.fragment_film_singolo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}