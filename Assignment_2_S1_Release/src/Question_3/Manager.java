/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_3;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 *
 * @author chg
 */
public class Manager {

    public MazeTree mazeTree;
    int col;
    int row;

    public Manager() {
        mazeTree = new MazeTree();
    }

    public Map<String, Node> readFile(String fileName) {

        try {
            File f = new File(fileName);
            Scanner myScanner = new Scanner(f);

            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    col = Integer.parseInt(data[1]);
                    row = Integer.parseInt(data[2]);
                }
                if (data.length == 5) {
                    String key = data[0];
                    int x = Integer.parseInt(data[1]);
                    int y = Integer.parseInt(data[2]);
                    String linkA = data[3];
                    String linkB = data[4];

                    mazeTree.addElement(key, x, y, linkA, linkB);
                }
            }
            myScanner.close();
            mazeTree.addNode();
//            mazeTree.traverse();
            return mazeTree.nodesMap;

        } catch (IOException e) {
            System.out.println("Cannot read the file" + e.getMessage());
        }
        return null;
    }
}
