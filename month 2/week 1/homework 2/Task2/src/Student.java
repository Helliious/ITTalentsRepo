public class Student {
    private String name;
    private String subject;
    private double grade;
    private int yearInCollege;
    private int age;
    private boolean isDegree;
    private double money;

    Student() {
        grade = 4.0;
        yearInCollege = 1;
        isDegree = false;
        money = 0;
    }

    Student(String name, String subject, int age) {
        this();
        this.name = name;
        this.subject = subject;
        this.age = age;
    }

    public void upYear() {
        if (!isDegree) {
            yearInCollege++;
        }

        if (yearInCollege == 4) {
            isDegree = true;
        }
    }

    public double receiveScholarship(double min, double amount) {
        if (grade >= min && age < 30) {
            money += amount;
        }

        return money;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public void setGrade(double grade) {
        if (grade >= 2 && grade <= 6) {
            this.grade = grade;
        }
    }

    public void printStudent() {
        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
        System.out.println("Grade: " + grade);
        System.out.println("Year in College: " + yearInCollege);
        System.out.println("Age: " + age);
        if (isDegree) {
            System.out.println("Degree: Finished");
        } else {
            System.out.println("Degree: In Progress");
        }
        System.out.println("Money: " + money);
    }
}
