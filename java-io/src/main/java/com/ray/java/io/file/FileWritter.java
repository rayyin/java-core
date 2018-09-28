package com.ray.java.io.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileWritter {

    /*
     * Create file
     */
    private static void createFileUsingFileClass(String filename, String content) throws IOException
    {
        File file = new File(filename);

        //Create the file
        if (file.createNewFile()){
            System.out.println("File is created!");
        }else{
            System.out.println("File already exists.");
        }

        //Write Content
        FileWriter writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }

    private static void createFileUsingFileOutputStreamClass(String filename, String content) throws IOException
    {
        FileOutputStream out = new FileOutputStream(filename);
        out.write(content.getBytes());
        out.close();
    }

    // best way, using nio files
    private static void createFileIn_NIO(String filename, String content)  throws IOException
    {
        Path path = Paths.get(filename);
        byte[] contentBytes = content.getBytes();
        Files.write(path, content.getBytes());

        //or write with iterator (append)
        List<String> lines = Arrays.asList("1st line", "2nd line");
        Files.write(Paths.get("file6.txt"), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    // less IO operation, then improve the performance
    public static void usingBufferedWritter(String filename, String content) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(content);
        writer.close();
    }

    // directly IO operation, less performance
    public static void usingFileWriter(String filename, String content) throws IOException
    {
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(content);
        fileWriter.close();
    }

    private static void appendFileIn_NIO(String filename, List<String> lines)  throws IOException
    {
        Files.write(Paths.get(filename), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static void main(String[] args) throws IOException
    {
        String filename1 = "c://temp//testFile1.txt";
        String filename2 = "c://temp//testFile2.txt";
        String filename3 = "c://temp//testFile3.txt";
        String filename4 = "c://temp//testFile4.txt";
        String filename5 = "c://temp//testFile5.txt";
        String content = "test data";

        createFileUsingFileClass(filename1, content);
        createFileUsingFileOutputStreamClass(filename2, content);
        createFileIn_NIO(filename3, content);
        usingBufferedWritter(filename4, content);
        usingFileWriter(filename5, content);
    }





}
