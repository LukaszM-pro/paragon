package lionheart.proteins;

import lionheart.proteins.equipment.Armor;
import lionheart.proteins.equipment.ArmorImpl;
import lionheart.proteins.equipment.Weapon;
import lionheart.proteins.equipment.WeaponImpl;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class AbstractSoldier {

    int reflex;
    int dexterity;
    int agility;
    int strength;
    int endurance;
    int vitality;

    int speed;
    int offensive;
    int defensive;

    Weapon weapon;
    Armor armor;

    int size;
}
