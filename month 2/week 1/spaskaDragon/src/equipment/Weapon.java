package equipment;

//Equipment of type Weapon
//TO DO: specific weapons with bonus effects
public class Weapon extends Equipment {
    private final int dmg;
    private final double critChance;

    public Weapon(String name, String type, int dmg, double critChance) {
        super(name, type);
        this.dmg = dmg;
        this.critChance = critChance;
    }

    public int getDmg() {
        return dmg;
    }

    public double getCritChance() {
        return critChance;
    }

    @Override
    public void showEquipmentStats() {
        System.out.println("Name: " + getName());
        System.out.println("Type: " + getType());
        System.out.println("Damage Points: " + dmg);
        System.out.println("Critical chance: " + (int)(critChance * 100) + "%");
    }
}
