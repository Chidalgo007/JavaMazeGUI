/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xhu
 */
public class BinaryTree<E, F extends Comparable> {

    Node root;
    int number_of_nodes;
    List<Node> nodeListArray;
    Node[] nodeList;
    Boolean reverseOrderFlag;

    public BinaryTree() {

        root = null;
        number_of_nodes = 0;
        nodeListArray = new ArrayList<>();
        reverseOrderFlag = false;
    }

    public BinaryTree(Node node) {
        root = node;
        reverseOrderFlag = false;
    }

    public BinaryTree(E element, F key) {

    }

    public void addElement(E element, F key) {
        if (root == null) {
            root = new Node(element, key);
        } else {
            Node newNode = new Node(element, key);
            addNode(root, newNode);
        }
        number_of_nodes++;
    }

    public void addNode(Node root, Node node) {
        if (node.compareTo(root) == 0) {
            return;
        } else if (node.compareTo(root) < 0) {
            if (root.left == null) {
                root.left = node;
            } else {
                addNode(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                addNode(root.right, node);
            }
        }
    }
    //for your debugging

    public void traversal(Node root) {
        if (root != null) {
            traversal(root.left);
            System.out.println(root.element);
            traversal(root.right);
        }
    }

    public Node[] toSortedList() {
        toSortedList(root);
        nodeList = new Node[nodeListArray.size()];
        return nodeListArray.toArray(nodeList);
    }

    private void toSortedList(Node root) {
        if (root != null) {
            toSortedList(root.left);
            nodeListArray.add(root);
            System.out.println("SORT TREE ==== " + root.element);
            toSortedList(root.right);
        }

    }

    public void reverseOrder() {
        nodeListArray.clear();
        reverseOrder(root);
    }

    private void reverseOrder(Node root) {
        if (root != null) {
            reverseOrder(root.right);
            nodeListArray.add(root);
            System.out.println("REVERSE TREE ==== " + root.element);
            reverseOrder(root.left);
        }
        reverseOrderFlag = true;

    }

    public E searchElement(F key) {
        Node targetNode = new Node(null, key);
        Node resultNode = searchNode(root, targetNode);
        if (resultNode != null) {
            return (E) resultNode.element;
        }
        return null;
    }

    public Node searchNode(Node root, Node node) {
        if (root == null || root.key.compareTo(node.key) == 0) {
            return root;
        }

        int n = node.key.compareTo(root.key);
        if (n < 0) {
            return searchNode(root.left, node);
        } else {
            return searchNode(root.right, node);
        }
    }

}
