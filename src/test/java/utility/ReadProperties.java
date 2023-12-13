package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public static String fileLocation = "src/test/resources/DockerProject.properties";
    public static Properties prop;
    public static FileInputStream fis;
    public static String URL;
    public static String AdminURL;
    public static String Browser;
    public static String Username;
    public static String Password;
    public static String RunMode;

    public static String readData(String value){
        prop = new Properties();
        try {
            fis = new FileInputStream(fileLocation);
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(value);
    }

    public static String getURL(){
        return readData("URL");
    }

    public static String getHostURL(){
        return readData("HostURL");
    }

    public static String getAdminURL(){
        return readData("AdminURL");
    }

    public static String getUsername(){
        return readData("UserName");
    }

    public static String getPassword(){
        return readData("PassWord");
    }

    public static String getRunMode(){
        return readData("runInstance");
    }

    public static String getBrowser() { return readData("Browser"); }
}
