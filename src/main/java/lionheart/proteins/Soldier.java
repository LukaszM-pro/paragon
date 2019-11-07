package lionheart.proteins;

public interface Soldier {

    int getInitiativeThrow();
    int getHitThrow();
    int getDodgeThrow();
    int getDamageThrow(int bonus);
    int getResistanceThrow();
    boolean getIfAlive();
    void takeWounds(int quantity);
    void incrementFought();
    int getFought();
    int getRandomizedId();
    void setRandomizedId();
}
