import java.util.NoSuchElementException;


public class DoublyLinkedList
{
    Node currentNode = null;
    int sizeCounter = 0;

    void add( WorkoutUnit newWorkoutUnit )
    {
        if( isEmpty() )
        {
            currentNode = new Node( newWorkoutUnit );
            currentNode.setPrev( currentNode );
            currentNode.setNext( currentNode );
            sizeCounter++;
            return;
        }

        Node newNode = new Node( newWorkoutUnit, currentNode, currentNode.getNext() );
        newNode.getPrev().setNext( newNode ); // = currentNode.setNext( newNode );
        newNode.getNext().setPrev( newNode );
        currentNode = newNode;
        sizeCounter++;
    }

    void remove( int offset )
    {
        if( isEmpty() ) throw new NoSuchElementException();
        if( getSize() == 1  )
        {
            currentNode = null;
            sizeCounter = 0;
            return;
        }

        Node toDelete = currentNode;
        for( int c = 0; c < offset; c++ )
        {
            toDelete = toDelete.getNext();
        }
        toDelete.next.prev = toDelete.prev;
        toDelete.prev = toDelete.next;
        sizeCounter--;
    }

    public WorkoutUnit getCurrent()
    {
        if( isEmpty() ) throw new NoSuchElementException();
        return  currentNode.getWorkoutUnit();
    }

    public WorkoutUnit next()
    {
        if( isEmpty() ) throw new NoSuchElementException();
        currentNode = currentNode.getNext();
        return currentNode.getWorkoutUnit();
    }

    public WorkoutUnit prev()
    {
        if( isEmpty() ) throw new NoSuchElementException();
        currentNode = currentNode.getPrev();
        return currentNode.getWorkoutUnit();
    }

    public WorkoutUnit get( int offset )
    {
        if( isEmpty() ) throw new NoSuchElementException();
        Node counterNode = currentNode;
        for( int c = 0; c < offset; c++ ) counterNode = counterNode.next;
        return counterNode.getWorkoutUnit();
    }

    public int getSizeByCounter()
    {
        return sizeCounter;
    }

    public int getSize()
    {
        if( isEmpty() ) return 0;
        int c = 0;
        Node start = currentNode;
        do
        {
            c++;
            this.next(); // Alternatively: currentNode = currentNode.getNext();
        } while( currentNode != start );
        currentNode = start;
        return c;
    }

    public boolean isEmpty()
    {
        return currentNode == null;
    }

    @Override
    public String toString()
    {
        if( isEmpty() ) return "EMPTY LIST";
        String string = "";
        Node start = currentNode;
        do
        {
            string += "<";
            string += currentNode;
            string += "> ";
            string += '\n';
            currentNode = currentNode.getNext();
        }while( currentNode != start );
        return string;
    }

    private class Node
    {
        WorkoutUnit workoutUnit;
        Node prev;
        Node next;


        public Node( WorkoutUnit workoutUnit )
        {
            this.workoutUnit = workoutUnit;
        }
        public Node( WorkoutUnit workoutUnit, Node prev, Node next )
        {
            this( workoutUnit );
            this.prev = prev;
            this.next = next;
        }

        public WorkoutUnit getWorkoutUnit()
        {
            return workoutUnit;
        }

        public void setWorkoutUnit( WorkoutUnit workoutUnit )
        {
            this.workoutUnit = workoutUnit;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev( Node prev )
        {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext( Node next )
        {
            this.next = next;
        }
    }
}
