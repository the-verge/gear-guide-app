package com.verge.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlayersPage extends Page {

    private static final String PLAYER_SELECTOR = "player";
    private static final String PLAYER_NAME_SELECTOR = "player-name";
    private static final String PLAYER_ICON_SELECTOR = "player-icon";

    public PlayersPage(WebDriver browser) {
        super(browser);
    }

    public void navigateToPlayer(String playerName) {
        List<WebElement> players = getPlayers();

        for (WebElement playerElement : players) {
            WebElement nameElement = getName(playerElement);
            String nameText = nameElement.getText();
            if (nameText.equals(playerName)) {
                WebElement icon = getIcon(playerElement);
                icon.click();
                break;
            }
        }
    }

    private List<WebElement> getPlayers() {
        return browser.findElements(By.className(PLAYER_SELECTOR));
    }

    private WebElement getName(WebElement playerElement) {
        return playerElement.findElement(By.className(PLAYER_NAME_SELECTOR));
    }

    private WebElement getIcon(WebElement playerElement) {
        return playerElement.findElement(By.className(PLAYER_ICON_SELECTOR));
    }
}
