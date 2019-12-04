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
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		elearningPOM.sendUserName("reva");
		elearningPOM.sendPassword("reva321");
		elearningPOM.clickLoginBtn();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=0)
	public void registerForCourse_ELTC_013() throws InterruptedException {
		String actualCourseConfirmationMsg=null;
		String expectedCourseConfirmationMsg="registered to course";
		String searchCourse="Manual";
		boolean courseRegistered;
		elearningPOM.clickCourseCatalogbtn();
		Thread.sleep(5000);
		elearningPOM.sendSearchTextBox(searchCourse);
		Thread.sleep(2000);
		elearningPOM.clickSearchBtn();
		Thread.sleep(2000);
		elearningPOM.clickSelectCourse();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC_013-CourseRegistration");
		actualCourseConfirmationMsg=elearningPOM.getConfirmationMsg();
		courseRegistered=actualCourseConfirmationMsg.contains(expectedCourseConfirmationMsg);
		Assert.assertEquals(courseRegistered, true);	
		System.out.println("ELTC013 -Course registered successfully : ");
		Thread.sleep(5000); 
	}
	
	@Test(priority=1)
	public void displayRegisteredCourseDetails_ELTC_014() throws InterruptedException {
		String actualCourseDetails1,actualCourseDetails2=null;
		String expectedCourseDetails1="Course description of 123testing below.";
		String expectedCourseDetails2="123testing content...123 testing content..123testingcontent...";
		elearningPOM.clickMyCoursesLink();
		Thread.sleep(5000);
		elearningPOM.clickSubscribedCourse();
		Thread.sleep(5000);
		elearningPOM.clickCourseDescription();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC_014-RegisteredCourseDetails");
		actualCourseDetails1=elearningPOM.getCourseDetails1();
		actualCourseDetails2=elearningPOM.getCourseDetails2();
		Assert.assertEquals(actualCourseDetails1, expectedCourseDetails1);
		Assert.assertEquals(actualCourseDetails2, expectedCourseDetails2);
		System.out.println("ELTC014-Course details displayed successfully");
		Thread.sleep(5000);
	
	}

	
	@Test(priority=2)
	public void logoutTest_ELTC_015() throws InterruptedException {
		String actualAfterLogoutUrl;
		String expectedAfterLogoutUrl="http://elearningm1.upskills.in/index.php";
		screenShot.captureScreenShot("ELTC_015-BeforeLogout");
		Thread.sleep(5000);
		elearningPOM.clickProfileDropDown();
		Thread.sleep(5000);
		elearningPOM.clickLogout();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC_015-AfterLogout");
		actualAfterLogoutUrl =driver.getCurrentUrl();
		Assert.assertEquals(actualAfterLogoutUrl, expectedAfterLogoutUrl);
		System.out.println("ELTC015-Logout successful");		
	}
	
	
	}
