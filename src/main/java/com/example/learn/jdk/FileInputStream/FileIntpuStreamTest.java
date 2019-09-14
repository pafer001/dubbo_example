package com.example.learn.jdk.FileInputStream;

import java.io.File;
import java.io.FileInputStream;

public class FileIntpuStreamTest {


    public static void main(String[] args) {

        String path = "/home/wangzhenya/IdeaProjects/core_java/src/main/java/com/own/learn/jdk/FileInputStream/11";
        System.out.println(readFile(path));
    }

    public static String readFile(String path) {
        FileInputStream inputStream = null;
        try {
            File file = new File(path);
            inputStream = new FileInputStream(file);
            Long filelength = file.length();
            byte[] fileContent = new byte[filelength.intValue()];
            int read = inputStream.read(fileContent);
            return new String(fileContent);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return "";


    }
}
