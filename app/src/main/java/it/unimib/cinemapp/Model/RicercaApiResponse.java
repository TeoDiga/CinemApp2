package it.unimib.cinemapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {this.errorMessage = errorMessage;}

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
