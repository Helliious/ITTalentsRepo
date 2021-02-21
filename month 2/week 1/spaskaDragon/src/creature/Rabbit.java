package creature;
import equipment.Equipment;

public abstract class Rabbit extends Creature {
    Rabbit(String name, int hp, int dmg, double critChance, double dodgeChance) {
        super(name, hp, dmg, critChance, dodgeChance);
    }

    public abstract Equipment dropItem();
}
