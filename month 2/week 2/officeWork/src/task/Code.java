package task;

public class Code implements Task {
    private final String  name;
    private int workingHours;

    public Code(String name, int workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }

    @Override
    public void reduceWorkingHours(double workingHours) {
        if (workingHours > 0 && this.workingHours >= workingHours) {
            this.workingHours -= workingHours;
        } else {
            System.out.println("Invalid input data!");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWorkingHours() {
        return workingHours;
    }
}
