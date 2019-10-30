package lionheart.battle.mechanics;

import l5k.config.KonfiguracjaL5K;
import l5k.proteins.Wojownik;
import lionheart.proteins.Warrior;

import java.util.concurrent.ThreadLocalRandom;

public class PotyczkaWojownikow {

    public static int rzut(int k) {
        return ThreadLocalRandom.current().nextInt(k) + 1;
    }

    private void cios(Warrior attacker, Warrior defender){
        int rzutTrafienia = rzut(100);
        int rzutUniku = rzut(100);
        if (rzutTrafienia <= attacker.getHit() && rzutUniku > defender.getDodge()) {
            int strength = attacker.getAttack() * ((rzutTrafienia <= attacker.getCritical())?2:1);
            int result = 0;
            int diceThrow = 0;
            for (int i=1; i <= strength; i++) {
                diceThrow = rzut(100);
                if (diceThrow > defender.getDefense()) {
                    result++;
                }
            }
            defender.setReceivedWounds(defender.getHealthActual() - result);
        }
    }

//    public void uderzenie(Wojownik agresor, Wojownik cel) {
//        if (agresor.getCzyZyje()) {
//            int trafienie = agresor.getAtak(0) - cel.getObrona(0);
//            if (trafienie > 0) {
//                int przebicie = agresor.getPrzebicie(trafienie / KonfiguracjaL5K.KOSTKA) - cel.getWyparowanie(0);
//                if (przebicie > 0) {
//                    System.out.println(trafienie+";"+przebicie);
//                    cel.otrzymajRane(przebicie);
//                }
//            }
//        }
//    }

//    public void runda_wymiana(Wojownik czerwony, Wojownik niebieski) {
//        int inicjatywaCzerwonego = czerwony.getInicjatywa(0);
//        int inicjatywaNiebieskiego = niebieski.getInicjatywa(0);
//
//        if (inicjatywaCzerwonego > inicjatywaNiebieskiego)  {
//            uderzenie(czerwony, niebieski);
//            uderzenie(niebieski, czerwony);
//        } else if (inicjatywaNiebieskiego > inicjatywaCzerwonego) {
//            uderzenie(niebieski, czerwony);
//            uderzenie(czerwony, niebieski);
//        } else {
//            return;
//        }
//
//        if (inicjatywaCzerwonego >= inicjatywaNiebieskiego * 2)  {
//            uderzenie(czerwony, niebieski);
//        } else if (inicjatywaNiebieskiego >= inicjatywaCzerwonego * 2) {
//            uderzenie(niebieski, czerwony);
//        }
//    }
}
