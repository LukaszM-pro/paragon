package lionheart.nie.wiem;

import lionheart.proteins.WarriorFactory;
import lionheart.proteins.WarriorImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import space.Hex;
import space.PlanszaHex;
import space.population.PionekFactory;
import space.population.PionekHex;
import space.population.myExceptions.GuideSameAsPositionException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OlowianyZolnierzykTest {

    @Test
    void constructorTest() {
        PlanszaHex plansza = new PlanszaHex(4,4);
        Hex hex01 = plansza.getPole(0,1);
        Hex hex10 = plansza.getPole(1,0);
        Hex hex11 = plansza.getPole(1,1);
        Hex hex33 = plansza.getPole(3,3);

        assertThrows(GuideSameAsPositionException.class, () -> {
            OlowianyZolnierzyk.<Hex>builder()
                .myInnerPionek(PionekFactory.getPionekHex(plansza,hex11,hex11,2))
                .myInnerWarrior(WarriorFactory.getWarrior("Samurai")).build();
        });

        OlowianyZolnierzyk<Hex> dziadekDoOrzechow = OlowianyZolnierzyk.<Hex>builder()
                .myInnerPionek(
                        PionekFactory.getPionekHex(plansza,hex11,hex10,2)
                )
                .myInnerWarrior(
                        WarriorFactory.getWarrior("Samurai")
                ).build();
        Assert.assertEquals("tyl",dziadekDoOrzechow.getFacing(hex33));
        dziadekDoOrzechow.obrocSie(hex10);
        Assert.assertEquals("tyl",dziadekDoOrzechow.getFacing(hex33));

        OlowianyZolnierzykHex babkaDoOrzechow = OlowianyZolnierzykHex.builder()
                .myInnerPionek(
                        PionekHex.builder().pozycja(hex11).przewodnik(hex01).plansza(plansza).ruch(2)/*.facings(Map.of())*/.build()
                )
                .myInnerWarrior(
                        WarriorImpl.builder().build()
                ).build();
        assertThrows(NullPointerException.class, () -> {
            babkaDoOrzechow.getFacing(hex33); // Manage to avoid this and U rule! // can be done with commented in PionekHex builder
        });
        babkaDoOrzechow.obrocSie(hex01);
        Assert.assertEquals("tylny bok",babkaDoOrzechow.getFacing(hex33));
    }
}