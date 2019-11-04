package lionheart.proteins.equipment;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class WeaponImpl extends Equipment implements Armor, Weapon {

    protected int range;

}
