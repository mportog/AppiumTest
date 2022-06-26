package org.mportog;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Singleton class of Appium Driver Initialization
 * Use the method Instance to get AppiumDriver
 */
public class AppiumDriverConfig {
    public static final String LOCAL_HOST_BASE_URL = "http://127.0.0.1";
    public static final String PORT = ":4723";
    public static final String PARAMS_V1 = "/wd/hub";
    public static final String PARAMS_V2 = "/";
    public static final String CONNECTION_STRING_URL = LOCAL_HOST_BASE_URL + PORT + PARAMS_V1;
    public static final String APK_FILE_PATH = "C:\\Users\\Porto\\AndroidStudioProjects\\appium-test-proj\\src\\main\\resources\\alura_esporte.apk";
    public static final String AUTOMATION_NAME_VALUE = "UiAutomator2";

    public final AppiumDriver driver;
    private static AppiumDriverConfig _instance;
    private URL _connectionUrl;
    private DesiredCapabilities _desiredCapabilities;
    private File _apkFile;


    public static AppiumDriverConfig Instance() {
        if (AppiumDriverConfig._instance == null) {
            AppiumDriverConfig._instance = new AppiumDriverConfig();
        }
        return AppiumDriverConfig._instance;
    }

    private AppiumDriverConfig() {
        Initialize();
        SetCapabilities();

        driver = new AppiumDriver<>(_connectionUrl, _desiredCapabilities);
    }

    private void Initialize() {
        try {
            _connectionUrl = new URL(CONNECTION_STRING_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        _desiredCapabilities = new DesiredCapabilities();
        _apkFile = new File(APK_FILE_PATH);
    }

    private void SetCapabilities() {
        _desiredCapabilities.setCapability(MobileCapabilityType.APP, _apkFile.getAbsolutePath());
        _desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        _desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME_VALUE);
    }
}
