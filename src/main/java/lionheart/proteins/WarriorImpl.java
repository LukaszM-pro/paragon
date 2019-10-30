package lionheart.proteins;

import lionheart.config.ConfigLionheart;
import lombok.experimental.SuperBuilder;

//@Data(inherit = true)
@SuperBuilder
public class WarriorImpl extends AbstractWarrior implements Warrior{

    private final int MODYFIKATOR_WAGI_BRONI = 1;
    private int aktualneRany = 0;

    @Override
    public int getDefense() {
        return getPancerz().getWaparowanie();
    }

    @Override
    public int getHit() {
        if (getBron().getOstrosc() < getModSilaWytrzymalosc() - MODYFIKATOR_WAGI_BRONI) {
            return getZrecznoscZwinnosc() + getSkill();
        } else if (getBron().getOstrosc() > getModSilaWytrzymalosc() + MODYFIKATOR_WAGI_BRONI) {
            return getSilaWytrzymalosc() + getSkill();
        } else {
            return (getSilaWytrzymalosc() + getZrecznoscZwinnosc()) / 2 + getSkill();
        }
    }

    @Override
    public int getDodge() {
        return (100 - getPancerz().getModIni()) / ConfigLionheart.DZIELNIK_SKL_EQ + getModZrecznoscZwinnosc();
    }

    @Override
    public int getAttack() {
        return getModSilaWytrzymalosc() * (int) (Math.min(getBron().getOstrosc(), getModSilaWytrzymalosc() * 1.5));
    }

    @Override
    public int getCritical() {
        return getModSkill() - getBron().getWAGA() + getBron().getJAKOSC() + ConfigLionheart.DZIELNIK_SKL_EQ;
    }

    @Override
    public int getHealthActual() {
        return getSilaWytrzymalosc() - aktualneRany;
    }

    @Override
    public int getInitiativeStep() {
        return (2 * getModSilaWytrzymalosc() + getModZrecznoscZwinnosc()) - getBron().getModIni() - getPancerz().getModIni() + getModSkill();
    }

    @Override
    public void setReceivedWounds(int newValue) {
        aktualneRany = aktualneRany + newValue;
    }
}
