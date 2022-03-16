package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @Test
    public void loginSuccsess() {
//        //open login form
//         WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
//        loginItem.click();
//        //type email fill
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("bobik@gmail.com");
//        //type password fill
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Bobik12345$");
//        //click login button
//        wd.findElement(By.xpath("//*[text()=' Login']")).click();
//        //assert
//        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
//
    }

    @Test
    public void loginSuccessNew() {
        //open login registration form
       applicationManager.getUserhelper().openLoginRegistrationform();
       //fill form
       applicationManager.getUserhelper().fillLogonRegistrationForm("bobik@gmail.com","Bobik12345$");
       //click login button
       applicationManager.getUserhelper().submitLogin();
        Assert.assertTrue(applicationManager.getUserhelper().isLoginRegistrationSuccess());
    }
}
