public class Person {
    private String name;
    private int age;
    private final boolean isMale;

    Person(String name, int age, boolean isMale) {
        if (name != null) {
            this.name = name;
        }
        if (age > 0 && age < 120) {
            this.age = age;
        }
        this.isMale = isMale;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    void showPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.print("Gender: ");
        if (isMale) {
            System.out.println("Male");
        } else {
            System.out.println("Female");
        }
    }
}
