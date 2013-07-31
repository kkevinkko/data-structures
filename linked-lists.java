public class ListNode {

    private Object myFirst;
    private ListNode myRest;

    public ListNode(Object first, ListNode rest) {
        this.myFirst = head;
        this.myRest = rest;
    }

    public ListNode(Object first) {
        this(first, null);
    }

    public Object first() {
        return myFirst;
    }

    public ListNode rest() {
        return myRest;
    }
}
