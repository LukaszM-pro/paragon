package lionheart.proteins.equipment;

public class EquipmentFactory {

    public static Weapon getWeapon(String id) {
        Weapon result;
        if (id.equalsIgnoreCase("Wakizashi")) {
            result = WeaponImpl.builder()
                    .efficiency(1)
                    .quality(1)
                    .range(1)
                    .build();
        } else if (id.equalsIgnoreCase("Katana")) {
            result = WeaponImpl.builder()
                    .efficiency(2)
                    .quality(2)
                    .range(1)
                    .build();
        } else if (id.equalsIgnoreCase("Nodachi")) {
            result = WeaponImpl.builder()
                    .efficiency(4)
                    .quality(0)
                    .range(1)
                    .build();
        } else if (id.equalsIgnoreCase("Naginata")) {
            result = WeaponImpl.builder()
                    .efficiency(2)
                    .quality(-2)
                    .range(2)
                    .build();
        } else if (id.equalsIgnoreCase("Yari")) {
            result = WeaponImpl.builder()
                    .efficiency(1)
                    .quality(-1)
                    .range(2)
                    .build();
        } else {
            result = WeaponImpl.builder()
                    .efficiency(0)
                    .quality(0)
                    .range(0)
                    .build();
        }
        return result;
    }

    public static Armor getArmor(String id) {
        Armor result;
        if (id.equalsIgnoreCase("Leather")) {
            result = ArmorImpl.builder()
                    .efficiency(1)
                    .quality(-1)
                    .build();
        } else if (id.equalsIgnoreCase("Reinforced leather")) {
            result = ArmorImpl.builder()
                    .efficiency(1)
                    .quality(1)
                    .build();
        } else if (id.equalsIgnoreCase("Chainmail")) {
            result = ArmorImpl.builder()
                    .efficiency(2)
                    .quality(-2)
                    .build();
        } else if (id.equalsIgnoreCase("Lamellar")) {
            result = ArmorImpl.builder()
                    .efficiency(2)
                    .quality(2)
                    .build();
        } else if (id.equalsIgnoreCase("Plate")) {
            result = ArmorImpl.builder()
                    .efficiency(3)
                    .quality(-3)
                    .build();
        } else {
            result = ArmorImpl.builder()
                    .efficiency(0)
                    .quality(0)
                    .build();
        }
        return result;
    }
}
