import task.*;

public class Work {
    public static void main(String[] args) {
        int dayIdx = 1;
        Task firstTask = new Code("task.Task one", 4);
        Task secondTask = new Test("task.Task two", 5);
        Task thirdTask = new Code("task.Task three", 10);
        Task forthTask = new Test("task.Task four", 12);
        Task fifthTask = new Test("task.Task five", 1);
        Task sixthTask = new Test("task.Task six", 9);
        Task seventhTask = new Test("task.Task seven", 32);
        Task eighthTask = new Test("task.Task eight", 14);
        Task ninthTask = new Test("task.Task nine", 7);
        Task tenthTask = new Test("task.Task ten", 56);
        Task eleventhTask = new Test("task.Task eleven", 99);
        AllWork allWork = new AllWork();
        allWork.addTask(firstTask);
        allWork.addTask(secondTask);
        allWork.addTask(thirdTask);
        allWork.addTask(forthTask);
        allWork.addTask(fifthTask);
        allWork.addTask(sixthTask);
        allWork.addTask(seventhTask);
        allWork.addTask(eighthTask);
        allWork.addTask(ninthTask);
        allWork.addTask(tenthTask);
        allWork.addTask(eleventhTask);
        Employee firstEmployee = new Employee("Peter");
        Employee secondEmployee = new Employee("Vlad");
        Employee thirdEmployee = new Employee("Balkan");
        firstEmployee.setAllWork(allWork);
        firstEmployee.nextTask();
        secondEmployee.nextTask();
        thirdEmployee.nextTask();

        while (!firstEmployee.getAllWork().isAllWorkDone()) {
            System.out.println("DAY: " + dayIdx++);
            firstEmployee.work();
            secondEmployee.work();
            thirdEmployee.work();
            firstEmployee.startWorkingDay();
            secondEmployee.startWorkingDay();
            thirdEmployee.startWorkingDay();
        }
    }
}
