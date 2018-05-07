package com.telerikacademy.io;

import java.io.*;

public class RecipeBox {

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
