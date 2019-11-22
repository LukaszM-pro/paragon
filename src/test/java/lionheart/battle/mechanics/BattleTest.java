package lionheart.battle.mechanics;

import lionheart.proteins.MilitaryUnit;
import lionheart.proteins.MilitaryUnitImplementation;
import lionheart.proteins.Soldier;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    void chaoticClash() {

        int aQuantity = 100;
        int bQuantity = 500;
        MilitaryUnit a = new MilitaryUnitImplementation("OniAshigaru", aQuantity);
        MilitaryUnit b = new MilitaryUnitImplementation("KitsuneSamurai", bQuantity);
        Assert.assertEquals(0, a.getSoldiers().stream().mapToInt(x -> x.getFought()).sum());
        Assert.assertEquals(0, b.getSoldiers().stream().mapToInt(x -> x.getFought()).sum());
        Assert.assertEquals(aQuantity, a.getSoldiers().stream().filter(Soldier::getIfAlive).count());
        Assert.assertEquals(bQuantity, b.getSoldiers().stream().filter(Soldier::getIfAlive).count());
        Battle.chaoticClash(a,b);
        Assert.assertTrue(a.getSoldiers().stream().mapToInt(x -> x.getFought()).sum() > 90);
        Assert.assertTrue(b.getSoldiers().stream().mapToInt(x -> x.getFought()).sum() > 90);
        Assert.assertTrue(a.getSoldiers().stream().filter(Soldier::getIfAlive).count() <= aQuantity);
        Assert.assertTrue(b.getSoldiers().stream().filter(Soldier::getIfAlive).count() <= bQuantity);

//        System.out.println(a.getSoldiers().stream().filter(Soldier::getIfAlive).count());
//        System.out.println(b.getSoldiers().stream().filter(Soldier::getIfAlive).count());
    }
}