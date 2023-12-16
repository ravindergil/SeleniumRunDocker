package org.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import utility.ReadProperties;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDockerTest {

    public String Username= ReadProperties.getUsername();
    public String Password= ReadProperties.getPassword();
    public String URL= ReadProperties.getURL();
    public String RunMode= ReadProperties.getRunMode();

    public String HostURL= ReadProperties.getHostURL();
    public RemoteWebDriver driver;

    @Test
    public void TestJobPortal() throws MalformedURLException {

        System.out.println(URL);
        System.out.println(Username);
        System.out.println(Password);
        System.out.println(RunMode);
        System.out.println("=====================Test Class=======================");


    /*    URL url = new URL("http://localhost:4444");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("firefox");
        driver = new RemoteWebDriver(url, cap);
     */
        driver = new ChromeDriver();

        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.id("user_login")).sendKeys(Username);
        driver.findElement(By.id("user_pass")).sendKeys(Password);
        driver.findElement(By.id("wp-submit")).click();
        System.out.println(driver.getTitle());
        driver.close();
    }
}
