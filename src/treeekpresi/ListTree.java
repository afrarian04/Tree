package treeekpresi;

class ListTreeNode {

    private TreeNode data;
    private ListTreeNode next;

    ListTreeNode(TreeNode treeNode) {
        this.data = treeNode;
        this.next = null;
    }

    public TreeNode getData() {
        return data;
    }

    public void setData(TreeNode data) {
        this.data = data;
    }

    public ListTreeNode getNext() {
        return next;
    }

    public void setNext(ListTreeNode next) {
        this.next = next;
    }

}

public class ListTree {

    private ListTreeNode firstNode;
    private ListTreeNode lastNode;

    public ListTree() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public void addFirst(TreeNode first) {
        if (isEmpty()) {
            firstNode = lastNode = new ListTreeNode(first);
        } else {
            ListTreeNode bantu = new ListTreeNode(first);
            bantu.setNext(firstNode);
            firstNode = bantu;
        }
    }

    public void addLast(TreeNode last) {
        if (isEmpty()) {
            firstNode = lastNode = new ListTreeNode(last);
        } else {
            ListTreeNode bantu = new ListTreeNode(last);
            lastNode.setNext(bantu);
            lastNode = bantu;
        }
    }

    public TreeNode removeFirst() {
        TreeNode bantu = null;
        if (!isEmpty()) {
            bantu = firstNode.getData();
            if (firstNode == lastNode) {
                firstNode = lastNode = null;
            } else {
                firstNode = firstNode.getNext();
            }
        }
        return bantu;
    }

    public TreeNode removelast() {
        TreeNode bantu = null;
        if (!isEmpty()) {
            bantu = lastNode.getData();
            if (firstNode == lastNode) {
                firstNode = lastNode = null;
            } else {
                ListTreeNode current = firstNode;
                while (current.getNext() != lastNode) {
                    current = current.getNext();
                }
                lastNode = current;
                current.setNext(null);
            }
        }
        return bantu;
    }

    public boolean isEmpty() {
        if (firstNode == null && lastNode == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String isi = "";
        ListTreeNode Pointer = firstNode;

        while (Pointer != null) {
            isi = isi + (Pointer.getData()).toString() + " ";
            Pointer = Pointer.getNext();
        }
        return isi;
    }

}
