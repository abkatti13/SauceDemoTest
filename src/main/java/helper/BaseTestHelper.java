package helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTestHelper {

    public static void CreateFolder(String path)  {
        //File is a class inside java.io package
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();//mkdir is used to create folder
        } else
            System.out.println("Folder already created");
    }

    public static String Timestamp() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        return formatter.format(now);
    }

}
