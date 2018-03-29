package com.test2;



public class FTPTest  {

    public static void main(String[] args)   {
        PropertiesUtil prop = new PropertiesUtil("config.properties");
        String hostname =prop.get("hostname");     //ip
        int port = 21;                         //端口
        String username = prop.get("username");            //帐号
        String password = prop.get("password");            //密码
        String pathname = prop.get("pathname");            //上传文件目录
        String filename = prop.get("filename");         //下载文件
        String originfilename = prop.get("originfilename");   //上传文地址
        String localpath = prop.get("localpath");             //下载文件地址

        //上传
        FTPUtil.uploadFileFromProduction(hostname, port, username, password, pathname, filename, originfilename);
        System.out.println("上传成功"+"到"+pathname);

       //下载
       FTPUtil.downloadFile(hostname, port, username, password, pathname, filename, localpath);
       System.out.println("下载成功");
    }

}