package christinaChen10;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PigLatinTest {

	String s;
	String s2;
	String s3;
	
	@Before
	public void setUp() throws Exception {
		s = "potayto";
		s2 = "yeet";
		s3 = "wee.";
	}

	@After
	public void tearDown() throws Exception {
		s = null;
		s2 = null;
		s3 = null;
	}

	@Test
	public void testVowel() {
		assertEquals(PigLatin.isVowel(s, 1), true);
		assertEquals(PigLatin.isVowel(s, 0), false);
	}
	
	@Test
	public void testStartOfCluster() {
		assertEquals(PigLatin.startOfFirstConsonantCluster(s), 0);
		assertEquals(PigLatin.startOfFirstConsonantCluster(s2), 0);
	}
	
	@Test
	public void testEndOfCluster() {
		assertEquals(PigLatin.endOfFirstConsonantCluster(s), 0);
		assertEquals(PigLatin.endOfFirstConsonantCluster(s2), 0);
	}

	@Test
	public void testWordToPL() {
		assertEquals(PigLatin.wordToPigLatin(s), "otaytopay");
		assertEquals(PigLatin.wordToPigLatin(s2), "eetyay");
	}
	
	@Test
	public void testFindStartOfEndingPuncSeq() {
		assertEquals(PigLatin.findStartOfEndingPuncSeq(s), -1);
		assertEquals(PigLatin.findStartOfEndingPuncSeq(s3), 3);
	}
}
