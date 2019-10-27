package l5k.proteins;

public interface Wojownik {
    int getInicjatywa(int adv);
    int getAtak(int adv);
    int getObrona(int adv);
    int getPrzebicie(int adv);
    int getWyparowanie(int adv);
    void otrzymajRane(int ile);
//    void poniesSmierc();
    boolean getCzyZyje();
//    int getZagrozenie(int adv);
//    int getZywotnosc(int adv);
    int getRanyAktualne();
}
