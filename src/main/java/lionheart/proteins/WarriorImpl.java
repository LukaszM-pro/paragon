package lionheart.proteins;

import lombok.Data;
import lombok.experimental.SuperBuilder;

//@Data(inherit = true)
@SuperBuilder
public class WarriorImpl extends AbstractWarrior implements Warrior{

    private final int MODYFIKATOR_WAGI_BRONI = 1;
    private final int DZIELNIK_BC_KR = 10;
    private final int DZIELNIK_SKL_EQ = 5;
    private int aktualneRany = 0;

    @Override
    public int getDefense() {
        return getPancerz().getSKUTECZNOSC();
    }

    @Override
    public int getHit() {
        if (getBron().getSKUTECZNOSC() < getSilaWytrzymalosc() / DZIELNIK_BC_KR - MODYFIKATOR_WAGI_BRONI) {
            return getZrecznoscZwinnosc() + getSkill();
        } else if (getBron().getSKUTECZNOSC() > getSilaWytrzymalosc() / DZIELNIK_BC_KR + MODYFIKATOR_WAGI_BRONI) {
            return getSilaWytrzymalosc() + getSkill();
        } else {
            return (getSilaWytrzymalosc() + getZrecznoscZwinnosc()) / 2 + getSkill();
        }
    }

    @Override
    public int getDodge() {
        return (100 - getPancerz().getSKUTECZNOSC()) / 5 + getZrecznoscZwinnosc() / DZIELNIK_SKL_EQ;
    }

    @Override
    public int getAttack() {
        return getSilaWytrzymalosc() / DZIELNIK_BC_KR * getBron().getSKUTECZNOSC();
    }

    @Override
    public int getCritical() {
        return getSkill() / DZIELNIK_SKL_EQ - getBron().getSKUTECZNOSC() + DZIELNIK_SKL_EQ;
    }

    @Override
    public int getHealthActual() {
        return getSilaWytrzymalosc() - aktualneRany;
    }

    @Override
    public int getInitiativeStep() {
        return (2 * getSilaWytrzymalosc() + getZrecznoscZwinnosc()) / DZIELNIK_BC_KR - getBron().getSKUTECZNOSC() - getPancerz().getSKUTECZNOSC() / DZIELNIK_SKL_EQ;
    }

    @Override
    public void setReceivedWounds(int newValue) {
        aktualneRany = aktualneRany + newValue;
    }
}
