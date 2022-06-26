package org.mportog.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPageObject extends BasePageObject {
    private AppiumDriver driver;

    private MobileElement userNameField;
    private MobileElement userPasswordField;
    private MobileElement userConfirmPasswordField;
    private MobileElement signupButton;
    private MobileElement errorLabel;

    public SignupPageObject(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void FetchElements() {
        userNameField = findElementById("input_nome");
        userPasswordField = findElementById("input_senha");
        userConfirmPasswordField = findElementById("input_confirmar_senha");
        signupButton = findElementById("cadastro_usuario_botao_cadastrar");
    }

    private void SetSignupForm(String username, String password, String passwordConfirmation) {
        userNameField.setValue(username);
        userPasswordField.setValue(password);
        userConfirmPasswordField.setValue(passwordConfirmation);
    }

    public LoginPageObject Signup(String username, String password, String passwordConfirmation) {
        SetSignupForm(username, password, passwordConfirmation);
        signupButton.click();
        return new LoginPageObject(driver);
    }

    public String GetErrorMessage() {
        By errorId = By.id(BASE_ID + "erro_cadastro");
        Wait(10, ExpectedConditions.presenceOfElementLocated(errorId));

        errorLabel = findElementById("erro_cadastro");
        return errorLabel.getText();
    }
}
