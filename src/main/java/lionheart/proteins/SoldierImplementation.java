package lionheart.proteins;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class SoldierImplementation extends AbstractSoldier implements Soldier {

    @Override
    public int getInitiativeThrow() {
        return 0;
    }

    @Override
    public int getHitThrow() {
        return 0;
    }

    @Override
    public int getDodgeThrow() {
        return 0;
    }

    @Override
    public int getDamageThrow() {
        return 0;
    }

    @Override
    public int getResistanceThrow() {
        return 0;
    }
}
