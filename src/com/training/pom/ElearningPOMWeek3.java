package com.training.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.generics.ScreenShotWeek2;
import com.training.generics.ScreenShotWeek3;

public class ElearningPOMWeek3 {
	private WebDriver driver;

	public ElearningPOMWeek3(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators for login
	@FindBy(id = "login")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "form-login_submitAuth")
	private WebElement loginBtn;

	// Locators for admintoAddNewRole_ELTC_072

	@FindBy(xpath = "//a[contains(text(),'Homepage')]")
	private WebElement homePageBtn;

	@FindBy(xpath = "//a[contains(text(),'Administration')]")
	private WebElement administrationBtn;

	@FindBy(xpath = "//a[contains(text(),'Add a user')]")
	private WebElement addUserLink;

	@FindBy(xpath = "//legend[contains(text(),'Add a user')]")
	private WebElement addUserPageName;

	@FindBy(id = "firstname")
	private WebElement firstNameTxtBox;

	@FindBy(id = "lastname")
	private WebElement lastNameTxtBox;

	@FindBy(id = "email")
	private WebElement emailTxtBox;

	@FindBy(id = "phone")
	private WebElement phoneTxtBox;

	@FindBy(id = "username")
	private WebElement loginTxtBox;

	@FindBy(xpath = "//label[contains(text(),'Enter password')]")
	private WebElement pwdRadioBtn;

	@FindBy(id = "password")
	private WebElement pwdTxtBox;

	@FindBy(xpath = "//select[@id='status_select']")
	private WebElement profileDropDown;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement addBtn;

	@FindBy(xpath = "//div[@class='alert alert-info']")
	private WebElement confirmationMsg;

	@FindBy(xpath = "//div[@class='alert alert-warning']")
	private WebElement errorMsg;

	// Locators for ELTC_071

	@FindBy(xpath = "//a[contains(text(),'Course with Test')]")
	private WebElement courseLink;

	@FindBy(xpath = "//a[@id='istooldesc_11467']")
	private WebElement testIcon1;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement createNewTestBtn;

	@FindBy(xpath = "//legend[contains(text(),'Create a new test')]")
	private WebElement createNewTestPage;

	@FindBy(xpath = "//input[@id='exercise_title']")
	private WebElement testName;

	@FindBy(xpath = "//button[@id='advanced_params']")
	private WebElement advSettings;

	@FindBy(xpath = "//div[@id='cke_1_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement testContextFrame;

	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement testContext;

	@FindBy(xpath = "//input[@id='exerciseType_0']")
	private WebElement atEndOfTest;

	@FindBy(xpath = "//label[contains(text(),'Enable start time')]")
	private WebElement enableStartTime;

	@FindBy(xpath = "//div[@id='date_time_wrapper_start_time']//span[@class='input-group-addon cursor-pointer']")
	private WebElement selectDateIcon;

	@FindBy(xpath = "//tr[3]/td[2]")
	private WebElement selectDate;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[3]/button[2]")
	private WebElement dateDoneBtn;

	@FindBy(xpath = "//input[@id='pass_percentage']")
	private WebElement passPercent;

	@FindBy(xpath = "//button[@id='exercise_admin_submitExercise']")
	private WebElement proceedToQuestionsBtn;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement confrmMsg;

	@FindBy(xpath = "//section[@id='cm-content']//li[1]//div[1]//a[1]//img[1]")
	private WebElement multipleChoiceIcon;

	@FindBy(xpath = "//legend[contains(text(),'Add this question to the test: Multiple choice')]")
	private WebElement multipleChoicePage;

	@FindBy(xpath = "//input[@id='question_admin_form_questionName']")
	private WebElement mcQue;

	@FindBy(xpath = "//div[@id='cke_2_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement mcQueFirstOptionFrame;

	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p")
	private WebElement mcQueAnswerOptionText;

	@FindBy(xpath = "//div[@id='cke_4_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement mcQueSecondOptionFrame;

	@FindBy(xpath = "//div[@id='cke_6_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement mcQueThirdOptionFrame;

	@FindBy(xpath = "//div[@id='cke_8_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement mcQueFourthOptionFrame;

	@FindBy(xpath = "//tr[1]/td[2]/input[1]")
	private WebElement firstOptionRadioBtn;

	@FindBy(xpath = "//tr[2]/td[2]/input[1]")
	private WebElement secondOptionRadioBtn;

	@FindBy(xpath = "//button[@id='submit-question']")
	private WebElement addThisQue;

	@FindBy(xpath = "//div[@class='actions']//a[2]//img[1]")
	private WebElement previewIcon;

	@FindBy(xpath = "//a[@class='btn btn-success btn-large']")
	private WebElement startBtn;

	@FindBy(xpath = "//a[contains(text(),'Course with Test')]")
	private WebElement selectCourseCourseWithTest;

	@FindBy(xpath = "//a[@id='istooldesc_11467']")
	private WebElement ELTC071_testIcon;

	@FindBy(xpath = "//a[contains(text(),'Selenium')]")
	private WebElement ELTC071_testLink;

	@FindBy(xpath = "//strong[contains(text(),'1. which course your learning?')]")
	private WebElement ELTC071_question1;

	@FindBy(xpath = "//strong[contains(text(),'2. which language are you using in selenium')]")
	private WebElement ELTC071_question2;

	@FindBy(xpath = "//label[1]/input[1]")
	private WebElement ELTC071_que1Ans;

	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement ELTC071_nextQue;

	@FindBy(xpath = "//label[2]/input[1]")
	private WebElement ELTC071_que2Ans;

	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement ELTC071_endButton;

	@FindBy(xpath = "//h3[contains(text(),'Result')]")
	private WebElement ELTC071_testResult;

	@FindBy(xpath = "//a[contains(text(),'Reporting')]")
	private WebElement reportingSection;

	@FindBy(xpath = "//h3[contains(text(),'Reporting')]")
	private WebElement reportingPage;

	@FindBy(xpath = "//a[contains(text(),'Followed students')]")
	private WebElement followedStudents;

	@FindBy(xpath = "//h3[contains(text(),'Learners')]")
	private WebElement learnersPage;

	@FindBy(xpath = "//input[@id='search_user_keyword']")
	private WebElement keywordTextBox;

	@FindBy(xpath = "//button[@id='search_user_submit']")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[@id='details_Dhara']//img")
	private WebElement firstArrow;

	@FindBy(xpath = "//tr[2]//td[7]//a[1]//img[1]")
	private WebElement secondArrow;

	@FindBy(xpath = "//td[6]//a[1]//img[1]")
	private WebElement attemptIcon;

	@FindBy(xpath = "//div[@id='gbox_results']//a[1]//img[1]")
	private WebElement gradeActvity;

	@FindBy(xpath = "//fieldset/div/div/label/input")
	private WebElement sendEmailChkBox;

	@FindBy(xpath = "//div[@id='cke_3_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement mailContentFrame;

	@FindBy(xpath = "//p[contains(text(),'Your following attempt has been viewed/commented/c')]")
	private WebElement mailDefaultContent;

	@FindBy(xpath = "//button[@id='form-email_submit']")
	private WebElement correctTestButton;

	@FindBy(xpath = "//a[contains(text(),'Course with Test')]")
	private WebElement ELTC_072_admin_SelectCourse;

	@FindBy(linkText = "Start test")
	private WebElement startTest;

	@FindBy(xpath = "//a[contains(text(),'My courses')]")
	private WebElement myCourses;

	// Functions for ECTC_072

	public void clickHomePageBtn() {
		this.homePageBtn.click();
	}

	public void clickAdministrationBtn() {
		this.administrationBtn.click();
	}

	public void clickAddUserLink() {
		this.addUserLink.click();
	}

	public String getAddUserPageName() {
		return this.addUserPageName.getText();
	}

	public void sendFirstNameTxtBox(String firstName) {
		this.firstNameTxtBox.clear();
		firstNameTxtBox.sendKeys(firstName);
	}

	public void sendLastNameTxtBox(String lastName) {
		this.lastNameTxtBox.clear();
		lastNameTxtBox.sendKeys(lastName);
	}

	public void sendEmailTxtBox(String email) {
		this.emailTxtBox.clear();
		emailTxtBox.sendKeys(email);
	}

	public void sendPhonetxtBox(String phone) {
		this.phoneTxtBox.clear();
		phoneTxtBox.sendKeys(phone);
	}

	public void sendLoginTxtBox(String login) {
		this.loginTxtBox.clear();
		loginTxtBox.sendKeys(login);
	}

	public void clickPwdRadioBtn() {
		this.pwdRadioBtn.click();
	}

	public void sendPwdTextBox(String pwd) {
		this.pwdTxtBox.clear();
		pwdTxtBox.sendKeys(pwd);
	}

	public void selectProfileDropDown() throws IOException {
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/othersWeek3.properties");
		properties.load(inStream);
		String profileToChoose = properties.getProperty("profileToChoose");
		Select profiles = new Select(profileDropDown);
		profiles.selectByVisibleText(profileToChoose);
	}

	public void clickAddBtn() {
		this.addBtn.click();
	}

	public String getConfirmationMsg() {
		return this.confirmationMsg.getText();
	}

	public String getErrorMsg() {
		return this.errorMsg.getText();
	}

	// WebElement Functions for ELTC_071

	public void clickcourseLink() {
		this.courseLink.click();
	}

	public void clickTestIcon1() {
		this.testIcon1.click();
	}

	public void clickCreateNewTestBtn() {
		this.createNewTestBtn.click();
	}

	public void clickCreateNewTestPage() {
		this.createNewTestPage.click();
	}

	public void sendTestName(String testName) {
		this.testName.sendKeys(testName);
	}

	public void clickAdvSettings() {
		this.advSettings.click();
	}

	public void sendTestContext(String testContext) {

		driver.switchTo().frame(testContextFrame);
		this.testContext.sendKeys(testContext);
		driver.switchTo().defaultContent();
	}

	public void clickAtEndOfTest() {
		this.atEndOfTest.click();
	}

	public void clickEnableStartTime() {
		this.enableStartTime.click();
	}

	public void clickSelectDateIcon() {
		this.selectDateIcon.click();
	}

	public void clickSelectDate() {
		this.selectDate.click();
	}

	public void clickDateDoneBtn() {
		this.dateDoneBtn.click();
	}

	public void sendPassPercent(String passPercent) {
		this.passPercent.sendKeys(passPercent);
	}

	public void clickProceedToQuestionsBtn() {
		this.proceedToQuestionsBtn.click();
	}

	public String getConfrmMsg() {
		return this.confrmMsg.getText();
	}

	public void clickMultipleChoiceIcon() {
		this.multipleChoiceIcon.click();
	}

	public String getMultipleChoicePage() {
		return this.multipleChoicePage.getText();
	}

	public void sendMcQue(String mcQue) {
		this.mcQue.clear();
		this.mcQue.sendKeys(mcQue);
	}

	public void populateAnswerOptionTextBox(String mcQueAnswerOption) {
		this.mcQueAnswerOptionText.clear();
		this.mcQueAnswerOptionText.sendKeys(mcQueAnswerOption);
	}

	public void sendMcQueAnswerOption1Text(String mcQueAnswerOption) {

		driver.switchTo().frame(mcQueFirstOptionFrame);
		populateAnswerOptionTextBox(mcQueAnswerOption);
		driver.switchTo().defaultContent();
	}

	public void sendMcQueAnswerOption2Text(String mcQueAnswerOption) {

		driver.switchTo().frame(mcQueSecondOptionFrame);
		populateAnswerOptionTextBox(mcQueAnswerOption);
		driver.switchTo().defaultContent();
	}

	public void sendMcQueAnswerOption3Text(String mcQueAnswerOption) {

		driver.switchTo().frame(mcQueThirdOptionFrame);
		populateAnswerOptionTextBox(mcQueAnswerOption);
		driver.switchTo().defaultContent();
	}

	public void sendMcQueAnswerOption4Text(String mcQueAnswerOption) {

		driver.switchTo().frame(mcQueFourthOptionFrame);
		populateAnswerOptionTextBox(mcQueAnswerOption);
		driver.switchTo().defaultContent();
	}

	public void clickFirstOptionRadioBtn() {
		this.firstOptionRadioBtn.click();
	}

	public void clickSecondOptionRadioBtn() {
		this.secondOptionRadioBtn.click();
	}

	public void clickAddThisQue() {
		this.addThisQue.click();
	}

	public void createMCQueWithAnswer(String mcQue1, String mcQue1AnsFirstOption, String mcQue1AnsSecondOption,
			String mcQue1AnsThirdOption, String mcQue1AnsFourthOption, String expMultipleChoicePage)
			throws InterruptedException {
		ElearningPOMWeek3 elearningPOMWeek3 = new ElearningPOMWeek3(driver);
		elearningPOMWeek3.clickMultipleChoiceIcon();
		Thread.sleep(4000);
		String actMultipleChoicePage = elearningPOMWeek3.getMultipleChoicePage();
		Assert.assertTrue(actMultipleChoicePage.contains(expMultipleChoicePage));
		System.out.println("Add this question to the test should get displayed- Verified");
		elearningPOMWeek3.sendMcQue(mcQue1);
		Thread.sleep(4000);
		elearningPOMWeek3.sendMcQueAnswerOption1Text(mcQue1AnsFirstOption);
		Thread.sleep(4000);
		elearningPOMWeek3.sendMcQueAnswerOption2Text(mcQue1AnsSecondOption);
		Thread.sleep(4000);
		elearningPOMWeek3.sendMcQueAnswerOption3Text(mcQue1AnsThirdOption);
		Thread.sleep(4000);
		elearningPOMWeek3.sendMcQueAnswerOption4Text(mcQue1AnsFourthOption);
		Thread.sleep(4000);
	}

	public void clickPreviewIcon() {
		this.previewIcon.click();
	}

	public boolean isDisplayedStartBtn() {
		return this.startBtn.isDisplayed();
	}

	public void clickSelectCourseCourseWithTest() {
		this.selectCourseCourseWithTest.click();
	}

	public void clickELTC_071TestIcon() {
		this.ELTC071_testIcon.click();
	}

	public void clickELTC_071TestLink() {
		this.ELTC071_testLink.click();
	}

	public boolean isDisplayedELTC_071TestLink() {
		return this.ELTC071_testLink.isDisplayed();
	}

	public String ELTC071_getQuestion1() {
		return this.ELTC071_question1.getText();
	}

	public String ELTC071_getQuestion2() {
		return this.ELTC071_question2.getText();
	}

	public void ELTC071_clickQue1Ans() {
		this.ELTC071_que1Ans.click();
	}

	public void ELTC071_clickNextQue() {
		this.ELTC071_nextQue.click();
	}

	public void ELTC071_clickQue2Ans() {
		this.ELTC071_que2Ans.click();
	}

	public void ELTC071_clickEndButton() {
		this.ELTC071_endButton.click();
	}

	public boolean ELTC071_isDisplayedTestResult() {
		return this.ELTC071_testResult.isDisplayed();
	}

	public void clickReportingSection() {
		this.reportingSection.click();
	}

	public String getReportingPage() {
		return this.reportingPage.getText();
	}

	public void clickFollowedStudents() {
		this.followedStudents.click();
	}

	public String getLearnersPage() {
		return this.learnersPage.getText();
	}

	public void sendKeywordTextBox(String studentNameToFollow) {
		this.keywordTextBox.sendKeys(studentNameToFollow);
	}

	public void clickSearchBtn() {
		this.searchBtn.click();
	}

	public void clickFirstArrow() {
		this.firstArrow.click();
	}

	public void clickSecondArrow() {
		this.secondArrow.click();
	}

	public void clickAttemptIcon() {
		this.attemptIcon.click();
	}

	public void clickGradeActvity() {
		this.gradeActvity.click();
	}

	public void clickSendEmailChkBox() {
		this.sendEmailChkBox.click();
	}

	public String getMailDefaultContent() {
		driver.switchTo().frame(mailContentFrame);
		String mailContent = this.mailDefaultContent.getText();
		driver.switchTo().defaultContent();
		return mailContent;
	}

	public void clickCorrectTestButton() {
		this.correctTestButton.click();
	}

	public void clickELTC_072_admin_SelectCourse() {
		this.ELTC_072_admin_SelectCourse.click();
	}

	public void clickStartTest() {
		this.startTest.click();
	}
	
	public boolean isDisplayedStartTest() {
		return this.startTest.isDisplayed();
	}
	public void clickMyCourses() {
		this.myCourses.click();
	}

	// Login WebElement functions
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	// Common methods to be used by test cases

	public void login(String username, String Password) {
		sendUserName(username);
		sendPassword(Password);
		clickLoginBtn();
	}

	public void searchAndSubscribeCourse(String searchCourseName, String tcNumber)
			throws IOException, InterruptedException {
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/othersWeek2.properties");
		properties.load(inStream);
		ScreenShotWeek2 screenShotWeek2 = new ScreenShotWeek2(driver);
		ElearningPOM elearningPOM = new ElearningPOM(driver);
		String expCourseCatalogPage = properties.getProperty("courseCatalogPage");
		String expSearchResult = properties.getProperty("expSearchResult");
		String expectedCourseConfirmationMsg = properties.getProperty("expectedCourseConfirmationMsg");

		elearningPOM.clickCourseCatalogbtn();
		Thread.sleep(5000);
		String screenshotName1 = "Course catalog page_";
		String screenshotFilename1 = screenshotName1 + tcNumber;
		screenShotWeek2.captureScreenShot(screenshotFilename1);
		String actCourseCatalogPage = elearningPOM.getCourseCatalogPage();
		Assert.assertEquals(actCourseCatalogPage, expCourseCatalogPage);
		System.out.println("Course catalog page displayed - verified");

		elearningPOM.sendSearchTextBox(searchCourseName);
		Thread.sleep(2000);

		elearningPOM.clickSearchBtn();
		Thread.sleep(2000);
		String screenshotName2 = "Course search result page_";
		String screenshotFilename2 = screenshotName2 + tcNumber;
		screenShotWeek2.captureScreenShot(screenshotFilename2);
		String actSearchResult = elearningPOM.getSearchResult();
		boolean srchResult = actSearchResult.contains(expSearchResult);
		Assert.assertEquals(srchResult, true);
		System.out.println("Search Result should be displayed - verified");

		elearningPOM.clickSelectCourse();
		Thread.sleep(5000);
		String screenshotName3 = "Course Subscribed Msg_";
		String screenshotFilename3 = screenshotName3 + tcNumber;
		screenShotWeek2.captureScreenShot(screenshotFilename3);
		String actualCourseConfirmationMsg = elearningPOM.getConfirmationMsg();
		boolean courseRegistered = actualCourseConfirmationMsg.contains(expectedCourseConfirmationMsg);
		Assert.assertEquals(courseRegistered, true);
		System.out.println("You have been registered to course message should get displayed - Verified");
		Thread.sleep(5000);

	}

	public void fillDetailsInAddUserRoleScreen(String tcNumber) throws InterruptedException, IOException {
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/othersWeek3.properties");
		properties.load(inStream);
		ScreenShotWeek3 screenShotWeek3 = new ScreenShotWeek3(driver);
		ElearningPOMWeek3 elearningPOMWeek3 = new ElearningPOMWeek3(driver);
		String expAdminUrl = properties.getProperty("expAdminUrl");
		String firstName = properties.getProperty("firstName");
		String lastName = properties.getProperty("lastName");
		String email = properties.getProperty("email");
		String phone = properties.getProperty("phone");
		String login = properties.getProperty("login");
		String pwd = properties.getProperty("pwd");

		elearningPOMWeek3.clickHomePageBtn();
		Thread.sleep(4000);

		elearningPOMWeek3.clickAdministrationBtn();
		Thread.sleep(4000);
		String screenshotName1 = "Admin Page_";
		String screenshotFilename1 = screenshotName1 + tcNumber;
		screenShotWeek3.captureScreenShot(screenshotFilename1);
		String actAdminUrl = driver.getCurrentUrl();
		Assert.assertEquals(expAdminUrl, actAdminUrl);
		System.out.println("Administration page should get displayed - Verified");

		elearningPOMWeek3.clickAddUserLink();
		Thread.sleep(4000);
		String screenshotName2 = "Add User Link Page_";
		String screenshotFilename2 = screenshotName2 + tcNumber;
		screenShotWeek3.captureScreenShot(screenshotFilename2);

		String actAddUserPageName = elearningPOMWeek3.getAddUserPageName();
		String expAddUserPageName = properties.getProperty("expAddUserPageName");
		Assert.assertEquals(actAddUserPageName, expAddUserPageName);
		System.out.println("Add a user page should get displayed - Verified");

		elearningPOMWeek3.sendFirstNameTxtBox(firstName);
		Thread.sleep(4000);
		System.out.println("First Name entered");

		elearningPOMWeek3.sendLastNameTxtBox(lastName);
		System.out.println("Last Name entered");
		Thread.sleep(4000);

		elearningPOMWeek3.sendEmailTxtBox(email);
		System.out.println("Email entered");
		Thread.sleep(4000);

		elearningPOMWeek3.sendPhonetxtBox(phone);
		Thread.sleep(4000);
		System.out.println("Phone number entered");

		elearningPOMWeek3.sendLoginTxtBox(login);
		Thread.sleep(4000);
		System.out.println("Login username entered");

		String screenshotName3 = "Add User Page details1_";
		String screenshotFilename3 = screenshotName3 + tcNumber;
		screenShotWeek3.captureScreenShot(screenshotFilename3);

		elearningPOMWeek3.clickPwdRadioBtn();
		Thread.sleep(4000);
		System.out.println("Radiobutton selected");

		elearningPOMWeek3.sendPassword(pwd);
		Thread.sleep(4000);
		System.out.println("Password entered");

		elearningPOMWeek3.selectProfileDropDown();
		Thread.sleep(4000);
		System.out.println("profile drop down selected");

		String screenshotName4 = "Add User Page details2_";
		String screenshotFilename4 = screenshotName4 + tcNumber;
		screenShotWeek3.captureScreenShot(screenshotFilename4);

		Thread.sleep(4000);

	}

}
