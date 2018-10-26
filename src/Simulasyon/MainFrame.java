
package Simulasyon;

import aygit.Tel;
import aygit.Source;
import aygit.DevreCihazi;
import javax.swing.*;
import javax.swing.UIManager.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;

public class MainFrame extends JFrame {

   
    public static ModEnum mode;
    public static AygitEnum currentDev;
    public static MouseEvent pressed, dragged, click, released, mouseMove;
    public Devre ckt;
    public DevreCihazi pressedDevice, releasedDevice;
    public Tel pressedWire, releasedWire;
    public int numberOfInput;
    private DevreCihazi selectedDevice;
    
    public MainFrame() {
        mode = ModEnum.drawing;
        currentDev = AygitEnum.wire;
        ckt = new Devre();
        numberOfInput = 2;
        
        try {
            numberOfInput = 1/0;
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(this);
            }
            catch(Exception ee)  {
                ee.printStackTrace();
            }
        }
        
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane3 = new javax.swing.JScrollPane();
        cktPanel = new Simulasyon.DevrePanel(ckt);
        andButton = new javax.swing.JButton();
        orButton = new javax.swing.JButton();
        xorButton = new javax.swing.JButton();
        notButton = new javax.swing.JButton();
        nandButton = new javax.swing.JButton();
        norButton = new javax.swing.JButton();
        inputNumbers = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        ledButton = new javax.swing.JButton();
        switchButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        runButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();

        jMenu3.setText("jMenu3");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Muhendislik Projesi-3");
        setMinimumSize(new java.awt.Dimension(700, 600));
        setName("mainFrame"); // NOI18N

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(1920, 1080));

        cktPanel.setBackground(new java.awt.Color(253, 254, 238));
        cktPanel.setToolTipText("");
        cktPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cktPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));
        cktPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                circuitPanelComponentAdded(evt);
            }
        });
        cktPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                circuitPanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                circuitPanelMouseMoved(evt);
            }
        });
        cktPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                circuitPanelFocusGained(evt);
            }
        });
        cktPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                circuitPanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                circuitPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cktPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout cktPanelLayout = new javax.swing.GroupLayout(cktPanel);
        cktPanel.setLayout(cktPanelLayout);
        cktPanelLayout.setHorizontalGroup(
            cktPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        cktPanelLayout.setVerticalGroup(
            cktPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(cktPanel);

        andButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        andButton.setText("AND");
        andButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                andButtonActionPerformed(evt);
            }
        });

        orButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        orButton.setText("OR");
        orButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orButtonActionPerformed(evt);
            }
        });

        xorButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        xorButton.setText("XOR");
        xorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xorButtonActionPerformed(evt);
            }
        });

        notButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        notButton.setText("NOT");
        notButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notButtonActionPerformed(evt);
            }
        });

        nandButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nandButton.setText("NAND");
        nandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nandButtonActionPerformed(evt);
            }
        });

        norButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        norButton.setText("NOR");
        norButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                norButtonActionPerformed(evt);
            }
        });

        inputNumbers.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        inputNumbers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3" }));
        inputNumbers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                inputNumbersItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Giriş Sayısı");

        ledButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/led.png"))); // NOI18N
        ledButton.setText("AMPUL");
        ledButton.setToolTipText("LED");
        ledButton.setFocusable(false);
        ledButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ledButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ledButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledButtonActionPerformed(evt);
            }
        });

        switchButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        switchButton.setText("1 & 0");
        switchButton.setToolTipText("Switch");
        switchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        deleteButton.setText("SİL");
        deleteButton.setToolTipText("Delete");
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        clearButton.setText("TEMİZLE");
        clearButton.setToolTipText("Clear Circuit Diagram");
        clearButton.setFocusable(false);
        clearButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        runButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/start.png"))); // NOI18N
        runButton.setText("BASLAT");
        runButton.setToolTipText("Simulate");
        runButton.setFocusable(false);
        runButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        runButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dur.png"))); // NOI18N
        stopButton.setText("DURDUR");
        stopButton.setToolTipText("Simulate");
        stopButton.setFocusable(false);
        stopButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stopButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        selectButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        selectButton.setText("Seçim");
        selectButton.setToolTipText("Select");
        selectButton.setFocusable(false);
        selectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        selectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(andButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(norButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(xorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(notButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nandButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(orButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inputNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(ledButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(inputNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ledButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(andButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(orButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nandButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(norButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(notButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void andButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_andButtonActionPerformed
        if ( mode == ModEnum.run ) {
            return;
        }
        mode = ModEnum.drawing;
        currentDev = AygitEnum.and;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"2", "3"}));
        numberOfInput = 2;
    }//GEN-LAST:event_andButtonActionPerformed

    private void notButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notButtonActionPerformed
        if ( mode == ModEnum.run ) {
            return;
        }
        mode = ModEnum.drawing;
        currentDev = AygitEnum.not;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"1"}));
        numberOfInput = 1;
    }//GEN-LAST:event_notButtonActionPerformed

    private void orButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orButtonActionPerformed
        if ( mode == ModEnum.run ) {
            return;
        }
        mode = ModEnum.drawing;
        currentDev = AygitEnum.or;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"2", "3"}));
        numberOfInput = 2;
    }//GEN-LAST:event_orButtonActionPerformed

    private void nandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nandButtonActionPerformed
        if ( mode == ModEnum.run ) {
            return;
        }
        mode = ModEnum.drawing;
        currentDev = AygitEnum.nand;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"2", "3"}));
    }//GEN-LAST:event_nandButtonActionPerformed

    private void norButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_norButtonActionPerformed
        if ( mode == ModEnum.run ) {
            return;
        }
        mode = ModEnum.drawing;
        currentDev = AygitEnum.nor;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"2", "3"}));
        numberOfInput = 2;
    }//GEN-LAST:event_norButtonActionPerformed

    private void xorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xorButtonActionPerformed
        if ( mode == ModEnum.run ) {
            return;
        }
        mode = ModEnum.drawing;
        currentDev = AygitEnum.xor;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"2", "3"}));
        numberOfInput = 2;
    }//GEN-LAST:event_xorButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        if ( mode == ModEnum.run ) {
            return;
        }
        mode = ModEnum.select;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"---"}));
    }//GEN-LAST:event_selectButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if ( mode != ModEnum.select )  return;
        if ( selectedDevice != null )   {
            if ( ckt.deleteDevice(selectedDevice) == false ) 
                System.out.println("Cihaz Silinemedi");
        }
        cktPanel.repaint();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void ledButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledButtonActionPerformed
        mode = ModEnum.drawing;
        currentDev = AygitEnum.led;
        numberOfInput = 1;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"---"}));
    }//GEN-LAST:event_ledButtonActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        if ( !ckt.isValid() )   {
            JOptionPane.showMessageDialog(null, "Devre eksik.");
            return;
        }
        if ( mode == ModEnum.run ) return;
        mode = ModEnum.run;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"---"}));
        int l = ckt.source.size();
        for ( int i = 0; i < l; i++ )   {
            Source s = ckt.source.get(i);
            s.setOutput(false);
        }
        cktPanel.repaint();
    }//GEN-LAST:event_runButtonActionPerformed

    private void switchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchButtonActionPerformed
        mode = ModEnum.drawing;
        currentDev = AygitEnum.source;
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"---"}));
    }//GEN-LAST:event_switchButtonActionPerformed

    private void circuitPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_circuitPanelFocusGained
    }//GEN-LAST:event_circuitPanelFocusGained

    private void circuitPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_circuitPanelComponentAdded
    }//GEN-LAST:event_circuitPanelComponentAdded

    private void circuitPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseMoved
        mouseMove = evt;
        if ( mode == ModEnum.drawing ) {
            if ( currentDev != AygitEnum.wire )    {
                ckt.setTemp(mouseMove, numberOfInput);
            }
            else    {
                Koordinat c = new Koordinat(evt);
                DevreCihazi temp = ckt.searchForDevice(c);

                System.out.println("Cihazda mı? : "+(temp != null));
                if ( temp != null ) {
                    int indx = temp.isOnInLeg(c);
                    if ( indx > -1 )    ckt.pointFlag = true;
                    else if ( temp.isOnOutLeg(c) )  {
                        System.out.println("Dışarıda...");
                        ckt.pointFlag = true;
                    }
                    else    ckt.pointFlag = false;
                }
                else    ckt.pointFlag = false;
            }
        }
        else if ( mode == ModEnum.run )    {
            Koordinat c = new Koordinat(evt);
            DevreCihazi temp = ckt.searchForSource(c);
            if ( temp != null ) {
                cktPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            else    {
                cktPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
        cktPanel.repaint();
        
    }//GEN-LAST:event_circuitPanelMouseMoved

    private void circuitPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseDragged
        dragged = evt;
        ckt.end = new Koordinat(dragged);
        cktPanel.repaint();
    }//GEN-LAST:event_circuitPanelMouseDragged

    private void circuitPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMousePressed
        if ( mode == ModEnum.drawing )  {
            if ( currentDev == AygitEnum.wire )    {
                DevreCihazi d = ckt.searchForDevice(new Koordinat(evt));
                if ( d != null )    {
                    int indx = d.isOnInLeg(new Koordinat(evt));
                    if ( indx > -1 || d.isOnOutLeg(new Koordinat(evt)))    {
                        pressed = evt;
                        pressedDevice = d;
                        ckt.start = new Koordinat(pressed);
                    }
                    else {
                        pressed = null;
                        pressedDevice = null;
                        pressedWire = null;
                    }
                }
                else    {
                    Tel w = ckt.searchForWire(new Koordinat(evt));
                    if ( w != null )    {
                        pressed = evt;
                        pressedWire = w;
                        ckt.start = new Koordinat(pressed);
                    }
                    else {
                        pressed = null;
                        ckt.start = null;
                        pressedWire = null;
                    }
                }
            }
        }
    }//GEN-LAST:event_circuitPanelMousePressed

    private void circuitPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseClicked
        if ( mode == ModEnum.drawing ) {
            ckt.placeTemp();
            currentDev = AygitEnum.wire;
        }
        else if ( mode == ModEnum.run )    {
            Source s = ckt.searchForSource(new Koordinat(evt));
            if ( s != null )    s.toggleOutput();
        }
        else if ( mode == ModEnum.select ) {
            if ( selectedDevice != null )   {
                selectedDevice.setSelected(false);
                selectedDevice = null;
            }
            Koordinat cd = new Koordinat(evt);
            DevreCihazi d = ckt.searchForDevice(cd);
            if ( d == null )    d = ckt.searchForSource(cd);
            if ( d == null )    return;
            d.setSelected(true);
            selectedDevice = d;
            System.out.println("Seçilen cihaz "+selectedDevice.getClass().toString());
        }
        cktPanel.repaint();
    }//GEN-LAST:event_circuitPanelMouseClicked

    private void inputNumbersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_inputNumbersItemStateChanged
        this.numberOfInput = Integer.parseInt((String) evt.getItem());
        try {
            ckt.getTemp().setGirisSayisi(numberOfInput);
        }   catch(Exception e)  {}
    }//GEN-LAST:event_inputNumbersItemStateChanged

    private void cktPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cktPanelMouseReleased
        dragged = null;
        ckt.end = null;
        if ( mode == ModEnum.drawing )  {
            if ( currentDev == AygitEnum.wire )    {
                DevreCihazi d = ckt.searchForDevice(new Koordinat(evt));
                if ( d != null )    {
                    int indx = d.isOnInLeg(new Koordinat(evt));
                    if ( indx > -1 || d.isOnOutLeg(new Koordinat(evt)))    {
                        System.out.println("Cihazda");
                        released = evt;
                        releasedDevice = d;
                        ckt.addWire(new Koordinat(pressed), pressedDevice, new Koordinat(released), releasedDevice);
                    }
                    else {
                        released = null;
                        releasedDevice = null;
                    }
                }
                else    {
                    Tel w = ckt.searchForWire(new Koordinat(evt));
                    if ( w != null )    {
                        pressed = evt;
                        pressedWire = w;
                    }
                    else {
                        pressed = null;
                        pressedWire = null;
                    }
                }
            }
        }
        cktPanel.repaint();
    }//GEN-LAST:event_cktPanelMouseReleased

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Hepsini Silmek İstediğinize Emin Misiniz ?");
        if ( i == 0 )   ckt.clear();
        cktPanel.repaint();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        mode = ModEnum.drawing;
        currentDev = AygitEnum.wire;
        int l = ckt.source.size();
        cktPanel.repaint();
        inputNumbers.setModel(new DefaultComboBoxModel(new String[]{"---"}));
    }//GEN-LAST:event_stopButtonActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton andButton;
    private javax.swing.JPanel cktPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox inputNumbers;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton ledButton;
    private javax.swing.JButton nandButton;
    private javax.swing.JButton norButton;
    private javax.swing.JButton notButton;
    private javax.swing.JButton orButton;
    private javax.swing.JButton runButton;
    private javax.swing.JButton selectButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JButton switchButton;
    private javax.swing.JButton xorButton;
    // End of variables declaration//GEN-END:variables
}
