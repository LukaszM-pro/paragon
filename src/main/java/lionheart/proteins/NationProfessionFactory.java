package lionheart.proteins;

import lionheart.proteins.equipment.ArmorImpl;
import lionheart.proteins.equipment.WeaponImpl;

public class NationProfessionFactory {

    public NationProfession getNation (String id) {
        NationProfession result;
        if (id.equalsIgnoreCase("Kitsune")) {
            result = NationProfession.builder()
                    .reflex()
                    .dexterity()
                    .agility()
                    .strength()
                    .endurance()
                    .vitality()
                    .speed()
                    .offensive()
                    .defensive()
                    .weapon()
                    .armor()
                    .size()
                    .build();
        } else if (id.equalsIgnoreCase("Tengu")) {
            result = NationProfession.builder()
                    .reflex()
                    .dexterity()
                    .agility()
                    .strength()
                    .endurance()
                    .vitality()
                    .speed()
                    .offensive()
                    .defensive()
                    .weapon()
                    .armor()
                    .size()
                    .build();
        } else if (id.equalsIgnoreCase("Oni")) {
            result = NationProfession.builder()
                    .reflex()
                    .dexterity()
                    .agility()
                    .strength()
                    .endurance()
                    .vitality()
                    .speed()
                    .offensive()
                    .defensive()
                    .weapon()
                    .armor()
                    .size()
                    .build();
        } else {
            result = NationProfession.builder()
                    .reflex(0)
                    .dexterity(0)
                    .agility(0)
                    .strength(0)
                    .endurance(0)
                    .vitality(0)
                    .speed(0)
                    .offensive(0)
                    .defensive(0)
                    .weapon(0)
                    .armor(0)
                    .size(0)
                    .build();
        }
        return result;
    }

    public NationProfession getNation (String id) {
        NationProfession result;
        if (id.equalsIgnoreCase("Ashigaru")) {
            result = NationProfession.builder()
                    .reflex()
                    .dexterity()
                    .agility()
                    .strength()
                    .endurance()
                    .vitality()
                    .speed()
                    .offensive()
                    .defensive()
                    .weapon()
                    .armor()
                    .size()
                    .build();
        } else if (id.equalsIgnoreCase("Samuraj")) {
            result = NationProfession.builder()
                    .reflex()
                    .dexterity()
                    .agility()
                    .strength()
                    .endurance()
                    .vitality()
                    .speed()
                    .offensive()
                    .defensive()
                    .weapon()
                    .armor()
                    .size()
                    .build();
        } else {
            result = NationProfession.builder()
                    .reflex(0)
                    .dexterity(0)
                    .agility(0)
                    .strength(0)
                    .endurance(0)
                    .vitality(0)
                    .speed(0)
                    .offensive(0)
                    .defensive(0)
                    .weapon(0)
                    .armor(0)
                    .size(0)
                    .build();
        }
        return result;
    }

}
