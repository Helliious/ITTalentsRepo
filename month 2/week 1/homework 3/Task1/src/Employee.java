public class Employee extends Person {
    private double daySalary;

    Employee(String name, int age, boolean isMale, double daySalary) {
        super(name, age, isMale);
        if (daySalary > 0) {
            this.daySalary = daySalary;
        }
    }

    double calculateOvertime(double hours) {
        double moneyPerHour = daySalary / 8;
        if (getAge() < 18) {
            return 0;
        } else {
            return Math.round(hours * (1.5 * moneyPerHour));
        }
    }

    @Override
    void showPersonInfo() {
        super.showPersonInfo();
        System.out.println("Day salary: " + daySalary);
    }
}
