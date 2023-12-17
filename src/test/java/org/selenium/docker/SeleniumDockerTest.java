package org.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.testng.annotations.Test;

import utility.ReadProperties;

import java.io.IOException;
import java.net.MalformedURLException;


public class SeleniumDockerTest {

    public String Username= ReadProperties.getUsername();
    public String Password= ReadProperties.getPassword();
    public String URL= ReadProperties.getURL();
    public String RunMode= ReadProperties.PrintMavenEnvProperties();

    public String HostURL= ReadProperties.getHostURL();
    public RemoteWebDriver driver;

    public RemoteWebDriver setDriverCapabilities() throws MalformedURLException {
        URL url = new URL("http://localhost:4444");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("firefox");
        return new RemoteWebDriver(url, cap);
    }
    @Test
    public void TestJobPortal() throws IOException {

        System.out.println(URL);
        System.out.println(Username);
        System.out.println(Password);
        System.out.println(RunMode);
        System.out.println("=====================Test Class=======================");

        if(RunMode.equalsIgnoreCase("LOCAL")){
            driver = new ChromeDriver();
            System.out.println("Hit Chrome Browser");
        } else if (RunMode.equalsIgnoreCase("DOCKER")) {
           driver = setDriverCapabilities();
        } else{
            System.out.println("Given Run time parameter is w=not correct");
        }


    /*    URL url = new URL("http://localhost:4444");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("firefox");
        driver = new RemoteWebDriver(url, cap);

        driver = new ChromeDriver();
   */
        System.out.println("Hitting Alchemy URL");
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        System.out.println("Loading Alchemy URL");
        driver.manage().window().maximize();
        driver.findElement(By.id("user_login")).sendKeys(Username);
        driver.findElement(By.id("user_pass")).sendKeys(Password);
        driver.findElement(By.id("wp-submit")).click();
        System.out.println(driver.getTitle());
        driver.close();
    }
}