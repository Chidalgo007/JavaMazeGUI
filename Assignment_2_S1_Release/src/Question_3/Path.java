/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Map;
import java.util.Stack;
import java.util.Timer;

/**
 *
 * @author chg
 */
public class Path {

    Node root;
    MazePaint mp;
    String target = "EXIT";
    Map<String, Node> nodes;
    Stack<Node> path = new Stack<>();
    boolean targetFound = false;

    public Path(Map<String, Node> nodesPath, MazePaint mazePaint) {
        nodes = nodesPath;
        mp = mazePaint;
        root = nodes.get("START");
    }

    public void DFS(Node node) {
        if (node == null || targetFound) {
            return;
        }
        if (node.visited) {
            return;
        }
        path.push(node);
        node.visited = true;
        // paint yellow dot
        mp.setCurrentNode(node);
        // add a pause for half sec
        try {
            Thread.sleep(500); // Pause for half sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // print path once finished
        if (node.key.equalsIgnoreCase(target)) {
            targetFound = true;
            consolePrintPath();
            mp.repaint();
            return;
        }
        // iterrate over the node children
        for (Node child : node.children) {
            DFS(child);
            if (targetFound) {
                break;
            }
        }
        
        if (!targetFound) {
            path.pop();
        }
    }

    public void consolePrintPath() {
        System.out.print("Path: ");
        for (Node node : path) {
            System.out.print(node.key + " ");
        }
        System.out.println();
    }

}
