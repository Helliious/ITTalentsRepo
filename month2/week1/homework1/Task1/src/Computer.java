public class Computer {
    int year;
    double price;
    boolean isNotebook;
    int hardDiskMemory;
    double freeMemory;
    String operationSystem;

    void changeOperationSystem(String operSys) {
        operationSystem = operSys;
    }

    void useMemory(double memory) {
        if (memory > freeMemory) {
            System.out.println("Not enough memory!");
        } else {
            freeMemory -= memory;
        }
    }

    void printPC() {
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("Laptop: " + isNotebook);
        System.out.println("HDD: " + hardDiskMemory);
        System.out.println("Free Memory: " + freeMemory);
        System.out.println("Operation System: " + operationSystem);
    }
}
