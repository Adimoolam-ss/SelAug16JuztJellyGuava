package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class FindMergeLeadsPage extends OpentapsWrappers {
	public WebDriverWait wait;

	public FindMergeLeadsPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
/*		if (!verifyTitle("Find Leads")) {
			reportStep("This is not Find Lead Page. Look at the SnapShot", "FAIL");
		}*/
	}

	public FindMergeLeadsPage enterFistname(String data) {
		enterByName(prop.getProperty("FindMergeLead.Firstname.Name"), data);
		return this;
	}

	public FindMergeLeadsPage clickFindLeadButton() {
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("FindMergeLead.FindLeadButton.Xpath")));
		clickByXpathNoSnap(prop.getProperty("FindMergeLead.FindLeadButton.Xpath"));
		return this;
	}

	public MergeLeadPage clickFirstResultingLead() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("FindMergeLead.FirstResultingLead.Xpath")));
		clickByXpathNoSnap(prop.getProperty("FindMergeLead.FirstResultingLead.Xpath"));
		switchToParentWindow();
		return new MergeLeadPage(driver, test);
	}

}
