package space.population;

import space.Pole;

public interface Pionek<GenericTypeExtendingPole extends Pole>{
    void ruszSie(GenericTypeExtendingPole cel);
    void obrocSie(GenericTypeExtendingPole nowyPrzewodnik);
    String getFacing(GenericTypeExtendingPole cel);
}
