package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class RemoveContactTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (!applicationManager.getUserhelper().isLoginRegistrationSuccess())
            applicationManager.getUserhelper().login(new User().withEmail("bobik@gmail.com").withPassword("Bobik12345$"));
        applicationManager.contact().createContacts();

    }
    @Test
    public void removeOneContact(){
    Assert.assertEquals(applicationManager.contact().removeContact(),1);
    }

    @Test
    public void removeAllContacts(){applicationManager.contact().remooveAllcontacts();}
}
