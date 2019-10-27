package lionheart.proteins;

public interface Wojownik {
    int getInicjatywa(int adv);
    int getAtak(int adv);
    int getObrona(int adv);
    int getPrzebicie(int adv);
    int getWyparowanie(int adv);
    void otrzymajRane(int ile);
    int getZagrozenie(int adv);
    int getZywotnosc(int adv);
    boolean getCzyZyje();
    int getRanyAktualne();
}
