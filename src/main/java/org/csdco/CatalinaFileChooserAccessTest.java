// May 12 2020, LacCore/CSDCO
// CatalinaFileChooserAccessTest.java
// 
// Minimal app demonstrating inability to access Documents, Desktop, and Downloads
// dirs in macOS 10.15 "Catalina" from JFileChooser when bundled as an app. These
// dirs are accessible through FileDialog, which appears to use the native macOS chooser.
// The expected system dialog "CatalinaFileChooserAccessTest.app would like to access the 
// [folder name] folder" does not appear in JFileChooser, thus access cannot be granted.
//
// These dirs are accessible from both dialogs when built and run locally i.e.
// [in src/main/java]% java org.csdco.CatalinaFileChooserAccessTest
//
// The problem manifests only when packaged as an app bundle.

package org.csdco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CatalinaFileChooserAccessTest {
    public static void main(String[] args) {
        CFCAT frame = new CFCAT();
        frame.show();
    }
}

class CFCAT {
    JFrame frame;
    public void show() {
        frame = new JFrame();
        frame.setTitle("macOS 10.15 Catalina Java File Chooser Directory Access Test");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        ((JComponent)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // show Java runtime info
        final String jreArch = System.getProperty("os.arch").contains("64") ? "64-bit" : "32-bit";
		final String javaVersion = System.getProperty("java.version");
		final String javaVendor = System.getProperty("java.vendor");
		final String javaHome = System.getProperty("java.home");
		addCentered(new JLabel("Running Java " + javaVersion + " (" + jreArch + ", " + javaVendor + ")"));
        addCentered(new JLabel("Java home: " + javaHome));
        addCentered(new JSeparator());

        JLabel label = new JLabel("Try to access contents of [home]/Documents, Desktop, and Downloads folder in each dialog.");
        addCentered(label);
        addCentered(new JLabel("On macOS Catalina 10.15, they're accessible in FileDialog but not in JFileChooser."));
        JButton fdButton = new JButton("Use FileDialog...");
        fdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFileDialog();
            }
        });
        addCentered(fdButton);
        JButton jfcButton = new JButton("Use JFileChooser...");
        jfcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openJFileChooser();
            }
        });
        addCentered(jfcButton);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void openJFileChooser() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("JFileChooser - Choose a file.");
        chooser.showOpenDialog(frame);
    }
    
    private void openFileDialog() {
        FileDialog fd = new FileDialog(frame, "FileDialog - Choose a file.");
        fd.setMode(FileDialog.LOAD);
        fd.setVisible(true);
    }

    private void addCentered(JComponent c) {
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(c);
    }
}