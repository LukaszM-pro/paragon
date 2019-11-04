package lionheart.proteins.equipment;


import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Equipment {

    protected int efficiency;
    protected int quality;

}
