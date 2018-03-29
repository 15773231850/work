package com.read;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class read4 {
    public static void main (String args[]){
        String  pathname="U:/testsftp/SFTPUtil.txt";
        File filename =new File(pathname);
        Reader reader = null;
        List lt=new LinkedList() ;
        try{
            String encoding="UTF-8";
            reader = new InputStreamReader(new FileInputStream(filename),encoding);
            //BufferedReader tr= new BufferedReader(reader);
          int ch;

            while(reader.read()!=-1){
                ch=(char)reader.read();
                System.out.print(ch);
                // lt.add(ch);

            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
       //System.out.print(lt);
    }



}
