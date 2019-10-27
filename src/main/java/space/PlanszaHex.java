package space;

import java.util.ArrayList;
import java.util.List;

public class PlanszaHex extends Plansza<Hex> {
    public PlanszaHex(int px, int py, int pz) {
        super(Hex.class, px, py, pz);
    }
    public PlanszaHex(int px, int py) {
        super(Hex.class, px, py);
    }

    public PlanszaHex(int px) {
        super(Hex.class, px);
    }

    public List<Hex> getSasiedziHex(Hex p, List<Hex> listaWykluczen) {
        List<Hex> listaWynikowa = new ArrayList<Hex>();
        Hex s0 = (Hex) getPole(p.x()+1, p.y()-1, p.z());
        Hex s1 = (Hex) getPole(p.x()+1, p.y(), p.z());
        Hex s2 = (Hex) getPole(p.x(), p.y()+1, p.z());
        Hex s3 = (Hex) getPole(p.x()-1, p.y()+1, p.z());
        Hex s4 = (Hex) getPole(p.x()-1, p.y(), p.z());
        Hex s5 = (Hex) getPole(p.x(), p.y()-1, p.z());
        if (s0 != null && !listaWykluczen.contains(s0)) {listaWynikowa.add(s0);}
        if (s1 != null && !listaWykluczen.contains(s1)) {listaWynikowa.add(s1);}
        if (s2 != null && !listaWykluczen.contains(s2)) {listaWynikowa.add(s2);}
        if (s3 != null && !listaWykluczen.contains(s3)) {listaWynikowa.add(s3);}
        if (s4 != null && !listaWykluczen.contains(s4)) {listaWynikowa.add(s4);}
        if (s5 != null && !listaWykluczen.contains(s5)) {listaWynikowa.add(s5);}

        if (rogZ > 0) {
            Hex s6 = (Hex) getPole(p.x() + 1, p.y(), p.z() - 1);
            Hex s7 = (Hex) getPole(p.x(), p.y(), p.z() + 1);
            Hex s8 = (Hex) getPole(p.x() - 1, p.y(), p.z() + 1);
            Hex s9 = (Hex) getPole(p.x(), p.y(), p.z() - 1);
            Hex s10 = (Hex) getPole(p.x(), p.y() + 1, p.z() - 1);
            Hex s11 = (Hex) getPole(p.x(), p.y() - 1, p.z() + 1);
            if (s6 != null && !listaWykluczen.contains(s6)) {listaWynikowa.add(s6);}
            if (s7 != null && !listaWykluczen.contains(s7)) {listaWynikowa.add(s7);}
            if (s8 != null && !listaWykluczen.contains(s8)) {listaWynikowa.add(s8);}
            if (s9 != null && !listaWykluczen.contains(s9)) {listaWynikowa.add(s9);}
            if (s10 != null && !listaWykluczen.contains(s10)) {listaWynikowa.add(s10);}
            if (s11 != null && !listaWykluczen.contains(s11)) {listaWynikowa.add(s11);}
        }
        return listaWynikowa;
    }

    private int getKrokiHex(Hex s, Hex m) {
        int result = List.of(
                Math.abs(s.x() - m.x()),
                Math.abs(s.y() - m.y()),
                Math.abs(s.z() - m.z()),
                Math.abs(s.xy() - m.xy()),
                Math.abs(s.xz() - m.xz()),
                Math.abs(s.yz() - m.yz()),
                Math.abs(s.xyz() - m.xyz())
        ).stream().mapToInt(Integer::intValue).max().getAsInt();
        return result;
    }

    public double getOdlegloscHex(Hex s, Hex m) {
        double valX = Math.abs(s._x() - m._x());
        double valY = Math.abs(s._y() - m._y());
        double valZ = Math.abs(s._z() - m._z());
        if (valZ>0) {
            double odleglosc3D = Math.sqrt(valX*valX + Math.pow(valY*Math.sqrt(3.0)/3.0,2) + Math.pow(valZ*Math.sqrt(6.0)/3.0,2) ) / 2;
            return odleglosc3D;
        }
        double odleglosc = Math.sqrt(valX*valX + Math.pow(valY*Math.sqrt(3.0)/2.0,2)) / 2;
        return odleglosc;
    }

    @Override
    protected List getSasiedzi(Hex p, List<Hex> listaWykluczen) {
        return getSasiedziHex(p, listaWykluczen);
    }

    @Override
    protected double getOdleglosc(Hex s, Hex m) {
        return getOdlegloscHex(s, m);
    }

    @Override
    protected int getKroki(Hex s, Hex m) {
        return getKrokiHex(s, m);
    }

}
