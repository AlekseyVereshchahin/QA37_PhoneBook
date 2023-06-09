package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactsTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preConditions(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("qwerty@mail.com").withPassword("Ff12345$"));
        }
        app.helperContact().provideContacts();//if list<3 --> add 3 contacts

    }

    @Test(groups = "smoke")
    public void removeFirstContact(){
        Assert.assertEquals(app.helperContact().removeOneContact(),1);

    }

    @Test
    public void removeAllContacts(){
        app.helperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");
    }
}
