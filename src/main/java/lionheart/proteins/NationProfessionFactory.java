package lionheart.proteins;

import lionheart.proteins.equipment.ArmorImpl;
import lionheart.proteins.equipment.EquipmentFactory;
import lionheart.proteins.equipment.Weapon;
import lionheart.proteins.equipment.WeaponImpl;

public class NationProfessionFactory {

    public static NationProfession getNation (String id) {
        NationProfession result;
        if (id.equalsIgnoreCase("Kitsune")) {
//            System.out.println("lis");
            result = NationProfession.builder()
//                    .reflex(0)
//                    .dexterity(0)
                    .agility(1)
//                    .strength(0)
//                    .endurance(0)
//                    .vitality(0)
//                    .speed(0)
                    .offensive(-1)
//                    .defensive(0)
                    .size(3)
                    .build();
        } else if (id.equalsIgnoreCase("Tengu")) {
//            System.out.println("kruk");
            result = NationProfession.builder()
                    .reflex(1)
//                    .dexterity(0)
//                    .agility(0)
                    .strength(-1)
//                    .endurance(0)
                    .vitality(1)
//                    .speed(0)
//                    .offensive(0)
//                    .defensive(0)
                    .size(3)
                    .build();
        } else if (id.equalsIgnoreCase("Oni")) {
//            System.out.println("oni");
            result = NationProfession.builder()
//                    .reflex(0)
//                    .dexterity(0)
//                    .agility(0)
                    .strength(1)
                    .endurance(1)
                    .vitality(1)
                    .speed(-1)
//                    .offensive(0)
//                    .defensive(0)
                    .size(4)
                    .build();
        } else {
//            System.out.println("else");
            result = NationProfession.builder()
//                    .reflex(0)
//                    .dexterity(0)
//                    .agility(0)
//                    .strength(0)
//                    .endurance(0)
//                    .vitality(0)
//                    .speed(0)
//                    .offensive(0)
//                    .defensive(0)
                    .size(3)
                    .build();
        }
        return result;
    }

    public static NationProfession getProfession (String id) {
        NationProfession result;
        if (id.equalsIgnoreCase("Ashigaru")) {
//            System.out.println("asz");
            result = NationProfession.builder()
//                    .reflex(0)
//                    .dexterity(0)
//                    .agility(0)
//                    .strength(0)
//                    .endurance(0)
                    .vitality(1)
//                    .speed(0)
                    .offensive(2)
                    .defensive(3)
                    .weapon(EquipmentFactory.getWeapon("Naginata"))
                    .armor(EquipmentFactory.getArmor("Leather"))
                    .build();
        } else if (id.equalsIgnoreCase("Samurai") || id.equalsIgnoreCase("Samuraj")) {
//            System.out.println("sam");
            result = NationProfession.builder()
//                    .reflex(0)
                    .dexterity(1)
                    .agility(1)
                    .strength(1)
                    .endurance(1)
//                    .vitality(0)
                    .speed(2)
                    .offensive(6)
                    .defensive(4)
                    .weapon(EquipmentFactory.getWeapon("Katana"))
                    .armor(EquipmentFactory.getArmor("Chainmail"))
                    .build();
        } else {
//            System.out.println("else");
            result = NationProfession.builder()
//                    .reflex(0)
//                    .dexterity(0)
//                    .agility(0)
//                    .strength(0)
//                    .endurance(0)
//                    .vitality(0)
//                    .speed(0)
//                    .offensive(0)
//                    .defensive(0)
                    .weapon(EquipmentFactory.getWeapon("Wakizashi"))
                    .armor(EquipmentFactory.getArmor("Leather"))
                    .build();
        }
        return result;
    }

}
