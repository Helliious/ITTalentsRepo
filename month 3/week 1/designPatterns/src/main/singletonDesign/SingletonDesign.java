package main.singletonDesign;

public class SingletonDesign {
    private static SingletonDesign instance;

    public static SingletonDesign getInstance() {
        if (instance == null) {
            instance = new SingletonDesign();
        }
        return instance;
    }

    private SingletonDesign() {

    }
}
