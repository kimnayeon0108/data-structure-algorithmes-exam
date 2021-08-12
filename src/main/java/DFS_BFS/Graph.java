package DFS_BFS;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    Node[] nodes;

    public Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    /**
     * 두 노드의 관계를 저장하는 함수
     * 두 개의 각 노드의 인접한 노드(adjacent)에 서로 포함되어 있지 않으면 추가해준다.
     */
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int idx) {
        Node root = nodes[idx];

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int idx) {
        Node root = nodes[idx];
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.dequeue();
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }

    void dfsRecursive(Node r) {
        if (r == null) return;
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if (!n.marked) {
                dfsRecursive(n);
            }
        }
    }

    void dfsRecursive(int idx) {
        Node r = nodes[idx];
        dfsRecursive(r);
    }

    void dfsRecursive() {
        dfsRecursive(0);
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }


    class Node {
        int data;
        LinkedList<Node> adjacent;      // 인접한 노드들
        boolean marked;

        public Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<>();
        }
    }
}
