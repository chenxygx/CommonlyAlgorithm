public class 反转链表 {
    private boolean stop;
    private LinkedList.Node left;

    public void recurseAndReverse(LinkedList.Node right, int m, int n) {
        if (n == 1) {
            return;
        }
        right = right.next;
        if (m > 1) {
            this.left = this.left.next;
        }
        this.recurseAndReverse(right, m - 1, n - 1);
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }
        if (!this.stop) {
            Object t = this.left.data;
            this.left.data = right.data;
            right.data = t;
            this.left = this.left.next;
        }
    }
}
