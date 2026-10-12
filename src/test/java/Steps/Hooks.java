package Steps;

import Pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BasePage {

    @Before
    public void runsBeforeAnyTest() {
        openBrowser();
    }

    @After
    public void close_browser(Scenario scenario) {
        if (scenario.isFailed() && base_page_driver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) base_page_driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot on Failure");
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
        if (base_page_driver != null) {
            base_page_driver.quit();
        }
    }
}