package it.unimib.cinemapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Result {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("resultType")
    @Expose
    private String resultType;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;

    public String getId() {
        return id;
    }

    public String getResultType() {
        return resultType;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public class RicercaApiResponse {
        @SerializedName("searchType")
        @Expose
        private String searchType;
        @SerializedName("expression")
        @Expose
        private String expression;
        @SerializedName("results")
        @Expose
        private List<Result> results;
        @SerializedName("errorMessage")
        @Expose
        private String errorMessage;

        public List<Film> conversione(){
            List<Film> lista= new ArrayList<>();
            Iterator<Result> iterator= results.iterator();
            while (iterator.hasNext()){
                Result filmCercato=iterator.next();
                Film film= new Film(filmCercato);
                lista.add(film);
            }
            return lista;
        }
    }
}