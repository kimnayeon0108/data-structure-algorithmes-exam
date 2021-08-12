package tree;

public class TreeTest {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Tree tree = new Tree();

        tree.makeTree(arr);
        tree.searchBTree(tree.root, 2);
    }
}
