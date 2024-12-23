package org.kr.co.algorithms.dfs;

public class DepthFirstSearch {
    /* 부모 노드, 왼쪽 자식 노드, 오른쪽 자식 노드
    *  전위순회, 중위순회, 후위순회
    * */
    Node root;
    public void DFS(Node root) {
        if(root == null) return;
        else {
            System.out.println(root.data + " "); //전위순회
            DFS(root.lt);
            System.out.println(root.data + " "); //중위순회
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch tree = new DepthFirstSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
