package main.vehicleParts;

public class Seat extends CarPart {
    public Seat() {
        super("Seat");
    }

    @Override
    public carPartKind getKind() {
        return carPartKind.SEAT;
    }

    @Override
    public int getAssembleTime() {
        return 3000;
    }
}
