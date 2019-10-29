package lionheart.proteins;

public interface Warrior {

    int getDefense();
    int getHit();
    int getDodge();
    int getAttack();
    int getCritical();
    int getHealthActual();
    int getInitiativeStep();
    void setReceivedWounds(int newWounds);

}
