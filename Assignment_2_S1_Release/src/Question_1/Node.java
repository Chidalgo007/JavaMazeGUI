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
public class Node <E, F extends Comparable> implements Comparable <Node<E,F>>{

    E element;
    F key;
    Node<E,F> left;
    Node<E,F> right;

    @Override
    public int compareTo(Node<E,F> t) {
        return this.key.compareTo(t.key);
    }
}
