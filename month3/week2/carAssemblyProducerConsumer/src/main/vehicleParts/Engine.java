package main.vehicleParts;

public class Engine extends CarPart {
    public Engine() {
        super("Engine");
    }

    @Override
    public carPartKind getKind() {
        return carPartKind.ENGINE;
    }

    @Override
    public int getAssembleTime() {
        return 7000;
    }
}
