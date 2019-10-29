package lionheart.nie.wiem;

import lionheart.proteins.Warrior;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import space.Pole;
import space.population.Pionek;

@Data
@SuperBuilder
public class OlowianyZolnierzyk<GenericTypeExtendingPole extends Pole> implements Pionek<GenericTypeExtendingPole>, Warrior {

    private Pionek myInnerPionek;
    private Warrior myInnerWarrior;

    @Override
    public int getDefense() {
        return myInnerWarrior.getDefense();
    }

    @Override
    public int getHit() {
        return myInnerWarrior.getHit();
    }

    @Override
    public int getDodge() {
        return myInnerWarrior.getDodge();
    }

    @Override
    public int getAttack() {
        return myInnerWarrior.getAttack();
    }

    @Override
    public int getCritical() {
        return myInnerWarrior.getCritical();
    }

    @Override
    public int getHealthActual() {
        return myInnerWarrior.getHealthActual();
    }

    @Override
    public int getInitiativeStep() {
        return myInnerWarrior.getInitiativeStep();
    }

    @Override
    public void setReceivedWounds(int newValue) {
        myInnerWarrior.setReceivedWounds(newValue);
    }

    @Override
    public void ruszSie(GenericTypeExtendingPole cel) {
        myInnerPionek.ruszSie(cel);
    }

    @Override
    public void obrocSie(GenericTypeExtendingPole nowyPrzewodnik) {
        myInnerPionek.obrocSie(nowyPrzewodnik);
    }

    @Override
    public String getFacing(GenericTypeExtendingPole cel) {
        return myInnerPionek.getFacing(cel);
    }
}
