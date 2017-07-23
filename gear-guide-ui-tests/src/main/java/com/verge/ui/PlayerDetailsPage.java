package com.verge.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerDetailsPage extends Page {

    private static final String GUITAR_TAB_SELECTOR = "player-details-guitar-tab";
    private static final String AMPLIFIER_TAB_SELECTOR = "player-details-amplifier-tab";
    private static final String GUITAR_MODEL_SELECTOR = "player-details-guitar-model";
    private static final String AMPLIFIER_MODEL_SELECTOR = "player-details-amplifier-model";

    public PlayerDetailsPage(WebDriver browser) {
        super(browser);
    }

    public boolean hasGuitars(List<String> guitars) {
        List<String> guitarNamesFromPage = getGuitarNames();
        boolean sizesMatch = guitarNamesFromPage.size() == guitars.size();
        boolean guitarsMatch = guitarNamesFromPage.containsAll(guitars);

        return sizesMatch && guitarsMatch;
    }

    public boolean hasAmplifiers(List<String> amplifiers) {
        List<String> ampNamesFromPage = getAmplifierNames();
        boolean sizesMatch = ampNamesFromPage.size() == amplifiers.size();
        boolean ampsMatch = ampNamesFromPage.containsAll(amplifiers);

        return sizesMatch && ampsMatch;
    }

    public void showGuitars() {
        browser.findElement(By.className(GUITAR_TAB_SELECTOR)).click();
    }

    public void showAmps() {
        browser.findElement(By.className(AMPLIFIER_TAB_SELECTOR)).click();
    }

    private List<String> getGuitarNames() {
        return getNames(GUITAR_MODEL_SELECTOR);
    }

    private List<String> getAmplifierNames() {
        return getNames(AMPLIFIER_MODEL_SELECTOR);
    }

    private List<String> getNames(String selector) {
        List<WebElement> elements = browser.findElements(By.className(selector));
        return elements.stream()
                .map(g -> g.getText())
                .collect(Collectors.toList());
    }

}
