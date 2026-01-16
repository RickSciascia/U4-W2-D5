package ricksciascia;

import ricksciascia.entities.Gioco;
import ricksciascia.entities.GiocoDaTavolo;
import ricksciascia.entities.Videogioco;

import java.util.*;

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
    public void removeByID(String id) throws IllegalArgumentException {
        if(collezione.containsKey(id)) {
            collezione.remove(id);
            System.out.println("Elemento rimosso correttamente");
        } else {
            throw new IllegalArgumentException("Errore: L'Id inserito non è presente");
        }
    }

    public void updateById(String id, Gioco giocoAggiornato) throws IllegalArgumentException {
        if(collezione.containsKey(id)) {
            if(giocoAggiornato.getId().equals(id)) {
                if(giocoAggiornato.getClass().equals(collezione.get(id).getClass())) {
                    collezione.put(id, giocoAggiornato);
                    System.out.println("Il gioco con ID " + id + " è stato sovrascritto");
                }
                else{
                    throw new IllegalArgumentException("Errore : Stai provando ad aggiornare un gioco di categoria Videogioco con un gioco di categoria Gioco Da Tavolo o viceversa");
                }
            }
            else {
                throw new IllegalArgumentException("Errore: L'id del gioco che vuoi aggiornare " + id + " non corrisponde all id che fornisci nella sua versione aggiornata! " + giocoAggiornato.getId());
            }

        }
        else {
                throw new IllegalArgumentException("ID non trovato");
        }
    }

    public void printStatsCollection() {
        if(collezione.isEmpty()) {
            System.out.println("Non ci sono elementi nella collezione non posso calcolare le statistiche");
            return;
        }
        int nVG = collezione.values().stream()
                .filter(gioco-> gioco instanceof Videogioco).toList().size();

        int nGDT = collezione.values().stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo).toList().size();
        List<Gioco> giocoCaro = collezione.values().stream()
                .sorted(Comparator.comparingDouble(Gioco::getPrezzo).reversed()).limit(1).toList();

        OptionalDouble avgPrice = collezione.values().stream()
                .mapToDouble(gioco -> gioco.getPrezzo()).average();

        System.out.println("---------- STATISTICHE DELLA COLLEZIONE ----------");
        System.out.println("Numero di Videogiochi: " + nVG);
        System.out.println("Numero di Giochi da Tavolo: " + nGDT);
        if(avgPrice.isPresent()) {
            System.out.println("La media prezzi è: " + avgPrice.getAsDouble());
        }
        if(!giocoCaro.isEmpty()) {
            System.out.println("Il gioco più costoso è : " + giocoCaro.getFirst().getTitolo() + " " +  giocoCaro.getFirst().getPrezzo() + " euro");
        }
        System.out.println("---------- FINE STATISTICHE DELLA COLLEZIONE ----------");

    }

    @Override
    public String toString() {
        return "Collezione{" +
                "collezione=" + collezione +
                '}';
    }
}
