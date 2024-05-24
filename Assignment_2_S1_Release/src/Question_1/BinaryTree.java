/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhu
 */
public class BinaryTree<E, F extends Comparable<F>> {
    Node<E, F> root;
    int number_of_nodes;
    Node<E, F>[] nodeList;

    // Method to add an element with a specified key to the binary tree
    public void addElement(E element, F key) {
        Node<E, F> newNode = new Node<>();
        newNode.element = element;
        newNode.key = key;
        addNode(root, newNode);
    }

    // Recursive method to add a node to the appropriate position in the binary tree
    private void addNode(Node<E, F> currentNode, Node<E, F> newNode) {
        if (root == null) { // If tree is empty, new node becomes the root
            root = newNode;
            number_of_nodes++;
        } else {
            if (newNode.key.compareTo(currentNode.key) < 0) { // If new node key is less, go to the left subtree
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    number_of_nodes++;
                } else {
                    addNode(currentNode.left, newNode);
                }
            } else { // If new node key is greater or equal, go to the right subtree
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    number_of_nodes++;
                } else {
                    addNode(currentNode.right, newNode);
                }
            }
        }
    }

    // Method to reverse the order of the binary tree (mirror the tree)
    public void reverseOrder() {
        reverseOrderHelper(root);
    }

    // Helper method to recursively reverse the order of the binary tree
    private void reverseOrderHelper(Node<E, F> currentNode) {
        if (currentNode != null) {
            Node<E, F> temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            reverseOrderHelper(currentNode.left);
            reverseOrderHelper(currentNode.right);
        }
    }

    // Method to search for an element by its key in the binary tree
    public E searchElement(F key) {
        Node<E, F> targetNode = new Node<>();
        targetNode.key = key;
        Node<E, F> resultNode = searchNode(root, targetNode);
        if (resultNode != null) {
            return resultNode.element;
        }
        return null;
    }

    // Recursive method to search for a node by its key in the binary tree
    private Node<E, F> searchNode(Node<E, F> currentNode, Node<E, F> targetNode) {
        if (currentNode == null) {
            return null; // Key not found
        }
        int compResult = currentNode.key.compareTo(targetNode.key);
        if (compResult == 0) {
            return currentNode; // Key found
        } else if (compResult < 0) {
            return searchNode(currentNode.right, targetNode); // Search in the right subtree
        } else {
            return searchNode(currentNode.left, targetNode); // Search in the left subtree
        }
    }

    // Method to convert the binary tree to a sorted list
    public Node<E, F>[] toSortedList() {
        nodeList = (Node<E, F>[]) new Node[number_of_nodes];
        int index = 0;
        traversal(root, index);
        return nodeList;
    }

    // Recursive in-order traversal method to populate the nodeList array with tree nodes in sorted order
    private int traversal(Node<E, F> currentNode, int index) {
        if (currentNode != null) {
            index = traversal(currentNode.left, index); // Traverse left subtree
            nodeList[index++] = currentNode; // Visit node
            index = traversal(currentNode.right, index); // Traverse right subtree
        }
        return index;
    }
}