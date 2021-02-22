package creature;
import constants.Constants;
import equipment.*;

public class Hero extends Creature {
    //TO DO: Item bag and trinkets
    private final Equipment[] equipmentItems;

    public Hero(String name, int hp, int dmg, double critChance, double dodgeChance) {
        super(name, hp, dmg, critChance, dodgeChance);
        equipmentItems = new Equipment[Constants.AMOUNT_OF_GEAR];
    }

    //restore hp for Hero
    public void goToTavern() {
        restoreHP();
        calcHP();
    }

    //Picking up an item
    public void equipItem(Equipment equipmentItem, String slot) {
        switch (slot) {
            case "Helmet":
                if (equipmentItems[0] != null) {
                    unequipItem("Helmet");
                }
                equipmentItems[0] = equipmentItem;
                increaseHp(((Armor)equipmentItems[0]).getDefencePoints());
                increaseDodgeChance(((Armor)equipmentItems[0]).getDodgeChance());
                break;
            case "Chest":
                if (equipmentItems[1] != null) {
                    unequipItem("Chest");
                }
                equipmentItems[1] = equipmentItem;
                increaseHp(((Armor)equipmentItems[1]).getDefencePoints());
                increaseDodgeChance(((Armor)equipmentItems[1]).getDodgeChance());
                break;
            case "Boots":
                if (equipmentItems[2] != null) {
                    unequipItem("Boots");
                }
                equipmentItems[2] = equipmentItem;
                increaseHp(((Armor)equipmentItems[2]).getDefencePoints());
                increaseDodgeChance(((Armor)equipmentItems[2]).getDodgeChance());
                break;
            case "Main Hand":
                if (equipmentItems[3] != null) {
                    unequipItem("Main Hand");
                }
                equipmentItems[3] = equipmentItem;
                increaseDmg(((Weapon)equipmentItems[3]).getDmg());
                increaseCritChance(((Weapon)equipmentItems[3]).getCritChance());
                break;
            case "Off Hand":
                if (equipmentItems[4] != null) {
                    unequipItem("Off Hand");
                }
                equipmentItems[4] = equipmentItem;
                increaseDmg(((Weapon)equipmentItems[4]).getDmg());
                increaseCritChance(((Weapon)equipmentItems[4]).getCritChance());
                break;
            default:
                break;
        }
    }

    //Taking down an item
    public void unequipItem(String slot) {
        switch (slot) {
            case "Helmet":
                substractHP(((Armor)equipmentItems[0]).getDefencePoints());
                substractDodgeChance(((Armor)equipmentItems[0]).getDodgeChance());
                equipmentItems[0] = null;
                break;
            case "Chest":
                substractHP(((Armor)equipmentItems[1]).getDefencePoints());
                substractDodgeChance(((Armor)equipmentItems[1]).getDodgeChance());
                equipmentItems[1] = null;
                break;
            case "Boots":
                substractHP(((Armor)equipmentItems[2]).getDefencePoints());
                substractDodgeChance(((Armor)equipmentItems[2]).getDodgeChance());
                equipmentItems[2] = null;
                break;
            case "Main Hand":
                substractDmg(((Weapon)equipmentItems[3]).getDmg());
                substractCritChance(((Weapon)equipmentItems[3]).getCritChance());
                equipmentItems[3] = null;
                break;
            case "Off Hand":
                substractDmg(((Weapon)equipmentItems[4]).getDmg());
                substractCritChance(((Weapon)equipmentItems[4]).getCritChance());
                equipmentItems[4] = null;
                break;
            default:
                break;
        }
    }

    @Override
    public void showStats() {
        System.out.println();
        showCreatureStats();
        System.out.println("-------Equipment.Equipment-------");
        for (int i = 0; i < equipmentItems.length; i++) {
            if (equipmentItems[i] != null) {
                equipmentItems[i].showEquipmentStats();
                System.out.println("-----------------------");
            }
        }
        System.out.println();
    }

    //Evaluating hero life points
    void calcHP() {
        int additionalHp = 0;
        for (int i = 0 ; i < equipmentItems.length; i++) {
            if (equipmentItems[i] instanceof Armor && equipmentItems[i] != null) {
                additionalHp += ((Armor)equipmentItems[i]).getDefencePoints();
            }
        }
        increaseHp(additionalHp);
    }
}
