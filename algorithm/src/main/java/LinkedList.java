public class LinkedList<E> {
    static class Node<T> {
        Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private int size;

    public int getSize() {
        return size;
    }

    public LinkedList() {
        head = new Node<E>(null);
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> add(E data, int index) throws Exception {
        if (index > size) {
            throw new Exception("超出范围...");
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node<E> node = new Node<E>(data);
        cur.next = node;
        size++;
        return node;
    }

    public Node<E> add(E data) throws Exception {
        return add(data, size);
    }

    public void add(Node<E> data) {
        Node<E> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = data;
        size++;
    }

    public E remove(int index) throws Exception {
        if (index > size - 1 || index < 0) {
            throw new Exception("超出范围");
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node<E> temp = cur.next;
        cur.next = temp.next;
        temp.next = null;
        size--;
        return temp.data;
    }

    public E remove() throws Exception {
        return remove(size - 1);
    }

    public void removeDuplicateNodes() {
        Node<E> cur = head.next;
        while (cur != null) {
            Node<E> temp = cur;
            while (temp != null && temp.next != null) {
                if (cur.data.equals(temp.next.data)) {
                    Node<E> duplicateNode = temp.next;
                    temp.next = duplicateNode.next;
                    duplicateNode.next = null;
                    size--;
                }
                temp = temp.next;
            }
            cur = cur.next;
        }
    }

    public Node<E> getEndK(int k) {
        Node<E> pre = head.next;
        Node<E> post = head.next;
        for (int i = 1; i < k; i++) {
            if (pre != null) {
                pre = pre.next;
            }
        }
        if (pre != null) {
            while (pre != null && pre.next != null) {
                pre = pre.next;
                post = post.next;
            }
            return post;
        }
        return null;
    }

    public static <T> boolean isLoopList(Node<T> head) {
        Node<T> slowPointer, fastPointer;
        slowPointer = fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public static <T> void deleteNode(Node<T> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static <T> Node<T> findEntranceInLoopList(Node<T> head) {
        Node<T> slowPointer, fastPointer;
        boolean isLoop = false;
        slowPointer = fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                isLoop = true;
                break;
            }
        }
        if (isLoop) {
            slowPointer = head;
            while ((fastPointer != null && fastPointer.next != null)) {
                if (slowPointer == fastPointer) {
                    return slowPointer;
                }
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }
        return null;
    }

    public static Node josephusKill(Node head, int m) {
        if (head == null || m < 1) {
            return head;
        }
        Node last = head;
        while (head.next != last) {
            head = head.next;
        }
        int count = 0;
        while (head.next != head) {
            if (++count == m) {
                head.next = head.next.next;
                count = 0;
            } else {
                head = head.next;
            }
        }
        return head;
    }

    public static Node reversList(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null){
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static void printNode(Node head){
        while (head.next != null){
            System.out.print(head.next.data);
            head = head.next;
        }
        System.out.println();
    }
}
