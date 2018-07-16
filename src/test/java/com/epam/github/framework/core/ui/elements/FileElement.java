package com.epam.github.framework.core.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileElement extends Element {
    
    @FindBy(xpath = ".//div[@id='last-commit']")
    private WebElement commit;
    @FindBy(xpath = ".//div[@id='last-commit']")
    private WebElement itemElement;

    public FileElement(WebElement webElement) {
        super(webElement);
    }

    public void selectItem(String itemName) {
        itemElement.click();
        //webElement.findElement(By.xpath("//tr//span/a[contains(text(), '" + itemName + "')]")).click();
    }

    public String getTimeOfCommit() {
        //selectItem(itemName);
        return commit.getText();
    }
}
