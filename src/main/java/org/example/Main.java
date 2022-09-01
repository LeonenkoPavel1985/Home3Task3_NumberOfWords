package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        String path;
        String word;

        System.out.println("Enter file path or file name:");
        path = scanner.next();

        File file = new File(path);

        System.out.println("Enter your search term:");
        word = scanner.next();
        scanner.close();

        String absPath = file.getAbsolutePath();
        System.out.println("Path to your file: " + absPath);

        if (file.exists()) {
            try (BufferedReader buffer = new BufferedReader(new FileReader(path));) {
                System.out.println("Text in the file:");
                String string = null;
                int counter = 0;
                while ((string = buffer.readLine()) != null) {
                    System.out.println(string);
                    String[] text = string.split(" ");
                    for (String t : text)
                        if (t.equals(word)) counter++;
                }
                System.out.println("Search results:");
                System.out.println("The word you entered occurs - " + counter + " once.");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("File doesn't exist.");
        }
    }
}


