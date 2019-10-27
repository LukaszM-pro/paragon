package l5k.proteins;

import l5k.config.KonfiguracjaL5K;
import l5k.proteins.equipment.Bron;
import l5k.proteins.equipment.Pancerz;
import lombok.Builder;
import l5k.dice.mechanics.ThrowL5R;

@Builder
public class Samuraj implements Wojownik, Zolnierz{
    @Builder.Default private int zrecznosc = 3;
    @Builder.Default private int zwinnosc = 3;
    @Builder.Default private int refleks = 3;
    @Builder.Default private int sila = 3;
    @Builder.Default private int wytrzymalosc = 3;
    @Builder.Default private int zywotnosc = 3;
    @Builder.Default private int wielkosc = 3;

    @Builder.Default private int cios = 3;
    @Builder.Default private int unik = 3;
    @Builder.Default private int szybkosc = 3;
    @Builder.Default private Bron bron = new Bron("1");
    @Builder.Default private Pancerz pancerz = new Pancerz("1");

    @Builder.Default private int ranyMax = 100;
    @Builder.Default private int ranyAktualne = 3*3*6;

    @Override
    public int getInicjatywa(int adv){
        int ini = ThrowL5R.l5K(refleks, szybkosc + adv);
        return ini;
    }

    @Override
    public int getAtak(int adv){
        return ThrowL5R.l5K(zrecznosc, cios + adv);
    }

    @Override
    public int getObrona(int adv){
        return ThrowL5R.l5K(zwinnosc, unik + adv);
    }

    @Override
    public int getPrzebicie(int adv){
        return ThrowL5R.l5K(bron.getSkutecznosc(), sila * bron.getSkutecznosc() + adv + bron.getJakosc());
    }

    @Override
    public int getWyparowanie(int adv){
        return ThrowL5R.l5K(pancerz.getSkutecznosc(), wytrzymalosc * pancerz.getSkutecznosc() + adv + pancerz.getJakosc());
    }

    @Override
    public void otrzymajRane(int ile){
        ranyAktualne -= ile;
    }

//    @Override
//    public void poniesSmierc(){
//        ranyAktualne = -1;
//    }

    @Override
    public boolean getCzyZyje(){
        return ranyAktualne > 0 ? true : false;
    }

    @Override
    public int getRanyAktualne(){
        return ranyAktualne;
    }

//    @Override
//    public int getZagrozenie(int adv){
//        return adv;
//    }

//    @Override
//    public int getZywotnosc(int adv){
//        return adv;
//    }

}
