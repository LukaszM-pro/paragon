package lionheart.proteins;

import lionheart.proteins.equipment.Bron;
import lionheart.proteins.equipment.Pancerz;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorImplTest {

    @Test
    void allRoundTest(){
        WarriorImpl connan = WarriorImpl.builder()
            .silaWytrzymalosc(50)
            .zrecznoscZwinnosc(30)
            .skill(25)
            .bron(Bron.builder().SKUTECZNOSC(8).build())
            .pancerz(Pancerz.builder().SKUTECZNOSC(50).build())
            .build();
        Assert.assertEquals(50,connan.getDefense());
        Assert.assertEquals(75,connan.getHit());
        Assert.assertEquals(16,connan.getDodge());
        Assert.assertEquals(40,connan.getAttack());
        Assert.assertEquals(2,connan.getCritical());
        Assert.assertEquals(50,connan.getHealthActual());
        Assert.assertEquals(-5,connan.getInitiativeStep());


        WarriorImpl redSonya = WarriorImpl.builder()
            .silaWytrzymalosc(45)
            .zrecznoscZwinnosc(35)
            .skill(25)
            .bron(Bron.builder().SKUTECZNOSC(7).build())
            .pancerz(Pancerz.builder().SKUTECZNOSC(25).build())
            .build();
        Assert.assertEquals(25,redSonya.getDefense());
        Assert.assertEquals(70,redSonya.getHit());
        Assert.assertEquals(22,redSonya.getDodge());
        Assert.assertEquals(28,redSonya.getAttack());
        Assert.assertEquals(3,redSonya.getCritical());
        Assert.assertEquals(45,redSonya.getHealthActual());
        Assert.assertEquals(0,redSonya.getInitiativeStep());
    }
}