public class Task {
    private String name;
    private double workingHours;

    Task(String name, double workingHours) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Invalid input data for name!");
        }
        if (workingHours > 0) {
            this.workingHours = workingHours;
        } else {
            System.out.println("Invalid input data for working hours!");
        }
    }

    void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Invalid input data for name!");
        }
    }

    void setWorkingHours(double workingHours) {
        if (workingHours >= 0) {
            this.workingHours = workingHours;
        } else {
            System.out.println("Invalid input data for working hours!");
        }
    }

    String getName() {
        return name;
    }

    double getWorkingHours() {
        return workingHours;
    }
}
