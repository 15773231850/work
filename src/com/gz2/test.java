package com.gz2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {

    private static final Integer ONE = 1;

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        /* 读取数据 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("U:/testsftp/test/test1.log")),
                    "GBK"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                String [] names = lineTxt.split(",");


                for (String name : names) {
                    if (map.keySet().contains(name)) {
                        map.put(name, (map.get(name) + ONE));
                    } else {
                        map.put(name, ONE);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }


        /* 输出数据 */
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("U:/testsftp/test/test1.txt")),
                    "UTF-8"));

            for (String name : map.keySet()) {
                bw.write(name + " " + map.get(name));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println("write errors :" + e);
        }
        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry<String, Integer> entry = entries.next();

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }

    }}
