package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector(".navbar-logged_nav__2Hx7M a:nth-child(5)"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());


    }

    public void pushSaveButton() {
        click(By.xpath("//*[text()='Save']"));
    }

    public boolean isContactByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))
                return true;
        }
        return false;
    }

    public boolean isContactByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }

    //public boolean contactCreateSuccessfully(Contact contact){
    //  String phone = contact.getPhone();
//return isElementPresent(By.xpath("//*[text()='']"))
    public int removeContact() {
        int countBefore = countOfContacts();
        if (!countListIsEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }
        int countAfter = countOfContacts();

        return countBefore - countAfter;
    }


    private boolean countListIsEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();

    }

    public void remooveAllcontacts() {
            while(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0){
                click(By.cssSelector(".contact-item_card__2SOIM"));
                click(By.xpath("//button[text()='Remove']"));
                pause(500);
            }
    }
//TODO complete contatcts precreation
    public void createContacts() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact cont = Contact.builder()
                .name("Bobik")
                .lastName("Bob")
                .phone("456123456" + index)
                .email("Bobby" + index + "@gmail.com")
                .address("asdasd")
                .description("4124 ")
                .build();

        openContactForm();
        fillContactForm(cont);
        pushSaveButton();
//        applicationManager.contact().contactCreateSuccessfully(cont);
        Assert.assertTrue(isContactByName(cont.getName()));
        Assert.assertTrue(isContactByPhone(cont.getPhone()));

    }
}
