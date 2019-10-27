package dice.mechanics;

//import l5k.battle.mechanics.PotyczkaSamurajow;
import l5k.battle.mechanics.PotyczkaWojownikow;
import l5k.proteins.Samuraj;
import l5k.proteins.Wojownik;
import org.junit.jupiter.api.Test;
//import proteins.l5k.proteins.Samuraj;

class PotyczkaSamurajowTest {

    @Test
    void ciosTest() {
    }

    @Test
    void runda_wymianaTest() {
        Wojownik aaa = Samuraj.builder().szybkosc(12).cios(12).sila(7).build();
        Wojownik bbb = Samuraj.builder().build();
        new PotyczkaWojownikow().runda_wymiana(aaa,bbb);
//        System.out.println("aaa:"+aaa.getCzyZyje()+aaa.getRanyAktualne());
//        System.out.println("bbb:"+bbb.getCzyZyje()+bbb.getRanyAktualne());
//        System.out.println(aaa.zrecznosc+":"+aaa.cios);
    }

}