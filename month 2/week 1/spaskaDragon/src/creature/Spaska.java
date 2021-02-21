package creature;

//THE BOSS SPASKA characteristics
public class Spaska extends Creature {
    public Spaska() {
        super("Creature.Creature.Spaska", 10000, 150, 1.5, 0.3);
    }

    @Override
    public void showStats() {
        showCreatureStats();
    }
}
