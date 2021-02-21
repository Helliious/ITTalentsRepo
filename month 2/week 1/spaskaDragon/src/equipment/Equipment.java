package equipment;

//abstract class for an item of type Equipment
public abstract class Equipment {
    private String name;
    private String type;

    Equipment(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public abstract void showEquipmentStats();

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
