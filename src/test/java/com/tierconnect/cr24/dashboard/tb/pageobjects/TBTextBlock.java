package com.tierconnect.cr24.dashboard.tb.pageobjects;

import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;
import com.vaadin.testbench.elements.RichTextAreaElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TBTextBlock extends TestBenchTestCase {

    private final TestBenchElement scope;

    public TBTextBlock(WebDriver driver) {
        setDriver(driver);
        scope = (TestBenchElement) findElement(By
                .cssSelector(".inline-text-editor"));
    }

    public void setValue(String value) {
        RichTextAreaElement rta = scope.$(RichTextAreaElement.class).first();
        WebElement iframe = rta.findElement(By.tagName("iframe"));
        iframe.click();
        iframe.sendKeys(Keys.BACK_SPACE);
        iframe.sendKeys(value);
        iframe.sendKeys(Keys.TAB);
    }

    public void save() {
        scope.$(ButtonElement.class).caption("Save").first().click();
    }

    public String getLabelContent() {
        return scope.$(LabelElement.class).first().getText();
    }

}
