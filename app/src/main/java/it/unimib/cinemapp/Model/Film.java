package it.unimib.cinemapp.Model;

public class Film {
    //parametri
    private String ID;
    private String titolo;
    private String descrizione;

    //costruttori
    public Film(Result result){
        this.ID= result.getId();
        this.titolo=result.getTitle();
        this.descrizione= result.getDescription();
    }
    //getter e setter

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    //parcelable
}
