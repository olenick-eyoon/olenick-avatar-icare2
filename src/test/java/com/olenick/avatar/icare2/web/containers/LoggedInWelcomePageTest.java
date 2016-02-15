package com.olenick.avatar.icare2.web.containers;

import org.junit.Test;

import com.olenick.avatar.icare2.SeleniumTest;

public class LoggedInWelcomePageTest extends SeleniumTest {
    @Test
    public void test_open() {
        new LoginPage(this.driver, URL_ROOT_DEV).open()
                .login(USERNAME, PASSWORD).waitForElementsToLoad();
    }

    @Test
    public void test_open_patient_experience_tab() {
        new LoginPage(this.driver, URL_ROOT_DEV).open()
                .login(USERNAME, PASSWORD).waitForElementsToLoad()
                .navigateToPatientExperienceTab().waitForElementsToLoad();
    }

    @Test
    public void test_open_home_tab() {
        new LoginPage(this.driver, URL_ROOT_DEV).open()
                .login(USERNAME, PASSWORD).waitForElementsToLoad()
                .navigateToHomeTab().waitForElementsToLoad();
    }

}
