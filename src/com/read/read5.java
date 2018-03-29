package com.read;

import java.io.*;
import java.util.Arrays;

public class read5 {


    public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub


//读取该文件的内容，存储到一个字符串中
        BufferedReader br = new BufferedReader(new FileReader("U:/testsftp/SFTPUtil.txt"));
        String line = br.readLine();
        br.close();

//把字符串转换为字符数组
        char[] chs = line.toCharArray();

//对字符数组进行排序
        //Arrays.sort(chs);

//把排序后的字符数组转换为字符串
        String s = new String(chs);

 System.out.print(s);

    }

}