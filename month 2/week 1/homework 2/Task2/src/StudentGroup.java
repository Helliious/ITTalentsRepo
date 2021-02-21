public class StudentGroup {
    private String groupSubject;
    private Student[] students;
    private int freePlaces;

    StudentGroup() {
        students = new Student[5];
        freePlaces = 5;
    }

    StudentGroup(String groupSubject) {
        this();
        this.groupSubject = groupSubject;
    }

    public void addStudent(Student s) {
        if (s.getSubject().equals(groupSubject) && freePlaces > 0) {
            for (int i = 0; i < freePlaces; i++) {
                if (students[i] == null) {
                    students[i] = s;
                    freePlaces--;
                    break;
                }
            }
        }
    }

    public void emptyGroup() {
        students = null;
        freePlaces = 5;
    }

    public String theBestStudent() {
        double maxGrade = students[0].getGrade();
        int idx = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getGrade() > maxGrade) {
                    maxGrade = students[i].getGrade();
                    idx = i;
                }
            } else {
                break;
            }
        }

        if (students[idx] != null) {
            return students[idx].getName();
        } else {
            return null;
        }
    }

    public void printStudentsInGroup() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                students[i].printStudent();
                System.out.println();
            } else {
                break;
            }
        }
    }
}
