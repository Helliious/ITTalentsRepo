package creature;
import constants.Constants;
import java.util.Random;

public abstract class Creature {
    private final String name;
    private int hp;
    private int dmg;
    private double critChance;
    private double dodgeChance;

    Creature(String name, int hp, int dmg, double critChance, double dodgeChance) {
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.critChance = critChance;
        this.dodgeChance = dodgeChance;
    }

    //abstract method printing all creature stats
    public abstract void showStats();
    //attack method logic
    public void attack(Creature opponent) {
        int critDmg = getDmg();
        //logic for critical chance
        int crit = (int)(Math.random() * 100);
        int critChance = (int)(getCritChance() * 100);
        if (crit >= 0 && crit <= critChance) {
            System.out.println("\n\nWOHA !!! CRITICAL !!!\n");
            critDmg = 2 * getDmg();
        }

        //logic for dodge chance
        int dodge = (int)(Math.random() * 100);
        int opponentDodgeChance = (int)(opponent.getDodgeChance() * 100);
        if (dodge > opponentDodgeChance) {
            opponent.reduceHP(critDmg);
        } else {
            System.out.println("WHOA !!! DODGED!!!");
        }
    }

    public void showCreatureStats() {
        System.out.println("Name: " + name);
        System.out.println("HP: " + hp);
        System.out.println("Damage: " + dmg);
        System.out.println("Critical: " + (int)(critChance * 100) + "%");
        System.out.println("Dodge: " + (int)(dodgeChance * 100) + "%");
    }

    int getHp() {
        return hp;
    }

    void increaseHp(int additionalHp) {
        this.hp += additionalHp;
    }

    int getDmg() {
        return dmg;
    }

    void increaseDmg(int additionalDmg) {
        this.dmg += additionalDmg;
    }

    double getCritChance() {
        return critChance;
    }

    void increaseCritChance(double additionalCritChance) {
        this.critChance += additionalCritChance;
    }

    double getDodgeChance() {
        return dodgeChance;
    }

    void increaseDodgeChance(double additionalDodgeChance) {
        this.dodgeChance += additionalDodgeChance;
    }

    void substractHP(int amountHp) {
        hp -= amountHp;
    }

    void substractDmg(int amountDmg) {
        dmg -= amountDmg;
    }

    void substractCritChance(double amountCritChance) {
        critChance -= amountCritChance;
    }

    void substractDodgeChance(double amountDodgeChance) {
        dodgeChance -= amountDodgeChance;
    }

    void reduceHP(int value) {
        if (value < hp) {
            hp -= value;
        } else {
            hp = 0;
        }
    }

    //restore life points
    void restoreHP() {
        hp = Constants.MAX_HP;
    }

    //check if creature is dead
    public boolean isDead() {
        return getHp() == 0;
    }

    //getting random int number from min inclusive to max exclusive
    int getRandomIntNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    //getting random double number from min inclusive to max exclusive
    double getRandomDoubleNumber(double min, double max) {
        return Math.random() * (max - min + 1) + min;
    }
}
