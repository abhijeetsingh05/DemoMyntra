package com.myntra.tests;

import static com.myntra.anotation.TesterName.ABHIJEET;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.anotation.Author;
import com.myntra.anotation.TestCaseNotes;
import com.myntra.testBase.TestBase;

public class SearchProductTestCases extends TestBase {
	
	@Author(name = ABHIJEET)
	@TestCaseNotes(Steps = "go  to myntra.com || Verify Home page title || ", expecatedResult = "Url should redirect to home page with expected page title")

	@Test(priority=0, enabled = false)
	public void verifyHomePageTitileTest() {
		log.info("verifying HomePageTitle");
		String title = homePage.pageTitle();
		log.info("Found homePageTitle->"+title);
		Assert.assertEquals(title,prop.getProperty("homePageTitle"));
		log.info("Title Verified!");
	}

	@Author(name = ABHIJEET)
	@TestCaseNotes(Steps = "go  to myntra.com || Search the shoes|| ", expecatedResult = "shoes should be display")
	@Test(priority=1, enabled = false)
	public void searchProductAsGuestUser() {

		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));

	}

	@Author(name = ABHIJEET)
	@TestCaseNotes(Steps = "go  to myntra.com || Search the shoes|| apply low to high sorting ", expecatedResult = "shoes should be display according to apply sorting")
	@Test(priority = 2, enabled = false)
	public void sortProductByPriceLowToHigh() {
		

		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));
		productSearchPage.isAllGenderFilterOptionsIsDisplay();
		productSearchPage.sortPriceLowToHigh();

	}

	@Author(name = ABHIJEET)
	@TestCaseNotes(Steps = "go  to myntra.com || Search the shoes|| filter the shoes by brand name|| click on first search product", expecatedResult = "product detail page should be display")
	@Test(priority = 3, enabled = false)
	public void filterProductByBrand() throws InterruptedException {
		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));
		productSearchPage.isAllGenderFilterOptionsIsDisplay();
		productDetailPage.searchBrand(prop.getProperty("brand"));
		productDetailPage.clickOnFirstSearchProduct();

	}

	@Author(name = ABHIJEET)
	@TestCaseNotes(Steps = "go  to myntra.com || Search the shoes|| select first searched product", expecatedResult = "product detail page should be display")
	@Test(priority = 4, enabled = false)
	public void selectFirstSearchProduct() throws InterruptedException {
		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));
		productSearchPage.isAllGenderFilterOptionsIsDisplay();
		productDetailPage.searchBrand(prop.getProperty("brand"));
		productDetailPage.clickOnFirstSearchProduct();
		productDetailPage.selectSizeOfProduct(prop.getProperty("size"));
		productDetailPage.clickOnaddToBagButton();
		Thread.sleep(18000);

	}
	
	@Author(name = ABHIJEET)
	@TestCaseNotes(Steps = "go  to myntra.com || Search the shoes|| select first searched product|| Add to Bag" , expecatedResult = "product detail page should be display")
	@Test(priority = 5)
	public void checkOutFromCart() throws InterruptedException {
		homePage.searchProductSearchTextBox(prop.getProperty("productSearch"));
		productSearchPage.isAllGenderFilterOptionsIsDisplay();
		productDetailPage.searchBrand(prop.getProperty("brand"));
		productDetailPage.clickOnFirstSearchProduct();
		productDetailPage.selectSizeOfProduct(prop.getProperty("size"));
		productDetailPage.clickOnaddToBagButton();
		mybagpage.checkOut(prop.getProperty("brand"));
		

	}
}
