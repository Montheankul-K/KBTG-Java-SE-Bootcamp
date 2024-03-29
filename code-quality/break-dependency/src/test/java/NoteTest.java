import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NoteTest {

	@Test
	@DisplayName("given initial note my, note should be empty")
	void initialNoteShouldBeEmpty() {
		TextFile textFile = new MockWriteTextFile();
		Note note = new Note(textFile);

		String expected = "";
		String actual = note.read();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("create reading book note, my note should return reading book")
	void createReadingNote() {
		TextFile textFile = new StubReadingNote();
		Note note = new Note(textFile);

		note.write("Reading book");

		String expected = "Reading book";
		assertEquals(expected, note.read());
	}

	@Test
	@DisplayName("my default note file should be note.txt")
	void defaultNoteFile() {
		SpyNoteFileName textFile = new SpyNoteFileName();
		Note note = new Note(textFile);

		String expected = "note.txt";
		assertEquals(expected, textFile.getSpyFileName());
	}

	@Test
	@DisplayName("initial note should create note.txt only one file")
	void createNoteFileOnlyOneTime() {
		SpyNoteFileName textFile = new SpyNoteFileName();
		Note note = new Note(textFile);

		int expected = 1;
		assertEquals(expected, textFile.getSpyCreateCount());
	}

	@Test
	@DisplayName("write reading note should call write method")
	void writeNote() {
		MockWriteTextFile textFile = new MockWriteTextFile();
		Note note = new Note(textFile);

		note.write("Reading book");

		// pass if textFile.isWriteCalled() return true
		assertTrue(textFile.isWriteCalled());
	}

	@Test
	@DisplayName("given today is my birthday write reading note and my note should contain 🎂")
	void writeNoteOnMyBirthday() {
		MockWriteTextFile textFile = new MockWriteTextFile();
		BirthdayChecker birthdayChecker = new StubBirthdayChecker();
		Note note = new Note(textFile, birthdayChecker);

		note.write("Happy Birthday");

		String expected = "Happy Birthday 🎂";
		assertEquals(expected, textFile.getContentWasWritten());
	}


	@Test
	@DisplayName("given write reading note async should success")
	void writeAsyncNoteShouldSuccess() {
		TextFile textFile = new MockWriteTextFile();
		BirthdayChecker birthdayChecker = new StubBirthdayChecker();
		Note note = new Note(textFile, birthdayChecker);

		// reactive programming should need to subscribe to get result
		// can use .test() to get result
		note.writeAsync("Reading book", Schedulers.trampoline())
				// Schedulers.trampoline() use current scheduler (current thread in unit test)
			.test()
			.assertComplete();
	}

	@Test
	@DisplayName("mockito: create reading book note should return reading book")
	void createReadingNoteWithMockito() {
		TextFile textFile = mock(TextFile.class);
		when(textFile.read("note.txt")).thenReturn("Reading book");

		Note note = new Note(textFile);

		note.write("Reading book");

		String expected = "Reading book";
		assertEquals(expected, note.read());
	}

	@Test
	@DisplayName("mockito: given today is my birthday write reading note and my note should contain 🎂")
	void mockitoWriteNoteOnMyBirthday() {
		MockWriteTextFile textFile = new MockWriteTextFile();
		BirthdayChecker birthdayChecker = mock(BirthdayChecker.class); // mock BirthdayChecker class
		// if call birthdayChecker.isBirthday() then return true
		when(birthdayChecker.isBirthday()).thenReturn(true);

		Note note = new Note(textFile, birthdayChecker);

		note.write("Happy Birthday");

		String expected = "Happy Birthday 🎂";
		assertEquals(expected, textFile.getContentWasWritten());
	}
}

class StubReadingNote extends TextFile {
	@Override
	public String read(String fileName) {
		return "Reading book";
	}

	@Override
	public void create(String fileName) {

	}

	@Override
	public void write(String fileName, String content) {

	}
}

class  SpyNoteFileName extends TextFile {
	private String spyFileName;
	private int spyCreateCount = 0;

	@Override
	public void create(String fileName) {
		this.spyFileName = fileName;
		spyCreateCount++;
	}

	public String getSpyFileName() {
		return spyFileName;
	}

	public int getSpyCreateCount() {
		return spyCreateCount;
	}
}

class MockWriteTextFile extends TextFile {

	private boolean writeWasCalled;
	private String contentWasWritten;

	@Override
	public void write(String fileName, String content) {
		writeWasCalled = true;
		contentWasWritten = content;
	}

	@Override
	public void create(String fileName) {

	}

	public boolean isWriteCalled() {
		return writeWasCalled;
	}

	public String getContentWasWritten() {
		return contentWasWritten;
	}
}

class StubBirthdayChecker extends BirthdayChecker {
	@Override
	boolean isBirthday() {
		return true;
	}
}
