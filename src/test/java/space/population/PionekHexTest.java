package space.population;

//import myExceptions.GuideIsNotANeighborOfPositionException;
//import myExceptions.GuideSameAsPositionException;
//import myExceptions.ThirdDimensionProblemException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import space.Hex;
//import space.Plansza;
import space.PlanszaHex;
import space.population.myExceptions.GuideIsNotANeighborOfPositionException;
import space.population.myExceptions.GuideSameAsPositionException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PionekHexTest {
    @Test
    void constructorTest(){
        PlanszaHex plansza = new PlanszaHex(3,3);
        Hex hex00 = plansza.getPole(0,0);
        Hex hex10 = plansza.getPole(1,0);
        Hex hex11 = plansza.getPole(1,1);
        Hex hex22 = plansza.getPole(2,2);
        PionekHex pionek0 = new PionekHex();
        Assert.assertEquals(null, pionek0.getPozycja());
        Assert.assertEquals(null, pionek0.getPrzewodnik());
        pionek0.setPlansza(plansza);
        pionek0.setPozycja(hex11);
        pionek0.setPrzewodnik(hex10);
        Assert.assertEquals(hex11, pionek0.getPozycja());
        Assert.assertEquals(hex10, pionek0.getPrzewodnik());
        assertThrows(GuideSameAsPositionException.class, () -> {
            pionek0.setPrzewodnik(hex11);
        });
        assertThrows(GuideIsNotANeighborOfPositionException.class, () -> {
            pionek0.setPrzewodnik(hex00);
        });
        PionekHex pionek1 = PionekHex.builder().pozycja(hex00).przewodnik(hex10).plansza(plansza).ruch(3).build();
        Assert.assertEquals(hex00, pionek1.getPozycja());
        Assert.assertEquals(hex10, pionek1.getPrzewodnik());
        Assert.assertEquals(3, pionek1.getRuch());
        Assert.assertEquals(plansza, pionek1.getPlansza());
    }

    @Test
    void ruszSieTest(){
        PlanszaHex plansza = new PlanszaHex(4,4);
        Hex hex00 = plansza.getPole(0,0);
        Hex hex10 = plansza.getPole(1,0);
        Hex hex01 = plansza.getPole(0,1);
        Hex hex02 = plansza.getPole(0,2);
        Hex hex11 = plansza.getPole(1,1);
        Hex hex20 = plansza.getPole(2,0);
        Hex hex21 = plansza.getPole(2,1);
        Hex hex12 = plansza.getPole(1,2);
        Hex hex22 = plansza.getPole(2,2);
        Hex hex30 = plansza.getPole(3,0);
        Hex hex31 = plansza.getPole(3,1);
//        PionekHex pionek = new PionekHex();
//        pionek.setPlansza(plansza);
//        pionek.setPozycja(hex11);
//        pionek.setPrzewodnik(hex10);
//        pionek.setRuch(99);
//        pionek.ruszSie(hex22);
//        Assert.assertEquals(hex22, pionek.getPrzewodnik());
//        pionek.setRuch(2);
//        pionek.setPozycja(hex11);
//        pionek.setPrzewodnik(hex10);
//        pionek.ruszSie(hex22);
//        Assert.assertEquals(hex21, pionek.getPozycja());
        PionekHex pionek0 = PionekHex.builder().pozycja(hex11).przewodnik(hex10).plansza(plansza).ruch(3).build();
        pionek0.ruszSie(hex22);
        Assert.assertEquals(hex21, pionek0.getPozycja());
        Assert.assertEquals(hex22, pionek0.getPrzewodnik());
        PionekHex pionek1 = PionekHex.builder().pozycja(hex11).przewodnik(hex21).plansza(plansza).ruch(3).build();
        pionek1.ruszSie(hex22);
        Assert.assertEquals(hex21, pionek1.getPozycja());
        Assert.assertEquals(hex22, pionek1.getPrzewodnik());
        PionekHex pionek2 = PionekHex.builder().pozycja(hex11).przewodnik(hex10).plansza(plansza).ruch(2).build();
        pionek2.ruszSie(hex22);
        Assert.assertEquals(hex21, pionek2.getPozycja());
        Assert.assertEquals(hex22, pionek2.getPrzewodnik());
        Assert.assertEquals(hex20, pionek2.getPlecy());
        Assert.assertTrue(pionek2.getPrzod().containsAll(Set.of(hex31,hex22,hex12)));
        Assert.assertTrue(pionek2.getTyl().containsAll(Set.of(hex30,hex20,hex11)));
    }

    @Test
    void obrocSieTest(){
        PlanszaHex plansza = new PlanszaHex(4,4);
        Hex hex10 = plansza.getPole(1,0);
        Hex hex11 = plansza.getPole(1,1);
        Hex hex21 = plansza.getPole(2,1);
        Hex hex33 = plansza.getPole(3,3);
        PionekHex pionek0 = PionekHex.builder().pozycja(hex11).przewodnik(hex10).plansza(plansza).ruch(2).build();
        pionek0.obrocSie(hex33);
        Assert.assertEquals(hex11,pionek0.getPozycja());
        Assert.assertEquals(hex21,pionek0.getPrzewodnik());
        PionekHex pionek1 = PionekHex.builder().pozycja(hex11).przewodnik(hex10).plansza(plansza).ruch(4).build();
        pionek1.obrocSie(hex33);
        Assert.assertEquals(hex11,pionek1.getPozycja());
        Assert.assertEquals(hex21,pionek1.getPrzewodnik());
    }

    @Test
    void getFacingTest(){
        PlanszaHex plansza = new PlanszaHex(4,4);
        Hex hex00 = plansza.getPole(0,0);
        Hex hex10 = plansza.getPole(1,0);
        Hex hex11 = plansza.getPole(1,1);
        Hex hex33 = plansza.getPole(3,3);
        PionekHex pionek0 = PionekHex.builder().pozycja(hex11).przewodnik(hex10).plansza(plansza).ruch(2).build();
        pionek0.obrocSie(hex10);
        Assert.assertEquals("przedni bok",pionek0.getFacing(hex00));
        Assert.assertEquals("tyl",pionek0.getFacing(hex33));
    }
}