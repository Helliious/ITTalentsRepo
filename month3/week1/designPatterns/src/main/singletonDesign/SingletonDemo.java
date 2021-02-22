package main.singletonDesign;


public class SingletonDemo {
    public static void main(String[] args) {
        SingletonDesign instance = SingletonDesign.getInstance();
        SingletonDesign instance1 = SingletonDesign.getInstance();
        System.out.println(instance);
        System.out.println(instance1);

    }
}
