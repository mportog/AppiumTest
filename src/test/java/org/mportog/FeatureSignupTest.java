package org.mportog;

import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.junit.Test;
import org.mportog.PageObject.LoginPageObject;
import org.mportog.PageObject.SignupPageObject;

import static org.junit.Assert.assertEquals;

public class FeatureSignupTest {
    public FeatureSignupTest() {
    }

    private AppiumDriver driver;
    private LoginPageObject loginPO;
    private SignupPageObject signupPO;

    @Before
    public void Setup() {
        driver = AppiumDriverConfig.Instance().driver;
    }

    @Test
    public void should_display_error_on_signup_when_passwords_do_not_match() {

        loginPO = new LoginPageObject(driver);
        loginPO.FetchElements();
        signupPO = loginPO.NavigateToSignup();

        signupPO.FetchElements();
        signupPO.Signup("Porto", "123", "456");

        assertEquals("Senhas não conferem", signupPO.GetErrorMessage());

        signupPO.pressBackButton();
    }

    @Test
    public void should_display_home_screen_on_successful_signup() {

        loginPO = new LoginPageObject(driver);
        loginPO.FetchElements();
        signupPO = loginPO.NavigateToSignup();

        signupPO.FetchElements();
        loginPO = signupPO.Signup("Porto", "123", "123");
        loginPO.FetchElements();
    }
}
