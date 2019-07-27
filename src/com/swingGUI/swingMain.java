package com.swingGUI;



import javax.swing.*;

public class swingMain {
    public static JFrame frame;
    public static JPanel panel1;
    public static JTabbedPane resPane;
    public static JPanel tab1,tab2,tab3;

    public static void main(String[] argv) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {

        frame = new JFrame("Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(460, 320);

        panel1 = new JPanel();
        panel1.setLayout(null);


        resPane = new JTabbedPane();
        resPane.setBounds(10, 10, 420, 260);
        panel1.add(resPane);

        tab1=new JPanel();
        tab2=new JPanel();
        tab3=new JPanel();

        resPane.addTab("tab1",tab1);
        resPane.addTab("tab2",tab2);
        resPane.addTab("tab3",tab3);

        panel1.add(resPane);

        frame.add(panel1);

        frame.setVisible(true);
    }
}