package org.mportog.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject extends BasePageObject {
    private MobileElement signingButton;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void FetchElements() {
        signingButton = findElementById("login_botao_cadastrar_usuario");
    }

    public SignupPageObject NavigateToSignup() {
        signingButton.click();
        return new SignupPageObject(driver);
    }
}
