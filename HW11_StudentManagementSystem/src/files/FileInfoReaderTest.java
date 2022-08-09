package files;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test methods for FileInfoReader
 * @author Renyu Liu
 *
 */
class FileInfoReaderTest {
	FileInfoReader FileInfoReader=new FileInfoReader();


	/**
	 * Set up for the method 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for load()
	 */
	@Test
	void testLoad() {
		assertEquals(true, FileInfoReader.load());
	}

	

}
