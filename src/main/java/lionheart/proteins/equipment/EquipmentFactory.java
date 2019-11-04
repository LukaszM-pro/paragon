package lionheart.proteins.equipment;

public class EquipmentFactory {

    static Weapon getWeapon(String id) {
        Weapon result;
        if (id.equalsIgnoreCase("Wakizashi")) {
            result = Weapon.builder()
                    .efficiency(1)
                    .quality(0)
                    .range(1)
                    .build();
        } else if (id.equalsIgnoreCase("Katana")) {
            result = Weapon.builder()
                    .efficiency(2)
                    .quality(0)
                    .range(1)
                    .build();
        } else if (id.equalsIgnoreCase("Nodachi")) {
            result = Weapon.builder()
                    .efficiency(4)
                    .quality(0)
                    .range(1)
                    .build();
        } else if (id.equalsIgnoreCase("Naginata")) {
            result = Weapon.builder()
                    .efficiency(2)
                    .quality(0)
                    .range(2)
                    .build();
        } else if (id.equalsIgnoreCase("Yari")) {
            result = Weapon.builder()
                    .efficiency(1)
                    .quality(0)
                    .range(2)
                    .build();
        } else {
            result = Weapon.builder()
                    .efficiency(0)
                    .quality(0)
                    .range(0)
                    .build();
        }
        return result;
    }

    static Armor getArmor(String id) {
        Armor result;
        if (id.equalsIgnoreCase("Leather")) {
            result = Armor.builder()
                    .efficiency(1)
                    .quality(-1)
                    .build();
        } else if (id.equalsIgnoreCase("Reinforced leather")) {
            result = Armor.builder()
                    .efficiency(1)
                    .quality(1)
                    .build();
        } else if (id.equalsIgnoreCase("Chainmail")) {
            result = Armor.builder()
                    .efficiency(2)
                    .quality(-2)
                    .build();
        } else if (id.equalsIgnoreCase("Lamellar")) {
            result = Armor.builder()
                    .efficiency(2)
                    .quality(2)
                    .build();
        } else if (id.equalsIgnoreCase("Plate")) {
            result = Armor.builder()
                    .efficiency(3)
                    .quality(0)
                    .build();
        } else {
            result = Armor.builder()
                    .efficiency(0)
                    .quality(0)
                    .build();
        }
        return result;
    }
}
