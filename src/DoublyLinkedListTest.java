import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    private static FitnessDevice f1 = new FitnessDevice();
    private static FitnessDevice f2 = new FitnessDevice();
    private static FitnessDevice f3 = new FitnessDevice();
    private static FitnessDevice f4 = new FitnessDevice();
    private static WorkoutUnit wu1  = new WorkoutUnit( f1 );
    private static WorkoutUnit wu2  = new WorkoutUnit( f2 );
    private static WorkoutUnit wu3  = new WorkoutUnit( f3 );
    private static WorkoutUnit wu4  = new WorkoutUnit( f4 );

    @Test
    void add()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add( wu1 );
        assertEquals( wu1, list.getCurrent() );
        assertEquals( 1, list.getSize() );
        list.add( wu2 );
        assertEquals( wu2, list.getCurrent() );
        assertEquals( 2, list.getSize() );
        list.add( wu3 );
        assertEquals( wu3, list.getCurrent() );
        assertEquals( 3, list.getSize() );
    }

    @org.junit.jupiter.api.Test
    void removeCurrentNode()
    {
    }

    @org.junit.jupiter.api.Test
    void remove()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows( NoSuchElementException.class, () -> list.remove(0) );
        list.add( wu1 );
        assertEquals( wu1, list.getCurrent() );
        list.remove(0);
        assertTrue( list.isEmpty() );
        list.add( wu2 );
        assertFalse( list.isEmpty() );
    }

    @org.junit.jupiter.api.Test
    void getCurrent()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows( NoSuchElementException.class, () -> list.getCurrent() );
        list.add( wu1 );
        assertEquals( wu1, list.getCurrent() );
        list.add( wu2 );
        assertEquals( wu2, list.getCurrent() );
    }

    @org.junit.jupiter.api.Test
    void next()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows( NoSuchElementException.class, list::next );
        list.add( wu1 );
        list.add( wu2 );
        list.add( wu3 );
        assertEquals( wu1, list.next() );
        assertEquals( wu2, list.next() );
        assertEquals( wu3, list.next() );
    }

    @org.junit.jupiter.api.Test
    void prev()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows( NoSuchElementException.class, list::prev );
        list.add( wu1 );
        list.add( wu2 );
        list.add( wu3 );
        assertEquals( wu2, list.prev() );
        assertEquals( wu1, list.prev() );
    }

    @org.junit.jupiter.api.Test
    void get()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows( NoSuchElementException.class, () -> list.get(0) );
        list.add( wu1 );
        list.add( wu2 );
        list.add( wu3 );
        assertEquals( wu3, list.get(0) );
        assertEquals( wu1, list.get(1) );
        assertEquals( wu2, list.get(2) );
    }

    @org.junit.jupiter.api.Test
    void getSizeByCounter()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals( 0, list.getSizeByCounter() );
        list.add( wu1 );
        assertEquals( 1, list.getSizeByCounter() );
        list.add( wu2 );
        assertEquals( 2, list.getSizeByCounter() );
    }

    @org.junit.jupiter.api.Test
    void getSize()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals( 0, list.getSize() );
        list.add( wu1 );
        assertEquals( 1, list.getSize() );
        list.add( wu2 );
        assertEquals( 2, list.getSize() );
    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        DoublyLinkedList list = new DoublyLinkedList();
        assertTrue( list.isEmpty() );
        list.add( wu1 );
        assertFalse( list.isEmpty() );
    }
}