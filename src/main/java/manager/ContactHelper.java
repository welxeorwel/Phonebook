package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openContactForm(){
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
    public void pushSaveButton(){
        click(By.xpath("//*[text()='Save']"));
    }
    //public boolean contactCreateSuccessfully(Contact contact){
      //  String phone = contact.getPhone();
//return isElementPresent(By.xpath("//*[text()='']"))

}
