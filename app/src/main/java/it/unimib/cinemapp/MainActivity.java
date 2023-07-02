package it.unimib.cinemapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag("ricerca_fragment") != null) {
            //Sono nella ricerca
            getSupportFragmentManager().popBackStack("ricerca_fragment_tag",
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else if (getSupportFragmentManager().findFragmentByTag("mostra_film_fragment") != null) {
            //Sono nella ricerca
            getSupportFragmentManager().popBackStack("mostra_fragment_tag",
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}