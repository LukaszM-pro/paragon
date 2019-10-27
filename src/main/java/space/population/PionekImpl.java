package space.population;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import space.Hex;
import space.Plansza;
import space.Pole;
import space.population.myExceptions.PositionChangedByTurnAroundException;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@SuperBuilder
public class PionekImpl<GenericTypeExtendingPole extends Pole, GenericTypeExtendingPlansza extends Plansza>
        extends PionekAbstractImplementation <GenericTypeExtendingPole, GenericTypeExtendingPlansza>
        implements Pionek<GenericTypeExtendingPole> {

    private int ruszSie(GenericTypeExtendingPole cel, int iloscDostepnychKrokow) {
        List<GenericTypeExtendingPole> sciezka = getPlansza().getSciezka(getPozycja(), cel, new ArrayList(List.of(getPozycja())));
        List<GenericTypeExtendingPole> sasiedzi = (List<GenericTypeExtendingPole>) getPlansza().getSasiedziFunkcja.apply(getPozycja(),List.of());
        int kroki = Math.min(sciezka.size()-1, iloscDostepnychKrokow);
        if (!sasiedzi.contains(sciezka.get(kroki))) {
            setPozycja(sciezka.get(kroki - 1));
        }
        setPrzewodnik(sciezka.get(kroki));
        return sciezka.size();
    }

    private int obrocSie(GenericTypeExtendingPole cel, int iloscDostepnychKrokow) {
        GenericTypeExtendingPole pozycjaWyjsciowa = getPozycja();
        GenericTypeExtendingPole najblizszySasiad = (GenericTypeExtendingPole) getPlansza().getNajblizszySasiad(getPozycja(),cel,new ArrayList(List.of(getPozycja())),getPrzewodnik());
        int pozostaleKroki =  ruszSie(najblizszySasiad,iloscDostepnychKrokow);
        if (pozycjaWyjsciowa != getPozycja()) {
            throw new PositionChangedByTurnAroundException("Obrót pionka spowodował zmianę pozycji. "+pozycjaWyjsciowa+" vs."+getPozycja());
        }
        return pozostaleKroki;
    }

    @Override
    public void ruszSie(GenericTypeExtendingPole cel) {
        int pozostaleKroki = getRuch();
        pozostaleKroki = obrocSie(cel,pozostaleKroki);
        ruszSie(cel,pozostaleKroki);
    }

    @Override
    public void obrocSie(GenericTypeExtendingPole cel) {
        int pozostaleKroki = getRuch();
        obrocSie(cel,pozostaleKroki);
    }

    @Override
    public String getFacing(GenericTypeExtendingPole cel) {
        GenericTypeExtendingPole ns = (GenericTypeExtendingPole) getPlansza().getNajblizszySasiad(getPozycja(),cel);
        String s = getFacings().get(ns);
        return s;
    }
}
