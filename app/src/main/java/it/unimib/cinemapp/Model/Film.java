package it.unimib.cinemapp.Model;

public class Film {
    private String ID;
    private String titolo;


    public Film(Result result){
        this.ID= result.getId();
        this.titolo=result.getTitle();
    }
}
