public class Task1 {
    public static void main(String[] args) {
        Computer comp1 = new Computer();
        Computer comp2 = new Computer();

        comp1.year = 1924;
        comp1.price = 234.50;
        comp1.hardDiskMemory = 250;
        comp1.freeMemory = 75.64;
        comp1.isNotebook = true;
        comp1.operationSystem = "Windows Vista";

        comp2.year = 1954;
        comp2.price = 334.50;
        comp2.hardDiskMemory = 750;
        comp2.freeMemory = 345.64;
        comp2.isNotebook = false;
        comp2.operationSystem = "Windows XP";

        comp2.useMemory(100);
        comp1.changeOperationSystem("Windows 10");

        comp1.printPC();
        System.out.println();
        comp2.printPC();
    }
}
