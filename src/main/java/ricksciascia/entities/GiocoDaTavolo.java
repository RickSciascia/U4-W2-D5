package ricksciascia.entities;

public class GiocoDaTavolo extends Gioco{
//    attrubuti specifici
    private int numberOfPlayers;
    private int durataMedia;

    public GiocoDaTavolo(String id, String titolo, int anno, double prezzo, int numberOfPlayers, int durataMedia)
            throws IllegalArgumentException {
        super(id, titolo, anno, prezzo);
        if(numberOfPlayers <2 || numberOfPlayers > 10){
            throw new IllegalArgumentException("Il numero di giocatori deve essere compreso tra 2 e 10");
        }
        this.numberOfPlayers = numberOfPlayers;
        this.durataMedia = durataMedia;
    }
//GETTER
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getDurataMedia() {
        return durataMedia;
    }
//    SETTER

    public void setNumberOfPlayers(int numberOfPlayers) throws IllegalArgumentException {
        if(numberOfPlayers <2 || numberOfPlayers > 10) {
            throw new IllegalArgumentException("Il numero di giocatori deve essere compreso tra 2 e 10");
        }
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setDurataMedia(int durataMedia) {
        this.durataMedia = durataMedia;
    }
}
