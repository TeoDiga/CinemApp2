package it.unimib.cinemapp.Util;

import it.unimib.cinemapp.Model.FilmApiResponse;
import it.unimib.cinemapp.Model.Result;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICalls {

    public static Call<Result.RicercaApiResponse> searchFilmQuery(String query){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://imdb-api.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        FilmRestService service= retrofit.create(FilmRestService.class);
        return service.listFilm(query);
    }
    public static Call<FilmApiResponse> findFilmById(String ID){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://imdb-api.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        FilmRestService service= retrofit.create(FilmRestService.class);
        return service.filmSingolo(ID);
    }

}
