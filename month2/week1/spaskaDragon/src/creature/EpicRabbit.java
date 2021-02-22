package creature;
import constants.Constants;
import equipment.*;

public class EpicRabbit extends Rabbit {
    public EpicRabbit() {
        super("Epic Creature.Creature.Rabbit", 150, 35,
                Constants.EPIC_RABBIT_CRIT_CHANCE, Constants.EPIC_RABBIT_DODGE_CHANCE);
    }

    @Override
    public void showStats() {
        showCreatureStats();
    }

    @Override
    public Equipment dropItem() {
        Equipment droppedItem = new Armor(Constants.EPIC_BOOTS[0],
                Constants.ARMOR_TYPE[2], 55, 0);
        int dropItemType = getRandomIntNumber(0, 2);
        if (dropItemType == 0) {
            int defPoints = getRandomIntNumber(150, 201);
            double dodgeChance = getRandomDoubleNumber(0.3, 0.7);
            int dropArmorType = getRandomIntNumber(0, Constants.ARMOR_TYPE.length);
            switch (dropArmorType) {
                case 0:
                    int chosenHelmetIdx = getRandomIntNumber(0, Constants.EPIC_HELMETS.length);
                    droppedItem = new Armor(Constants.EPIC_HELMETS[chosenHelmetIdx],
                            Constants.ARMOR_TYPE[0], defPoints, dodgeChance);
                    break;
                case 1:
                    int chosenChestIdx = getRandomIntNumber(0, Constants.EPIC_CHESTS.length);
                    droppedItem = new Armor(Constants.EPIC_CHESTS[chosenChestIdx],
                            Constants.ARMOR_TYPE[1], defPoints, dodgeChance);
                    break;
                case 2:
                    int chosenBootsIdx = getRandomIntNumber(0, Constants.EPIC_BOOTS.length);
                    droppedItem = new Armor(Constants.EPIC_BOOTS[chosenBootsIdx],
                            Constants.ARMOR_TYPE[2], defPoints, dodgeChance);
                    break;
                default:
                    break;
            }
        } else {
            int attackPoints = getRandomIntNumber(80, 101);
            double critChance = getRandomDoubleNumber(0.3, 0.8);
            int chosenWeaponIdx = getRandomIntNumber(0, Constants.EPIC_WEAPONS.length);
            int chosenWeaponType = getRandomIntNumber(0, Constants.WEAPON_TYPE.length);
            droppedItem = new Weapon(Constants.EPIC_WEAPONS[chosenWeaponIdx],
                    Constants.WEAPON_TYPE[chosenWeaponType], attackPoints, critChance);
        }

        return droppedItem;
    }
}
