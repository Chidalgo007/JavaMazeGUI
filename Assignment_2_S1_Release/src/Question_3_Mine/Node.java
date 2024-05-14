/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3_Mine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xhu
 */
public class Node implements Comparable<Node> {

    String key;// name
    int x;// possition columns
    int y;// possition rows
    String linkA;
    String linkB;
    List<Node> children;

    public Node(String key, int x, int y, String linkA, String linkB) {
        this.key = key;
        this.x = x;
        this.y = y;
        this.linkA = linkA;
        this.linkB = linkB;
        this.children = new ArrayList<>();
    }

    @Override
    public int compareTo(Node t) {
        return key.compareTo(t.key);
    }
}
