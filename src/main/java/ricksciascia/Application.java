package ricksciascia;

import ricksciascia.entities.Genere;
import ricksciascia.entities.GiocoDaTavolo;
import ricksciascia.entities.Videogioco;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione();

        collezione.addNew(new Videogioco("V1","Cyberpunk 2077",2020,39.90,"PC", 120, Genere.RPG));
        collezione.addNew(new Videogioco("V2","The Witcher 3",2015,19.90,"PC", 100, Genere.RPG));
        collezione.addNew(new GiocoDaTavolo("T1","Monopoli",1970,29.90,2,240));
        collezione.addNew(new GiocoDaTavolo("T2","Risiko",2000,59.90,4,300));
//        collezione.addNew(new Videogioco("V1","test",1999,10.00,"PC",10,Genere.RPG));

//        System.out.println(collezione.searchById("T2"));
//        System.out.println(collezione.searchById("T3"));
//        System.out.println(collezione.searchByPrice(19.99));
//        System.out.println(collezione);
//        System.out.println(collezione.searchByPlayerNumber(2));
        
    }
}
