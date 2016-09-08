package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FindMergeLeadsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MergeLeadPage;
import pages.MyHomePage;
import pages.MyLeadsPage;
import wrappers.OpentapsWrappers;

public class TC007_MergeLead extends OpentapsWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser){
		browserName = browser;
		testCaseName = "TC007 Merge Lead";
		testDescription = "Merge Leads by giving two lead id's";
		category = "Sanity";
		dataSheetName = "TC007";
	}
	
	@Test(dataProvider="fetchData")
	public void mergeLead(String userName, String password, String lead1, String lead2){
		new LoginPage(driver, test)
		.login(userName, password);
		new HomePage(driver, test).clickCRMSFA();
		new MyHomePage(driver, test).clickLeads();
		new MyLeadsPage(driver, test).clickMergeLeads();
		new MergeLeadPage(driver, test).clickFromLead();
		new FindMergeLeadsPage(driver, test).enterFistname(lead1).ClickFindLeadButton().ClickFirstResultingLead();
		new MergeLeadPage(driver, test).clickToLead();
		new FindMergeLeadsPage(driver, test).enterFistname(lead2).ClickFindLeadButton().ClickFirstResultingLead();
		new MergeLeadPage(driver, test).mergeLead().confirmMerge();			
	}

}
