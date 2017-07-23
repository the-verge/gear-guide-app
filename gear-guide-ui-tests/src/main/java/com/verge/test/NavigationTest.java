package com.verge.test;

import com.google.common.collect.Lists;
import com.verge.ui.PlayerDetailsPage;
import com.verge.ui.PlayersPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class NavigationTest {

    private WebDriver browser;

    @Before
    public void setUp() {
        browser = new FirefoxDriver();
        browser.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void navigateToPlayerTest() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();

        browser.get("http://localhost:8585/");

        PlayersPage playersPage = new PlayersPage(browser);
        playersPage.navigateToPlayer("Jimi Hendrix");

        PlayerDetailsPage jimiHendrix = new PlayerDetailsPage(browser);
        assertTrue(jimiHendrix.hasGuitars(Lists.newArrayList(
                "Standard Stratocaster",
                "SG Custom",
                "Standard Telecaster",
                "Les Paul Standard"
        )));

        jimiHendrix.showAmps();
        assertTrue(jimiHendrix.hasAmplifiers(Lists.newArrayList(
                "1959",
                "Bassman"
        )));

        browser.quit();
    }
}
