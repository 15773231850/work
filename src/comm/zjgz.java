package comm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
//注意要将文件保存为utf-8，txt文件的默认保存为ANSI.要改成urf-8不然会像file:ziptestfile/fileInZip.txt
public class zjgz {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        zjgz rz=new zjgz();
        rz.readZipContext();
    }
    public void readZipContext() throws IOException{
        String zipPath="U:/testsftp/test1.zip";
        ZipFile zf=new ZipFile(zipPath);

        InputStream in=new BufferedInputStream(new FileInputStream(zipPath));
        ZipInputStream zin=new ZipInputStream(in);
        //ZipEntry 类用于表示 ZIP 文件条目。
        ZipEntry ze;
        while((ze=zin.getNextEntry())!=null){
            if(ze.isDirectory()){
                //为空的文件夹什么都不做
                System.out.print(ze);
            }else{

                System.err.println("file:"+ze.getName()+"\nsize:"+ze.getSize()+"bytes");
                if(ze.getSize()>0){
                    BufferedReader reader;
                    try {
                        reader = new BufferedReader(new InputStreamReader(zf.getInputStream(ze), "utf-8"));
                        String line=null;
                        while((line=reader.readLine())!=null){
                            System.out.println(line);
                        }
                        reader.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}