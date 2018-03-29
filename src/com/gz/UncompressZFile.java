package com.gz;

import java.io.BufferedOutputStream;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.FileReader;
        import java.util.zip.ZipInputStream;

    public class UncompressZFile {
    public static void main(String args[]) throws Exception {

        String fileName = "U:/testsftp/test.zip";
        ZipInputStream zip = new ZipInputStream(UncompressZFile.class
                .getClassLoader().getResourceAsStream(fileName));
        int to = fileName.lastIndexOf('.');

        String toFileName = fileName.substring(0, to);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(toFileName));
        int b;
        byte[] d = new byte[1024];
        try {

            while ((b = zip.read(d)) > 0) {
                bos.write(d, 0, b);
            }

        } catch (Exception err) {
        }
        zip.close();
        bos.close();

        File file = new File(toFileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader buffferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = buffferedReader.readLine()) != null) {
            System.out.println(line);
        }
        buffferedReader.close();
        fileReader.close();
    }}
