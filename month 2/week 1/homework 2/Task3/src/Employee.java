public class Employee {
    private String name;
    private Task currentTask;
    private double hoursLeft;

    Employee(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Invalid input data for name!");
        }
    }

    void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Invalid input data for name!");
        }
    }

    void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }

    void setHoursLeft(double hoursLeft) {
        this.hoursLeft = hoursLeft;
    }

    void work() {
        if (hoursLeft > 0 && currentTask != null) {
            if (hoursLeft < currentTask.getWorkingHours()) {
                currentTask.setWorkingHours(currentTask.getWorkingHours() - hoursLeft);
                hoursLeft = 0;
            } else {
                hoursLeft -= currentTask.getWorkingHours();
                currentTask.setWorkingHours(0);
            }
        }
    }

    void showReport() {
        System.out.println("Name: " + name);
        System.out.println("Task Name: " + currentTask.getName());
        System.out.println("Worker's working hours left: " + hoursLeft);
        System.out.println("Working hours left on this task: " + currentTask.getWorkingHours());
    }
}
