package lionheart.proteins.equipment;


import lionheart.config.ConfigurationL5K;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class EquipmentImpl {

    protected int efficiency;
    protected int quality;
    protected int weight;
    public int getWeight(){
        return Math.min(Math.max(efficiency/2-1, efficiency-quality/2 - ConfigurationL5K.EQUIPMENT_WEIGHT_QUALIFIER), efficiency*2);
    }

}
