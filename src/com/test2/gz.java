package com.test2;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class gz {
    PropertiesUtil prop = new PropertiesUtil("config.properties");
    String inputpath =prop.get("inputpath");
     String outputpath =prop.get("outputpath");

    public static void main(String args[]) throws IOException {
            //定义要压缩的文件 (必须要有,否者会有异常,要判断);
            File file = new File("U:/testsftp/test" + File.separator + "test1.txt");

            //定义压缩文件的名称
            File zipFile = new File("U:/testsftp/test" + File.separator + "test1.zip");

            //定义输入文件流
            InputStream input = new FileInputStream(file);

            //定义压缩输出流
            ZipOutputStream zipOut = null;

            //实例化压缩输出流,并制定压缩文件的输出路径  就是D盘下,名字叫 demo.zip
            zipOut = new ZipOutputStream(new FileOutputStream(zipFile));

            zipOut.putNextEntry(new ZipEntry(file.getName()));
            System.out.println("压缩成功");
        }
    }
