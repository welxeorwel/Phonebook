package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userhelper;
    ContactHelper contact;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        userhelper = new UserHelper(wd);
        contact = new ContactHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public UserHelper getUserhelper() {
        return userhelper;
    }

    public ContactHelper contact() {
        return contact;
    }

}