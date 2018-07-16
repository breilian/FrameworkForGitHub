package com.epam.github.tests.github.page;

import com.epam.github.framework.core.ui.elements.Decorator;
import com.epam.github.framework.core.ui.elements.FileElement;
import com.epam.github.framework.core.ui.pages.BasePage;
import com.epam.github.framework.utils.TestProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Describe Repository page
 */
public class RepositoryPage extends BasePage {

    /**
     * Web elements
     */
	@FindBy(xpath = "//strong[@itemprop='name']/a")
	private WebElement repositoryNameLink;
	@FindBy(xpath = "//tr//span/a[contains(text(), '')]")
    WebElement itemElement;
    @FindBy(xpath = "//table[contains()@class,'js-navigation-container')]/tbody[2]/tr[@class='js-navigation-item']           tr//span/a[contains(text(), '')]")
    private FileElement file;

    public RepositoryPage() {
        PageFactory.initElements(new Decorator(driver), this);
    }

    /**
     * Open create repository page where
     */
    public void open() {
        driver.get(TestProperties.getTestProperty("repository.url"));
    }

    public void openItem(String fileName) {
        file.selectItem(fileName);
    }

    public String getItemLastCommit() {
        return file.getTimeOfCommit();
    }

    /**
     * Check is new Repository was create
     * @param name
     * @return
     */
    public Boolean isRepoCreate(String name) {
        return repositoryNameLink.getText().equals(name);
    }

}
