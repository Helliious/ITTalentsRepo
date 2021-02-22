package main.builder;

public class BuilderDesign {
    private String name;
    private String address;
    private int age;
    private int exp;
    private boolean isMale;

    BuilderDesign() {
        this.name = "Pesho";
        this.address = "Gorni Bogorov";
        this.age = 23;
        this.exp = 2;
        this.isMale = true;
    }

    public BuilderDesign withName(String name) {
        this.name = name;
        return this;
    }

    public BuilderDesign withAge(int age) {
        this.age = age;
        return this;
    }

    public BuilderDesign withAddress(String address) {
        this.address = address;
        return this;
    }

    public BuilderDesign withExp(int exp) {
        this.exp = exp;
        return this;
    }

    public BuilderDesign isMale(boolean isMale) {
        this.isMale = isMale;
        return this;
    }

    public void showBuilder() {
        System.out.println(name);
        System.out.println(address);
        System.out.println(age);
        System.out.println(exp);
        System.out.println(isMale);
    }
}
