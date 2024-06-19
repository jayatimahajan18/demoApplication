package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Base {
    public static void maximiseWindow(WiniumDriver driver) throws AWTException {
        Robot enter= new Robot();
        enter.keyPress(KeyEvent.VK_ENTER);
        enter.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(By.name("Maximize")).click();
    }
    public static void keyboardActions_ESC() throws AWTException {
        Robot r= new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
    }
    public static void keyboardActions_SHFT_TAB() throws AWTException {
        Robot r= new Robot();
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_ESCAPE);
    }
    /*
    This method helps to copy text from clipboard and convert into string.
     */
    public String getClipboardText() throws IOException, UnsupportedFlavorException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        System.out.println("----"+clipboard.toString());
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }

}
