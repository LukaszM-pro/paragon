package space;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class PlanszaKwadrat extends Plansza {
    public PlanszaKwadrat(int px, int py, int pz) {
        super(Szescian.class, px, py, pz);
    }
    public PlanszaKwadrat(int px, int py) {
        super(Szescian.class, px, py);
    }

    private List<Pole> getSasiedziKwadrat(Pole p, List<Pole> listaWykluczen, boolean czyWlacznieZKrawedziamiIRogami) {
        List<Pole> listaWynikowa = new ArrayList();
        Pole p0 = getPole(p.x()+1, p.y(), p.z());
        Pole p1 = getPole(p.x()-1, p.y(), p.z());
        Pole p2 = getPole(p.x(), p.y()+1, p.z());
        Pole p3 = getPole(p.x(), p.y()-1, p.z());
        if (p0 != null && !listaWykluczen.contains(p0)) {listaWynikowa.add(p0);}
        if (p1 != null && !listaWykluczen.contains(p1)) {listaWynikowa.add(p1);}
        if (p2 != null && !listaWykluczen.contains(p2)) {listaWynikowa.add(p2);}
        if (p3 != null && !listaWykluczen.contains(p3)) {listaWynikowa.add(p3);}

        if (czyWlacznieZKrawedziamiIRogami) {
            Pole p4 = getPole(p.x()+1, p.y()+1, p.z());
            Pole p5 = getPole(p.x()-1, p.y()-1, p.z());
            Pole p6 = getPole(p.x()-1, p.y()+1, p.z());
            Pole p7 = getPole(p.x()+1, p.y()-1, p.z());
            if (p4 != null && !listaWykluczen.contains(p4)) {listaWynikowa.add(p4);}
            if (p5 != null && !listaWykluczen.contains(p5)) {listaWynikowa.add(p5);}
            if (p6 != null && !listaWykluczen.contains(p6)) {listaWynikowa.add(p6);}
            if (p7 != null && !listaWykluczen.contains(p7)) {listaWynikowa.add(p7);}
        }
        if (rogZ > 0) {

            if (!czyWlacznieZKrawedziamiIRogami) {
                Pole p8 = getPole(p.x(), p.y(), p.z()+1);
                Pole p9 = getPole(p.x(), p.y(), p.z()-1);
                if (p8 != null && !listaWykluczen.contains(p8)) {listaWynikowa.add(p8);}
                if (p9 != null && !listaWykluczen.contains(p9)) {listaWynikowa.add(p9);}
            }

            if (czyWlacznieZKrawedziamiIRogami) {
                for (int x = Math.max(p.x()-1, rogZero); x <= Math.min(p.x()+1, rogX); x++) {
                    for (int y = Math.max(p.y()-1, rogZero); y <= Math.min(p.y()+1, rogY); y++) {
                        Pole pp0 = getPole(x, y, p.z()-1);
                        Pole pp1 = getPole(x, y, p.z()+1);
                        if (pp0 != null && !listaWykluczen.contains(pp0)) {listaWynikowa.add(pp0);}
                        if (pp1 != null && !listaWykluczen.contains(pp1)) {listaWynikowa.add(pp1);}
                    }
                }
            }
        }
        return listaWynikowa;
    }

    private List<Pole> getSasiedziKwadratRuch(Pole p, List<Pole> listaWykluczen) {return getSasiedziKwadrat(p, listaWykluczen,false);}
    public final BiFunction<Pole, List<Pole>, List<Pole>> getSasiedziKwadratRuchFunkcja = (a,b) -> getSasiedziKwadratRuch(a,b);

    private List<Pole> getSasiedziKwadratStrzal(Pole p, List<Pole> listaWykluczen) {return getSasiedziKwadrat(p, listaWykluczen, true);}
    public final BiFunction<Pole, List<Pole>, List<Pole>> getSasiedziKwadratStrzalFunkcja = (a,b) -> getSasiedziKwadratStrzal(a,b);

    private double getOdlegloscKwadrat(Pole s, Pole m) {
        int valX = Math.abs(s.x() - m.x());
        int valY = Math.abs(s.y() - m.y());
        int valZ = Math.abs(s.z() - m.z());
        double odleglosc2D = Math.sqrt(Math.pow(valX, 2) + Math.pow(valY, 2)) / 2;
        return (rogZ==0) ? odleglosc2D : (Math.sqrt(Math.pow(odleglosc2D, 2) + Math.pow(valZ, 2)) / 2);
    }

    @Override
    protected List getSasiedzi(Pole p, List listaWykluczen) {
        return null;
    }

    @Override
    protected double getOdleglosc(Pole s, Pole m) {
        return 0;
    }

    @Override
    protected int getKroki(Pole s, Pole m) {
        return 0;
    }
}
