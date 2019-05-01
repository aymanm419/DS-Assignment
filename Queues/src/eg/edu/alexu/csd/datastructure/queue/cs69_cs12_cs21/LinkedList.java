package eg.edu.alexu.csd.datastructure.queue.cs69_cs12_cs21;


public class LinkedList {
    private node head = null;
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
        if (head == null) {
            head = c2;
            return;
        }
        while (i != null) {
            if (i.next == null) {
                c2.next = null;
                i.next = c2;
                i = null;
            } else {
                i = i.next;
            }
        }

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
        node i = head;
        int length = 0;
        while (i != null) {
            length++;
            i = i.next;
        }
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
        int counter;
        counter = getlength();
        if (index == 0) {
            return head.value;
        } else if (index > counter) {
            System.out.println("You Choose A Null Character");
            return -1;
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
            System.out.println("You Choose A Null Character");

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


    }

    /**
     * Check If The LinkedList is Empty Or Not
     *
     * @return boolean
     */
    public boolean isEmpty() {
        node i = head;
        if (i == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove An Element At Specified Index At List
     *
     * @param index
     */
    public void remove(int index) {
        node i = head;
        int counter;
        counter = getlength();
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
