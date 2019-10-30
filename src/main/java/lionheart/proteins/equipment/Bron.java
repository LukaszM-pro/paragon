package lionheart.proteins.equipment;

import lionheart.config.ConfigLionheart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Bron {

    private final int WAGA;
    private final int JAKOSC;

    public int getOstrosc() {
        return WAGA + JAKOSC;
    }

//    public int getModyfikatorSkutecznosci() {
//        return WAGA + JAKOSC / ConfigLionheart.DZIELNIK_SKL_EQ / 2;
//    }

//    public int getModyfikatorWagi() {
//        return WAGA / ConfigLionheart.DZIELNIK_SKL_EQ;
//    }

    public int getModIni() {
        return WAGA;
    }

}
