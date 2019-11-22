package lionheart.proteins.equipment;

import lionheart.config.ConfigurationL5K;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class WeaponImpl extends EquipmentImpl implements Weapon {

    protected int range;

    @Override
    public int getWeight(){
        int poleArmEfficiency = efficiency + range - 1;//efficiency * ((range <= 1)?1:2);
        return Math.min(Math.max(
                poleArmEfficiency/2-1,
                poleArmEfficiency-quality/2) - ConfigurationL5K.EQUIPMENT_WEIGHT_QUALIFIER
                , poleArmEfficiency * 2
        );
    }

}
