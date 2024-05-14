/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhu
 */
public class MemoManager<E extends Comparable> {

    public BinaryTree bTreeTitle;
    public BinaryTree bTreeDate;

    public MemoManager() {
        bTreeDate = new BinaryTree();
        bTreeTitle = new BinaryTree();
    }

    public void addMemo(String date, String title, String message) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Memo memo = new Memo();
        try {
            //converting a string to date
            memo.date = dateFormat.parse(date);
            memo.title = title;
            memo.message = message;
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        addToTree(memo, (E) memo.date);
        addToTree(memo, (E) memo.title);
    }

    public void addToTree(Memo memo, E key) {

        if (key instanceof Date) {
            bTreeDate.addElement(memo, key);
        } else {
            bTreeTitle.addElement(memo, key);
        }
    }

    public Memo findMemo(E key) {
        if (key instanceof Date) {
            return (Memo) bTreeDate.searchElement(key);
        } else {
            return (Memo) bTreeTitle.searchElement(key);
        }
    }

    public Memo[] getSortedMemoList(E key) {
        Node[] sortedNodes;
        if (key instanceof Date) {
            sortedNodes = bTreeDate.toSortedList();
        } else {
            sortedNodes = bTreeTitle.toSortedList();
        }

        List<Memo> memoList = new ArrayList<>();
        for (Node<Memo, E> node : sortedNodes) {
            memoList.add(node.element);
        }
        Memo[] memoArray = new Memo[memoList.size()];
        return memoList.toArray(memoArray);
    }

    public void reverseOrder() {
        bTreeDate.reverseOrder();
        bTreeTitle.reverseOrder();
    }
}
