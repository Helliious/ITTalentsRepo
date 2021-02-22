public class Work {
    public static void main(String[] args) {
        Task firstTask = new Task("Task one", 45.5);
        Task secondTask = new Task("Task two", 5);
        Employee firstEmployee = new Employee("Peter");
        Employee secondEmployee = new Employee("Vlad");

        firstEmployee.setCurrentTask(firstTask);
        firstEmployee.setHoursLeft(8);
        secondEmployee.setCurrentTask(secondTask);
        secondEmployee.setHoursLeft(7);

        firstEmployee.work();
        secondEmployee.work();

        firstEmployee.showReport();
        System.out.println();
        secondEmployee.showReport();
    }
}
