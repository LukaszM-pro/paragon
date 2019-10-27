package configuration;

import java.util.concurrent.ThreadLocalRandom;

public class Kostki {

    public enum Kosci {
        K1(1),
        K6(6),
        K10(10),
        K100(100),
        PROG_DOL(5),
        PROG_GORA(95),

        JEDYNKA(K1.getScianki()),
        SLABA_KOSC(K6.getScianki()),
        MOCNA_KOSC(K10.getScianki());

        private int scianki;

        Kosci(int inputInt) {
            this.scianki = inputInt;
        }

        public int getScianki() {
            return scianki;
        }
    }

    public static int rzut(int scianki) {
        return ThreadLocalRandom.current().nextInt(scianki) + 1;
    }

    public static int rzutK6() {
        return rzut(Kosci.K6.scianki);
    }

    public static int rzutK10() {
        return rzut(Kosci.K10.scianki);
    }

    public static int rzutK100() {
        return rzut(Kosci.K100.scianki);
    }

    public static int rzut020() {
        return ThreadLocalRandom.current().nextInt(21);
    }



}
