package com.telerikacademy.io;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class RecipeBox extends JFrame {

    private final JFrame frame = new JFrame();
    public static String user = "NoName";

    public RecipeBox() {
        JPanel panel = new JPanel();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Cooking ebook");
        frame.setLayout(new FlowLayout());
        JButton enterButt = new JButton("Enter");
        frame.setLayout(new GridLayout());
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String text = "";
        JTextArea textArea = new JTextArea(text, 0, 10);
        textArea.setPreferredSize(new Dimension(600, 500));
        textArea.setLineWrap(true);
        frame.add(textArea);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.requestFocus();
        panel.add(textArea, 0);
        panel.add(enterButt, 1);
        frame.add(panel);

        File file = new File("recipes/recipes.txt");
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(file);
            printWriter.println("test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }


//        textField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String input = textField.getText();
//                setPlayerName(input);
//                frame.dispose();
//            }
//        });
//
//        enterButt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String input = textField.getText();
//                setUserName(input);
//                frame.dispose();
//            }
//        });
    }

    private void setUserName(String name) {
        System.out.println(name);
        if (name.equals("") || name.contains(" ")) {
            user = "NoName";
        } else {
            user = name;
        }
    }
}
