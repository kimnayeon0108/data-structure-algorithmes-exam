package tree;

public class Tree {

    Node root;

    public void makeTree(int[] a) {
        root = makeTreeRoot(a, 0, a.length - 1);
    }

    public Node makeTreeRoot(int[] a, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeTreeRoot(a, start, mid - 1);
        node.right = makeTreeRoot(a, mid + 1, end);
        return node;
    }

    public void searchBTree(Node node, int find) {
        if (find < node.data) {
            System.out.println("Data is smaller than " + node.data);
            searchBTree(node.left, find);
        } else if (find > node.data) {
            System.out.println("Data is bigger than " + node.data);
            searchBTree(node.right, find);
        } else {
            System.out.println("Data found!");
        }
    }

    class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}

