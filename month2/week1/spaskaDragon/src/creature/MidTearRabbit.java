package creature;
import constants.Constants;
import equipment.*;

public class MidTearRabbit extends Rabbit {
    public MidTearRabbit() {
        super("MidTear Creature.Creature.Rabbit", 50, 10,
                Constants.MID_TEAR_RABBIT_CRIT_CHANCE, Constants.MID_TEAR_RABBIT_DODGE_CHANCE);
    }

    @Override
    public void showStats() {
        showCreatureStats();
    }

    @Override
    public void attack(Creature opponent) {
        opponent.reduceHP(this.getDmg());
    }

    @Override
    public Equipment dropItem() {
        Equipment droppedItem = new Armor(Constants.MID_TEAR_CHESTS[0],
                Constants.ARMOR_TYPE[1], 55, 0);
        int dropItemType = getRandomIntNumber(0, 2);
        if (dropItemType == 0) {
            int defPoints = getRandomIntNumber(50, 101);
            double dodgeChance = getRandomDoubleNumber(0.1, 0.4);
            int dropArmorType = getRandomIntNumber(0, Constants.ARMOR_TYPE.length);
            switch (dropArmorType) {
                case 0:
                    int chosenHelmetIdx = getRandomIntNumber(0, Constants.MID_TEAR_HELMETS.length);
                    droppedItem = new Armor(Constants.MID_TEAR_HELMETS[chosenHelmetIdx],
                            Constants.ARMOR_TYPE[0], defPoints, dodgeChance);
                    break;
                case 1:
                    int chosenChestIdx = getRandomIntNumber(0, Constants.MID_TEAR_CHESTS.length);
                    droppedItem = new Armor(Constants.MID_TEAR_CHESTS[chosenChestIdx],
                            Constants.ARMOR_TYPE[1], defPoints, dodgeChance);
                    break;
                case 2:
                    int chosenBootsIdx = getRandomIntNumber(0, Constants.MID_TEAR_BOOTS.length);
                    droppedItem = new Armor(Constants.MID_TEAR_BOOTS[chosenBootsIdx],
                            Constants.ARMOR_TYPE[2], defPoints, dodgeChance);
                    break;
                default:
                    break;
            }
        } else {
            int attackPoints = getRandomIntNumber(30, 51);
            double critChance = getRandomDoubleNumber(0.1, 0.3);
            int chosenWeaponIdx = getRandomIntNumber(0, Constants.MID_TEAR_WEAPONS.length);
            int chosenWeaponType = getRandomIntNumber(0, Constants.WEAPON_TYPE.length);
            droppedItem = new Weapon(Constants.MID_TEAR_WEAPONS[chosenWeaponIdx],
                    Constants.WEAPON_TYPE[chosenWeaponType], attackPoints, critChance);
        }

        return droppedItem;
    }
}
