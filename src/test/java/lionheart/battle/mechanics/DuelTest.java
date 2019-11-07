package lionheart.battle.mechanics;

import lionheart.dice.mechanics.ThrowL5R;
import lionheart.proteins.Soldier;
import lionheart.proteins.SoldierFactory;
import lionheart.proteins.SoldierImplementation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuelTest {

    @Test
    void hitTest() {
        SoldierImplementation monster = SoldierFactory.getSoldier("-still", "Oni", "Samurai");
        SoldierImplementation hero = SoldierFactory.getSoldier("-still", "Tengu", "Samurai");
//        System.out.println(monster.getIfAlive() + " " + monster.toString());
//        System.out.println(hero.getIfAlive() + " " + hero.toString());
        Duel.hit(hero, monster);
//        System.out.println(monster.getIfAlive() + " " + monster.toString());
//        System.out.println(hero.getIfAlive() + " " + hero.toString());
    }

    @Test
    void round_exchangeTest() {
        SoldierImplementation monster = SoldierFactory.getSoldier("-still", "Oni", "Samurai");
        SoldierImplementation hero = SoldierFactory.getSoldier("-still", "Tengu", "Samurai");
//        System.out.println(monster.getIfAlive() + " " + monster.toString());
//        System.out.println(hero.getIfAlive() + " " + hero.toString());
        Duel.round_exchange(hero, monster);
//        System.out.println(monster.getIfAlive() + " " + monster.toString());
//        System.out.println(hero.getIfAlive() + " " + hero.toString());
    }
}