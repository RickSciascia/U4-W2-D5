package ricksciascia;

import ricksciascia.entities.Genere;
import ricksciascia.entities.GiocoDaTavolo;
import ricksciascia.entities.Videogioco;

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
        }
        while(scelta!=0);
    }
}
