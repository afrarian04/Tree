package treeekpresi;

public class StackTree {

    private ListTree stackListTree;

    public StackTree() {
        stackListTree = new ListTree();
    }

    public void push(TreeNode node_in) {
        stackListTree.addFirst(node_in);
    }

    public TreeNode pop() {
        return stackListTree.removeFirst();
    }

    public boolean isEmpty() {
        return stackListTree.isEmpty();
    }

    public void print() {
        stackListTree.toString();
    }
}
