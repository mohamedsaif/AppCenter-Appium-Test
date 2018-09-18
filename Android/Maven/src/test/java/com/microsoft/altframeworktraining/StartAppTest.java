package com.microsoft.altframeworktraining;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Transient;
import java.net.MalformedURLException;
import java.net.URL;


import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;


public class StartAppTest {
    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    private static EnhancedAndroidDriver<MobileElement> driver;


    @Before
    public void setUp() throws Exception
    {
        driver = getDriver();
    }

    public static EnhancedAndroidDriver<MobileElement> getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = androidCaps();

        URL url = new URL("http://localhost:4723/wd/hub");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return Factory.createAndroidDriver(url, capabilities);
    }

    private static DesiredCapabilities androidCaps() throws MalformedURLException {
        // File classpathRoot = new File(System.getProperty("user.dir"));
        // File appDir = new File(classpathRoot, "../../../apps/");
        // File app = new File(appDir.getCanonicalPath(), "VodQA.apk");
        // DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("deviceName", "Android");
        // capabilities.setCapability("app", app.getAbsolutePath());
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "5554");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/saif/Dev/AppCenter-Test-Samples/Appium/Android/swiftnotes.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        return capabilities;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void noteCreationTest() throws MalformedURLException, InterruptedException {
        
        driver.label("App Launched");

        //MobileElement elem = Util.findByByOrName(driver, By.id("com.moonpi.swiftnotes:id/newNote"), "+");
        //MobileElement elem = Util.findByByOrName(driver, By.id("com.moonpi.swiftnotes:id/newNote"), "New note");
        //MobileElement elem = Util.findByName(driver, "New note");// driver.findElementByAccessibilityId("New note");
        ////android.widget.ImageButton[@content-desc="New note"]
        
        Thread.sleep(3000);

        MobileElement elem = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New note\"]");
        elem.click();

        Thread.sleep(3000);
        
        driver.label("New Note");
        
        MobileElement el1 = (MobileElement) driver.findElementById("com.moonpi.swiftnotes:id/titleEdit");
        el1.click();
        el1.sendKeys("App Center Appium Test");
        Thread.sleep(3000);     
        
        MobileElement el2 = (MobileElement) driver.findElementById("com.moonpi.swiftnotes:id/bodyEdit");
        //MobileElement el2 = (MobileElement) driver.findElementById("com.moonpi.swiftnotes:id/scrollView");
        el2.click();
        el2.sendKeys("Upload Appium tests to App Center");
        Thread.sleep(3000);
        
        driver.label("New Note - Info Entered");

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageButton");
        el3.click();
        Thread.sleep(3000);

        driver.label("New Note - Save Confirmation");

        MobileElement el4 = (MobileElement) driver.findElementById("android:id/button1");
        el4.click();
        Thread.sleep(3000);

        driver.label("New Note - Saved");

        MobileElement el5 = (MobileElement) driver.findElementById("com.moonpi.swiftnotes:id/relativeLayout");
        el5.click();
        Thread.sleep(3000);

        driver.label("New Note - Details");

        
    }

    @After
    public void after() throws Exception {
        if (driver != null) {
            //driver.label("Test Completed");
            driver.quit();
        }
    }
}
