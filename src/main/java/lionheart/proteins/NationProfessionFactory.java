package lionheart.proteins;

import lionheart.proteins.equipment.ArmorImpl;
import lionheart.proteins.equipment.EquipmentFactory;
import lionheart.proteins.equipment.Weapon;
import lionheart.proteins.equipment.WeaponImpl;

public class NationProfessionFactory {

    public NationProfession getNation (String id) {
        NationProfession result;
        if (id.equalsIgnoreCase("Kitsune")) {
            result = NationProfession.builder()
                    .reflex(0)
                    .dexterity(0)
                    .agility(1)
                    .strength(0)
                    .endurance(0)
                    .vitality(0)
                    .speed(0)
                    .offensive(-1)
                    .defensive(0)
//                    .weapon(null)
//                    .armor(null)
                    .size(3)
                    .build();
        } else if (id.equalsIgnoreCase("Tengu")) {
            result = NationProfession.builder()
                    .reflex(1)
                    .dexterity(0)
                    .agility(0)
                    .strength(-1)
                    .endurance(0)
                    .vitality(1)
                    .speed(0)
                    .offensive(0)
                    .defensive(0)
//                    .weapon(null)
//                    .armor(null)
                    .size(3)
                    .build();
        } else if (id.equalsIgnoreCase("Oni")) {
            result = NationProfession.builder()
                    .reflex(0)
                    .dexterity(0)
                    .agility(0)
                    .strength(1)
                    .endurance(1)
                    .vitality(1)
                    .speed(-1)
                    .offensive(0)
                    .defensive(0)
//                    .weapon(null)
//                    .armor(null)
                    .size(4)
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
                    .weapon(null)
                    .armor(null)
                    .size(0)
                    .build();
        }
        return result;
    }

    public NationProfession getProfession (String id) {
        NationProfession result;
        if (id.equalsIgnoreCase("Ashigaru")) {
            result = NationProfession.builder()
                    .reflex(0)
                    .dexterity(0)
                    .agility(0)
                    .strength(0)
                    .endurance(0)
                    .vitality(0)
                    .speed(0)
                    .offensive(1)
                    .defensive(2)
                    .weapon(EquipmentFactory.getWeapon("Naginata"))
                    .armor(EquipmentFactory.getArmor("Leather"))
//                    .size(0)
                    .build();
        } else if (id.equalsIgnoreCase("Samuraj")) {
            result = NationProfession.builder()
                    .reflex(0)
                    .dexterity(1)
                    .agility(1)
                    .strength(1)
                    .endurance(1)
                    .vitality(0)
                    .speed(2)
                    .offensive(6)
                    .defensive(4)
                    .weapon(EquipmentFactory.getWeapon("Katana"))
                    .armor(EquipmentFactory.getArmor("Chainmail"))
//                    .size()
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
                    .weapon(EquipmentFactory.getWeapon("Wakizashi"))
                    .armor(EquipmentFactory.getArmor("Leather"))
//                    .size(0)
                    .build();
        }
        return result;
    }

}
