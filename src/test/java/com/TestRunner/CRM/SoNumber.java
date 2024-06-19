package com.TestRunner.CRM;

import Utilities.Base;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class SoNumber extends Base {

    public String so_Number(Robot robot) throws IOException, UnsupportedFlavorException, InterruptedException {
        System.out.println("Hovering to Column SO number");
        robot.mouseMove(1000,160);
        //left click
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        //right click
        System.out.println("Right click to copy so number");
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseMove(1080,180);
        Thread.sleep(3000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        System.out.println("Copy happen successfull");
        String soNumber= getClipboardText();
        System.out.println("SO Number is : "+soNumber);
        return soNumber;
    }
}
