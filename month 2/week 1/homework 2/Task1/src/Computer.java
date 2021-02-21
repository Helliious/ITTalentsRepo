public class Computer {
    int year;
    double price;
    boolean isNotebook;
    double hardDiskMemory;
    double freeMemory;
    String operationSystem;

    Computer() {
        isNotebook = false;
        operationSystem = "Win XP";
    }

    Computer(int year, double price, double hardDiskMemory, double freeMemory) {
        this();
        this.year = year;
        this.price = price;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
    }

    Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory, String operationSystem) {
        this.year = year;
        this.price = price;
        this.isNotebook = isNotebook;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
        this.operationSystem = operationSystem;
    }

    int comparePrice(Computer c) {
        if (this.price > c.price) {
            return -1;
        } else if (this.price < c.price) {
            return 1;
        } else {
            return 0;
        }
    }

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

