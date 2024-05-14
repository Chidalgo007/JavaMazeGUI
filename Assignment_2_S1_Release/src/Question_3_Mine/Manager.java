/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_3_Mine;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author chg
 */
public class Manager {

    public String name;
    public String data = "";
    public MazeTree mazeTree;
    

    public void readFile(String fileName) {
        System.out.println("inside readFile");
        mazeTree = new MazeTree();
        File f;
        if (fileName == null) {
            f = new File(this.name);
        } else {
            f = new File(fileName);
        }

        try {
            Scanner myScanner = new Scanner(f);
            int lineNum = 0;
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();

                data = line;
                String[] dataL = data.split(",");
                if (dataL.length == 5) {
                    
                    mazeTree.addElement(dataL[0],
                            Integer.parseInt(dataL[1]),
                            Integer.parseInt(dataL[2]),
                            dataL[3], dataL[4]);
                }
            }
            myScanner.close();
            mazeTree.addNode();
            mazeTree.traverse();
        } catch (IOException e) {
            System.out.println("Cannot read the file" + e.getMessage());
        }
    }
}
