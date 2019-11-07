package lionheart.proteins;

import lionheart.config.ConfigurationL5K;
import lionheart.dice.mechanics.ThrowL5R;
import lionheart.proteins.equipment.Armor;
import lionheart.proteins.equipment.Weapon;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.concurrent.ThreadLocalRandom;

@ToString(callSuper=true)
//@Getter
@Data
@SuperBuilder
public class SoldierImplementation extends AbstractSoldier implements Soldier {

    protected int actualWounds = 0;

    private int reflex(){
        return reflex + nation.reflex + profession.reflex - profession.weapon.getWeight() - profession.armor.getWeight();
    }
    private int dexterity(){
        return dexterity + nation.dexterity + profession.dexterity;
    }
    private int agility(){
        return agility + nation.agility + profession.agility;
    }
    private int strength(){
        return (int) Math.ceil((strength + nation.strength + profession.strength) * livePercentageRate());
    }
    private int endurance(){
        return (int) Math.ceil((endurance + nation.endurance + profession.endurance) * livePercentageRate());
    }
    private int vitality(){
        return vitality + nation.vitality + profession.vitality;
    }
    private int speed(){
        return (int) Math.ceil((speed + nation.speed + profession.speed) * livePercentageRate());
    }
    private int offensive(){
        return (int) Math.ceil((offensive + nation.offensive + profession.offensive) * livePercentageRate());
    }
    private int defensive(){
        return (int) Math.ceil((defensive + nation.defensive + profession.defensive) * livePercentageRate());
    }
    private int size(){
        return size + nation.size + profession.size;
    }
    private int maximalLivePoints(){
//        System.out.println(
//                "vitality:" + vitality() + "   size:" + size() + "   ConfigurationL5K.DICE:" + ConfigurationL5K.DICE
//        );

        return (vitality() + size()) * ConfigurationL5K.DICE;
    }
    private double livePercentageRate(){
        return ((double) maximalLivePoints() - actualWounds) / maximalLivePoints();
    }

    @Override
    public int getInitiativeThrow() {
        return ThrowL5R.l5K(reflex(), Math.max(1, speed() * ConfigurationL5K.SKILL_MULTIPLIER)) - fought;
    }

    @Override
    public int getHitThrow() {
        return ThrowL5R.l5K(dexterity(), Math.max(1, offensive() * ConfigurationL5K.SKILL_MULTIPLIER - profession.weapon.getWeight())) - fought;
    }

    @Override
    public int getDodgeThrow() {
        return ThrowL5R.l5K(agility(), Math.max(1, defensive() * ConfigurationL5K.SKILL_MULTIPLIER - profession.armor.getWeight())) - fought;
    }

    @Override
    public int getDamageThrow(int bonus) {
        return ThrowL5R.l5K(profession.weapon.getEfficiency(), Math.max(1, profession.weapon.getEfficiency() * strength() + profession.weapon.getQuality() + bonus)) - fought;
    }

    @Override
    public int getResistanceThrow() {
        return ThrowL5R.l5K(profession.armor.getEfficiency(), Math.max(1, profession.armor.getEfficiency() * endurance() + profession.armor.getQuality())) - fought;
    }

    @Override
    public
    synchronized
    boolean getIfAlive() {
        return actualWounds < maximalLivePoints();
    }

    @Override
    public
    synchronized
    void takeWounds(int quantity) {
        actualWounds += quantity;
    }

    @Override
    public
    synchronized
    void incrementFought() {
        fought++;
    }

    @Override
    public
    synchronized
    int getFought() {
        return fought;
    }

//    @Override
//    public
//    synchronized
//    int getRandomizedId() {
//        while (randomizedId == 0) {
//            randomizedId = ThreadLocalRandom.current().nextInt();
//        }
//        return randomizedId;
//    }

    @Override
    public
    synchronized
    void setRandomizedId() {
        while (randomizedId == 0) {
            randomizedId = ThreadLocalRandom.current().nextInt();
        }
    }

    @Override
    public String toString(){
        return "reflex:" + reflex() + "  speed:" + speed()
                + "  dexterity:" + dexterity() + "  offensive:" + offensive()
                + "  agility:" + agility() + "  defensive:" + defensive()
                + "  strength:" + strength() + "  endurance:" + endurance()
                + "  vitality:" + vitality() + "  actualWounds:" + actualWounds
                + "  livePercentageRate:" + livePercentageRate() + "  maximalLivePoints:" + maximalLivePoints()
                + "  size:" + size();
    }
}
