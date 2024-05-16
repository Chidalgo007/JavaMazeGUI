/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_3;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.io.File;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author chg
 */
public class Main extends JFrame {

    private JPanel mazePanel;
    private MazePaint mazePaint;
    private Manager manager;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(700, 600));
        setResizable(false);

        mazePanel = new JPanel(new GridLayout());
        mazePaint = new MazePaint();
        mazePanel.add(mazePaint, new GridBagConstraints());

        manager = new Manager();

        JPanel btnPanel = new JPanel();
        JButton openFile = new JButton("File");
        openFile.setBackground(new java.awt.Color(51, 51, 51));
        openFile.setForeground(new java.awt.Color(255, 255, 255));
        openFile.setFocusable(false);
        openFile.addActionListener(e -> openFileActionPerformed());
        btnPanel.add(openFile);

        add(btnPanel, BorderLayout.NORTH);
        add(mazePanel, BorderLayout.CENTER);

        pack();
    }

    private void openFileActionPerformed() {
        JFileChooser fileChooser = new JFileChooser(new File("."));
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(txtFilter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getPath();
            // read add the node in the MazeTree and return Map from MazeTree
            Map<String, Node> nodesMap = manager.readFile(fileName);
            //Set coordinates and nodes to draw
            mazePaint.setNodes(nodesMap);
            mazePaint.col = manager.col;
            mazePaint.row = manager.row;
            // Start DFS in a separate thread
            new Thread(() -> mazePaint.startDFS()).start();
        } else {
            System.out.println("File selection canceled");
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}
