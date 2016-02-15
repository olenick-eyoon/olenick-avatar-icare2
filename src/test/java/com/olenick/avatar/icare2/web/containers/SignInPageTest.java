package com.olenick.avatar.icare2.web.containers;

import com.olenick.avatar.icare2.SeleniumTest;
import org.junit.Test;

/**
 * Created by eyoon on 1/7/2016.
 */
public class SignInPageTest extends SeleniumTest {
    private static final String BAD_USERNAME = "invalid-user";
    private static final String BAD_PASSWORD = "invalid-password";

    @Test
    public void test_loading() {
        new SignInPage(this.driver, URL_ROOT_DEV).pageLoad();
    }

    @Test
    public void test_login() {
        new SignInPage(this.driver, URL_ROOT_DEV).pageLoad().pageSign_in(USERNAME, PASSWORD);
    }

    @Test
    public void test_login_failure() {
        new SignInPage(this.driver, URL_ROOT_DEV).pageLoad().pageSign_in(BAD_USERNAME, BAD_PASSWORD);
    }
}
