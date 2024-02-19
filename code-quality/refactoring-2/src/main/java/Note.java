public class Note {

    // dependency
    private final TextFile textFile;
    private final BirthDayChecker birthDayChecker;

    // dependency injection
    public Note(TextFile textFile, BirthDayChecker birthDayChecker) {
        // this.textFile = new TextFile();
        this.textFile = textFile;
        this.birthDayChecker = birthDayChecker;
    }

    private void create() {
        textFile.create("note.txt");
    }

    public void write(String content) {
        // LocalDateTime today = LocalDateTime.now();
        // boolean isBirthDay = today.getDayOfMonth() == 1 && today.getMonthValue() == 1;
        if (birthDayChecker.isBirthDay()) {
            content += " 🎂";
        }
        textFile.write("note.txt", content);
    }

    public String read() {
        return textFile.read("note.txt");
    }
}

