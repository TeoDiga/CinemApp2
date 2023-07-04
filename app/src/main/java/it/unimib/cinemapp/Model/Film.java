package it.unimib.cinemapp.Model;

public class Film {
    //parametri
    private String ID;
    private String titolo;
    private String descrizione;
    private String anno;
    private String durata;
    private String trama;
    private String premi;
    private String regista;
    private String sceneggiatore;
    private String cast;
    private String genere;
    private String compagnia;
    private String paese;
    private String votoUtenti;
    private String votoProfessionisti;
    private String budget;
    private String incassi;


    private String URLimmagine;

    private boolean preferito;

    //costruttori
    public Film(Result result){
        this.ID= result.getId();
        this.titolo=result.getTitle();
        this.descrizione= result.getDescription();
        this.URLimmagine=result.getImage();
        this.preferito=false;
    }
    public Film espandi(FilmApiResponse fonte){
        this.anno=fonte.getYear();
        this.paese=fonte.getCompanies();
        this.durata=fonte.getRuntime();

        this.regista=fonte.getDirector();
        this.sceneggiatore=fonte.getWriters();
        this.cast=fonte.getStars();

        this.compagnia=fonte.getCompanies();
        this.budget=fonte.getBoxOffice().getBudget();
        this.incassi=fonte.getBoxOffice().getCumulativeWorldwideGross();

        this.premi=fonte.getAwards();
        this.votoUtenti=fonte.getImDbRating();
        this.votoProfessionisti=fonte.getMetacriticRating();

        this.trama=fonte.getPlot();
        this.genere=fonte.getGenres();
        return this;
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

    public String getURLimmagine() {
        return URLimmagine;
    }

    public void setURLimmagine(String URLimmagine) {
        this.URLimmagine = URLimmagine;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public String getPremi() {
        return premi;
    }

    public void setPremi(String premi) {
        this.premi = premi;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public String getSceneggiatore() {
        return sceneggiatore;
    }

    public void setSceneggiatore(String sceneggiatore) {
        this.sceneggiatore = sceneggiatore;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getCompagnia() {
        return compagnia;
    }

    public void setCompagnia(String compagnia) {
        this.compagnia = compagnia;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getVotoUtenti() {
        return votoUtenti;
    }

    public void setVotoUtenti(String votoUtenti) {
        this.votoUtenti = votoUtenti;
    }

    public String getVotoProfessionisti() {
        return votoProfessionisti;
    }

    public void setVotoProfessionisti(String votoProfessionisti) {
        this.votoProfessionisti = votoProfessionisti;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getIncassi() {
        return incassi;
    }

    public void setIncassi(String incassi) {
        this.incassi = incassi;
    }

    public boolean isPreferito() {
        return preferito;
    }

    public void setPreferito(boolean preferito) {
        this.preferito = preferito;
    }
    //parcelable
}
