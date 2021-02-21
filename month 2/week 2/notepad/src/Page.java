public class Page {
    private static final int CHUNK_SIZE = 50;
    private final String title;
    private String text;

    Page(String title) {
        this.title = title;
    }

    void addText(String newText) {
        if (text == null) {
            text = formatText(newText);
        } else {
            text = text + " " + newText;
            text = formatText(text);
        }
    }

    String formatText(String text) {
        boolean endReached = false;
        StringBuilder resultText = new StringBuilder();
        int chunkStart = 0;
        int chunkEnd = CHUNK_SIZE;
        while (!endReached) {
            if (chunkEnd >= text.length()) {
                chunkEnd = text.length();
                endReached = true;
            }
            resultText.append(text, chunkStart, chunkEnd);
            if (chunkEnd != text.length()) {
                resultText.append("\n");
            }
            chunkStart += CHUNK_SIZE;
            chunkEnd += CHUNK_SIZE;
        }

        if (text.length() < CHUNK_SIZE) {
            return text;
        } else {
            return resultText.toString();
        }
    }

    void delText() {
        if (text != null) {
            text = null;
        }
    }

    String viewPage() {
        return text != null ? title + "\n" + text : title;
    }

    boolean searchWord(String word) {
        boolean hasWord = false;
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                hasWord = true;
                break;
            }
        }
        return hasWord;
    }

    boolean containsDigits() {
        boolean hasDigit = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= '0' && text.charAt(i) <= '9') {
                hasDigit = true;
            }
        }
        return hasDigit;
    }
}
