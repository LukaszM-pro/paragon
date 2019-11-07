package lionheart.battle.mechanics;

import lionheart.config.ConfigurationL5K;
import lionheart.proteins.Soldier;

public class Duel {

    public static void hit(Soldier aggressor, Soldier target) {
        if (aggressor.getIfAlive()) {
            int hitThrow = aggressor.getHitThrow() - target.getDodgeThrow();
//            System.out.println("hit:" + hitThrow);
            if (hitThrow > 0) {
                int punctureThrow = aggressor.getDamageThrow(hitThrow / ConfigurationL5K.DICE) - target.getResistanceThrow();
//                System.out.println("wounds:" + punctureThrow);
                if (punctureThrow > 0) {
                    target.takeWounds(punctureThrow);
                }
            }
            aggressor.incrementFought();
            target.incrementFought();
        }
    }

    public static void round_exchange(Soldier redCornerContestant, Soldier blueCornerContestant) {
        if (redCornerContestant == null || blueCornerContestant == null) {
            return;
        }
        int redInitiative = redCornerContestant.getInitiativeThrow();
        int blueInitiative = blueCornerContestant.getInitiativeThrow();

//        System.out.println("redInitiative:" + redInitiative);
//        System.out.println("blueInitiative:" + blueInitiative);

        if (redInitiative > blueInitiative)  {
            hit(redCornerContestant, blueCornerContestant);
            hit(blueCornerContestant, redCornerContestant);
        } else if (blueInitiative > redInitiative) {
            hit(blueCornerContestant, redCornerContestant);
            hit(redCornerContestant, blueCornerContestant);
        } else {
            return;
        }

        if (redInitiative >= blueInitiative * 2)  {
            hit(redCornerContestant, blueCornerContestant);
        } else if (blueInitiative >= redInitiative * 2) {
            hit(blueCornerContestant, redCornerContestant);
        }
    }

}
