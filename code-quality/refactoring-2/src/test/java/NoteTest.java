import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NoteTest {
    @Test
    @DisplayName("given today is my birthday write reading note and my note should contain 🎂")
    void writeNoteOnMyBirthday() {
        TextFile textFile = mock(TextFile.class);
        BirthDayChecker birthDayChecker = mock(BirthDayChecker.class);
        when(birthDayChecker.isBirthDay()).thenReturn(true);
        when(textFile.read("note.txt")).thenReturn("Today is my birthday 🎂");

        Note note = new Note(textFile, birthDayChecker);

        note.write("Today is my birthday");

        // this two parameters was passed into method write in TextFile or not?
        verify(textFile, times(1)).write("note.txt", "Today is my birthday 🎂");
        // times() function call times that expect
        assertEquals("Today is my birthday 🎂", note.read());
    }
}
