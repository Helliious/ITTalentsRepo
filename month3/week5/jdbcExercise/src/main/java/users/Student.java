package users;

import java.time.LocalDate;

public class Student {
    private int id;
    private final String first_name;
    private final  String last_name;
    private final  String city;
    private final  int age;
    private final  String gender;
    private final String pet_type;
    private LocalDate created_at;

    public Student(String first_name, String last_name, String city, int age, String gender, String pet_type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.pet_type = pet_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPet_type() {
        return pet_type;
    }
}
