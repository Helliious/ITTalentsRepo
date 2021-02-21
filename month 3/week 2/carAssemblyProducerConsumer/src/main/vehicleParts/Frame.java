package main.vehicleParts;

public class Frame extends CarPart {
    public Frame() {
        super("Frame");
    }

    @Override
    public carPartKind getKind() {
        return carPartKind.FRAME;
    }

    @Override
    public int getAssembleTime() {
        return 5000;
    }
}
