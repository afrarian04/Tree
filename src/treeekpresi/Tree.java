package treeekpresi;

class TreeNode {

    private TreeNode leftChild;
    private TreeNode rightChild;
    private char data;

    public TreeNode(char nodeData) {
        this.data = nodeData;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

}

public class Tree {

    private TreeNode root;

    public Tree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preOrder(TreeNode localRoot) { //root left right
        if (localRoot != null) {
            System.out.print(localRoot.getData() + " ");
            preOrder(localRoot.getLeftChild());
            preOrder(localRoot.getRightChild());
        }
    }

    public void inOrder(TreeNode localRoot) { //left root right
        if (localRoot != null) {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getData() + " ");
            inOrder(localRoot.getRightChild());
        }
    }

    public void postOrder(TreeNode localRoot) { //left right root
        if (localRoot != null) {
            postOrder(localRoot.getLeftChild());
            postOrder(localRoot.getRightChild());
            System.out.print(localRoot.getData() + " ");
        }
    }
}
