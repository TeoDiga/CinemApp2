package it.unimib.cinemapp.Util;

import it.unimib.cinemapp.Model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmRestService {
    @GET("en/API/SearchMovie/k_i9h6l2b5/{titolo}")
    Call<Result.RicercaApiResponse> listFilm(@Path("titolo") String titolo);

    //@GET("en/API/Title/k_i9h6l2b5/{id}")
    //Call<> filmSingolo(@Path("id") String id);
}
