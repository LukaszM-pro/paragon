package lionheart.proteins;

import lionheart.proteins.equipment.Armor;
import lionheart.proteins.equipment.ArmorImpl;
import lionheart.proteins.equipment.Weapon;
import lionheart.proteins.equipment.WeaponImpl;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
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

    int size;

    Weapon weapon;
    Armor armor;

    NationProfession nation;
    NationProfession profession;

    int fought = 0;
    int randomizedId;
}
