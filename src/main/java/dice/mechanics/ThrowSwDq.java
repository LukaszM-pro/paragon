package dice.mechanics;

import configuration.Kostki;
import configuration.MetaDane;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ThrowSwDq {
    private final int JEDYNKA = Kostki.Kosci.K1.getScianki();
    private final String KOSC_SLABA_NAPIS = MetaDane.SLABE_KOSCI.getNapis();
    private final int KOSC_SLABA_WARTOSC = Kostki.Kosci.SLABA_KOSC.getScianki();
    private final String KOSC_MOCNA_NAPIS = MetaDane.MOCNE_KOSCI.getNapis();
    private final int KOSC_MOCNA_WARTOSC = Kostki.Kosci.MOCNA_KOSC.getScianki();

    private static int getIloscSlabychKosci (int atr, int skl) {
        int wyzszyParametr = Math.max(atr, skl);
        int nizszyParametr = Math.min(atr, skl);
        int kosckiSlabe = wyzszyParametr - nizszyParametr;
        return kosckiSlabe;
    }

    private static int getIloscMocnychKosci (int atr, int skl) {
        int nizszyParametr = Math.min(atr, skl);
        int kosciMocne = nizszyParametr;
        return kosciMocne;
    }

    private int getPrzerzuconaJedynka (int oryginalnyRzut, int przerzuty, Supplier<Integer> kostkiRzut) {
        if (oryginalnyRzut == JEDYNKA && przerzuty > 0) {
            przerzuty--;
            return kostkiRzut.get();
        } else {
            return oryginalnyRzut;
        }
    }

    private IntStream getStrumienSW (int atr, int skl, int ap, int arm) {
        final Cnt przerzuty = new Cnt(ap);
        int iloscSlabychKosci = getIloscSlabychKosci(atr, skl);
        int iloscMocnychKosci = getIloscMocnychKosci(atr, skl);
        IntStream strumienMocnych = IntStream.generate(Kostki::rzutK10).limit(iloscMocnychKosci).map(a -> getPrzerzuconaJedynka(a, przerzuty.i, Kostki::rzutK10));
        IntStream strumienSlabych = IntStream.generate(Kostki::rzutK6).limit(iloscSlabychKosci);
//                .map(a -> getPrzerzuconaJedynka(a, przerzuty.i, Kostki::rzutK6));
        IntStream przesortowanyOdwrotnieStrumienWynikowy = IntStream.concat(strumienSlabych, strumienMocnych).filter(a -> a > arm).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue);
        return przesortowanyOdwrotnieStrumienWynikowy;
    }

    private IntStream getStrumienSW (int atr, int skl) {
        return getStrumienSW(atr, skl, 0, 0);
    }

    private class Cnt {
        int i;
        int w;
        private Cnt () {}
        private Cnt (int i) { this.i = i; }
        private Cnt (int i, int w) {
            this.i = i;
            this.w = w;
        }
    }

    public int getResultDQ (int a1, int a2, int p1, int p2, int ap, int arm) {
        IntStream aktywnychStrumien = getStrumienSW(a1, a2, ap, arm);
        IntStream pasywnychStrumien = getStrumienSW(p1, p2);
        int[] aktywnySzyk = aktywnychStrumien.toArray();
        int[] pasywnySzyk = pasywnychStrumien.toArray();
        final Cnt a = new Cnt();
        a.w = Math.max(0, aktywnySzyk.length - pasywnySzyk.length);
        Arrays.stream(aktywnySzyk).forEach(elementAktywny -> {
            if (elementAktywny > pasywnySzyk[a.i]) { a.w++; } else { a.i++; }
        });
        return a.w;
    }

    private static int getWybuchajacaKosc(int prog, int wybuch, int scianki) {
        int rzut = Kostki.rzut(scianki);
        int wynik = rzut>=prog?1:0;
        while (rzut >= wybuch) {
            rzut = Kostki.rzut(scianki);
            if (rzut>=prog) {
                wynik++;
            }
        }
        return wynik;
    }

    public static int rnd(int atr, int skl) {
        int iloscSlabychKosci = getIloscSlabychKosci(atr, skl);
        int iloscMocnychKosci = getIloscMocnychKosci(atr, skl);
        int wynikSlabych = (iloscSlabychKosci==0)?0:IntStream.generate(() -> getWybuchajacaKosc(7,11, 12)).limit(iloscSlabychKosci).sum();
        int wynikMocnych = (iloscMocnychKosci==0)?0:IntStream.generate(() -> getWybuchajacaKosc(7,11, 20)).limit(iloscMocnychKosci).sum();
        return  wynikSlabych + wynikMocnych;
    }

}
