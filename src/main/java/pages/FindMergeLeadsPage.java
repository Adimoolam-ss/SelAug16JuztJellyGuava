package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class FindMergeLeadsPage extends OpentapsWrappers {

	public FindMergeLeadsPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Find Leads")) {
			reportStep("This is not Find Lead Page. Look at the SnapShot", "FAIL");
		}
	}

	public FindMergeLeadsPage enterFistname(String data) {
		enterByName(prop.getProperty("FindMergeLead.Firstname.Name"), data);
		return this;
	}

	public FindMergeLeadsPage ClickFindLeadButton() {
		clickByXpath(prop.getProperty("FindMergeLead.FindLeadButton.Xpath"));
		return this;
	}

	public MergeLeadPage ClickFirstResultingLead() {
		clickByXpath(prop.getProperty("FindMergeLead.FirstResultingLead.Xpath"));
		switchToParentWindow();
		return new MergeLeadPage(driver, test);
	}

}
