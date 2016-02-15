package com.olenick.avatar.icare2;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.olenick.selenium.drivers.ExtendedRemoteWebDriver;

public class SeleniumTest {
    protected static final String USERNAME = "ielia-test-001@olenick.com";
    protected static final String PASSWORD = "Password1";
    protected static final String URL_ROOT_DEV = "http://172.16.20.210:8080/ibi_apps";
    protected static final int TIME_TO_SLEEP_TO_ALLOW_SEEING = 3000;
    protected ExtendedRemoteWebDriver driver;

    public static void SleepToSee() {
        try {
            Thread.sleep(TIME_TO_SLEEP_TO_ALLOW_SEEING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        this.driver = new ExtendedRemoteWebDriver(new FirefoxDriver());
    }

    @After
    public void tearDown() {
        SleepToSee();
        this.driver.quit();
    }
}
