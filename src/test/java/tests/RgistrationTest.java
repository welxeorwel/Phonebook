package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RgistrationTest extends TestBase {
    @Test
    public void registrationSuccess() {
        int index = (int) System.currentTimeMillis();

        applicationManager.getUserhelper().openLoginRegistrationform();
        applicationManager.getUserhelper().fillLogonRegistrationForm("bobik" + index + "@gmail.com", "Bobik12345$");
        applicationManager.getUserhelper().submitRegistration();
        Assert.assertTrue(applicationManager.getUserhelper().isLoginRegistrationSuccess());
    }

}
