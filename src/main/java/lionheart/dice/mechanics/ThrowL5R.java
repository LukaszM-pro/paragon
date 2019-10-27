package lionheart.dice.mechanics;

import dice.mechanics.myExceptions.L5KProblemException;
import l5k.config.KonfiguracjaL5K;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ThrowL5R {

//    private static final int K10 = Kostki.Kosci.K10.getScianki();
    private static final int KOSTKA = KonfiguracjaL5K.KOSTKA;

    private static int rzut(int scianki) {
        int r = ThreadLocalRandom.current().nextInt(scianki) + 1;
        return r;
    }

    private static int throwL5K_1K(int kostka) {
        int r = rzut(kostka);
        int w =+ r;
        while (r == kostka) {
            r = rzut(kostka);
            w = w + r - 1;
        }
        return w;
    }

    private static int throwL5K(int zatrzymywane, int rzucane, int kostka) {
        if (zatrzymywane > rzucane) {throw new L5KProblemException("Custom user exception. za > rz");}
        int a[] = new int[rzucane];
        for(int i=0; i<a.length; i++) {a[i] = throwL5K_1K(kostka);}
        Arrays.sort(a);
        int r = 0;
        for(int i = rzucane - Math.min(zatrzymywane,rzucane); i < a.length; i++) {r = r + a[i];}
        return r;
    }

    public static int throwL5K(int zatrzymywane, int rzucane, int modyfikator, int kostka) {
        int lRz = Math.min(kostka, rzucane);
        int gRz = Math.max(0, rzucane - kostka);
        int lZa = Math.min(kostka, zatrzymywane + gRz);
        int gZa = Math.max(0, zatrzymywane - kostka);
        int lMo = Math.min(kostka, modyfikator + gZa);
//        System.out.println(lZa+":"+lRz+":"+kostka+":"+lMo);
        return throwL5K(lZa, lRz, kostka) + lMo;
    }

    public static int l5K(int za, int rz, int mod) {
        return throwL5K(za, rz, mod, KonfiguracjaL5K.KOSTKA);
    }

    public static int l5K(int za, int rz) {
        return throwL5K(za, rz, 0, KonfiguracjaL5K.KOSTKA);
    }
}
