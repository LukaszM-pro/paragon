package proteins.whfb;

import org.junit.jupiter.api.Test;

class WojownikTest {

    @Test
    void wojownikTest() {
        WojownikWHFB czlowiek = WojownikWHFB.builder()
                .nazwa("Łowca")
                .ataki(2)
                .pancerz(2)
            .build();
        WojownikWHFB troll = WojownikWHFB.builder()
                .nazwa("Troll")
                .inicjatywa(2)
                .wwa(3)
                .wwo(0)
                .sila(5)
                .wytrzymalosc(3)
                .pancerz(1)
                .rany(2)
                .zagrozenie(2)
                .morale(8)
            .build();
        WojownikWHFB.runda(troll,czlowiek);
//        System.out.print("Czlowiek: "+czlowiek.getRany()+"\n");
//        System.out.print("Troll: "+troll.getRany()+"\n");
    }
}