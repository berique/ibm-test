package br.com.ibm.assassinato.utils;

import br.com.ibm.assassinato.models.Gun;
import br.com.ibm.assassinato.models.Location;
import br.com.ibm.assassinato.models.Suspect;

public class HypothesisUtils {
    public final static Gun[] GUNS = new Gun[]{
            new Gun("Peixeira"),
            new Gun("DynaTAC 8000X"),
            new Gun("Trezoitão"),
            new Gun("Trebuchet"),
            new Gun("Maça"),
            new Gun("Gládio")
    };

    public final static Location[] LOCATIONS = new Location[]{
            new Location("Redmond"),
            new Location("Palo Alto"),
            new Location("San Francisco"),
            new Location("Tokio"),
            new Location("Restaurante no Fim do Universo"),
            new Location("São Paulo"),
            new Location("Cupertino"),
            new Location("Helsinki"),
            new Location("Maida Vale"),
            new Location("Toronto"),
    };

    public final static Suspect[] SUSPECTS = new Suspect[] {
            new Suspect("Charles B. Abbage"),
            new Suspect("Donald Duck Knuth"),
            new Suspect("Ada L. Ovelace"),
            new Suspect("Alan T. Uring"),
            new Suspect("Ivar J. Acobson"),
            new Suspect("Ras Mus Ler Dorf"),
    };
}
