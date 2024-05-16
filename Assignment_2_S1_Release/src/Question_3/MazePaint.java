/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_3;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

/**
 *
 * @author chg
 */
public class MazePaint extends JPanel {

    Map<String, Node> nodes;// = new HashMap<>();
    int rowSpacing = 40;
    int colSpacing = 40;
    int dotSize = 15;
    int center = dotSize / 2; // add half dotSize to center the line
    int colSpace;
    int rowSpace;
    int col;
    int row;
    Path path;
    Node curretnNode;

    public MazePaint() {
        setPreferredSize(new Dimension(700, 550));

    }

    public void setNodes(Map<String, Node> nodesMap) {
        nodes = nodesMap;
        revalidate();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
        if (nodes != null) {

            colSpace = getWidth() / col;
            rowSpace = getHeight() / row;

            // iterrate through the nodes
            for (Node node : nodes.values()) {
                int x = node.x * (colSpace) + colSpacing;
                int y = node.y * (rowSpace) + rowSpacing;
                // draw the links line between node and child
                for (Node child : node.children) {
                    int xChild = child.x * (colSpace) + colSpacing + center;
                    int yChild = child.y * (rowSpace) + rowSpacing + center;
                    g2d.setColor(Color.YELLOW);
                    g2d.setStroke(new BasicStroke(2));
                    g2d.drawLine(x + center, y + center, xChild, yChild);
                }
                // draw the nodes
                Ellipse2D.Double ed = new Ellipse2D.Double(x, y, dotSize, dotSize);
                g2d.setColor(Color.decode("#0787F7"));
                g2d.fill(ed);
                g2d.setColor(Color.BLACK);
                g2d.drawString(node.key, (int) ed.getX() - 5, (int) ed.getY() - 2);
            }

            // paint current node visiting in the DFS traverse
            if (curretnNode != null) {
                int x = curretnNode.x * colSpace + colSpacing;
                int y = curretnNode.y * rowSpace + rowSpacing;
                Ellipse2D.Double ed = new Ellipse2D.Double(x, y, dotSize, dotSize);
                g2d.setColor(Color.YELLOW);
                g2d.fill(ed);
                if (curretnNode.key.equalsIgnoreCase(path.target)) {
                    g2d.setColor(Color.decode("#F56464"));
                    g2d.fill(ed);
                }
            }
            if (path.targetFound) {
                int x = path.root.x * (colSpace) + colSpacing + center;
                int y = path.root.y * (rowSpace) + rowSpacing + center;

                for (Node node : path.path) {
                    int xNext = node.x * (colSpace) + colSpacing + center;
                    int yNext = node.y * (rowSpace) + rowSpacing + center;
                    g2d.setColor(Color.GREEN);
                    g2d.setStroke(new BasicStroke(3));
                    g2d.drawLine(x, y, xNext, yNext);
                    x = xNext;
                    y = yNext;
                }

            }
        }
    }

    public void startDFS() {
        if (nodes != null) {
            path = new Path(nodes, this);
            new Thread(() -> path.DFS(path.root)).start();
        }
    }

    public void setCurrentNode(Node node) {
        curretnNode = node;
        repaint();
    }

}
