package it.unimib.cinemapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmApiResponse {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("runtimeStr")
    @Expose
    private String runtime;
    @SerializedName("plot")
    @Expose
    private String plot;
    @SerializedName("awards")
    @Expose
    private String awards;
    @SerializedName("directors")
    @Expose
    private String director;
    @SerializedName("writers")
    @Expose
    private String writers;
    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("genres")
    @Expose
    private String genres;
    @SerializedName("companies")
    @Expose
    private String companies;
    @SerializedName("countries")
    @Expose
    private String countries;
    @SerializedName("imDbRating")
    @Expose
    private String imDbRating;
    @SerializedName("metacriticRating")
    @Expose
    private String metacriticRating;
    @SerializedName("boxOffice")
    @Expose
    private BoxOffice boxOffice;
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getYear() {
        return year;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getPlot() {
        return plot;
    }

    public String getAwards() {
        return awards;
    }

    public String getDirector() {
        return director;
    }

    public String getWriters() {
        return writers;
    }

    public String getStars() {
        return stars;
    }

    public String getGenres() {
        return genres;
    }

    public String getCompanies() {
        return companies;
    }

    public String getCountries() {
        return countries;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public String getMetacriticRating() {
        return metacriticRating;
    }

    public BoxOffice getBoxOffice() {
        return boxOffice;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public class BoxOffice{
        @SerializedName("budget")
        @Expose
        private String budget;
        @SerializedName("cumulativeWorldwideGross")
        @Expose
        private String cumulativeWorldwideGross;

        public String getBudget() {
            return budget;
        }

        public String getCumulativeWorldwideGross() {
            return cumulativeWorldwideGross;
        }
    }
}
