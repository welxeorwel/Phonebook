package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!applicationManager.getUserhelper().isLoginRegistrationSuccess())
            applicationManager.getUserhelper().login(new User().withEmail("bobik@gmail.com").withPassword("Bobik12345$"));

    }

    @Test
    public void fillContactPositive() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact cont = Contact.builder()
                .name("Bobik")
                .lastName("Bob")
                .phone("456123456" + index)
                .email("Bobby" + index + "@gmail.com")
                .address("asdasd")
                .description("4124 ")
                .build();

        applicationManager.contact().openContactForm();
        applicationManager.contact().fillContactForm(cont);
        applicationManager.contact().pushSaveButton();
//        applicationManager.contact().contactCreateSuccessfully(cont);
        Assert.assertTrue(applicationManager.contact().isContactByName(cont.getName()));
        Assert.assertTrue(applicationManager.contact().isContactByPhone(cont.getPhone()));

    }

}
