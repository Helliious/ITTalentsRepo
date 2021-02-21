package main.vehicleParts;

public class Tire extends CarPart {
    public Tire() {
        super("Tire");
    }

    @Override
    public carPartKind getKind() {
        return carPartKind.TIRE;
    }

    @Override
    public int getAssembleTime() {
        return 2000;
    }
}
