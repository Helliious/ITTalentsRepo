import task.Task;

public class Employee {
    private String name;
    private static final int MAX_WORK_HOURS = 8;
    private Task currentTask;
    private int hoursLeft;
    private static AllWork allWork;

    Employee(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Invalid input data for name!");
        }
        this.hoursLeft = MAX_WORK_HOURS;
        allWork = new AllWork();
    }

    public String getName() {
        return name;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    void nextTask() {
        this.currentTask = allWork.getNextTask();
    }

    void setHoursLeft(int hoursLeft) {
        this.hoursLeft = hoursLeft;
    }

    public int getHoursLeft() {
        return hoursLeft;
    }

    void work() {
        if (hoursLeft > 0 && currentTask != null) {
            if (hoursLeft < currentTask.getWorkingHours()) {
                currentTask.reduceWorkingHours(hoursLeft);
                hoursLeft = 0;
                System.out.println("Worker " + name + " finished his hours for today!");
                System.out.println("Hours left to finish task " + currentTask.getName() + ": " + currentTask.getWorkingHours());
            } else {
                hoursLeft -= currentTask.getWorkingHours();
                currentTask.reduceWorkingHours(currentTask.getWorkingHours());
                System.out.println("Worker " + name + " finished task " + currentTask.getName() + ".");
                if (allWork.hasNextTask()) {
                    currentTask = allWork.getNextTask();
                    if (currentTask != null) {
                        System.out.println("Worker " + name + " begins work on task " + currentTask.getName() + ".");
                        work();
                    }
                }
            }
        }
    }

    void startWorkingDay() {
        this.hoursLeft = MAX_WORK_HOURS;
    }

    public AllWork getAllWork() {
        return allWork;
    }

    public void setAllWork(AllWork allWork) {
        this.allWork = allWork;
    }

    void showReport() {
        System.out.println("Name: " + name);
        System.out.println("task.Task Name: " + currentTask.getName());
        System.out.println("Worker's working hours left: " + hoursLeft);
        System.out.println("Working hours left on this task: " + currentTask.getWorkingHours());
    }
}
