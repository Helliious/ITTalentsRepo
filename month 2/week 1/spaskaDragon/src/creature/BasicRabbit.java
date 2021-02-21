package creature;
import constants.Constants;
import equipment.*;

public class BasicRabbit extends Rabbit {
    public BasicRabbit() {
        super("Basic Creature.Creature.Rabbit", 10, 5, 0,0);
    }

    //printing basic rabbit stats
    @Override
    public void showStats() {
        showCreatureStats();
    }

    //drop item logic when basic rabbit dies
    @Override
    public Equipment dropItem() {
        Equipment droppedItem = new Armor(Constants.BASIC_HELMETS[0],
                Constants.ARMOR_TYPE[0], 5, 0);
        //choose randomly to drop weapon or armor
        int dropItemType = getRandomIntNumber(0, 2);
        if (dropItemType == 0) {
            //randomly select stats for drop armor
            int defPoints = getRandomIntNumber(1, 11);
            int dropArmorType = getRandomIntNumber(0, Constants.ARMOR_TYPE.length);
            switch (dropArmorType) {
                case 0:
                    int chosenHelmetIdx = getRandomIntNumber(0, Constants.BASIC_HELMETS.length);
                    droppedItem = new Armor(Constants.BASIC_HELMETS[chosenHelmetIdx],
                            Constants.ARMOR_TYPE[0], defPoints, 0);
                    break;
                case 1:
                    int chosenChestIdx = getRandomIntNumber(0, Constants.BASIC_CHESTS.length);
                    droppedItem = new Armor(Constants.BASIC_CHESTS[chosenChestIdx],
                            Constants.ARMOR_TYPE[1], defPoints, 0);
                    break;
                case 2:
                    int chosenBootsIdx = getRandomIntNumber(0, Constants.BASIC_BOOTS.length);
                    droppedItem = new Armor(Constants.BASIC_BOOTS[chosenBootsIdx],
                            Constants.ARMOR_TYPE[2], defPoints, 0);
                    break;
                default:
                    break;
            }
        } else {
            //randomly select stats for drop weapon
            int attackPoints = getRandomIntNumber(1, 11);
            int chosenWeaponIdx = getRandomIntNumber(0, Constants.BASIC_WEAPONS.length);
            int chosenWeaponType = getRandomIntNumber(0, Constants.WEAPON_TYPE.length);
            droppedItem = new Weapon(Constants.BASIC_WEAPONS[chosenWeaponIdx],
                    Constants.WEAPON_TYPE[chosenWeaponType], attackPoints, 0);
        }

        return droppedItem;
    }
}
