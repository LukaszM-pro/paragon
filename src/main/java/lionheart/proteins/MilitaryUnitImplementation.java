package lionheart.proteins;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MilitaryUnitImplementation implements MilitaryUnit {

    private List<Soldier> soldiers = new ArrayList<>(

    );
    public MilitaryUnitImplementation(String who, int howMany){
        List<Soldier> soldierList = Stream.generate(() -> SoldierFactory.getSoldier(who)).limit(howMany).collect(Collectors.toList());
//        System.out.println(soldierList.size());
        soldiers.addAll(soldierList);
    }
    public List<Soldier> getSoldiers() {
        return soldiers;
    }
    public Soldier getRandomFresh() {
        return (soldiers.parallelStream().filter(Soldier::getIfAlive).count() > 0)
                ? soldiers
                    .parallelStream()
                    .filter(Soldier::getIfAlive)
                    .peek(Soldier::setRandomizedId)
                    .sorted(Comparator.comparingInt(Soldier::getFought).thenComparingInt(Soldier::getRandomizedId))
                    .findAny()
                    .get()
                : null
                ;

    }
}
