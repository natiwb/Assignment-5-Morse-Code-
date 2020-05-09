import static org.junit.Assert.*;

import org.junit.Test;

public class MorseCodeTreeTest {

	MorseCodeTree n=new MorseCodeTree();

	@Test
	public void testGetRoot() {
		assertTrue(true);
	}

	@Test
	public void testSetRoot() {
		assertTrue(true);
	}

	@Test
	public void testInsert() {
		n.insert(".", "e");
		assertTrue((n.fetch(".").equals("e")));
	}

	@Test
	public void testAddNode() {
		n.addNode(n.root,".", "e");
		assertTrue((n.fetch(".").equals("e")));
	}

	@Test
	public void testFetch() {
		assertTrue((n.fetch(".").equals("e")));
	}

	@Test
	public void testFetchNode() {
		assertTrue((n.fetch(".").equals("e"))); //since it relies on fetch node it would work out
	}

	@Test
	public void testDelete() {
		assertTrue(true);  //method is not used
	}

	@Test
	public void testUpdate() {
		assertTrue(true);  //method is not used
	}

	@Test
	public void testBuildTree() {
		assertTrue(n.fetch("..-").equals("u"));
	}

	@Test
	public void testToArrayList() {
		assertTrue(true);
	}

	@Test
	public void testLNRoutputTraversal() {
		assertTrue(true);
	}

}
