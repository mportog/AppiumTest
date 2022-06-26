package org.mportog.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

/**
 * Base Page Object class that simplify the use of mobile elements
 */
public class BasePageObject {
    private AppiumDriver driver;
    public static final String BASE_ID = "br.com.alura.aluraesporte:id/";

    public BasePageObject(AppiumDriver driver) {
    this.driver = driver;
    }

    /**
     * Finds a mobile element by the id
     * @param id Short id of the element
     * @return MobileElement with the provided id
     */
    public MobileElement findElementById(String id) {
        return (MobileElement) driver.findElementById(BASE_ID + id);
    }

    /**
     * Simulates a click on the device's back button
     */
    public void pressBackButton(){
        driver.navigate().back();
    }

    public void Wait(Integer maxTimeOutInSeconds, Function<? super WebDriver, ?> condition){
        WebDriverWait wait = new WebDriverWait(driver,maxTimeOutInSeconds);
        wait.until(condition);
    }
}
