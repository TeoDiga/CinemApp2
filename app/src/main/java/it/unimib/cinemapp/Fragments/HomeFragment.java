package it.unimib.cinemapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.android.material.textfield.TextInputEditText;

import it.unimib.cinemapp.Model.Result;
import it.unimib.cinemapp.R;
import it.unimib.cinemapp.Util.APICalls;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private Toast toastLoading;

    private boolean lock;
    public HomeFragment() {    }
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        toastLoading=new Toast(getContext());
        View toastLayout=inflater.inflate(R.layout.toast_loading,
                (ViewGroup) container.findViewById(R.id.toast_lin_layout));
        toastLoading.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toastLoading.setDuration(Toast.LENGTH_LONG);
        toastLoading.setView(toastLayout);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lock=false;
        final TextInputEditText textInput=  view.findViewById(R.id.TIET_query);
        final Button bottone= view.findViewById(R.id.bottoneRicerca);
        bottone.setOnClickListener(v -> {
            if(lock){
                return;
            }
            lock=true;
            String ricerca=textInput.getText().toString().trim();
            if(ricerca.equals("")){
                lock=false;
                return;
            }
            toastLoading.show();


            APICalls.searchFilmQuery(ricerca).enqueue(new Callback<Result.RicercaApiResponse>() {
                @Override
                public void onResponse(Call<Result.RicercaApiResponse> call, Response<Result.RicercaApiResponse> response) {
                    getParentFragmentManager().beginTransaction().replace(
                            R.id.fragmentContainerView,
                            new EsitoRicercaFragment(response.body().conversione()),
                            "ricerca_fragment")
                            .addToBackStack("ricerca_fragment_tag")
                            .commit();
                }

                @Override
                public void onFailure(Call<Result.RicercaApiResponse> call, Throwable t) {
                    Snackbar.make(view, "errore", Snackbar.LENGTH_SHORT).show();
                }
            });
            //Snackbar.make(view, ricerca, Snackbar.LENGTH_SHORT).show();

        });
        final Button bottonePref= view.findViewById(R.id.buttonePref);
        bottonePref.setOnClickListener(v ->
                getParentFragmentManager().beginTransaction().replace(
                        R.id.fragmentContainerView,
                        new PreferitiFragment(),
                        "preferiti_fragment")
                .addToBackStack("preferiti_fragment_tag")
                .commit());
    }
}