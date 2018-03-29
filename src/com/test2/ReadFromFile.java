package com.test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFromFile {
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            Map<Integer, String> map1 = new HashMap<Integer, String>();
            int line = 1; // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
               // tempString = tempString.replace('|', ' ');
                String a[] = tempString.split("\\|!");
                for (int i = 0; i < a.length; i++) {
                    System.out.print(a[i]+' ');
                    //list.add(a[i]);
                    //map1.put(line*100+i,a[i]);
                }
                line++;
                 System.out.print('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }
    public static void main(String[] args) {
        String fileName = "U:/testsftp/SFTPUtil.txt";
        readFileByLines(fileName);
    }
}