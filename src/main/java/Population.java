import com.google.gson.annotations.SerializedName;

public class Population{

    @SerializedName("ID Nation")
    private String IDNation;
    private String Nation;
    @SerializedName("ID Year")
    private int IDYear;
    private String Year;
    private long Population;
    @SerializedName("Slug Nation")
    private String SlugNation;

    public String getIDNation() {
        return IDNation;
    }

    public String getNation() {
        return Nation;
    }

    public int getIDYear() {
        return IDYear;
    }

    public String getYear() {
        return Year;
    }

    public long getPopulation() {
        return Population;
    }

    public String getSlugNation() {
        return SlugNation;
    }

    public void setIDNation(String IDNation) {
        this.IDNation = IDNation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public void setIDYear(int IDYear) {
        this.IDYear = IDYear;
    }

    public void setYear(String year) {
        Year = year;
    }

    public void setPopulation(long population) {
        Population = population;
    }

    public void setSlugNation(String slugNation) {
        SlugNation = slugNation;
    }

    @Override
    public String toString() {
        return "Population{" +
                "IDNation='" + IDNation + '\'' +
                ", Nation='" + Nation + '\'' +
                ", IDYear=" + IDYear +
                ", Year='" + Year + '\'' +
                ", Population=" + Population +
                ", SlugNation='" + SlugNation + '\'' +
                '}';
    }
}
