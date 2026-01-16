package ricksciascia.entities;

public abstract class Gioco {
//    attributi
    private String id;
    private String titolo;
    private int anno;
    private double prezzo;
//    COSTRUTTORE
    public Gioco(String id,String titolo, int anno, double prezzo) {
        this.id = id;
        this.titolo = titolo;
        this.anno = anno;
//        lancio errore se prezzo minore o uguale 0
        if(prezzo<=0) {
            throw new IllegalArgumentException("Il prezzo deve essere un numero positivo");
        }
        this.prezzo = prezzo;
    }
//    GETTER E SETTER

    public String getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if(prezzo <= 0) {
            throw new IllegalArgumentException("Il prezzo deve essere un numero positivo");
        }
        this.prezzo = prezzo;
    }
}
