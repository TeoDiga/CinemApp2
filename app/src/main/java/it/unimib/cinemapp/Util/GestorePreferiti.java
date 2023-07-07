package it.unimib.cinemapp.Util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import it.unimib.cinemapp.Model.Film;
import it.unimib.cinemapp.R;

public class GestorePreferiti {
    public static void aggiungi(Context context, Film film) {
        String key = context.getString(R.string.chiave_preferiti);

        SharedPreferences sharedPreferences =
                context.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        //https://anupamchugh.medium.com/a-nightmare-with-shared-preferences-and-stringset-c53f39f1ef52
        Set<String> vecchio = new HashSet<String>(sharedPreferences.getStringSet(key, new HashSet<String>()));

        vecchio.add(film.getID());
        editor.putStringSet(key, vecchio);
        editor.apply();
    }

    public static void rimuovi(Context context, Film film) {
        String key = context.getString(R.string.chiave_preferiti);

        SharedPreferences sharedPreferences =
                context.getSharedPreferences(key, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        //https://anupamchugh.medium.com/a-nightmare-with-shared-preferences-and-stringset-c53f39f1ef52
        Set<String> vecchio = new HashSet<String>(sharedPreferences.getStringSet(key, new HashSet<String>()));

        vecchio.remove(film.getID());
        editor.putStringSet(key, vecchio);
        editor.apply();
    }

    public static boolean isPreferito(Context context, Film film) {
        String key = context.getString(R.string.chiave_preferiti);

        SharedPreferences sharedPreferences =
                context.getSharedPreferences(key, Context.MODE_PRIVATE);

        //https://anupamchugh.medium.com/a-nightmare-with-shared-preferences-and-stringset-c53f39f1ef52
        Set<String> set = new HashSet<String>(sharedPreferences.getStringSet(key, new HashSet<String>()));

        return set.contains(film.getID());

    }
    public static ArrayList<String> leggiElenco(Context context){
        String key= context.getString(R.string.chiave_preferiti);
        SharedPreferences sharedPreferences=context.getSharedPreferences(key, Context.MODE_PRIVATE);
        Set<String> elenco =sharedPreferences.getStringSet(key, null);
        ArrayList<String> esito= new ArrayList<>();
        esito.addAll(elenco);
        return esito;
    }

}
