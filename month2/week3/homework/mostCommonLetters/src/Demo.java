import java.util.*;

public class Demo {
    static final int MAX = 20;
    public static void main(String[] args) {
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        text = sc.nextLine();
        Map<Character, Integer> formatText = formatInput(text);

        ArrayList<Map.Entry<Character, Integer>> result = new ArrayList<>(formatText.entrySet());
        result.sort((e1, e2) -> e2.getValue() - e1.getValue());
        createStatistics(result);
    }

    static Map<Character, Integer> formatInput(String text) {
        String lowerCaseText = text.toLowerCase();
        Map<Character, Integer> formatResult = new HashMap<>();

        for (int i = 0; i < lowerCaseText.length(); i++) {
            if (lowerCaseText.charAt(i) >= 'a' && lowerCaseText.charAt(i) <= 'z') {
                if (formatResult.containsKey(lowerCaseText.charAt(i))) {
                    formatResult.put(lowerCaseText.charAt(i),
                            formatResult.get(lowerCaseText.charAt(i)) + 1);
                } else {
                    formatResult.put(lowerCaseText.charAt(i), 1);
                }
            }
        }
        return formatResult;
    }

    static void createStatistics(ArrayList<Map.Entry<Character, Integer>> results) {
        int countTimes = results.get(0).getValue();
        int min = MAX / countTimes;
        if (min == 0 && MAX % countTimes != 0) {
            min = 2;
        } else if (min == 1) {
            min = 2;
        }

        for (Map.Entry<Character, Integer> e : results) {
            countTimes = e.getValue();
            if (countTimes > 10) {
                countTimes = 10;
            }
            System.out.printf("%S: %2d ",  e.getKey(), e.getValue());
            for (int i = 0; i < min * countTimes; i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
