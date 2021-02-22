package main.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        BuilderDesign builder = new BuilderDesign().isMale(false).withAddress("Durvenica").withName("Petya");
        builder.showBuilder();
    }
}
