public class Student extends Person {
    private double score;

    Student(String name, int age, boolean isMale, double score) {
        super(name, age, isMale);
        if (score >= 2 && score <= 6) {
            this.score = score;
        }
    }

    @Override
    void showPersonInfo() {
        super.showPersonInfo();
        System.out.println("Score: " + score);
    }
}
