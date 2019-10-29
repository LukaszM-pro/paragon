package lionheart.proteins;

import lombok.NonNull;

public class WarriorFactory {

    @NonNull
    public static Warrior getWarrior(String type){
        if("ashigaru".equalsIgnoreCase(type)) {
            Warrior manufacturedWarrior = WarriorImpl.builder()
                .name("Generic Ashigaru")
//                .healthMaximum(50)
//                .healthActual(50)
//                .hit(50)
//                .dodge(5)
//                .attack(5)
//                .defense(50)
//                .critical(5)
//                .initiativeStep(5)
//                .initiativeActual(0)
//                .movement(5)
//                .attackRange(2)
//                .morale(5)
                .build();
            return manufacturedWarrior;
        } else if("samuraj".equalsIgnoreCase(type) || "samurai".equalsIgnoreCase(type)) {
            Warrior manufacturedWarrior = WarriorImpl.builder()
                .name("Generic Samurai")
//                .healthMaximum(75)
//                .healthActual(75)
//                .hit(75)
//                .dodge(10)
//                .attack(10)
//                .defense(75)
//                .critical(10)
//                .initiativeStep(10)
//                .initiativeActual(0)
//                .movement(5)
//                .attackRange(1)
//                .morale(10)
                .build();
            return manufacturedWarrior;
        } else {
            return null;
        }
    }

}
