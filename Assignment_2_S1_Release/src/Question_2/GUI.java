/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Question_2;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author chg
 */
public class GUI extends javax.swing.JFrame {

    private String fileName;

    public GUI() {
        setResizable(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openFile = new javax.swing.JButton();
        fixImg = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        imgDisplay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openFile.setText("Open File");
        openFile.setFocusable(false);
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });

        fixImg.setText("Fix Img");
        fixImg.setFocusable(false);
        fixImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixImgActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        imgDisplay.setBackground(new java.awt.Color(204, 204, 204));
        imgDisplay.setForeground(new java.awt.Color(204, 204, 204));
        imgDisplay.setAlignmentY(0.0F);
        imgDisplay.setFocusable(false);
        imgDisplay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imgDisplay.setMaximumSize(new java.awt.Dimension(430, 310));
        imgDisplay.setMinimumSize(new java.awt.Dimension(430, 310));
        imgDisplay.setPreferredSize(new java.awt.Dimension(430, 310));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(openFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fixImg)
                .addGap(134, 134, 134))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openFile)
                    .addComponent(fixImg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        JFileChooser imageFileChooser = new JFileChooser(new File("."));

        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                "Image files", "jpg", "jpeg", "png", "gif", "bmp");
        imageFileChooser.setFileFilter(imageFilter);

        int stateImageFileChooser = imageFileChooser.showOpenDialog(null);

        if (stateImageFileChooser == JFileChooser.APPROVE_OPTION) {
            fileName = imageFileChooser.getSelectedFile().getPath();
            ImageIcon img = new ImageIcon(fileName);
            Image scale = img.getImage()
                    .getScaledInstance(
                            imgDisplay.getWidth(),
                            imgDisplay.getHeight(),
                            Image.SCALE_SMOOTH);
            ImageIcon sImg = new ImageIcon(scale);
            imgDisplay.setIcon(sImg);

        }   
    }//GEN-LAST:event_openFileActionPerformed

    private void fixImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixImgActionPerformed

        if (imgDisplay.getIcon() != null) {
            ImageProcess ip = new ImageProcess(fileName);
            ip.cleanNoise();
            String outputName = "noise_removed.jpg";
            ip.save(outputName);

            File file = new File(fileName);
            String newPath = file.getParent();
            String newFilePath = newPath + "\\" + outputName;

            ImageIcon img = new ImageIcon(newFilePath);
            Image scale = img.getImage()
                    .getScaledInstance(
                            imgDisplay.getWidth(),
                            imgDisplay.getHeight(),
                            Image.SCALE_SMOOTH);
            ImageIcon sImg = new ImageIcon(scale);
            imgDisplay.setIcon(sImg);
        }
    }//GEN-LAST:event_fixImgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fixImg;
    private javax.swing.JLabel imgDisplay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openFile;
    // End of variables declaration//GEN-END:variables
}
