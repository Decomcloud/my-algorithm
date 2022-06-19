package cloud.lintcode.common;

/**
 * @author Yunfeng Sun
 * @date 2022/4/25 19:52
 */
public class DoubleLinkedListNode {
    public int val;
    public DoubleLinkedListNode prev;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode() {
    }

    public DoubleLinkedListNode(int value) {
        this.val = value;
        this.prev = null;
        this.next = null;
    }

}
