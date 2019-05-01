package eg.edu.alexu.csd.datastructure.queue.cs69_cs12_cs21;


public class LinkedList {
    private node head = null;
    private node tail = null;
    private int length = 0;
    // private node node;

    /**
     * Add Element At Last Of List
     *
     * @param c
     */
    public void add(Object c) {
        node i = head;
        node c2 = new node();
        c2.value = c;
        length++;
        if (head == null) {
            head = c2;
            tail = c2;
            return;
        }
        tail.next = c2;
        tail = c2;
    }

    /**
     * Print The LinkedList
     */
    public void print() {
        node i = head;
        while (i != null) {
            System.out.print(i.value + " ");
            i = i.next;
        }
        System.out.println();
    }

    /**
     * Get The Size Of LinkedList
     *
     * @return Integer
     */
    public int getlength() {
        return length;
    }

    /**
     * Get The Element At Specified Index In LinkedList
     *
     * @param index
     * @return integer
     */
    public Object get(int index) {
        node i = head;
        int counter = getlength();
        if (index == 0) {
            return head.value;
        } else if (index > counter) {
            throw new RuntimeException("Linked List out of bounds");
        } else if (index == counter - 1) {
            return tail.value;
        } else {
            for (int count = 0; count < index; count++) {
                i = i.next;
            }
            return i.value;
        }
    }

    /**
     * Set And Change Specified  Index With Another Variable At LinkedList
     *
     * @param index
     * @param c
     */
    public void set(int index, Object c) {
        int counter;
        counter = getlength();
        node i = head;
        if (index == 0) {
            head.value = c;
        } else if (index > counter) {
            throw new RuntimeException("Linked list out of bounds");
        } else {
            for (int count = 0; count < index; count++) {
                i = i.next;
            }
            i.value = c;
        }

    }

    /**
     * Clear The LinkedList
     */
    public void clear() {
        if (head != null) {
            head.next = null;
            head = null;
        }
        length = 0;

    }

    /**
     * Check If The LinkedList is Empty Or Not
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return getlength() == 0;
    }

    /**
     * Remove An Element At Specified Index At List
     *
     * @param index
     */
    public void remove(int index) {
        node i = head;
        int counter = getlength();
        node j = i.next;
        if (index == 0) {
            head = head.next;
        } else if (index == counter - 1) {
            for (int count = 0; count < index - 1; count++) {
                i = i.next;
                j = j.next;
            }
            i.next = j.next;
            j.next = null;
        } else {
            for (int count = 0; count < index - 1; count++) {
                i = i.next;
                j = j.next;
            }
            i.next = j.next;
            j.next = null;
        }
        length--;
    }

    /**
     * Check  The Repeated Value
     *
     * @param c
     * @return boolean
     */
    public boolean contains(Object c) {
        node i = head;
        while (i != null) {
            if (i.value == c) {
                return true;
            } else
                i = i.next;

        }
        return false;
    }
}
