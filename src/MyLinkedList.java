public class MyLinkedList<T> {
    private ListNode head, tail;
    private int size;

    private class ListNode {
        T val; // does a private inner class need private instance variables?
        ListNode next;
    
        public ListNode(T val) {
            this.val = val;
        }
        
        @Override
        public String toString() {
            return "" + this.val;
        }
    
        // for printing / debug
    }


    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public MyLinkedList(T val) {
        head = tail = new ListNode(val);
        head.next = null;
        size = 1;
    }

    public MyLinkedList(T... vals) {
        head = tail = new ListNode(vals[0]);
        for (int i = 1; i < vals.length; i++) {
            tail.next = new ListNode(vals[i]);
            tail = tail.next;
        }
        size = vals.length;
    }

    public void add(T newVal) {
        size++;
        ListNode newNode = new ListNode(newVal);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = new ListNode(newVal);
        tail = tail.next;
    }

    public boolean contains(T val) {
        ListNode node = head;
        while (node != null) {
            if (node.val.equals(val))
                return true;
            
            node = node.next;
        }
        return false;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            if (node == null)
                throw new IndexOutOfBoundsException();

            node = node.next;
        }
        return node.val;
    }

    public int indexOf(T val) {
        ListNode node = head;
        for (int i = 0; node != null; i++) {
            if (node.val.equals(val))
                return i;
            
            node = node.next;
        }
        return -1;
    }

    public void set(T newVal, int index) throws IndexOutOfBoundsException {
        if (index < 0)
            throw new IndexOutOfBoundsException();
            
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            if (node == null)
                throw new IndexOutOfBoundsException();

            node = node.next;
        }
        node.val = newVal;
    }

    public int size() {
        return size;
    }

    public int sizeRecursive(ListNode current) {
        if (current == null)
            return 0;

        return 1 + sizeRecursive(current.next);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T remove(int index) {
        ListNode currentNode = head;
        ListNode previousNode = null;
        for (int i = 0; i < index; i++) {
            if (currentNode == null)
                throw new IndexOutOfBoundsException();

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (previousNode == null)
            head = currentNode.next;
        
        else
            previousNode.next = currentNode.next;

        size--;
        return currentNode.val;
    }

    public void add(T newVal, int index) {
        ListNode newNode = new ListNode(newVal);

        ListNode currentNode = head;
        ListNode previousNode = null;
        for (int i = 0; i < index; i++) {
            if (currentNode == null)
                throw new IndexOutOfBoundsException();

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (previousNode == null) {
            head = newNode;
            newNode.next = currentNode;
        }
        else {
            previousNode.next = newNode;
            newNode.next = currentNode;
        }
        size++;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public String toString() {
        if (isEmpty())
            return "[]";

        String string = "";
        ListNode node = head;
        while (node != null) {
            string += node.val + ", ";
            node = node.next;
        }
        return "[" + string.substring(0, string.length() - 2) + "]";
    }
}
