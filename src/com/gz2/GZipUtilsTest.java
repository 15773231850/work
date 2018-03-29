package com.gz2;

import static java.lang.System.*;
import static org.junit.Assert.assertEquals;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * @author <a href="mailto:zlex.dongliang@gmail.com">梁栋</a>
 * @since 1.0
 */
public class GZipUtilsTest {

    private String inputStr = "zlex@zlex.org,snowolf@zlex.org,zlex.snowolf@zlex.org";

    @Test
    public final void testDataCompress() throws Exception {

        err.println("原文:\t" + inputStr);

        byte[] input = inputStr.getBytes();
        err.println("长度:\t" + input.length);

        byte[] data = GZipUtils.compress(input);
        err.println("压缩后:\t");
        err.println("长度:\t" + data.length);

        byte[] output = GZipUtils.decompress(data);
        String outputStr = new String(output);
        err.println("解压缩后:\t" + outputStr);
        err.println("长度:\t" + output.length);

        assertEquals(inputStr, outputStr);

    }

    @Test
    public final void testFileCompress() throws Exception {

        FileOutputStream fos = new FileOutputStream("U:/testsftp/test/test1.txt");

        fos.write(inputStr.getBytes());
        fos.flush();
        fos.close();

        GZipUtils.compress("U:/testsftp/test/test1.txt", false);

        GZipUtils.decompress("U:/testsftp/test/test1.txt.gz", false);

        File file = new File("U:/testsftp/test/test1.txt");

        FileInputStream fis = new FileInputStream(file);

        DataInputStream dis = new DataInputStream(fis);

        byte[] data = new byte[(int) file.length()];
        dis.readFully(data);

        fis.close();

        String outputStr = new String(data);
        assertEquals(inputStr, outputStr);


    }


}
