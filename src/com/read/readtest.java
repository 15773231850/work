package com.read;
import sun.rmi.runtime.Log;
import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class readtest {
    public static void main(String[] args){
        readFile();  }
        //System.out.println("");

    public static void readFile(){
        try {
            File file=new File("U:/testsftp/SFTPUtil.txt");
            Reader in=new FileReader(file);
            char[] ch=new char[20];
            int len=-1;
            StringBuffer sb=new StringBuffer();
            while((len=in.read(ch))!=-1){
                sb.append(new String(ch,0,len));
            }
            in.close();
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}





