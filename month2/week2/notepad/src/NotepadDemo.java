public class NotepadDemo {
    public static void main(String[] args) {
        ElectronicSecuredNotepad notepad = new ElectronicSecuredNotepad("aA123", 5);
        notepad.start();
        notepad.addTextOnPage("Bla blabdsad", 0);
        notepad.addTextOnPage("Kak akakak", 1);
        notepad.addTextOnPage("Hah ahahaha", 2);
        notepad.addTextOnPage("Sas sasaasa", 3);
        notepad.addTextOnPage("Krq krqkrqkqr", 4);

        notepad.addTextOnPage("Mamama", 0);
        notepad.replaceTextOnPage("HUHAHUA", 1);
        notepad.delTextOnPage(2);

        notepad.printPages();
        notepad.stop();
    }
}
