package com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class test3 {

    /**
     * @param args
     */
    public static boolean main(String[] args) throws Exception{
        JSch jsch = new JSch();

        Session session = jsch.getSession("yxxyxx", "172.16.2.2");
        session.setPassword("yxxyxx");
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp)session.openChannel("sftp");
        channelSftp.connect();
        channelSftp.setFilenameEncoding("UTF-8");

        Vector vector  = channelSftp.ls("/");
        try{
            for(Object obj :vector){
                if(obj instanceof com.jcraft.jsch.ChannelSftp.LsEntry){
                    String fileName = ((com.jcraft.jsch.ChannelSftp.LsEntry)obj).getFilename();
                    System.out.println(fileName);
                }
            }
        }
        finally{
            channelSftp.quit();
            session.disconnect();
        }
        String hostname = "172.16.2.2";
        int port = 22;
        String username = "yxxyxx";
        String password = "yxxyxx";
        String pathname = "/";
        String filename = "test.txt";
        //String originfilename = "C:\\test1.txt";
        boolean flag = false;
        FTPClient ftpClient = new FTPClient();
        try {
            //连接FTP服务器
            ftpClient.connect(hostname, port);
            //登录FTP服务器
            ftpClient.login(username, password);
            //验证FTP服务器是否登录成功
            int replyCode = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                return flag;
            }
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for(FTPFile file : ftpFiles){
                if(filename.equalsIgnoreCase(file.getName())){
                    File localFile = new File( "/" + file.getName());
                    OutputStream os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(ftpClient.isConnected()){
                try {
                    ftpClient.logout();
                } catch (IOException e) {

                }
            }
        }
        return flag;
    }
    }

