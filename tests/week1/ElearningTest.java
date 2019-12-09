package week1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ElearningTest {

	private WebDriver driver;
	private String baseUrl;
	private ElearningPOM elearningPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String userName;
	private String pwd;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		elearningPOM = new ElearningPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		userName=properties.getProperty("userName");
		pwd=properties.getProperty("pwd");	
		screenShot = new ScreenShot(driver); 
		//Open the browser 
		driver.get(baseUrl);
		Thread.sleep(5000);
		//Enter the login credentials and login
		elearningPOM.sendUserName(userName);
		elearningPOM.sendPassword(pwd);
		elearningPOM.clickLoginBtn();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=0,enabled=true)
	public void registerForCourse_ELTC_013() throws InterruptedException, IOException {
		String actualCourseConfirmationMsg=null;
		String expectedCourseConfirmationMsg=properties.getProperty("expectedCourseConfirmationMsg");
		String searchCourseName=properties.getProperty("searchCourseName");
		boolean courseRegistered;
		elearningPOM.clickCourseCatalogbtn();
		Thread.sleep(5000);
		elearningPOM.sendSearchTextBox(searchCourseName);
		Thread.sleep(2000);
		elearningPOM.clickSearchBtn();
		Thread.sleep(2000);
		elearningPOM.clickSelectCourse();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC_013-CourseRegistration");
		//verify if the course is registered successfully
		actualCourseConfirmationMsg=elearningPOM.getConfirmationMsg();
		courseRegistered=actualCourseConfirmationMsg.contains(expectedCourseConfirmationMsg);
		Assert.assertEquals(courseRegistered, true);	
		System.out.println("ELTC013 -Course registered successfully : ");
		Thread.sleep(5000); 
	}
	
	@Test(priority=1,enabled=true)
	public void displayRegisteredCourseDetails_ELTC_014() throws InterruptedException, IOException {
		String actualCourseDetails1,actualCourseDetails2=null;
		String expectedCourseDetails1=properties.getProperty("expectedCourseDetails1");
		String expectedCourseDetails2=properties.getProperty("expectedCourseDetails2");
		elearningPOM.clickMyCoursesLink();
		Thread.sleep(5000);
		elearningPOM.clickSubscribedCourse();
		Thread.sleep(5000);
		elearningPOM.clickCourseDescription();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC_014-RegisteredCourseDetails");
		//verify if the course details are displayed correctly
		actualCourseDetails1=elearningPOM.getCourseDetails1();
		actualCourseDetails2=elearningPOM.getCourseDetails2();
		Assert.assertEquals(actualCourseDetails1, expectedCourseDetails1);
		Assert.assertEquals(actualCourseDetails2, expectedCourseDetails2);
		System.out.println("ELTC014-Course details displayed successfully");
		Thread.sleep(5000);
	
	}

	
	@Test(priority=2,enabled=true)
	public void logoutTest_ELTC_015() throws InterruptedException, IOException {
		String actualAfterLogoutUrl;
		String expectedAfterLogoutUrl=properties.getProperty("expectedAfterLogoutUrl");
		screenShot.captureScreenShot("ELTC_015-BeforeLogout");
		Thread.sleep(5000);
		//click on Profile Drop Down
		elearningPOM.clickProfileDropDown();
		Thread.sleep(5000);
		//verify if Inbox,My certificates & Logout are displayed upon clicking drop down beside user icon
		String expectedDropdown1=properties.getProperty("DropDown1");
		String expectedDropdown2=properties.getProperty("DropDown2");
		String expectedDropdown3=properties.getProperty("DropDown3");
		String actualDropdown1=elearningPOM.getdropdown1Inbox();
		String actualDropdown2=elearningPOM.getdropdown2MyCertificates();
		String actualDropdown3=elearningPOM.getdropdown3Logout();
		Assert.assertEquals(actualDropdown1,expectedDropdown1);
		Assert.assertEquals(actualDropdown2,expectedDropdown2);
		Assert.assertEquals(actualDropdown3,expectedDropdown3);
		screenShot.captureScreenShot("ELTC_015-Dropdown menu");
		//Logout verification
		elearningPOM.clickLogout();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC_015-AfterLogout");
		actualAfterLogoutUrl =driver.getCurrentUrl();
		Assert.assertEquals(actualAfterLogoutUrl, expectedAfterLogoutUrl);
		System.out.println("ELTC015-Logout successful");		
	}
		
	}
