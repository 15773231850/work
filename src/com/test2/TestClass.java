package com.test2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestClass extends Properties {

    public static void main(String[] args) {
        TestClass test = new TestClass();
        try {
            ///配置文件所在的路径
            test.getProperties(TestClass.class.getResource("/config.properties").openStream());
            //system.title配置文件中的Key可以获得Value的值
            System.out.println(test.getProperty("system.title"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void getProperties(InputStream inStream){
        try {
            this.load(inStream);
            inStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }}
