package lionheart.proteins;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class AbstractWarrior{

    private String name;
    private int healthMaximum;
    private int healthActual;
    private int hit;
    private int dodge;
    private int attack;
    private int defense;
    private int critical;
    private int initiativeStep;
    private int initiativeActual;
    private int movement;
    private int attackRange;
    private int morale;

}
