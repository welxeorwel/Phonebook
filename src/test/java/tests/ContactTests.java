package tests;

import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTests extends TestBase {

   @BeforeMethod
    public void precondition() {
        applicationManager.getUserhelper().openLoginRegistrationform();
        applicationManager.getUserhelper().fillLogonRegistrationForm("bobik@gmail.com", "Bobik12345$");
        applicationManager.getUserhelper().submitLogin();
        applicationManager.getUserhelper().isLoginRegistrationSuccess();

    }
    @Test
    public void fillContactPositive() {
        Contact cont = Contact.builder()
                .name("Bobik")
                .lastName("Bob")
                .phone("456123456")
                .email("wdasfasfgsg")
                .address("asdasd")
                .description("4124 ")
                .build();
        applicationManager.contact().openContactForm();
        applicationManager.contact().fillContactForm(cont);
        applicationManager.contact().pushSaveButton();
//        applicationManager.contact().contactCreateSuccessfully(cont);
    }

}
