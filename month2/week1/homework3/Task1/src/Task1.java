public class Task1 {
    public static void main(String[] args) {
        Person[] persons = new Person[10];
        Person firstPerson = new Person("Pesho", 23, true);
        Person secondPerson = new Person("Mariika", 13, false);
        Student firstStudent = new Student("Gabi", 21, false, 5.60);
        Student secondStudent = new Student("Miro", 20, true, 3.60);
        Employee firstEmployee = new Employee("Stamat", 38, true, 75.50);
        Employee secondEmployee = new Employee("Vihur", 58, true, 105.50);

        persons[0] = firstPerson;
        persons[1] = secondPerson;
        persons[2] = firstStudent;
        persons[3] = secondStudent;
        persons[4] = firstEmployee;
        persons[5] = secondEmployee;

        int idx = 0;
        while (persons[idx] != null) {
            persons[idx].showPersonInfo();
            System.out.println();
            idx++;
        }

        idx = 0;
        while (persons[idx] != null) {
            if (persons[idx] instanceof Employee) {
                System.out.println(persons[idx].getName() + " overtime is: " +
                                    ((Employee)persons[idx]).calculateOvertime(2));
            }
            idx++;
        }
    }
}
