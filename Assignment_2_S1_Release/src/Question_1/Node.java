/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

/**
 *
 * @author xhu
 */
public class Node <E, F extends Comparable> implements Comparable <Node>{

    E element;
    F key;
    Node<E,F> left;
    Node<E,F> right;
    
    public Node(E ele, F k){
        element = ele;
        key = k;
    }

    @Override
    public int compareTo(Node t) {
        return key.compareTo(t.key);
    }
}
