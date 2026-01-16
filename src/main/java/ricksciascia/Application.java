package ricksciascia;

import ricksciascia.entities.Genere;
import ricksciascia.entities.Gioco;
import ricksciascia.entities.GiocoDaTavolo;
import ricksciascia.entities.Videogioco;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Collezione collezione = new Collezione();

        collezione.addNew(new Videogioco("V1","Cyberpunk",2020,39.90,"PC", 120, Genere.RPG));
        collezione.addNew(new Videogioco("V2","The Witcher 3",2015,19.90,"PC", 100, Genere.RPG));
        collezione.addNew(new GiocoDaTavolo("T1","Monopoli",1970,29.90,2,240));
        collezione.addNew(new GiocoDaTavolo("T2","Risiko",2000,59.90,4,300));
        collezione.addNew(new Videogioco("V3","Project Cars",1999,100.00,"PC",30,Genere.SIM));
//        Videogioco newVideogioco = new Videogioco("V1","Cyberpunk 2077",2020,49.90,"PC",120,Genere.RPG);
        int scelta = -1;

//        System.out.println(collezione.searchById("T2"));
//        System.out.println(collezione.searchById("T3"));
//        System.out.println(collezione.searchByPrice(19.99));
//        System.out.println(collezione);
//        System.out.println(collezione.searchByPlayerNumber(2));
//        collezione.removeByID("V1");
//        collezione.updateById("V1",newVideogioco);
//        System.out.println(collezione);
//        collezione.printStatsCollection();
        do {
            System.out.println("---- Interfaccia collezione giochi ----");
            System.out.println("1. Aggiungi Gioco");
            System.out.println("2. Ricerca Gioco tramite ID");
            System.out.println("3. Ricerca Giochi tramite prezzo");
            System.out.println("4. Ricerca Giochi tramite numero giocatori");
            System.out.println("5. Rimuovi Gioco tramite ID");
            System.out.println("6. Aggiorna Gioco tramite ID");
            System.out.println("7. Stampa statistiche della collezione");

            scelta = Integer.parseInt(sc.nextLine());

            switch (scelta) {
                case 1:
                    try {
                        System.out.println("che tipo di gioco stai inserendo?");
                        System.out.println("1: videogioco");
                        System.out.println("2: gioco da tavolo");
                        int typeOfGame = Integer.parseInt(sc.nextLine());
                        System.out.println("ID: ");
                        String id = sc.nextLine();
                        System.out.println("Titolo: ");
                        String titolo = sc.nextLine();
                        System.out.println("Anno: ");
                        int anno = Integer.parseInt(sc.nextLine());
                        System.out.println("Prezzo: ");
                        double prezzo = Double.parseDouble(sc.nextLine());
                        if (typeOfGame == 1) {
                            System.out.println("Piattaforma: ");
                            String piattaforma = sc.nextLine();
                            System.out.println("Tempo per terminare il gioco espresso in ore: ");
                            int timeToBeat = Integer.parseInt(sc.nextLine());
                            System.out.println("Scegli Genere (ACTION, RPG, SPARATUTTO, SIM)");
                            String genereScritto = sc.nextLine().toUpperCase();
                            Genere genereScelto = Genere.valueOf(genereScritto);
                            Videogioco vg = new Videogioco(id,titolo,anno,prezzo,piattaforma,timeToBeat,genereScelto);
                            collezione.addNew(vg);
                        } else if(typeOfGame == 2) {
                            System.out.println("Numero di giocatori consigliato da 2 a 10 ");
                            int nGiocatori = Integer.parseInt(sc.nextLine());
                            System.out.println("Durata media delle partite del gioco che stai inserendo espresso in minuti: ");
                            int durataMedia = Integer.parseInt(sc.nextLine());
                            GiocoDaTavolo gdt = new GiocoDaTavolo(id,titolo,anno,prezzo,nGiocatori,durataMedia);
                            collezione.addNew(gdt);
                        }
                    }
                    catch(IllegalArgumentException ex) {
                        System.out.println("Errore: " + ex.getMessage());
                }
                    catch(Exception ex) {
                        System.out.println("Errore generico, controlla che i dati inseriti siano corretti!");
                    }
                    break;
                case 2:
                    try{
                        System.out.println("Inserisci ID del gioco da cercare: ");
                        String id = sc.nextLine();
                        Gioco giocoCorrispondente = collezione.searchById(id);
                        System.out.println("---- DETTAGLI GIOCO ----");
                        System.out.println(giocoCorrispondente);
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("chiusura programma");
                    break;
                default:
                    System.out.println("scelta non valida");
            }
        }
        while(scelta!=0);
    }
}
