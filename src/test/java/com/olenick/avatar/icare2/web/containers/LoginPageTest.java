package com.olenick.avatar.icare2.web.containers;

import org.junit.Test;

import com.olenick.avatar.icare2.SeleniumTest;

public class LoginPageTest extends SeleniumTest {
    private static final String BAD_USERNAME = "invalid-user";
    private static final String BAD_PASSWORD = "invalid-password";

    @Test
    public void test_loading() {
        new LoginPage(this.driver, URL_ROOT_DEV).open().waitForElementsToLoad();
    }

    @Test
    public void test_login() {
        new LoginPage(this.driver, URL_ROOT_DEV).open()
                .login(USERNAME, PASSWORD).waitForPageComplete();
    }

    @Test
    public void test_login_failure() {
        new LoginPage(this.driver, URL_ROOT_DEV).open().loginFailure(
                BAD_USERNAME, BAD_PASSWORD);
    }
}
