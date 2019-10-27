package space.population;

import lombok.*;
import lombok.experimental.SuperBuilder;
import space.Plansza;
import space.Pole;
import space.population.myExceptions.GuideIsNotANeighborOfPositionException;
import space.population.myExceptions.GuideSameAsPositionException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@SuperBuilder
@NoArgsConstructor
public class PionekAbstractImplementation<GenericTypeExtendingPole extends Pole, GenericTypeExtendingPlansza extends Plansza>{
    private GenericTypeExtendingPole pozycja;
//    @Builder.ObtainVia(method = "setPrzewodnik")
    private GenericTypeExtendingPole przewodnik;
    private GenericTypeExtendingPole plecy;
    private GenericTypeExtendingPlansza plansza;
    private Set<GenericTypeExtendingPole> przod;
    private Set<GenericTypeExtendingPole> tyl;
    private Map<GenericTypeExtendingPole, String> facings;
    private int ruch;

    public void setPrzewodnik(GenericTypeExtendingPole newPrzewodnik) {
        if (newPrzewodnik.equals(pozycja)) {
            throw new GuideSameAsPositionException("Both position and guide point to the same field:  "+newPrzewodnik.toString());
        }
        List<GenericTypeExtendingPole> sasiedzi = (List<GenericTypeExtendingPole>) plansza.getSasiedziFunkcja.apply(pozycja,List.of());
        if (!sasiedzi.contains(newPrzewodnik)) {
            throw new GuideIsNotANeighborOfPositionException(newPrzewodnik.toString());
        }
        GenericTypeExtendingPole newPlecy = sasiedzi.stream().filter(a -> ((double)plansza.getOdlegloscFunkcja.apply(a,newPrzewodnik) >= 1.99)).findFirst().orElse(null);
        if (newPlecy.equals(pozycja)) {
            throw new GuideSameAsPositionException("Both position and rear point to the same field:  "+newPlecy.toString());
        }
        Set<GenericTypeExtendingPole> newPrzod = sasiedzi.stream().filter(a -> ((double)plansza.getOdlegloscFunkcja.apply(a,newPrzewodnik) >= 0.99 && (double)plansza.getOdlegloscFunkcja.apply(a,newPrzewodnik) <= 1.0)).collect(Collectors.toSet());
        newPrzod.add(newPrzewodnik);
        Set<GenericTypeExtendingPole> newTyl = sasiedzi.stream().filter(a -> ((double)plansza.getOdlegloscFunkcja.apply(a,newPrzewodnik) >= 1.73 && (double)plansza.getOdlegloscFunkcja.apply(a,newPrzewodnik) <= 1.74)).collect(Collectors.toSet());
        newTyl.add(newPlecy);
        if (!Collections.disjoint(newPrzod, newTyl) || !sasiedzi.containsAll(newPrzod) || !sasiedzi.containsAll(newTyl)){
            throw new GuideIsNotANeighborOfPositionException("Problem with sets;");
        }
        setFacings(newPrzewodnik, newPlecy, newPrzod, newTyl);
    }

    private void setFacings(GenericTypeExtendingPole newPrzewodnik, GenericTypeExtendingPole newPlecy, Set<GenericTypeExtendingPole> newPrzod, Set<GenericTypeExtendingPole> newTyl){
        przewodnik = newPrzewodnik;
        plecy = newPlecy;
        przod = newPrzod;
        tyl = newTyl;
        facings = new HashMap<>();
        Map <GenericTypeExtendingPole, String> mapka = newPrzod.stream().collect(Collectors.toMap(Function.identity(),a -> "przedni bok"));
        facings.putAll(mapka);
        mapka.clear();
        mapka = newTyl.stream().collect(Collectors.toMap(Function.identity(),a -> "tylny bok"));
        facings.putAll(mapka);
        facings.put(przewodnik, "przod");
        facings.put(plecy, "tyl");
    }
}
