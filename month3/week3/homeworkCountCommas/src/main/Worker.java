package main;

public class Worker extends Thread {
    private int commasCount;
    private final String text;

    Worker(String text) {
        this.text = text;
        this.commasCount = 0;
    }

    public int getCommasCount() {
        return commasCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ',') {
                commasCount++;
            }
        }
    }
}
