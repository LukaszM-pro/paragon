package lionheart.proteins;

import java.util.List;

public interface MilitaryUnit {
    List<Soldier> getSoldiers();
    Soldier getRandomFresh();
}
