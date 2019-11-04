package lionheart.proteins;

import lionheart.proteins.equipment.ArmorImpl;
import lionheart.proteins.equipment.WeaponImpl;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class AbstractSoldier {

    int reflex;
    int dexterity;
    int agility;
    int strenhgt;
    int endurance;
    int vitality;

    int speed;
    int offensive;
    int defensive;

    WeaponImpl weapon;
    ArmorImpl armor;

    int size;
}
