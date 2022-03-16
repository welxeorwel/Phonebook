package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationform() {
        click(By.cssSelector("[href='/login']"));
    }


    public void fillLogonRegistrationForm(String login, String password) {
        //fill login
        type(By.xpath("//input[1]"), login);
        //fill password
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin() {
        //click login button
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isLoginRegistrationSuccess() {
       return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }
    public void submitRegistration(){
        click(By.xpath("//*[text()=' Registration']"));
    }
}
