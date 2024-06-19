package com.TestRunner.Test;

import Utilities.Base;
import Utilities.ConfigReader;
import Utilities.ReadExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

public class ECC_Portal extends Base {
    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        WiniumDriver driver = null;
        try {
/*
Set capabilities to run application on local evn
 */
            System.out.println("Driver setup");
            DesktopOptions options = new DesktopOptions();
            options.setApplicationPath("C:\\Program Files (x86)\\SAP\\FrontEnd\\SapGui\\saplogon.exe");
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
 /*
 Created an entry of account SAP Q22 as user
 */
            System.out.println("Connecting to CRM");
            driver.findElement(By.name("Maximize")).click();
            driver.findElement(By.name("SAP Q22")).click();
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
            String user = ConfigReader.getValue("ECC_USER");
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
            String password = ConfigReader.getValue("ECC_PWD");
            for (char c : password.toCharArray()) {
                keyboard1.sendKeys(Character.toString(c));
                Thread.sleep(100);
            }
            Thread.sleep(500);
            maximiseWindow(driver);
            Thread.sleep(8000);
            System.out.println("Login Successful");
            //for finding ecc number
            System.out.println("Launching /nvl01n");
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            Keyboard keyboard2 = driver.getKeyboard();
            Thread.sleep(2000);
            String xyz = ConfigReader.getValue("ECC_TCODE");// Tcode
            for (char c : xyz.toCharArray()) {
                Thread.sleep(2000);
                keyboard2.sendKeys(Character.toString(c));
                Thread.sleep(100);
            }
            Thread.sleep(500);
            maximiseWindow(driver);
            System.out.println("Launching /nvl01n completed");
/*
Entering So number and more details to get further data from application
 */
            String soNumber = ReadExcelData.getTestData();
            System.out.println(soNumber);
            for (char c : soNumber.toCharArray()) {
                Thread.sleep(1050);
                keyboard.sendKeys(Character.toString(c));
                // Add a short delay between key presses (optional)
                Thread.sleep(100); // Wait for 0.1 seconds
            }
            keyboardActions_SHFT_TAB();
/*
Enter shipping point for ECC portal
*/
            System.out.println("Entering details like so number, shiping point to generate cn number");
            String shippingPoint = "Y343";
            for (char c : shippingPoint.toCharArray()) {
                Thread.sleep(1050);
                keyboard.sendKeys(Character.toString(c));
                // Add a short delay between key presses (optional)
                Thread.sleep(100); // Wait for 0.1 seconds
            }
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//            Thread.sleep(5000);
//            System.out.println("CN number generated");
//            System.out.println("Copying CN number");
//            robot.mouseMove(230, 50);
//            //left click
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//            Thread.sleep(1000);
           // String error = driver.findElement(By.xpath("//*[contains(text(),'Sales order')]")).getText();
//            String cnNumber = driver.findElement(By.xpath("//*[contains(text(),'JioM Digital DelvGG')]")).getText();
//            System.out.println("CN Number    :" + cnNumber);
          //  System.out.println(error);
            System.out.println("Copied CN number");
            driver.close();
            driver.quit();
        } catch(Exception e) {
            //driver.quit();
            throw new RuntimeException(e);
        }
        finally {
            driver.quit();
        }
    }
}

