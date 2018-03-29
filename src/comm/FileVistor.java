package comm;

import com.test2.PropertiesUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileVistor {
    public static void main (String args[]){
        PropertiesUtil prop = new PropertiesUtil("config.properties");
        String file =prop.get("file");     //ip
        System.out.print(file);
        int rowIndex = 0;
// 读取并解析CSV文件
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            String dataInRow = scanner.nextLine();
            String[] rowData = dataInRow.split("|!");
            if (rowIndex == 0) {

            } else {

            }
            rowIndex++;
        }
        //reconHeader.setReconDetailList(reconDetailList);
    }
}
