package space.population;

import lombok.NonNull;
import space.Hex;
import space.Plansza;
import space.PlanszaHex;
import space.Pole;
import space.population.myExceptions.GuideSameAsPositionException;

public class PionekFactory {

    @NonNull
    public static PionekHex getPionekHex(PlanszaHex plansza, Hex pozycja, Hex przewodnik, int ruch) {
        if (pozycja.equals(przewodnik)) {
            throw new GuideSameAsPositionException(pozycja.toString());
        }
        PionekHex manufacturedPionek = PionekHex.builder()
            .plansza(plansza)
            .pozycja(pozycja)
            .przewodnik(przewodnik)
            .ruch(ruch)
            .build();
        manufacturedPionek.obrocSie(przewodnik);
        return manufacturedPionek;
    }

}
