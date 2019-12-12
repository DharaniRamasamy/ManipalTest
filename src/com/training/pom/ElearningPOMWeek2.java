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

public class ElearningPOMWeek2 {
	private WebDriver driver;

	public ElearningPOMWeek2(WebDriver driver) {
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

	// Locators for teacherToAddprojectDetails_ELTC_040

	@FindBy(xpath = "//a[contains(text(),'Manipal Course')]")
	private WebElement course;

	@FindBy(xpath = "//a[@id='istooldesc_11458']")
	private WebElement projectIcon;

	@FindBy(xpath = "//a[contains(text(),'Project management')]")
	private WebElement projectManagementPage;

	@FindBy(xpath = "//div[@class='actions']//a//img")
	private WebElement createNewProjectIcon;

	@FindBy(xpath = "//legend[contains(text(),'Create a new project')]")
	private WebElement createNewProjectPage;

	@FindBy(xpath = "//input[@id='add_blog_blog_name']")
	private WebElement titleTextBox;

	@FindBy(xpath = "//textarea[@id='add_blog_blog_subtitle']")
	private WebElement subTitleTextBox;

	@FindBy(xpath = "//button[@id='add_blog_submit']")
	private WebElement saveBlog;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement confirmMsg;

	@FindBy(xpath = "//a[contains(text(),'e learning')]")
	private WebElement projectLink;

	@FindBy(xpath = "//a[contains(text(),'Welcome !')]")
	private WebElement welcomeMsg;

	@FindBy(xpath = "//a[2]//img[1]")
	private WebElement createNewTask;

	@FindBy(xpath = "//legend[contains(text(),'New task')]")
	private WebElement newTaskPage;

	@FindBy(xpath = "//input[@id='add_post_title']")
	private WebElement taskTitle;

	@FindBy(xpath = "//button[@id='add_post_save']")
	private WebElement taskSaveButton;

	@FindBy(xpath = "//div[@id='toolbar']//a[3]//img[1]")
	private WebElement roleManagement;

	@FindBy(xpath = "//li[contains(text(),'Roles management')]")
	private WebElement rolesManagementPage;

	@FindBy(xpath = "//a[contains(text(),'Add a new role')]")
	private WebElement addNewRole;

	@FindBy(xpath = "//legend[contains(text(),'Add a new role')]")
	private WebElement newRolePage;

	@FindBy(xpath = "//input[@name='task_name']")
	private WebElement roleTitle;

	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement roleSubmit;

	@FindBy(xpath = "//a[contains(text(),'Assign roles')]")
	private WebElement assignRole;

	@FindBy(xpath = "//legend[contains(text(),'Assign a role')]")
	private WebElement assignRolePage;

	@FindBy(xpath = "//button[@id='assign_task_submit']")
	private WebElement assignRoleValidate;

	@FindBy(xpath = "//a[4]//img[1]")
	private WebElement userManagementIcon;

	@FindBy(xpath = "//legend[contains(text(),'Subscribe users')]")
	private WebElement userMgmtPage;

	@FindBy(xpath = "//input[@name='user[]']")
	private WebElement userCheckBox;

	@FindBy(xpath = "//div[contains(text(),'Unregister')]")
	private WebElement unregister;

	@FindBy(xpath = "//body/main/section/div/div/div/section/div/div/div/form[2]/div[2]/button[1]")
	private WebElement unsubscribeValidate;

	// Locators for studentToSubscribeCourseTakeTest_ELTC_041

	@FindBy(xpath = "//a[contains(text(),'My courses')]")
	private WebElement myCourses;

	@FindBy(xpath = "//a[contains(text(),'Manipal Course')]")
	private WebElement selectCourse;

	@FindBy(xpath = "//a[@id='istooldesc_11443']")
	private WebElement testIcon;

	@FindBy(xpath = "//a[contains(text(),'Reskill Online Quiz')]")
	private WebElement testLink;

	@FindBy(linkText = "Start test")
	private WebElement startTest;

	@FindBy(xpath = "//strong[contains(text(),'1. Which course are your learning?')]")
	private WebElement question1;

	@FindBy(xpath = "//strong[contains(text(),'2. which language are you using in selenium?')]")
	private WebElement question2;

	@FindBy(xpath = "//input[@id='choice-189-1']")
	private WebElement que1Ans;

	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement nextQue;

	@FindBy(xpath = "//input[@id='choice-190-2']")
	private WebElement que2Ans;

	@FindBy(xpath = "//button[@name='save_now']")
	private WebElement endButton;

	@FindBy(xpath = "//h3[contains(text(),'Result')]")
	private WebElement testResult;
	
	//Locators for ELTC_042
	
	@FindBy(xpath = "//a[contains(text(),'Project Week2 course')]")
	private WebElement selectAssessmentCourse;
	
	@FindBy(xpath = "//a[@id='istooldesc_11646']")
	private WebElement assessmentIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Intermediate test')]")
	private WebElement assessmentLink;
	
	@FindBy(xpath = "//strong[contains(text(),'1. What is the scripting language used in Selenium')]")
	private WebElement assessmentQue1;

	@FindBy(xpath = "//strong[contains(text(),'2. What is the default port number of Selenium gri')]")
	private WebElement assessmentQue2;
	
	@FindBy(xpath = "//input[@id='choice-191-1']")
	private WebElement assessmentQue1Ans;
	
	@FindBy(xpath = "//input[@id='choice-192-3']")
	private WebElement assessmentQue2Ans;
	//Functions for ECTC_042
	public void clickSelectAssessmentCourse() {
		this.selectAssessmentCourse.click();
	}
		
	public void clickAssessmentIcon() {
		this.assessmentIcon.click();
	}
	
	public boolean isDisplayedAssessmentLink() {
		return this.assessmentLink.isDisplayed();
	}
	
	public void clickAssessmentLink() {
		this.assessmentLink.click();
	}
	
	public void clickAssessmentQue1Ans() {
		this.assessmentQue1Ans.click();
	}
	
	public void clickAssessmentQue2Ans() {
		this.assessmentQue2Ans.click();
	}
	
	public String getAssessmentQuestion1() {
		return this.assessmentQue1.getText();
	}
	public String getAssessmentQuestion2() {
		return this.assessmentQue2.getText();
	}
	
	//Functions for studentToSubscribeCourseTakeTest_ELTC_041

	public void clickMyCourses() {
		this.myCourses.click();
	}

	public void clickSelectCourse() {
		this.selectCourse.click();
	}

	public void clickTestIcon() {
		this.testIcon.click();
	}

	public void clickTestLink() {
		this.testLink.click();
	}

	public boolean isDisplayedTestLink() {
		return this.testLink.isDisplayed();
	}

	public void clickStartTest() {
		this.startTest.click();
	}

	public boolean isDisplayedStartTest() {
		return this.startTest.isDisplayed();
	}

	public String getQuestion1() {
		return this.question1.getText();
	}

	public String getQuestion2() {
		return this.question2.getText();
	}

	public void clickQue1Ans() {
		this.que1Ans.click();
	}

	public void clickNextQue() {
		this.nextQue.click();
	}

	public void clickQue2Ans() {
		this.que2Ans.click();
	}

	public void clickEndButton() {
		this.endButton.click();
	}

	public boolean isDisplayedTestResult() {
		return this.testResult.isDisplayed();
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

	// teacherToAddprojectDetails_ELTC_040 - WebElement functions

	public void clickCourse() {
		this.course.click();
	}

	public void clickProjectIcon() {
		this.projectIcon.click();
	}

	public String getProjectManagementPage() {
		return this.projectManagementPage.getText();
	}

	public void clickCreateNewProjectIcon() {
		this.createNewProjectIcon.click();
	}

	public String getCreateNewProjectPage() {
		return this.createNewProjectPage.getText();
	}

	public void sendTitleTextBox(String projTitle) {
		this.titleTextBox.clear();
		this.titleTextBox.sendKeys(projTitle);
	}

	public void sendSubTitleTextBox(String subTitle) {
		this.subTitleTextBox.clear();
		this.subTitleTextBox.sendKeys(subTitle);
	}

	public void clickSaveBlog() {
		this.saveBlog.click();
	}

	public String getconfirmMsg() {
		return this.confirmMsg.getText();
	}

	public void clickProjectLink() {
		this.projectLink.click();
	}

	public String getWelcomeMsg() {
		return this.welcomeMsg.getText();
	}

	public void clickCreateNewtask() {
		this.createNewTask.click();
	}

	public String getNewTaskPage() {
		return this.newTaskPage.getText();
	}

	public void sendTaskTitle(String taskTitle) {
		this.taskTitle.clear();
		this.taskTitle.sendKeys(taskTitle);
	}

	public void clickTaskSaveButton() {
		this.taskSaveButton.click();
	}

	public void clickRoleManagement() {
		this.roleManagement.click();
	}

	public String getRolesManagementPage() {
		return this.rolesManagementPage.getText();
	}

	public void clickAddNewRole() {
		this.addNewRole.click();
	}

	public String getNewRolePage() {
		return this.newRolePage.getText();
	}

	public void sendRoleTitle(String roleTitle) {
		this.roleTitle.clear();
		this.roleTitle.sendKeys(roleTitle);
	}

	public void clickRoleSubmit() {
		this.roleSubmit.click();
	}

	public void clickAssignRole() {
		this.assignRole.click();
	}

	public String getAssignRolePage() {
		return this.assignRolePage.getText();
	}

	public void selectUserForAssignRole() throws IOException {
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/othersWeek2.properties");
		properties.load(inStream);
		String user = properties.getProperty("UsertoChoose");
		Select userRoles = new Select(driver.findElement(By.id("assign_task_task_user_id")));
		userRoles.selectByVisibleText(user);
	}

	public void clickAssignRoleValidate() {
		this.assignRoleValidate.click();
	}

	public void clickUserManagementIcon() {
		this.userManagementIcon.click();
	}

	public String getUserMgmtPage() {
		return this.userMgmtPage.getText();
	}

	public void clickUserCheckBox() {
		this.userCheckBox.click();
	}

	public void clickUnregister() {
		this.unregister.click();
	}

	public void clickUnsubscribeValidate() {
		this.unsubscribeValidate.click();
	}
	
	
	//Common methods to be used by test cases
	
	public void login(String username, String Password) {
		sendUserName(username);
		sendPassword(Password);
		clickLoginBtn();
	}

	public void searchAndSubscribeCourse(String searchCourseName,String tcNumber) throws IOException, InterruptedException {
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/othersWeek2.properties");
		properties.load(inStream);
		ScreenShotWeek2 screenShotWeek2=new ScreenShotWeek2(driver);
		ElearningPOM elearningPOM = new ElearningPOM(driver);
		String expCourseCatalogPage = properties.getProperty("courseCatalogPage");
		String expSearchResult = properties.getProperty("expSearchResult");
		String expectedCourseConfirmationMsg = properties.getProperty("expectedCourseConfirmationMsg");

		elearningPOM.clickCourseCatalogbtn();
		Thread.sleep(5000);
		String screenshotName1="Course catalog page_";
		String screenshotFilename1=screenshotName1+tcNumber;
		screenShotWeek2.captureScreenShot(screenshotFilename1);
		String actCourseCatalogPage = elearningPOM.getCourseCatalogPage();
		Assert.assertEquals(actCourseCatalogPage, expCourseCatalogPage);
		System.out.println("Course catalog page displayed - verified");

		elearningPOM.sendSearchTextBox(searchCourseName);
		Thread.sleep(2000);

		elearningPOM.clickSearchBtn();
		Thread.sleep(2000);
		String screenshotName2="Course search result page_";
		String screenshotFilename2=screenshotName2+tcNumber;
		screenShotWeek2.captureScreenShot(screenshotFilename2);
		String actSearchResult = elearningPOM.getSearchResult();
		boolean srchResult = actSearchResult.contains(expSearchResult);
		Assert.assertEquals(srchResult, true);
		System.out.println("Search Result should be displayed - verified");

		elearningPOM.clickSelectCourse();
		Thread.sleep(5000);
		String screenshotName3="Course Subscribed Msg_";
		String screenshotFilename3=screenshotName3+tcNumber;
		screenShotWeek2.captureScreenShot(screenshotFilename3);
		String actualCourseConfirmationMsg = elearningPOM.getConfirmationMsg();
		boolean courseRegistered = actualCourseConfirmationMsg.contains(expectedCourseConfirmationMsg);
		Assert.assertEquals(courseRegistered, true);
		System.out.println("You have been registered to course message should get displayed - Verified");
		Thread.sleep(5000);

	}

}
