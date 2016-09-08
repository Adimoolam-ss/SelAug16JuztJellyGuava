package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class ViewLeadPage extends OpentapsWrappers {

	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver; 
		this.test = test;
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is not View Lead Page. Look at the SnapShot", "FAIL");
		}
	}

	public EditLeadPage clickEdit() {
		clickByLink(prop.getProperty("ViewLead.Edit.Link"));
		return new EditLeadPage(driver,test) ;
	}
	public ViewLeadPage verifyFName(String data) {
		verifyTextContainsById(prop.getProperty("ViewLead.FirstName.ID"),data);
		return this;
	}
	

	public ViewLeadPage verifySources(String data) {
		verifyTextContainsById(prop.getProperty("ViewLead.Sources.ID"),data);
		return this;
	}

	public ViewLeadPage verifyMarketingCampaigns(String data) {
		verifyTextContainsById(prop.getProperty("ViewLead.Marketing.ID"),data);
		return this;
	}

	

	public MyLeadsPage clickDelete() throws InterruptedException {
		clickByLink(prop.getProperty("ViewLead.Delete.Link"));
		return new MyLeadsPage(driver,test);

	}


}
