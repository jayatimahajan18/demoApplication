package com.TestRunner.Test;

import Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class redbus extends Base {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jayati.mahajan\\Documents\\Automation\\DesktopApplication_CRM\\src\\test\\resources\\Driver\\chrome\\chromedriver.exe");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--disable-notifications");
        //options.addArguments("--headless");
        WebDriver driver= new ChromeDriver(options);
        driver.get("https://www.redbus.in/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        String title=driver.getTitle();
        System.out.println(title);
        driver.findElement(By.xpath("//input[@class='sc-bxivhb hrsLPT' and @id='src']")).click();
        driver.findElement(By.xpath("//input[@class='sc-bxivhb hrsLPT' and @id='src']")).sendKeys("pune");
        // direct with xpath
        Thread.sleep(5000);
        //using list and dropdown
        WebElement from = driver.findElement(By.xpath("//ul[@class='sc-dnqmqq eFEVtU']//following-sibling::li"));
        List<WebElement> lst= from.findElements(By.xpath("//child::div//child::text[1]"));
        for(WebElement e:lst){
            if(e.getText().equals("Shivaji Nagar")){
                System.out.println(e.getText());
                e.click();
                Thread.sleep(1000);
                break;
            }
           // System.out.println(e.getText());
        }
        Thread.sleep(3000);
        //using direct xpath of the dropdown value
       // driver.findElement(By.xpath("//ul[@class='sc-dnqmqq eFEVtU']//following-sibling::li[@class='sc-iwsKbI jTMXri']//child::text[contains(text(),'Shivaji Nagar')]")).click();
        driver.findElement(By.xpath("//input[@class='sc-bxivhb hrsLPT']")).click();
        driver.findElement(By.xpath("//input[@class='sc-bxivhb hrsLPT']")).sendKeys("hyd");
        Thread.sleep(4000);
        WebElement to= driver.findElement(By.xpath("//ul[@class='sc-dnqmqq eFEVtU']"));
        List<WebElement> lst1= to.findElements(By.xpath("//following-sibling::li//child::div//child::text[1]"));
        for(WebElement e: lst1){
            if(e.getText().equals("Miyapur")){
                System.out.println(e.getText());
                e.click();
                break;
            }
        }
        driver.findElement(By.xpath("//div[@class='labelCalendarContainer']")).click();
        Thread.sleep(5000);
        Boolean arrow= driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//child::div[3]")).isDisplayed();
        int flag=0;
        while(!(driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]")).getText().equals("Jul 2024"))) {
            System.out.println("Not Found Jul 2024");
            if (arrow) {
               // driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//child::div[3]")).click();
                String monthtext = driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]")).getText();
                System.out.println(monthtext);
                List<WebElement> dats = driver.findElements(By.xpath("(//span[@class='DayTilesWrapper__SpanContainer-sc-19pz9i8-0 hQhlTG'])[5]//child::span"));
                for(int i=0;i<dats.size();i++){
                    System.out.println(dats.get(i).getText());
                }
                if (monthtext.contains("Jul 2024")) {
                    System.out.println("Found Jul 2024");
                    for(int i=0;i<dats.size()-1;i++) {
                        for (WebElement date : dats) {
                            if (date.getText().equals("27")) {
                                date.click();
                                flag++;
                                System.out.println("Click on date and breaking the loop");
                                break;
                            }
                        }
                        break;
                    }
                    System.out.println("Out of loop for Jul 2024");
                } else {
                    driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//child::div[3]")).click();
                }
            } if(flag>0){
                break;
            }
        }
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@id='search_button']")).click();
        Thread.sleep(8000);

        //div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//child::div[3] -- arrow to next month
        //div[@class='DayTilesWrapper__RowWrap-sc-19pz9i8-1 fGGTDM'])[6]//child::span-- to get dates in list form and pass which ever date we want to select and perform click operation
        driver.quit();
    }
}

