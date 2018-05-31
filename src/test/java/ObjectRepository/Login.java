package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {


    @FindBy(id = "com.ebay.mobile:id/home")
    public WebElement Menu;

    @FindBy(id = "com.ebay.mobile:id/logo")
    public WebElement Signinlogo;

    public WebElement getMenu() {
        return Menu;
    }

    public void setMenu(WebElement menu) {
        Menu = menu;
    }

    public WebElement getSigninlogo() {
        return Signinlogo;
    }

    public void setSigninlogo(WebElement signinlogo) {
        Signinlogo = signinlogo;
    }

    @FindBy(id = "com.ebay.mobile:id/edit_text_username")
    public WebElement username;

    @FindBy(id = "com.ebay.mobile:id/edit_text_password")
    public WebElement Password;

    @FindBy(id = "com.ebay.mobile:id/button_sign_in")
    public WebElement SignIn;

    @FindBy(id = "com.ebay.mobile:id/button_google_deny")
    public WebElement NoThanksLink;





    public WebElement getUsername() {
        return username;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }

    public WebElement getPassword() {
        return Password;
    }

    public void setPassword(WebElement password) {
        Password = password;
    }

    public WebElement getSignIn() {
        return SignIn;
    }

    public void setSignIn(WebElement signIn) {
        SignIn = signIn;
    }

    public WebElement getNoThanksLink() {
        return NoThanksLink;
    }

    public void setNoThanksLink(WebElement noThanksLink) {
        NoThanksLink = noThanksLink;
    }





}
