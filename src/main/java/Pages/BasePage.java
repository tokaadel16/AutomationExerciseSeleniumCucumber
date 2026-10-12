package Pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    public static WebDriver base_page_driver;
    public static Properties props = new Properties();


    public BasePage() {
        try {
            File file = new File("src/main/java/Properities/config.properities");
            FileInputStream fis = new FileInputStream(file);
            props.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openBrowser() {
        if (props.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            base_page_driver = new ChromeDriver();
            base_page_driver.manage().window().maximize();
            base_page_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            base_page_driver.get(props.getProperty("URL"));
        } else if (props.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            base_page_driver = new FirefoxDriver();
            base_page_driver.manage().window().maximize();
            base_page_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            base_page_driver.get(props.getProperty("URL"));
        } else {
            throw new Error("Browser not Supported");
        }
    }

    //Scroll Down
    public void scroll_down() {
        JavascriptExecutor js = (JavascriptExecutor) base_page_driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Wait Elements
    public void wait_element(WebDriver driver, int time, WebElement element_name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element_name));
    }

    //Get Validation Message
    public String getValidationMessage(WebElement element) {
        return (String) ((JavascriptExecutor) base_page_driver).executeScript("return arguments[0].validationMessage;", element);
    }
}
