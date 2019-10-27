package space;

import space.abstractFactory.Manufakturka;
import space.myExceptions.ThirdDimensionProblemException;
import java.io.Serializable;
import java.util.*;
import java.util.function.BiFunction;

public abstract class Plansza <GenericTypeExtendingPole extends Pole> implements Serializable {

    private Map<List<Integer>, GenericTypeExtendingPole> mapaByXYZ;
    protected static final int rogZero = 0;
    protected static int rogX;
    protected static int rogY;
    protected static int rogZ;

    public Plansza(Class<GenericTypeExtendingPole> clazz, int px, int py, int pz) {
        int szerokosc = px - 1;
        int glebokosc = py - 1;
        int wysokosc = pz - 1;
        Manufakturka manufakturka = new Manufakturka<>(clazz);
        Map<List<Integer>, GenericTypeExtendingPole> mxy = new HashMap<>();
        for (int x = rogZero; x <= szerokosc; x++) {
            for (int y = rogZero; y <= glebokosc; y++) {
                for (int z = rogZero; z <= wysokosc; z++) {
                    GenericTypeExtendingPole p = (GenericTypeExtendingPole) manufakturka.buildOne(x,y,z);
                            mxy.put(List.of(x,y,z), p);
                }
            }
        }
        mapaByXYZ = mxy;
        rogX = szerokosc;
        rogY = glebokosc;
        rogZ = wysokosc;
    }

    public Plansza(Class<GenericTypeExtendingPole> clazz, int bok) {
        this(clazz, bok, bok, bok);
    }

    public Plansza(Class<GenericTypeExtendingPole> clazz, int x, int y) {
        this(clazz, x, y, 1);
    }

    public Map<List<Integer>, GenericTypeExtendingPole> getMapaByXYZ() {
        return mapaByXYZ;
    }

    public GenericTypeExtendingPole getPole(int x, int y, int z) {
        return mapaByXYZ.getOrDefault(List.of(x,y,z), null);
    }

    public GenericTypeExtendingPole getPole(int x, int y) {
        if (rogZ==0) {
            return getPole(x,y,0);
        } else {
            throw new ThirdDimensionProblemException("Nie podano wartości dla trzeciego wymiaru! ("+rogZero+"-"+rogZ+")");
        }
    }

    abstract protected List getSasiedzi(GenericTypeExtendingPole p, List<GenericTypeExtendingPole> listaWykluczen);
    public final BiFunction<GenericTypeExtendingPole, List<GenericTypeExtendingPole>, List<GenericTypeExtendingPole>> getSasiedziFunkcja = (a,b) -> getSasiedzi(a,b);

    abstract protected double getOdleglosc(GenericTypeExtendingPole s, GenericTypeExtendingPole m);
    public final BiFunction<GenericTypeExtendingPole, GenericTypeExtendingPole, Double> getOdlegloscFunkcja = (a,b) -> getOdleglosc(a,b);

    abstract protected int getKroki(GenericTypeExtendingPole s, GenericTypeExtendingPole m);
    public final BiFunction<GenericTypeExtendingPole, GenericTypeExtendingPole, Integer> getKrokiFunkcja = (a,b) -> getKroki(a,b);

    protected List getOtoczenie(GenericTypeExtendingPole p, int o, BiFunction<GenericTypeExtendingPole, GenericTypeExtendingPole, Integer> funkcjaMierzacaKroki) {
        List<GenericTypeExtendingPole> listaWynikowa = new ArrayList<>();
        GenericTypeExtendingPole q;
        for (int x = Math.max(p.x()-o, rogZero); x <= Math.min(p.x()+o, rogX); x++) {
            for (int y = Math.max(p.y()-o, rogZero); y <= Math.min(p.y()+o, rogY); y++) {
                for (int z = Math.max(p.z()-o, rogZero); z <= Math.min(p.z()+o, rogZ); z++) {
                    q = getPole(x,y,z);
                    if (q != null && funkcjaMierzacaKroki.apply(p,q) <= o && q != p) {
                        listaWynikowa.add(q);
                    }
                }
            }
        }
        return listaWynikowa;
    }

    public List getOtoczenie(GenericTypeExtendingPole p, int o) {
        return getOtoczenie(p, o, getKrokiFunkcja);
    }

    private GenericTypeExtendingPole getNajblizszySasiad(GenericTypeExtendingPole s, GenericTypeExtendingPole m, BiFunction<GenericTypeExtendingPole, List<GenericTypeExtendingPole>, List<GenericTypeExtendingPole>> funkcjaGetSasiedzi, BiFunction<GenericTypeExtendingPole, GenericTypeExtendingPole, Double> funkcjaGetOdleglosc, List<GenericTypeExtendingPole> listaWykluczen, GenericTypeExtendingPole kotwica) {
        List<GenericTypeExtendingPole> listaRobocza = funkcjaGetSasiedzi.apply(s, listaWykluczen);
        Collections.shuffle(listaRobocza);
        listaRobocza.sort(Comparator
                .comparing((GenericTypeExtendingPole p) -> funkcjaGetOdleglosc.apply(p, m))
                .thenComparing((GenericTypeExtendingPole p) -> funkcjaGetOdleglosc.apply(p, kotwica==null?s:kotwica))
        );
        return listaRobocza.get(0);
    }

    public GenericTypeExtendingPole getNajblizszySasiad(GenericTypeExtendingPole s, GenericTypeExtendingPole m, List<GenericTypeExtendingPole> listaWykluczen, GenericTypeExtendingPole kotwica) {
        return getNajblizszySasiad(s, m, getSasiedziFunkcja, getOdlegloscFunkcja, listaWykluczen, kotwica);
    }

    public GenericTypeExtendingPole getNajblizszySasiad(GenericTypeExtendingPole s, GenericTypeExtendingPole m, List<GenericTypeExtendingPole> listaWykluczen) {
        return getNajblizszySasiad(s, m, getSasiedziFunkcja, getOdlegloscFunkcja, listaWykluczen, null);
    }

    public GenericTypeExtendingPole getNajblizszySasiad(GenericTypeExtendingPole s, GenericTypeExtendingPole m) {
        return getNajblizszySasiad(s, m, getSasiedziFunkcja, getOdlegloscFunkcja, new ArrayList<>(), null);
    }

    private List<GenericTypeExtendingPole> getSciezka(GenericTypeExtendingPole s, GenericTypeExtendingPole m, BiFunction<GenericTypeExtendingPole, List<GenericTypeExtendingPole>, List<GenericTypeExtendingPole>> funkcjaGetSasiedzi, BiFunction<GenericTypeExtendingPole, GenericTypeExtendingPole, Double> funkcjaGetOdleglosc, List<GenericTypeExtendingPole> listaZakazanychPol) {
        List<GenericTypeExtendingPole> listaWynikowa = new LinkedList<>();
        GenericTypeExtendingPole aktualnaPozycja = s;
        GenericTypeExtendingPole najblizszySasiad = s;
        while (najblizszySasiad != m) {
            najblizszySasiad = getNajblizszySasiad(aktualnaPozycja, m, funkcjaGetSasiedzi, funkcjaGetOdleglosc, listaZakazanychPol, null);
            listaWynikowa.add(najblizszySasiad);
            aktualnaPozycja = najblizszySasiad;
            listaZakazanychPol.addAll(listaWynikowa);
        }
        return listaWynikowa;
    }

    public List<GenericTypeExtendingPole> getSciezka(GenericTypeExtendingPole s, GenericTypeExtendingPole m, List<GenericTypeExtendingPole> listaZakazanychPol) {
        return getSciezka(s, m, getSasiedziFunkcja, getOdlegloscFunkcja, listaZakazanychPol);
    }

    public List<GenericTypeExtendingPole> getSciezka(GenericTypeExtendingPole s, GenericTypeExtendingPole m) {
        return getSciezka(s, m, getSasiedziFunkcja, getOdlegloscFunkcja, new LinkedList<>());
    }
}