package org.mportog.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPageObject extends BasePageObject {

    private MobileElement userNameField;
    private MobileElement userPasswordField;
    private MobileElement userConfirmPasswordField;
    private MobileElement signupButton;
    private MobileElement errorLabel;
    private final String inputNome;
    private final String inputSenha;
    private final String inputConfirmarSenha;
    private final String cadastroUsuarioBotaoCadastrar;
    private final String erroCadastro;

    public SignupPageObject(AppiumDriver driver) {
        super(driver);
        inputNome = "input_nome";
        inputSenha = "input_senha";
        inputConfirmarSenha = "input_confirmar_senha";
        cadastroUsuarioBotaoCadastrar = "cadastro_usuario_botao_cadastrar";
        erroCadastro = "erro_cadastro";
    }

    public void FetchElements() {
        userNameField = findElementById(inputNome);
        userPasswordField = findElementById(inputSenha);
        userConfirmPasswordField = findElementById(inputConfirmarSenha);
        signupButton = findElementById(cadastroUsuarioBotaoCadastrar);
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
        By errorId = By.id(BASE_ID + erroCadastro);
        Wait(10, ExpectedConditions.presenceOfElementLocated(errorId));

        errorLabel = findElementById(erroCadastro);
        return errorLabel.getText();
    }
}
