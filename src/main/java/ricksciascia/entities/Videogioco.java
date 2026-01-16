package ricksciascia.entities;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int timeToBeat;
    private Genere genere;

    public Videogioco(String id, String titolo, int anno, double prezzo, String piattaforma, int timeToBeat, Genere genere) {
        super(id, titolo, anno, prezzo);
        this.piattaforma = piattaforma;
        this.timeToBeat = timeToBeat;
        this.genere = genere;
    }
//    setter e getter
    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getTimeToBeat() {
        return timeToBeat;
    }

    public void setTimeToBeat(int timeToBeat) {
        this.timeToBeat = timeToBeat;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogioco " + "ID: " + getId() +" TITOLO: " + getTitolo() + " anno: " + getAnno() + " PREZZO: " + getPrezzo() +
                " piattaforma='" + piattaforma + '\'' +
                ", timeToBeat=" + timeToBeat +
                ", genere=" + genere +
                '.';
    }
}
