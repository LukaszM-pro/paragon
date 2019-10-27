package proteins.whfb;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
@Builder
public class WojownikWHFB {
    private String nazwa;
    @Builder.Default private int ruch = 4;
    @Builder.Default private int inicjatywa = 4;
    @Builder.Default private int wwa = 3;
    @Builder.Default private int wwo = 3;
    @Builder.Default private int sila = 3;
    @Builder.Default private int wytrzymalosc = 3;
    @Builder.Default private int pancerz = 0;
    @Builder.Default private int ap = 0;
    @Builder.Default private int ataki = 1;
    @Builder.Default private int zagrozenie = 1;
    @Builder.Default private int rany = 1;
    @Builder.Default private int morale = 10;

    public int ciosy (WojownikWHFB cel) {
        WojownikWHFB agresor = this;
        int rezultat = 0;
        int prog = (agresor.wwa - cel.wwo + 3)
                * (agresor.sila - cel.wytrzymalosc + 3)
                * (agresor.ap - cel.pancerz + 6);
        for (int i=0; i<agresor.ataki; i++) {
            int rzut = ThreadLocalRandom.current().nextInt(6 * 6 * 6) + 1;
            if (rzut <= prog) {
                rezultat = rezultat + agresor.zagrozenie;
            }
        }
        return rezultat;
    }
    public void zran(int pRany){
        this.rany = this.rany - pRany;
    }

    public static void runda (WojownikWHFB a, WojownikWHFB b) {
        WojownikWHFB szybki = a.inicjatywa >= b.inicjatywa ? a : b;
        WojownikWHFB wolny = a.inicjatywa < b.inicjatywa ? a : b;
        wolny.zran(szybki.ciosy(wolny));
        szybki.zran(wolny.ciosy(szybki));
    }
}
