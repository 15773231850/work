package com.test2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
public class gzip {


    public static void main(String[] args) throws IOException {

        PropertiesUtil prop = new PropertiesUtil("config.properties");

        String yasupath=prop.get("yasupath");
        String yasuoname=prop.get("yasuoname");
        //做准备压缩一个字符文件，注，这里的字符文件要是GBK编码方式的
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(
                yasupath), "UTF-8"));
        //使用GZIPOutputStream包装OutputStream流，使其具体压缩特性，最后会生成test.txt.gz压缩包
        //并且里面有一个名为test.txt的文件
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(
                new FileOutputStream(new SimpleDateFormat(
                        "现在时间:yyyy年MM月dd日E HH时mm分ss秒")+yasuoname)));
        System.out.println("开始写压缩文件...");
        int c;
        while ((c = in.read()) != -1) {

            /*
             * 注，这里是压缩一个字符文件，前面是以字符流来读的，不能直接存入c，因为c已是Unicode
             * 码，这样会丢掉信息的（当然本身编码格式就不对），所以这里要以GBK来解后再存入。
             */
            out.write(String.valueOf((char) c).getBytes("UTF-8"));
        }
        in.close();
        out.close();
        System.out.println("开始读压缩文件...");
        //使用GZIPInputStream包装InputStream流，使其具有解压特性
        BufferedReader in2 = new BufferedReader(new InputStreamReader(
                new GZIPInputStream(new FileInputStream("test.txt.gz")), "UTF-8"));
        String s;
        //读取压缩文件里的内容
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
        in2.close();
    }
}