package com.gz;

import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.zip.GZIPOutputStream;

public class CompressGZIP {

    public static void main(String[] args) throws FileNotFoundException,
            IOException {

        System.out.println("Creating gzip file.");
        String fileName = "U:/testsftp/test/test.txt";
        GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(
                fileName + ".gz"));
        InputStream in = UncompressGZIP.class.getClassLoader().getResourceAsStream(fileName);

        byte[] buf = new byte[1024];
        int len;
        if (buf!=null) {
        while ((len = in.read(buf))>0) {
            out.write(buf, 0, len);
        }
        in.close();

        out.finish();
        out.close();

    }
    }
}


