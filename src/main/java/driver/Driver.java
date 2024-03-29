package driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browsers) {

        if (drivers.get() == null) {
            switch (browsers) {
                case EDGE:
                    //WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case FIREFOX:
                    //WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                case SAFARI:
                    //WebDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver());
                    break;
                default:
                    //WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--start-maximized");
                    //options.addArguments("--headless");
                   // options.addArguments("user-data-dir=C:\\Users\\Haldun35\\AppData\\Local\\Google\\Chrome\\User Data");
                    drivers.set(new ChromeDriver(options));
                    break;
            }
        }
        waits.set(new WebDriverWait(drivers.get(), Duration.ofSeconds(10), Duration.ofMillis(100)));
        return drivers.get();
    }

    public static WebDriverWait getWait(){
        return waits.get();
    }

    public static void quitDriver(){
        if (drivers.get() != null){
            drivers.get().quit();
            drivers.set(null);
            waits.set(null);
        }
    }
}
