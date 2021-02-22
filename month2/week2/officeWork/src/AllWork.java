import task.Task;

public class AllWork {
    private final Task[] tasks;
    private static final int MAX_TASKS = 13;
    private int freePlacesForTasks;
    private int currentUnassignedTask;

    AllWork() {
        tasks = new Task[MAX_TASKS];
        freePlacesForTasks = MAX_TASKS;
        currentUnassignedTask = 0;
    }

    void addTask(Task newTask) {
        if (freePlacesForTasks > 0) {
            tasks[MAX_TASKS - freePlacesForTasks] = newTask;
            freePlacesForTasks--;
        } else {
            System.out.println("No more space for new tasks!");
        }
    }

    boolean hasNextTask() {
        return currentUnassignedTask < MAX_TASKS;
    }

    Task getNextTask() {
        return tasks[currentUnassignedTask++];
    }

    boolean isAllWorkDone() {
        boolean workDone = true;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].getWorkingHours() > 0) {
                workDone = false;
                break;
            }
        }

        return workDone;
    }
}
