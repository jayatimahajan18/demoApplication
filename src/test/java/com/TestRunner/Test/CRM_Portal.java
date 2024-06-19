package com.TestRunner.Test;

import Utilities.Base;
import Utilities.ConfigReader;
import Utilities.ReadExcelData;
import com.TestRunner.CRM.SoNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CRM_Portal extends Base {

    static SoNumber soNumber=new SoNumber();
    WiniumDriver driver;

    @BeforeTest
    public void initiliser() throws MalformedURLException {
/*
Set capabilities to run application on local evn
 */
        System.out.println("Driver setup");
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(ConfigReader.getValue("SAPLOGON_EXE"));
        driver = new WiniumDriver(new URL("http://localhost:9999"), options);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Driver setup completed");
 /*
 Opening application through taskbar
  */
        System.out.println("Opening sap logon application");
        driver.findElement(By.name("SAP Logon - 1 running window")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Windows appkication completed");
    }
    @Test
    public void CRMTest() throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {

 /*
 Created an entry of account CRM Q42 as user
 */
        System.out.println("Connecting to CRM");
        driver.findElement(By.name("Maximize")).click();
        driver.findElement(By.name("CRM Q42")).click();
        driver.findElement(By.name("Log On")).click();
        System.out.println("Connection established to CRM");

 /*
 Login functionality
 */
        //User details
        System.out.println("Login");
        driver.findElement(By.name("Maximize")).click();
        Robot robot = new Robot();
        Keyboard keyboard = driver.getKeyboard();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(1000);
        String username= ReadExcelData.getTestData();
        String userText= getClipboardText();
        System.out.println(userText);

        String user = ConfigReader.getValue("CRM_USER");
        for (char c : user.toCharArray()) {
            Thread.sleep(1050);
            keyboard.sendKeys(Character.toString(c));
            // Add a short delay between key presses (optional)
            Thread.sleep(100); // Wait for 0.1 seconds
        }
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        //Password Details
        Keyboard keyboard1 = driver.getKeyboard();
        String password = ConfigReader.getValue("CRM_PWD");
        for (char c : password.toCharArray()) {
            Thread.sleep(1000);
            keyboard1.sendKeys(Character.toString(c));
            Thread.sleep(100);
        }
        Thread.sleep(500);
        maximiseWindow(driver);
        Thread.sleep(10000);
        System.out.println("Login Successful");

        //for finding SO number
        System.out.println("Launching /nse16");
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Keyboard keyboard2 = driver.getKeyboard();
        //driver.findElement(By.id("/wnd[0]/tbar[0]/okcd")).sendKeys("/nse16");
        Thread.sleep(2000);
        String xyz = ConfigReader.getValue("CRM_TCODE");// Tcode
        for (char c : xyz.toCharArray()) {
            Thread.sleep(2000);
            keyboard2.sendKeys(Character.toString(c));
            Thread.sleep(100);
        }
        Thread.sleep(500);
        maximiseWindow(driver);
        System.out.println("Launching /nse16 completed");

        //Table to get sells order(SO) Number
        System.out.println("Loading table ");
        Keyboard keyboard3 = driver.getKeyboard();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(2000);
        String tablename = ConfigReader.getValue("CRM_Table");
        for (char c : tablename.toCharArray()) {
            keyboard3.sendKeys(Character.toString(c));
            Thread.sleep(100);
        }
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        System.out.println("table  loaded");

// Send keys to the element (assuming textInput is the desired text)
        System.out.println("Entering order number");
        String textInput = ConfigReader.getValue("ShipmentID");
        for (char c : textInput.toCharArray()) {
            Thread.sleep(500);
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
        driver.findElement(By.name("Execute")).click();
        Thread.sleep(2000);
        System.out.println("Clicked on Execute and looking for SO Nunber");
        String soOrder=soNumber.so_Number(robot);
        System.out.println(soOrder);
        ReadExcelData.writeIntoExcel(soOrder,textInput);
/*
Exist from CRM portal
 */
        System.out.println("Exiting steps started");
        for(int i=0;i<3;i++) {
            keyboardActions_ESC();
            //System.out.println(i);
            Thread.sleep(200);
        }
        System.out.println("Exit completed");
        Thread.sleep(3000);
    }


    @AfterClass
     public void shutDown(){
        driver.close();
     }

}

