package l5k.battle.mechanics;

import l5k.config.KonfiguracjaL5K;
import l5k.proteins.Wojownik;

public class PotyczkaWojownikow {

    public void cios(Wojownik agresor, Wojownik cel) {
        if (agresor.getCzyZyje()) {
            int trafienie = agresor.getAtak(0) - cel.getObrona(0);
            if (trafienie > 0) {
                int przebicie = agresor.getPrzebicie(trafienie / KonfiguracjaL5K.KOSTKA) - cel.getWyparowanie(0);
                if (przebicie > 0) {
//                    System.out.println(trafienie+";"+przebicie);
                    cel.otrzymajRane(przebicie);
                }
            }
        }
    }

    public void runda_wymiana(Wojownik czerwony, Wojownik niebieski) {
        int inicjatywaCzerwonego = czerwony.getInicjatywa(0);
        int inicjatywaNiebieskiego = niebieski.getInicjatywa(0);

        if (inicjatywaCzerwonego > inicjatywaNiebieskiego)  {
            cios(czerwony, niebieski);
            cios(niebieski, czerwony);
        } else if (inicjatywaNiebieskiego > inicjatywaCzerwonego) {
            cios(niebieski, czerwony);
            cios(czerwony, niebieski);
        } else {
            return;
        }

        if (inicjatywaCzerwonego >= inicjatywaNiebieskiego * 2)  {
            cios(czerwony, niebieski);
        } else if (inicjatywaNiebieskiego >= inicjatywaCzerwonego * 2) {
            cios(niebieski, czerwony);
        }
    }
}
