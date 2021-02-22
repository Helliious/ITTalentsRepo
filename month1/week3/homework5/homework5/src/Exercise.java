public class Exercise {
    public static void main(String[] args) {
        StringBuilder oldString = new StringBuilder("alabala");

        changeString(oldString);

        System.out.println(oldString);
    }

    static void changeString(StringBuilder resultString) {
        resultString.replace(0, resultString.length(), "kakamara");
    }
}
