package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void fillLogonRegistrationForm(User user) {
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());
    }

    public void submitLogin() {
        //click login button
        click(By.xpath("//*[text()=' Login']"));
    }

    public boolean isLoginRegistrationSuccess() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//*[text()=' Registration']"));
    }

    public boolean isAlertDispalyed() {
        Alert alert = new WebDriverWait(wd, 5)
                .until(ExpectedConditions.alertIsPresent());
        return alert != null;
    }

    public boolean isErrorWrongFormat() {
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();
        String error = alert.getText();
        System.out.println(error);
        //ok
        alert.accept();
        //cancel
        //alert.dismiss();
        //send message
        //alert.sendKeys("Hello there");
        return error.contains("Wrong email or password format");

    }
    public void login(User user){

        openLoginRegistrationform();
        fillLogonRegistrationForm(user.getEmail(), user.getPassword());
        submitLogin();
            }
}
