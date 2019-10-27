package space;

//import myExceptions.ThirdDimensionProblemException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import space.myExceptions.ThirdDimensionProblemException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PlanszaTest {

//    @Mock
//    public Plansza<Pole> fooMock;

    @Test
    void getPoleTest() {
        int bok = 4;
        Plansza<Pole> plansza =
//                new Plansza<Pole>(Pole.class, bok);
                (Plansza<Pole>) Mockito.mock(Plansza.class, Mockito.withSettings().useConstructor(Pole.class, bok).defaultAnswer(Mockito.CALLS_REAL_METHODS));
//        System.out.println(plansza.getMapaByXYZ()+"\n");
        Pole p = plansza.getPole(0,0,0);
//        System.out.println(p+"\n");
        Assert.assertEquals(0,p.x());
        Assert.assertEquals(0,p.y());
        Assert.assertEquals(0,p.z());
        p = plansza.getPole(1,1,1);
        Assert.assertEquals(1,p.x());
        Assert.assertEquals(1,p.y());
        Assert.assertEquals(1,p.z());
        p = plansza.getPole(bok-2,bok-2,bok-2);
        Assert.assertEquals(2,p.x());
        Assert.assertEquals(2,p.y());
        Assert.assertEquals(2,p.z());
        p = plansza.getPole(bok-1,bok-1,bok-1);
        Assert.assertEquals(3,p.x());
        Assert.assertEquals(3,p.y());
        Assert.assertEquals(3,p.z());
        p = plansza.getPole(bok, bok, bok);
        Assert.assertEquals(null,p);
    }
/**/
    @Test
    void getMapaByXYZTest() {
        int bok = 3;
        Plansza<Pole> plansza = (Plansza<Pole>) Mockito.mock(Plansza.class, Mockito.withSettings().useConstructor(Pole.class, bok).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        Assert.assertEquals(27,plansza.getMapaByXYZ().size());
        plansza = Mockito.mock(Plansza.class, Mockito.withSettings().useConstructor(Pole.class, bok, bok).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        Assert.assertEquals(9,plansza.getMapaByXYZ().size());
        plansza = Mockito.mock(Plansza.class, Mockito.withSettings().useConstructor(Pole.class, 5, 10, 15).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        Assert.assertEquals(5*10*15,plansza.getMapaByXYZ().size());
        Pole p = plansza.getPole(0,0,0);
        Assert.assertNotEquals(null,p);
        p = plansza.getPole(1,0,0);
        Assert.assertNotEquals(null,p);
        p = plansza.getPole(2,0,0);
        Assert.assertNotEquals(null,p);
        p = plansza.getPole(3,0,0);
        Assert.assertNotEquals(null,p);
        p = plansza.getPole(4,0,0);
        Assert.assertNotEquals(null,p);
        p = plansza.getPole(5,0,0);
        Assert.assertEquals(null,p);
        p = plansza.getPole(0,10,0);
        Assert.assertEquals(null,p);
        p = plansza.getPole(0,0,15);
        Assert.assertEquals(null,p);
        p = plansza.getPole(5,10,15);
        Assert.assertEquals(null,p);
        assertThrows(ThirdDimensionProblemException.class, () -> {
            Mockito.mock(Plansza.class, Mockito.withSettings().useConstructor(Pole.class, 5, 10, 15).defaultAnswer(Mockito.CALLS_REAL_METHODS)).getPole(5,10);
        });
    }

}
