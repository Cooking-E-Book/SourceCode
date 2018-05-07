package com.telerikacademy.io;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class RecipeBox extends JFrame {

    private final JFrame frame = new JFrame();

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

    public void writeRecipe(String filepath, String output) {
        File file = new File(filepath);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(file);
            printWriter.println(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

}
