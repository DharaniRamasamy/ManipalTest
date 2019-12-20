package week3;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShotWeek2;
import com.training.generics.ScreenShotWeek3;
import com.training.pom.ElearningPOM;
import com.training.pom.ElearningPOMWeek3;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ElearningTestWeek3 {

	private WebDriver driver;
	private String baseUrl;
	private ElearningPOMWeek3 elearningPOMWeek3;
	private static Properties properties;
	private ScreenShotWeek3 screenShotWeek3;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/othersWeek3.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		elearningPOMWeek3 = new ElearningPOMWeek3(driver);
		baseUrl = properties.getProperty("baseURL");
		driver.get(baseUrl);
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 0, enabled = true)
	public void adminToAddNewUser_ELTC_072() throws InterruptedException, IOException, AWTException {

		String adminUserName = properties.getProperty("adminUserName");
		String adminPwd = properties.getProperty("adminPwd");
		String tcNumber = "ELTC_072";
		String expConfirmationMsg = properties.getProperty("expConfirmationMsg");
		screenShotWeek3 = new ScreenShotWeek3(driver);

		elearningPOMWeek3.login(adminUserName, adminPwd);
		Thread.sleep(4000);

		elearningPOMWeek3.fillDetailsInAddUserRoleScreen(tcNumber);
		Thread.sleep(4000);

		elearningPOMWeek3.clickAddBtn();
		Thread.sleep(4000);
		System.out.println("Add button clicked");
		screenShotWeek3.captureScreenShot("After clicking Add Button_ELTC_072");
		String actConfirmationMsg = elearningPOMWeek3.getConfirmationMsg();
		Assert.assertTrue(actConfirmationMsg.contains(expConfirmationMsg));
		System.out.println("The user has been added- message should get displayed - Verified");
		Thread.sleep(4000);
		System.out.println("End of Test case ELTC_072 !!!!");
	}

	@Test(priority = 1, enabled = true)
	public void errorMsgVerifyInAddNewUser_ELTC_083() throws InterruptedException, IOException, AWTException {

		String adminUserName = properties.getProperty("adminUserName");
		String adminPwd = properties.getProperty("adminPwd");
		String tcNumber = "ELTC_083";
		String expErrorMsg = properties.getProperty("expErrorMsg");
		screenShotWeek3 = new ScreenShotWeek3(driver);

		elearningPOMWeek3.login(adminUserName, adminPwd);
		Thread.sleep(4000);

		elearningPOMWeek3.fillDetailsInAddUserRoleScreen(tcNumber);
		Thread.sleep(4000);

		elearningPOMWeek3.clickAddBtn();
		Thread.sleep(4000);
		System.out.println("Add button clicked");
		screenShotWeek3.captureScreenShot("After clicking Add Button_ELTC_083");
		String actErrorMsg = elearningPOMWeek3.getErrorMsg();
		// Assert.assertTrue(actErrorMsg.contains(expConfirmationMsg));
		Assert.assertEquals(actErrorMsg, expErrorMsg);
		System.out.println("Error message should get displayed- Verified");
		Thread.sleep(4000);
		System.out.println("End of Test case ELTC_083 !!!!");
	}

	@Test(priority = 2, enabled = true)
	public void testCase_ELTC_071() throws Exception {

		// Login as teacher
		String teacherUserName = properties.getProperty("teacherUserName");
		String teacherPwd = properties.getProperty("teacherPwd");
		String testName = properties.getProperty("testName");
		String testContext = properties.getProperty("testContext");
		String passPercent = properties.getProperty("passPercent");
		String expConfrmMsg = properties.getProperty("expConfrmMsg");
		String expMultipleChoicePage = properties.getProperty("expMultipleChoicePage");
		String expQue1addedConfirmMsg = properties.getProperty("expQue1addedConfirmMsg");
		String mcQue1 = properties.getProperty("mcQue1");
		String mcQue1AnsFirstOption = properties.getProperty("mcQue1AnsFirstOption");
		String mcQue1AnsSecondOption = properties.getProperty("mcQue1AnsSecondOption");
		String mcQue1AnsThirdOption = properties.getProperty("mcQue1AnsThirdOption");
		String mcQue1AnsFourthOption = properties.getProperty("mcQue1AnsFourthOption");
		String expQue2addedConfirmMsg = properties.getProperty("expQue2addedConfirmMsg");
		String mcQue2 = properties.getProperty("mcQue2");
		String mcQue2AnsFirstOption = properties.getProperty("mcQue2AnsFirstOption");
		String mcQue2AnsSecondOption = properties.getProperty("mcQue2AnsSecondOption");
		String mcQue2AnsThirdOption = properties.getProperty("mcQue2AnsThirdOption");
		String mcQue2AnsFourthOption = properties.getProperty("mcQue2AnsFourthOption");

		elearningPOMWeek3.login(teacherUserName, teacherPwd);
		Thread.sleep(4000);
		elearningPOMWeek3.clickcourseLink();
		Thread.sleep(4000);
		elearningPOMWeek3.clickTestIcon1();
		Thread.sleep(4000);
		elearningPOMWeek3.clickCreateNewTestBtn();
		Thread.sleep(4000);
		elearningPOMWeek3.clickCreateNewTestPage();
		Thread.sleep(4000);
		elearningPOMWeek3.sendTestName(testName);
		Thread.sleep(4000);
		elearningPOMWeek3.clickAdvSettings();
		Thread.sleep(5000);
		elearningPOMWeek3.sendTestContext(testContext);
		Thread.sleep(5000);
		elearningPOMWeek3.clickAtEndOfTest();
		Thread.sleep(4000);
		elearningPOMWeek3.clickEnableStartTime();
		Thread.sleep(4000);
		elearningPOMWeek3.clickSelectDateIcon();
		Thread.sleep(4000);
		// selecting date as Dec 16 2019
		elearningPOMWeek3.clickSelectDate();
		Thread.sleep(4000);
		elearningPOMWeek3.clickDateDoneBtn();
		Thread.sleep(4000);
		elearningPOMWeek3.sendPassPercent(passPercent);
		Thread.sleep(4000);
		elearningPOMWeek3.clickProceedToQuestionsBtn();
		Thread.sleep(4000);
		String actConfrmMsg = elearningPOMWeek3.getConfrmMsg();
		Assert.assertTrue(actConfrmMsg.contains(expConfrmMsg));
		System.out.println("Exercise added message should get displayed - Verified");

		elearningPOMWeek3.createMCQueWithAnswer(mcQue1, mcQue1AnsFirstOption, mcQue1AnsSecondOption,
				mcQue1AnsThirdOption, mcQue1AnsFourthOption, expMultipleChoicePage);
		Thread.sleep(4000);
		elearningPOMWeek3.clickFirstOptionRadioBtn();
		Thread.sleep(4000);
		elearningPOMWeek3.clickAddThisQue();
		Thread.sleep(4000);
		String actQue1addedConfirmMsg = elearningPOMWeek3.getConfirmationMsg();
		Assert.assertEquals(actQue1addedConfirmMsg, expQue1addedConfirmMsg);
		System.out.println(
				"1 questions, for a total score (all questions) of 0. message should get displayed-  Verified");

		elearningPOMWeek3.createMCQueWithAnswer(mcQue2, mcQue2AnsFirstOption, mcQue2AnsSecondOption,
				mcQue2AnsThirdOption, mcQue2AnsFourthOption, expMultipleChoicePage);
		Thread.sleep(4000);
		elearningPOMWeek3.clickSecondOptionRadioBtn();
		Thread.sleep(4000);
		elearningPOMWeek3.clickAddThisQue();
		Thread.sleep(4000);
		String actQue2addedConfirmMsg = elearningPOMWeek3.getConfirmationMsg();
		Assert.assertEquals(actQue2addedConfirmMsg, expQue2addedConfirmMsg);
		System.out.println(
				"2 questions, for a total score (all questions) of 0. message should get displayed-  Verified");

		elearningPOMWeek3.clickPreviewIcon();
		Thread.sleep(4000);
		Assert.assertTrue(elearningPOMWeek3.isDisplayedStartBtn());
		System.out.println("Start test button should get displayed-  Verified");
		System.out.println("**************************************************");
		tearDown();
		setUp();

		// Login as student
		String studentUserName = properties.getProperty("studentUserName");
		String studentPwd = properties.getProperty("studentPwd");
		String searchCourseName = properties.getProperty("searchCourseName_ELTC071");
		String expQue1 = properties.getProperty("ELTC_071mcQue1");
		String expQue2 = properties.getProperty("ELTC_071mcQue2");
		String tcNumber = "ELTC_071";
		elearningPOMWeek3.login(studentUserName, studentPwd);
		Thread.sleep(4000);
		elearningPOMWeek3.searchAndSubscribeCourse(searchCourseName, tcNumber);
		Thread.sleep(4000);

		elearningPOMWeek3.clickMyCourses();
		Thread.sleep(4000);

		elearningPOMWeek3.clickSelectCourseCourseWithTest();
		Thread.sleep(4000);

		elearningPOMWeek3.clickELTC_071TestIcon();
		Thread.sleep(4000);
		boolean actTestLinkDisplayed_ELTC_071 = elearningPOMWeek3.isDisplayedELTC_071TestLink();
		Assert.assertEquals(actTestLinkDisplayed_ELTC_071, true);
		System.out.println("Test name should get displayed - verified");

		elearningPOMWeek3.clickELTC_071TestLink();
		Thread.sleep(4000);
		boolean actStartTestDisplayed = elearningPOMWeek3.isDisplayedStartTest();
		Assert.assertEquals(actStartTestDisplayed, true);
		System.out.println("Start Test button should get displayed - verified");

		elearningPOMWeek3.clickStartTest();
		Thread.sleep(4000);

		String actQue1 = elearningPOMWeek3.ELTC071_getQuestion1();
		Assert.assertEquals(actQue1, expQue1);
		System.out.println("Question 1 displayed - verified");

		elearningPOMWeek3.ELTC071_clickQue1Ans();
		Thread.sleep(4000);

		System.out.println("Answer selected for Question 1");

		elearningPOMWeek3.ELTC071_clickNextQue();
		Thread.sleep(4000);

		String actQue2 = elearningPOMWeek3.ELTC071_getQuestion2();
		Assert.assertEquals(actQue2, expQue2);
		System.out.println("Question 2 displayed - verified");

		elearningPOMWeek3.ELTC071_clickQue2Ans();
		Thread.sleep(4000);

		System.out.println("Answer selected for Question 2");

		elearningPOMWeek3.ELTC071_clickEndButton();
		Thread.sleep(4000);

		boolean actTestResultDisplayed = elearningPOMWeek3.ELTC071_isDisplayedTestResult();
		Assert.assertEquals(actTestResultDisplayed, true);
		System.out.println("Test Result should get displayed - verified");
		System.out.println("*******************************************");
		tearDown();
		setUp();

		// Login as Admin
		String adminUserName = properties.getProperty("adminUserName");
		String adminPwd = properties.getProperty("adminPwd");
		String studentNameToFollow = properties.getProperty("studentNameToFollow");
		String expReportingPage = properties.getProperty("expReportingPage");
		String expLearnerPage = properties.getProperty("expLearnerPage");
		String expAdminUrl = properties.getProperty("expAdminUrl");
		String expMailContent = properties.getProperty("expMailContent");
		String expEmailSentConfrmMsg = properties.getProperty("expEmailSentConfrmMsg");

		elearningPOMWeek3.login(adminUserName, adminPwd);
		Thread.sleep(4000);
		String actAdminUrl = driver.getCurrentUrl();
		Assert.assertTrue(actAdminUrl.contains(expAdminUrl));
		System.out.println("Admin home page should get displayed- Verified");

		elearningPOMWeek3.clickReportingSection();
		Thread.sleep(4000);
		String actReportingPage = elearningPOMWeek3.getReportingPage();
		Assert.assertEquals(actReportingPage, expReportingPage);
		System.out.println("Reporting page should get displayed-Verified");

		elearningPOMWeek3.clickFollowedStudents();
		Thread.sleep(4000);
		String actLearnerPage = elearningPOMWeek3.getLearnersPage();
		Assert.assertEquals(actLearnerPage, expLearnerPage);
		System.out.println("Learners page should get displayed-Verified");

		elearningPOMWeek3.sendKeywordTextBox(studentNameToFollow);
		Thread.sleep(4000);
		elearningPOMWeek3.clickSearchBtn();
		Thread.sleep(4000);
		elearningPOMWeek3.clickFirstArrow();
		Thread.sleep(4000);
		elearningPOMWeek3.clickSecondArrow();
		Thread.sleep(4000);
		elearningPOMWeek3.clickAttemptIcon();
		Thread.sleep(4000);
		elearningPOMWeek3.clickGradeActvity();
		Thread.sleep(4000);
		elearningPOMWeek3.clickSendEmailChkBox();
		Thread.sleep(4000);
		String actMailContent = elearningPOMWeek3.getMailDefaultContent();
		Assert.assertTrue(actMailContent.contains(expMailContent));
		System.out.println(
				"Textbox containing default message to student about test submission should get displayed - Verified");
		elearningPOMWeek3.clickCorrectTestButton();
		Thread.sleep(4000);
		String actEmailSentConfrmMsg = elearningPOMWeek3.getConfirmationMsg();
		Assert.assertEquals(actEmailSentConfrmMsg, expEmailSentConfrmMsg);
		System.out.println("Message Sent message should get displayed-Verified");
		Thread.sleep(4000);
		elearningPOMWeek3.clickELTC_072_admin_SelectCourse();
		Thread.sleep(4000);
		System.out.println("Course name link is clicked");
		System.out.println("****************************");
		System.out.println("ended...");
	}
}
