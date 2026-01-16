package ricksciascia;

import ricksciascia.entities.Gioco;
import ricksciascia.entities.GiocoDaTavolo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collezione {
    private Map<String, Gioco> collezione = new HashMap<>();

//    metodi
    public void addNew(Gioco gioco) throws IllegalArgumentException {
        if(collezione.containsKey(gioco.getId())) {
            throw new IllegalArgumentException("Errore l ID " + gioco.getId() + " è già presente");
        } else {
            collezione.put(gioco.getId(), gioco);
        }
    }

    public Gioco searchById(String id) throws IllegalArgumentException {
        if(collezione.containsKey(id)) {
            return collezione.get(id);
        } else {
            throw new IllegalArgumentException("L Id inserito non è stato trovato!");
        }
    }

    public List<Gioco> searchByPrice(double prezzo) {
        List<Gioco> ricercaPerPrezzo = collezione.values().stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
        return ricercaPerPrezzo;
    }
    public List<GiocoDaTavolo> searchByPlayerNumber(int nGiocatori) {
        List<GiocoDaTavolo> ricercaPerGiocatori = collezione.values().stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .map(gioco -> (GiocoDaTavolo) gioco)
                .filter(gioco -> gioco.getNumberOfPlayers() == nGiocatori).toList();
        return ricercaPerGiocatori;
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "collezione=" + collezione +
                '}';
    }
}
