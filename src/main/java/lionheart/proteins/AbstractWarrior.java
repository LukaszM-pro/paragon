package lionheart.proteins;

import lionheart.config.ConfigLionheart;
import lionheart.proteins.equipment.Bron;
import lionheart.proteins.equipment.Pancerz;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class AbstractWarrior{

    private String name;
//    private int healthMaximum;
//    private int healthActual;
//    private int hit;
//    private int dodge;
//    private int attack;
//    private int defense;
//    private int critical;
//    private int initiativeStep;
//    private int initiativeActual;
//    private int movement;
//    private int attackRange;
//    private int morale;
    private int silaWytrzymalosc;
    private int zrecznoscZwinnosc;
    private int skill;
    private Bron bron;
    private Pancerz pancerz;

    public int getModSilaWytrzymalosc(){
        return silaWytrzymalosc / ConfigLionheart.DZIELNIK_BC_KR;
    }

    public int getModZrecznoscZwinnosc(){
        return zrecznoscZwinnosc / ConfigLionheart.DZIELNIK_BC_KR;
    }

    public int getModSkill(){
        return skill / ConfigLionheart.DZIELNIK_SKL_EQ;
    }

/*
    protected AbstractWarrior(AbstractWarriorBuilder<?, ?> b) {
        this.name = b.name;
        this.healthMaximum = b.healthMaximum;
        this.healthActual = b.healthActual;
        this.hit = b.hit;
        this.dodge = b.dodge;
        this.attack = b.attack;
        this.defense = b.defense;
        this.critical = b.critical;
        this.initiativeStep = b.initiativeStep;
        this.initiativeActual = b.initiativeActual;
        this.movement = b.movement;
        this.attackRange = b.attackRange;
        this.morale = b.morale;
    }

    public static abstract class AbstractWarriorBuilder<C extends AbstractWarrior, B extends AbstractWarriorBuilder<C, B>> {
        private String name;
        private int healthMaximum;
        private int healthActual;
        private int hit;
        private int dodge;
        private int attack;
        private int defense;
        private int critical;
        private int initiativeStep;
        private int initiativeActual;
        private int movement;
        private int attackRange;
        private int morale;

        public B name(String name) {
            this.name = name;
            return self();
        }

        public B healthMaximum(int healthMaximum) {
            this.healthMaximum = healthMaximum;
            return self();
        }

        public B healthActual(int healthActual) {
            this.healthActual = healthActual;
            return self();
        }

        public B hit(int hit) {
            this.hit = hit;
            return self();
        }

        public B dodge(int dodge) {
            this.dodge = dodge;
            return self();
        }

        public B attack(int attack) {
            this.attack = attack;
            return self();
        }

        public B defense(int defense) {
            this.defense = defense;
            return self();
        }

        public B critical(int critical) {
            this.critical = critical;
            return self();
        }

        public B initiativeStep(int initiativeStep) {
            this.initiativeStep = initiativeStep;
            return self();
        }

        public B initiativeActual(int initiativeActual) {
            this.initiativeActual = initiativeActual;
            return self();
        }

        public B movement(int movement) {
            this.movement = movement;
            return self();
        }

        public B attackRange(int attackRange) {
            this.attackRange = attackRange;
            return self();
        }

        public B morale(int morale) {
            this.morale = morale;
            return self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "AbstractWarrior.AbstractWarriorBuilder(name=" + this.name + ", healthMaximum=" + this.healthMaximum + ", healthActual=" + this.healthActual + ", hit=" + this.hit + ", dodge=" + this.dodge + ", attack=" + this.attack + ", defense=" + this.defense + ", critical=" + this.critical + ", initiativeStep=" + this.initiativeStep + ", initiativeActual=" + this.initiativeActual + ", movement=" + this.movement + ", attackRange=" + this.attackRange + ", morale=" + this.morale + ")";
        }
    }
/**/
}
