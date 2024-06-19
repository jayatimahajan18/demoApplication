package com.TestRunner.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class mmt {
    public static void main(String[] args){

        System.setProperty("driver.chrome.drive","C:\\Users\\jayati.mahajan\\Documents\\Automation\\DesktopApplication_CRM\\src\\test\\resources\\Driver\\chrome\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.className("menu_Hotels")).click();
        driver.findElement(By.className("hsw_inputField lineHeight36 latoBlack font32")).click();
        driver.findElement(By.className("hsw_inputField lineHeight36 latoBlack font32")).sendKeys("ban");
        WebElement from= driver.findElement(By.xpath("//div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']//ul"));
        List<WebElement> city= from.findElements(By.xpath("//child::li"));
        for(WebElement c:city){
            if(c.getText().equals("Bangalore")){
                c.click();
                break;
            }
        }

        WebElement date=driver.findElement(By.xpath("//div[@class='DayPicker-Months']//child::div[@class='DayPicker-Month']//child::div[@class='DayPicker-Caption']"));
        List<WebElement> monthname= date.findElements(By.xpath("//div"));
    }
}
