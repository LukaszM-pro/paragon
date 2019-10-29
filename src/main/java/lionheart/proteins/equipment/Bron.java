package lionheart.proteins.equipment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Bron {

    private final int SKUTECZNOSC;

    /*
    final int WAGA;
    final int SKUTECZNOSC;
    final int JAKOSC;

    public Bron (String typ) {
        if (typ == "2") {
            WAGA = 2;
            SKUTECZNOSC = 2;
            JAKOSC = 0;
        } else if (typ == "1") {
            WAGA = 1;
            SKUTECZNOSC = 1;
            JAKOSC = 0;
        } else {
            WAGA = 0;
            SKUTECZNOSC = 0;
            JAKOSC = 0;
        }
    }

    public int getSkutecznosc(){
        return SKUTECZNOSC;
    }

    public int getWaga(){
        return WAGA;
    }

    public int getJakosc(){
        return JAKOSC;
    }

    public int getModInicjatywy(){
        return 0;
    }

    public int getModAtaku(){
        return 0;
    }

    public int getModObrony(){
        return 0;
    }

    public int getModPrzebicia(){
        return 0;
    }

    public int getModWyparowania(){
        return 0;
    }

    public int getModZagrozenia(){
        return 0;
    }

    public int getModZywotnosci(){
        return 0;
    }

/**/
}
