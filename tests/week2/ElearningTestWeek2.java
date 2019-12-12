package week2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.generics.ScreenShotWeek2;
import com.training.pom.ElearningPOM;
import com.training.pom.ElearningPOMWeek2;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ElearningTestWeek2 {

	private WebDriver driver;
	private String baseUrl;
	private ElearningPOMWeek2 elearningPOMWeek2;
	private ElearningPOM elearningPOM;
	private static Properties properties;
	private ScreenShotWeek2 screenShotWeek2;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/othersWeek2.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		elearningPOMWeek2 = new ElearningPOMWeek2(driver);
		elearningPOM = new ElearningPOM(driver);
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
	public void teacherToAddprojectDetails_ELTC_040() throws InterruptedException, IOException {
		
		String teacherUserName = properties.getProperty("teacherUserName");
		String teacherPwd = properties.getProperty("teacherPwd");
		String projTitle = properties.getProperty("projTitle");
		String projSubTitle = properties.getProperty("projSubTitle");
		String taskTitle = properties.getProperty("taskTitle");
		String roleTitle = properties.getProperty("roleTitle");
		String expProjMgmtPage = properties.getProperty("projMgmtPage");
		String expCreateProjectPage = properties.getProperty("createProjectPage");
		String expconfirmMsg = properties.getProperty("createNewProjConfirmMsg");
		String expWelcomeMsg = properties.getProperty("welcomeMsg");
		String expTaskPageMsg = properties.getProperty("newTaskPage");
		String expTaskConfirmationMsg = properties.getProperty("taskConfirmationMsg");
		String expRoleMgmtPage = properties.getProperty("rolesMgmtPage");
		String expNewRolePage = properties.getProperty("newRolePage");
		String expRoleConfirmationMsg = properties.getProperty("roleConfirmationMsg");
		String expAssignRolePage = properties.getProperty("assignRolePage");
		String expAssignRoleConfirmationMsg = properties.getProperty("AssignRoleConfirmationMsg");
		String expUserMgmtPage = properties.getProperty("userMgmtPage");
		screenShotWeek2 = new ScreenShotWeek2(driver);

		elearningPOMWeek2.login(teacherUserName,teacherPwd);
		Thread.sleep(4000);

		elearningPOMWeek2.clickCourse();
		Thread.sleep(4000);

		elearningPOMWeek2.clickProjectIcon();
		Thread.sleep(4000);
		String actProjMgmtPage = elearningPOMWeek2.getProjectManagementPage();
		screenShotWeek2.captureScreenShot("ELTC_040_01");
		Assert.assertEquals(actProjMgmtPage, expProjMgmtPage);
		System.out.println("Project management page should get displayed -Verified");

		elearningPOMWeek2.clickCreateNewProjectIcon();
		Thread.sleep(4000);
		String actCreateProjectPage = elearningPOMWeek2.getCreateNewProjectPage();
		screenShotWeek2.captureScreenShot("ELTC_040_02");
		Assert.assertEquals(actCreateProjectPage, expCreateProjectPage);
		System.out.println("Create a new project page should get displayed -Verified");

		elearningPOMWeek2.sendTitleTextBox(projTitle);
		Thread.sleep(4000);

		elearningPOMWeek2.sendSubTitleTextBox(projSubTitle);
		Thread.sleep(4000);

		elearningPOMWeek2.clickSaveBlog();
		Thread.sleep(4000);
		String actconfirmMsg = elearningPOMWeek2.getconfirmMsg();
		screenShotWeek2.captureScreenShot("ELTC_040_03");
		Assert.assertEquals(actconfirmMsg, expconfirmMsg);
		System.out.println("The project has been added. Message should get displayed -Verified");

		elearningPOMWeek2.clickProjectLink();
		Thread.sleep(4000);
		String actWelcomeMsg = elearningPOMWeek2.getWelcomeMsg();
		screenShotWeek2.captureScreenShot("ELTC_040_04");
		Assert.assertEquals(actWelcomeMsg, expWelcomeMsg);
		System.out.println("Welcome message should get displayed -Verified");

		elearningPOMWeek2.clickCreateNewtask();
		Thread.sleep(4000);
		String actTaskPageMsg = elearningPOMWeek2.getNewTaskPage();
		screenShotWeek2.captureScreenShot("ELTC_040_05");
		Assert.assertEquals(actTaskPageMsg, expTaskPageMsg);
		System.out.println("New task page should get displayed -Verified");

		elearningPOMWeek2.sendTaskTitle(taskTitle);
		Thread.sleep(4000);

		elearningPOMWeek2.clickTaskSaveButton();
		Thread.sleep(4000);
		String actTaskConfirmationMsg = elearningPOMWeek2.getconfirmMsg();
		screenShotWeek2.captureScreenShot("ELTC_040_06");
		Assert.assertEquals(actTaskConfirmationMsg, expTaskConfirmationMsg);
		System.out.println("The article has been added. Message should get displayed -Verified");

		elearningPOMWeek2.clickRoleManagement();
		Thread.sleep(4000);
		String actRoleMgmtPage = elearningPOMWeek2.getRolesManagementPage();
		screenShotWeek2.captureScreenShot("ELTC_040_07");
		Assert.assertEquals(actRoleMgmtPage, expRoleMgmtPage);
		System.out.println("Roles management page should get displayed -Verified");

		elearningPOMWeek2.clickAddNewRole();
		Thread.sleep(4000);
		String actNewRolePage = elearningPOMWeek2.getNewRolePage();
		screenShotWeek2.captureScreenShot("ELTC_040_08");
		Assert.assertEquals(actNewRolePage, expNewRolePage);
		System.out.println("Add a new role page should get displayed -Verified");

		elearningPOMWeek2.sendRoleTitle(roleTitle);
		Thread.sleep(4000);

		elearningPOMWeek2.clickRoleSubmit();
		Thread.sleep(4000);
		String actRoleConfirmationMsg = elearningPOMWeek2.getconfirmMsg();
		screenShotWeek2.captureScreenShot("ELTC_040_09");
		Assert.assertEquals(actRoleConfirmationMsg, expRoleConfirmationMsg);
		System.out.println("The task has been created message should get displayed -Verified");

		elearningPOMWeek2.clickAssignRole();
		Thread.sleep(4000);
		String actAssignRolePage = elearningPOMWeek2.getAssignRolePage();
		screenShotWeek2.captureScreenShot("ELTC_040_10");
		Assert.assertEquals(actAssignRolePage, expAssignRolePage);
		System.out.println("Assign a role page should get displayed -Verified");

		elearningPOMWeek2.selectUserForAssignRole();
		Thread.sleep(4000);

		elearningPOMWeek2.clickAssignRoleValidate();
		Thread.sleep(4000);
		String actAssignRoleConfirmationMsg = elearningPOMWeek2.getconfirmMsg();
		screenShotWeek2.captureScreenShot("ELTC_040_11");
		Assert.assertEquals(actAssignRoleConfirmationMsg, expAssignRoleConfirmationMsg);
		System.out.println("The task has been assigned. Message should get displayed -Verified");

		elearningPOMWeek2.clickUserManagementIcon();
		Thread.sleep(4000);
		String actUserMgmtPage = elearningPOMWeek2.getUserMgmtPage();
		screenShotWeek2.captureScreenShot("ELTC_040_12");
		Assert.assertEquals(actUserMgmtPage, expUserMgmtPage);
		System.out.println("Subscribe users page should get displayed -Verified");

		elearningPOMWeek2.clickUserCheckBox();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_040_13");

		elearningPOMWeek2.clickUnregister();
		Thread.sleep(4000);

		elearningPOMWeek2.clickUnsubscribeValidate();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_040_14");
		System.out.println("End of Test Case ELTC_040 !!!");
	}

	@Test(priority = 1, enabled = true)
	public void studentToSubscribeCourseTakeTest_ELTC_041() throws InterruptedException, IOException {
		
		String studentUserName = properties.getProperty("studentUserName");
		String studentPwd = properties.getProperty("studentPwd");
		String searchCourseName=properties.getProperty("searchCourseName1");
		String expQue1=properties.getProperty("question1");
		String expQue2=properties.getProperty("question2");
		screenShotWeek2 = new ScreenShotWeek2(driver);
		
		elearningPOMWeek2.login(studentUserName,studentPwd);
		Thread.sleep(4000);
		
		elearningPOMWeek2.searchAndSubscribeCourse(searchCourseName);
		Thread.sleep(4000);
		
		elearningPOMWeek2.clickMyCourses();
		Thread.sleep(4000);
		
		elearningPOMWeek2.clickSelectCourse();
		Thread.sleep(4000);
		
		elearningPOMWeek2.clickTestIcon();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_041_01");
		boolean actTestLinkDisplayed=elearningPOMWeek2.isDisplayedTestLink();
		Assert.assertEquals(actTestLinkDisplayed, true);
		System.out.println("Test name should get displayed - verified");
		
		elearningPOMWeek2.clickTestLink();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_041_02");
		boolean actStartTestDisplayed=elearningPOMWeek2.isDisplayedStartTest();
		Assert.assertEquals(actStartTestDisplayed, true);
		System.out.println("Start Test button should get displayed - verified");
		
		elearningPOMWeek2.clickStartTest();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_041_01");
		String actQue1=elearningPOMWeek2.getQuestion1();
		Assert.assertEquals(actQue1, expQue1);
		System.out.println("Question 1 displayed - verified");
		
		elearningPOMWeek2.clickQue1Ans();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_041_02");
		System.out.println("Answer selected for Question 1");
		
		elearningPOMWeek2.clickNextQue();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_041_03");
		String actQue2=elearningPOMWeek2.getQuestion2();
		Assert.assertEquals(actQue2, expQue2);
		System.out.println("Question 2 displayed - verified");
		
		elearningPOMWeek2.clickQue2Ans();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_041_04");
		System.out.println("Answer selected for Question 2");
		
		elearningPOMWeek2.clickEndButton();
		Thread.sleep(4000);
		screenShotWeek2.captureScreenShot("ELTC_041_05");
		boolean actTestResultDisplayed=elearningPOMWeek2.isDisplayedTestResult();
		Assert.assertEquals(actTestResultDisplayed, true);
		System.out.println("Test Result should get displayed - verified");
				
		System.out.println("End of Test Case ELTC_041 !!!");

	}
}