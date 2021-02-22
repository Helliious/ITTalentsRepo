public class College {
    public static void main(String[] args) {
        Student pesho = new Student("Pesho", "Communism", 19);
        Student vanko = new Student("Vanko", "Communism", 23);
        Student mariika = new Student("Mariika", "Art", 21);

        vanko.upYear();
        vanko.upYear();
        vanko.upYear();

        mariika.upYear();
        mariika.upYear();

        pesho.receiveScholarship(3.5, 650);
        vanko.receiveScholarship(3.5, 1200.50);
        pesho.setGrade(4.5);

        StudentGroup philosophy = new StudentGroup("Communism");
        StudentGroup art = new StudentGroup("Art");

        philosophy.addStudent(vanko);
        philosophy.addStudent(pesho);

        art.addStudent(mariika);

        philosophy.printStudentsInGroup();
        System.out.println("Best student in philosophy: " + philosophy.theBestStudent());
        System.out.println();

        art.printStudentsInGroup();
    }
}
