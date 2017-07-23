package com.verge.ui;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver browser;

    public Page(WebDriver browser) {
        this.browser = browser;
    }
}
