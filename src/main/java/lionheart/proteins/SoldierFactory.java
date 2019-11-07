package lionheart.proteins;

import lionheart.config.ConfigurationL5K;
import lionheart.dice.mechanics.ThrowL5R;
import lionheart.proteins.equipment.Armor;
import lionheart.proteins.equipment.Weapon;

public class SoldierFactory {

    public static Soldier getSoldier(String id){
        Soldier soldier;
        if (id.replace(" ","").equalsIgnoreCase("KitsuneAshigaru")
                || id.replace(" ","").equalsIgnoreCase("AshigaruKitsune")) {
            soldier = getSoldier("notStill", "Kitsune", "Ashigaru");
        } else if (id.replace(" ","").equalsIgnoreCase("KitsuneSamurai")
                || id.replace(" ","").equalsIgnoreCase("SamuraiKitsune")) {
            soldier = getSoldier("notStill", "Kitsune", "Samurai");
        } else if (id.replace(" ","").equalsIgnoreCase("OniSamurai")
                || id.replace(" ","").equalsIgnoreCase("SamuraiOni")) {
            soldier = getSoldier("notStill", "Oni", "Samurai");
        } else if (id.replace(" ","").equalsIgnoreCase("OniAshigaru")
                || id.replace(" ","").equalsIgnoreCase("AshigaruOni")) {
            soldier = getSoldier("notStill", "Oni", "Ashigaru");
        } else {
            soldier = getSoldier("still", "else", "else");
        }
        return soldier;
    }

    public static SoldierImplementation getSoldier(String id, String nation, String profession){
        SoldierImplementation soldier;
        if (id.equalsIgnoreCase("still")){
//            System.out.println("random");
            soldier = SoldierImplementation.builder()
                    .reflex(ConfigurationL5K.ATTRIBUTE_BASE + 1)
                    .dexterity(ConfigurationL5K.ATTRIBUTE_BASE + 1)
                    .agility(ConfigurationL5K.ATTRIBUTE_BASE + 1)
                    .strength(ConfigurationL5K.ATTRIBUTE_BASE + 1)
                    .endurance(ConfigurationL5K.ATTRIBUTE_BASE + 1)
                    .speed(ConfigurationL5K.SKILL_BASE + 2)
                    .offensive(ConfigurationL5K.SKILL_BASE + 2)
                    .defensive(ConfigurationL5K.SKILL_BASE + 2)
//                    .size(3)
                    .nation(NationProfessionFactory.getNation(nation))
                    .profession(NationProfessionFactory.getProfession(profession))
                    .build();
        } else {
//            System.out.println("else");
            soldier = SoldierImplementation.builder()
                    .reflex(ConfigurationL5K.ATTRIBUTE_BASE + ThrowL5R.statisticsDeviation(2))
                    .dexterity(ConfigurationL5K.ATTRIBUTE_BASE + ThrowL5R.statisticsDeviation(2))
                    .agility(ConfigurationL5K.ATTRIBUTE_BASE + ThrowL5R.statisticsDeviation(2))
                    .strength(ConfigurationL5K.ATTRIBUTE_BASE + ThrowL5R.statisticsDeviation(2))
                    .endurance(ConfigurationL5K.ATTRIBUTE_BASE + ThrowL5R.statisticsDeviation(2))
                    .speed(ConfigurationL5K.SKILL_BASE + ThrowL5R.statisticsDeviation(4))
                    .offensive(ConfigurationL5K.SKILL_BASE + ThrowL5R.statisticsDeviation(4))
                    .defensive(ConfigurationL5K.SKILL_BASE + ThrowL5R.statisticsDeviation(4))
//                    .size(3)
                    .nation(NationProfessionFactory.getNation(nation))
                    .profession(NationProfessionFactory.getProfession(profession))
                    .build();
        }
        return soldier;
    }

}
