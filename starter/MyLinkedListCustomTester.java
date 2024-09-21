import static org.junit.Assert.*;

import org.junit.*;

public class MyLinkedListCustomTester {

	// Optional: add test variables here

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		// Optional: add setup here
	}

	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() {
		// TODO: add your test here
		MyLinkedList<Integer> newArrayList;
		newArrayList = new MyLinkedList<>();
		assertEquals("Should return true because it's a boolean", 
		true, newArrayList.add(1));
		assertEquals("Size should now be 1", 
		1, newArrayList.size); 

	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		// TODO: add your test here
		MyLinkedList<Integer> firstArrayList;
		firstArrayList = new MyLinkedList<Integer>();
		firstArrayList.add(0, 1); 
		firstArrayList.add(1, 2); 
		firstArrayList.add(2, 3); 
		firstArrayList.add(0, 4); 
		assertEquals("Size should now be four", 
		4, firstArrayList.size); 
		assertEquals("index 0 should be 4",
		Integer.valueOf(4), firstArrayList.head.next.data
		);
		assertEquals("index 1 should be 1",
		Integer.valueOf(1), firstArrayList.head.next.next.data
		);
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		// TODO: add your test here
		MyLinkedList<Integer> firstArrayList;
		firstArrayList = new MyLinkedList<Integer>();
		firstArrayList.add(0, 1); 
		firstArrayList.add(1, 2); 
		firstArrayList.add(2, 3); 
		firstArrayList.add(3, 4); 
		firstArrayList.add(4, 5); 
		firstArrayList.add(2, 7); 
		assertEquals("index 2 should be 7",
		Integer.valueOf(7), firstArrayList.head.next.next.next.data
		);
		assertEquals("index 3 should be 3",
		Integer.valueOf(3), firstArrayList.head.next.next.next.next.data
		);
		assertEquals("index 1 should be 2",
		Integer.valueOf(2), firstArrayList.head.next.next.data
		);
	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() {
		// TODO: add your test here
		MyLinkedList<Integer> firstArrayList;
		firstArrayList = new MyLinkedList<Integer>();
		assertThrows(IndexOutOfBoundsException.class,
		() -> {
			firstArrayList.remove(5); 
		}); 
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		// TODO: add your test here
		MyLinkedList<Integer> firstArrayList;
		firstArrayList = new MyLinkedList<Integer>();
		firstArrayList.add(0, 1);
		firstArrayList.add(1, 2); 
		firstArrayList.add(2, 3); 
		assertEquals("Should return the old data that was removed", 
		Integer.valueOf(2), firstArrayList.remove(1)); 
		assertEquals("index 0 should now point to index 2", 
		Integer.valueOf(3), firstArrayList.head.next.next.data);
		assertEquals("index 2 should be pointing at index 0", 
		Integer.valueOf(1), firstArrayList.head.next.next.prev.data);
		assertEquals("index head should be pointing at index 0", 
		Integer.valueOf(1), firstArrayList.head.next.data);
		assertEquals("size should now be 2",
		2, firstArrayList.size);
		assertThrows(IndexOutOfBoundsException.class,
		() -> {
			firstArrayList.remove(5); 
		}); 
	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		// TODO: add your test here
		MyLinkedList<Integer> firstArrayList;
		firstArrayList = new MyLinkedList<Integer>();
		firstArrayList.size = 3;
		assertThrows(IndexOutOfBoundsException.class,
		() -> {
			firstArrayList.set(-1, 2); 
		}); 
		assertThrows(IndexOutOfBoundsException.class,
		() -> {
			firstArrayList.set(10, 2); 
		}); 
	}

	/**
	 * Aims to test the contains(E data, int start, int end) method.
	 * Data argument exists in the list but outside the given range. 
	 */
	@Test
	public void testCustomContainsExistsOutOfRange() {
		// TODO: add your test here
		MyLinkedList<Integer> firstArrayList;
		firstArrayList = new MyLinkedList<Integer>();
		firstArrayList.add(0, 1); 
		firstArrayList.add(1, 2); 
		firstArrayList.add(2, 3); 
		firstArrayList.add(3, 4); 
		firstArrayList.add(4, 5);
		assertEquals("Data exists but outside of range, should be false", 
		false, firstArrayList.contains(1, 2, 4)); 
	}
}
