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
            .skill(20)
            .bron(Bron.builder().WAGA(5).JAKOSC(2).build())
            .pancerz(Pancerz.builder().WAGA(50).JAKOSC(10).build())
            .build();
        Assert.assertEquals(60,connan.getDefense());
        Assert.assertEquals(70,connan.getHit());
        Assert.assertEquals(12,connan.getDodge());
        Assert.assertEquals(35,connan.getAttack());
        Assert.assertEquals(9,connan.getCritical());
        Assert.assertEquals(50,connan.getHealthActual());
        Assert.assertEquals(5,connan.getInitiativeStep());

        WarriorImpl redSonya = WarriorImpl.builder()
                .silaWytrzymalosc(45)
                .zrecznoscZwinnosc(35)
                .skill(25)
                .bron(Bron.builder().WAGA(6).build())
                .pancerz(Pancerz.builder().WAGA(25).build())
                .build();
        Assert.assertEquals(25,redSonya.getDefense());
        Assert.assertEquals(70,redSonya.getHit());
        Assert.assertEquals(12,redSonya.getDodge());
        Assert.assertEquals(24,redSonya.getAttack());
        Assert.assertEquals(6,redSonya.getCritical());
        Assert.assertEquals(45,redSonya.getHealthActual());
        Assert.assertEquals(5,redSonya.getInitiativeStep());

        WarriorImpl uruk = WarriorImpl.builder()
                .silaWytrzymalosc(65)
                .zrecznoscZwinnosc(25)
                .skill(20)
                .bron(Bron.builder().WAGA(2).build())
                .pancerz(Pancerz.builder().WAGA(75).build())
                .build();
        Assert.assertEquals(75,uruk.getDefense());
        Assert.assertEquals(45,uruk.getHit());
        Assert.assertEquals(11,uruk.getDodge());
        Assert.assertEquals(12,uruk.getAttack());
        Assert.assertEquals(10,uruk.getCritical());
        Assert.assertEquals(65,uruk.getHealthActual());
        Assert.assertEquals(7,uruk.getInitiativeStep());
    }
}