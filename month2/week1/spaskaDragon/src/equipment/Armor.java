package equipment;

//Equipment of type Armor
//TO DO: specific armors with bonus effects
public class Armor extends Equipment {
    private final int defencePoints;
    private final double dodgeChance;

    public Armor(String name, String type, int defencePoints, double dodgeChance) {
        super(name, type);
        this.defencePoints = defencePoints;
        this.dodgeChance = dodgeChance;
    }

    public int getDefencePoints() {
        return defencePoints;
    }

    public double getDodgeChance() {
        return dodgeChance;
    }

    @Override
    public void showEquipmentStats() {
        System.out.println("Name: " + getName());
        System.out.println("Type: " + getType());
        System.out.println("Defence Points: " + defencePoints);
        System.out.println("Dodge chance: " + (int)(dodgeChance * 100) + "%");
    }
}
