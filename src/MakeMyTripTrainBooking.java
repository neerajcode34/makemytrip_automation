import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class MakeMyTripTrainBooking {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\91620\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");


        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);

        // Navigate to the MakeMyTrip website
        driver.get("https://www.makemytrip.com/railways/");
        driver.get("https://www.makemytrip.com/railways/");

        driver.manage().window().maximize();

        // Verify if you have landed on the correct page
        if (driver.getTitle().contains("MakeMyTrip")) {
            System.out.println("Landed on the correct page.");
        } else {
            System.out.println("Landed on the wrong page.");
            driver.quit();
            return;
        }

        // Click on the "FROM" input
        WebElement fromCityInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]"));
        fromCityInput.click();


        Thread.sleep(1000);
        driver.findElement(
                        By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"))
                .sendKeys("Delhi");


        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // find the length of all the elements find using selector
        int length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
        System.out.println("Length of the list is: " + length);

        // define a loop to iterate through the list
        for (int i = 0; i < length; i++) {
            // find the element using index
            String element = driver.findElements(By.cssSelector(
                            "ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
                    .get(i)
                    .getText();
            System.out.println("Element is: " + element);
            // check if the element is equal to the search term
            if (element.equals("Delhi")) {
                // click on the element
                driver.findElements(By.cssSelector(
                                "ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
                        .get(i).click();
                break;
            }
        }

        // Click on the "TO" input
        WebElement toCityInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div[2]"));
        toCityInput.click();
        Thread.sleep(1000);
        driver.findElement(
                        By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"))
                .sendKeys("Lucknow");
        Thread.sleep(2000);
        length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
        System.out.println("Length of the list is: " + length);
        // define a loop to iterate through the list
        for (int i = 0; i < length; i++) {
            // find the element using index
            String element = driver.findElements(By.cssSelector(
                            "ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
                    .get(i)
                    .getText();
            System.out.println("Element is: " + element);
            // check if the element is equal to the search term
            if (element.equals("Lucknow")) {
                // click on the element
                driver.findElements(By.cssSelector(
                                "ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span"))
                        .get(i).click();
                break;
            }
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[6]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]")).click();
        length = driver.findElements(By.cssSelector("ul.travelForPopup > li")).size();
        System.out.println("Length of the list is: " + length);
        for (int i = 0; i < length; i++) {
            String element = driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).getText();
            System.out.println("Element is: " + element);
            if (element.equals("Third AC")) {
                driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i).click();
                break;
            }
        }

        // Clicking Search button
        Thread.sleep(2000);
        driver.findElement(By.xpath("// *[@id='root']/div/div[2]/div/div/div/div[2]/p/a")).click();
//        driver.close();


        Thread.sleep(5000);
        driver.quit();
    }
}

