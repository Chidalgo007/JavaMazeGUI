/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3_Mine;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author xhu
 */
public class MazeTree {

    Node root;
    Map<String, Node> nodesMap = new HashMap<>();
    int num;

    public MazeTree() {

    }

    public void addElement(String key, int x, int y, String linkA, String linkB) {
        Node newNode = new Node(key, x, y, linkA, linkB);
        nodesMap.put(key, newNode);
        num++;
    }

    public void addNode() {
        for (Node node : nodesMap.values()) {
            Node linkedNodeA;
            if (!node.linkA.equalsIgnoreCase("A")) {
                if (node.linkA.equalsIgnoreCase("W")) {
                    linkedNodeA = nodesMap.get("EXIT");
                    if (linkedNodeA != null) {
                        node.children.add(linkedNodeA);
                    }
                }
                linkedNodeA = nodesMap.get(node.linkA);
                if (linkedNodeA != null) {
                    node.children.add(linkedNodeA);
                }
            }
            if (!node.linkB.equalsIgnoreCase("A")) {
                Node linkeNodeB;

                if (node.linkB.equalsIgnoreCase("W")) {
                    linkeNodeB = nodesMap.get("EXIT");
                    if (linkeNodeB != null) {
                        node.children.add(linkeNodeB);
                    }
                }
                linkeNodeB = nodesMap.get(node.linkB);
                if (linkeNodeB != null) {
                    node.children.add(linkeNodeB);
                }
            }
        }

        root = nodesMap.get("START");
    }
    //for your debugging

    public void traverse(Node node) {
        if (node != null) {
            System.out.println("Node: " + node.key);
            for (Map.Entry<String, Node> no : nodesMap.entrySet()) {
                System.out.println("Node " + no.getKey());
                
                for (Node child : no.getValue().children) {
//                traverse(child);
                    System.out.println("Child " + child.key);
                }
            }
        }
    }

    public void traverse() {

        if (root != null) {
            traverse(root);
        }
    }

}
