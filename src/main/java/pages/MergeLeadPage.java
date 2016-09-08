package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class MergeLeadPage extends OpentapsWrappers {
	public WebDriverWait wait;
	
	public MergeLeadPage(RemoteWebDriver driver , ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This is not Merge Lead Page", "FAIL");
		}
	}
	
	public FindMergeLeadsPage clickFromLead(){
		clickByXpath(prop.getProperty("MergeLead.FromLead.Xpath"));
		switchToLastWindow();
		return new FindMergeLeadsPage(driver,test);
	}
	
	public FindMergeLeadsPage clickToLead(){
		clickByXpath(prop.getProperty("MergeLead.ToLead.Xpath"));
		switchToLastWindow();
		return new FindMergeLeadsPage(driver,test);
	}
	public MergeLeadPage mergeLead(){
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Merge")));
		clickByLink(prop.getProperty("MergeLead.MergeButton.Link"));
		return this;
	}
	public ViewLeadPage confirmMerge(){
		acceptAlert();
		verifyTitle("View Lead | opentaps CRM");
		return new ViewLeadPage(driver, test);
	}
}
