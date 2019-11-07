package lionheart.battle.mechanics;

import lionheart.proteins.MilitaryUnit;
import lionheart.proteins.Soldier;

public class Battle {

    public static void chaoticClash(MilitaryUnit left, MilitaryUnit right){
        if (left.getSoldiers().parallelStream().filter(Soldier::getIfAlive).count() > 0) {
            left.getSoldiers()
                    .stream()
//                    .parallel()
                    .filter(Soldier::getIfAlive)
                    .forEach(fighter -> Duel.round_exchange(fighter, right.getRandomFresh()));
        }
        if (right.getSoldiers().parallelStream().filter(Soldier::getIfAlive).count() > 0) {
            right.getSoldiers()
                    .stream()
//                    .parallel()
                    .filter(Soldier::getIfAlive)
                    .forEach(fighter -> Duel.round_exchange(fighter, left.getRandomFresh()));
        }
    }

}
