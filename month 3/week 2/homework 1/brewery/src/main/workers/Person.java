package main.workers;

public abstract class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract FruitType getType();
    public abstract int getJobTime();
}
