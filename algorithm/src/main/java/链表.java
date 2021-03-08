
public class 链表 {
    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        LinkedList.Node node = LinkedList.reversList(list.getHead());
        System.out.println();
    }
}
