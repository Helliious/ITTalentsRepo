public class Task1 {
    public static void main(String[] args) {
        Computer firstComp = new Computer(1992, 123.45,
                                    320, 125.35);
        Computer secondComp = new Computer();
        Computer thirdComp = new Computer(2012, 350,
                                        true, 500,
                                        345.50, "Ubuntu");

        if (firstComp.comparePrice(thirdComp) == -1) {
            System.out.println("The computer manufactured in " + firstComp.year +
                                " is more expensive than the computer manufactured in " + thirdComp.year);
        } else if (firstComp.comparePrice(thirdComp) == 1) {
            System.out.println("The computer manufactured in " + thirdComp.year +
                    " is more expensive than the computer manufactured in " + firstComp.year);
        } else {
            System.out.println("Both computers have the same price!");
        }

        System.out.println();
        secondComp.printPC();
    }
}
