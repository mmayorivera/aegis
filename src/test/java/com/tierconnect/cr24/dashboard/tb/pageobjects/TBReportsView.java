package com.tierconnect.cr24.dashboard.tb.pageobjects;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TBReportsView extends TestBenchTestCase {

    public TBReportsView(WebDriver driver) {
        setDriver(driver);

    }

    public boolean isDisplayed() {
        return findElement(By.className("reports")).isDisplayed();
    }

    public boolean hasReportForTitle(String title) {
        return !findElements(By.xpath("//div[text() = \"" + title + "\"]"))
                .isEmpty();
    }

    public void createReportFromDraft() {
        findElement(By.cssSelector(".draft-thumb img")).click();
    }

    public TBConfirmDialog closeReport() {
        findElement(By.cssSelector(".v-tabsheet-caption-close")).click();
        return new TBConfirmDialog(driver);
    }

    public void createEmptyReport() {
        $(ButtonElement.class).caption("Create New").first().click();
    }

    public TBTextBlock addTextBlock() {
        findElements(By.xpath("//div[text() = \"Text Block\"]")).get(0).click();
        return new TBTextBlock(driver);
    }

}
