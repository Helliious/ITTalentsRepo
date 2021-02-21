public interface INotepad {
    void addTextOnPage(String text, int pageNumber);
    void replaceTextOnPage(String text, int pageNumber);
    void delTextOnPage(int pageNumber);
    boolean searchWord(String word);
    void printAllPagesWithDigits();
    void printPages();
}
