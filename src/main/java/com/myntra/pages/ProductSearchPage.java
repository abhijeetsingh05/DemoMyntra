package com.myntra.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.myntra.base.Driver;

public class ProductSearchPage extends BasePage {
	public static Logger log = LogManager.getLogger(ProductSearchPage.class.getName());

	@FindBy(xpath = "//*[@class = 'gender-list']/li")
	private List<WebElement> ListOfGenderFilter;
	@FindBy(className = "sort-sortBy")
	private WebElement sortByDropDown;
	@FindBy(css = "._1xHtJz:nth-child(2)")
	private WebElement RelevanceFilter;
	@FindBy(css = "._1xHtJz:nth-child(3)")
	private WebElement popularityFilter;
	@FindBy(xpath = "//*[contains(text() ,'Price: Low to High')]")
	private WebElement priceLowToHighFilter;
	@FindBy(css = "._1xHtJz:nth-child(5)")
	private WebElement priceHighToLowFilter;
	@FindBy(css = "._1xHtJz:nth-child(6)")
	private WebElement newArrivalFilter;

	@FindBy(css = "._3vKPvR")
	private WebElement searchProductByBrand;

	@FindBy(xpath = "//span[text()='Price: Low to High']")
	private WebElement checkFilterApplied;

	public ProductSearchPage() {
		driver = Driver.driver;
		PageFactory.initElements(driver, this);
	}

	public void isAllGenderFilterOptionsIsDisplay() {
		log.info("Page load with search result and filters in left side pf page");
		waitForListOfElementToBeDisplay(ListOfGenderFilter);
		ListOfGenderFilter.forEach(e -> Assert.assertTrue(e.isDisplayed()));

	}

	public void selectRelevanceFilter() {
		waitForElementToBeDisplay(RelevanceFilter);
		jsClick(RelevanceFilter);
	}

	public void selectPopularityFilter() {
		waitForElementToBeDisplay(popularityFilter);
		jsClick(popularityFilter);
		Assert.assertEquals(checkFilterApplied.getText(), popularityFilter.getText(),
				String.format(" %s filter is not working", popularityFilter.getText()));

	}

	public void sortPriceLowToHigh() {
		waitForElementToBeDisplay(sortByDropDown);
		sortByDropDown.click();
		waitForElementToBeDisplay(priceLowToHighFilter);
		jsClick(priceLowToHighFilter);
		waitForElementToBeVisible(checkFilterApplied);
		
		wait(2000);
		Assert.assertEquals(checkFilterApplied.getText(), priceLowToHighFilter.getText(),
				String.format(" %s filter is not working", priceLowToHighFilter.getText()));
	}

	public void selectPriceHighToLowFilter() {
		waitForElementToBeDisplay(priceHighToLowFilter);
		jsClick(priceHighToLowFilter);
		Assert.assertEquals(checkFilterApplied.getText(), priceHighToLowFilter.getText(),
				String.format(" %s filter is not working", priceHighToLowFilter.getText()));

	}

	public void selectNewArrivalFilter() {
		waitForElementToBeDisplay(newArrivalFilter);
		jsClick(newArrivalFilter);
		Assert.assertEquals(checkFilterApplied.getText(), newArrivalFilter.getText(),
				String.format(" %s filter is not working", newArrivalFilter.getText()));

	}

	public void searchProductByBrand(String brand) {
		waitForElementToBeDisplay(searchProductByBrand);
		searchProductByBrand.sendKeys(brand);

	}

}
