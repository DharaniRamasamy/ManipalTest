package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningPOM {
	private WebDriver driver; 
	
	public ElearningPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']//span[@class='caret']")
	private WebElement ProfileDropDown; 
	
	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logout;
	
	@FindBy(linkText="Course catalog")
	private WebElement courseCatalogbtn;
	
	@FindBy(name="search_term")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//div[@class='input-group']//button[1]")
	private WebElement searchBtn;
	
	@FindBy(xpath="//div[*]//div[1]//div[2]//div[4]//div[1]//a[1]")
	private WebElement selectCourse;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/section[1]/div[1]/div[2]")
	private WebElement courseConfirmationMsg;
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement myCoursesLink;
	
	@FindBy(xpath="//div[@class='panel-body']/div[@class='row']/div[@class='col-md-10']/h4/a")
	private WebElement subscribedCourse;
	
	@FindBy(id="istooldesc_1742")
	private WebElement courseDescription;
	
	@FindBy(xpath="//div[@class='panel-heading']")
	private WebElement courseDetails1;
	
	@FindBy(xpath="//div[@class='panel-body']")
	private WebElement courseDetails2;
	
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
	
	public void clickProfileDropDown() {
		this.ProfileDropDown.click(); 
	}
	
	public void clickLogout() {
		this.logout.click();
	}
	
	public void clickCourseCatalogbtn() {
		this.courseCatalogbtn.click(); 
	}
	
	public void sendSearchTextBox(String courseName) {
		this.searchTextBox.clear();
		this.searchTextBox.sendKeys(courseName);
	}
	
	public void clickSearchBtn() {
		this.searchBtn.click(); 
	}
	
	public void clickSelectCourse() {
		this.selectCourse.click(); 
	}
	
	public String getConfirmationMsg()
	{
		return this.courseConfirmationMsg.getText();
	}
	
	public void clickMyCoursesLink() {
		this.myCoursesLink.click(); 
	}
	
	public void clickSubscribedCourse() {
		this.subscribedCourse.click(); 
	}
	
	public void clickCourseDescription() {
		this.courseDescription.click(); 
	}
	
	public String getCourseDetails1()
	{
		return this.courseDetails1.getText();
	}
	
	public String getCourseDetails2()
	{
		return this.courseDetails2.getText();
	}
	
}
