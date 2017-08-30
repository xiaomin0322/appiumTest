package com.dbyl.core;
 
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
 

/**
 * --启动appium
appium -a 127.0.0.1 -p 4723 -U Z2X4C15702014407 --no-reset

--查看main方法
aapt dump badging D:\workspace\AppiumDemo\apps\com.zhihu.android.apk


--查看设备号
adb devices -l

 * @author ThinkPad
 *
 */
public class ZhiHu {
    private  AppiumDriver  driver;
 
    @Before
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "com.zhihu.android.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        //设备名称
        capabilities.setCapability("platformName", "Android");
        //设备id
        capabilities.setCapability("deviceName","Z2X4C15702014407");
        capabilities.setCapability("platformVersion", "6.0");
        //if no need install don't add this app路径
        capabilities.setCapability("app", app.getAbsolutePath());
        //包名称
        capabilities.setCapability("appPackage", "com.zhihu.android");
        //support Chinese 
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        //no need sign
        capabilities.setCapability("noSign", "True");
        //man方法入口
        capabilities.setCapability("appActivity", "com.zhihu.android.app.ui.activity.MainActivity");
        //appium 地址
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
 
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
 
    @org.junit.Test
    public void Login()throws Exception{
        //find login button
       /*  WebElement loginButton = driver.findElement(By.id("com.zhihu.android:id/login"));
        loginButton.click();
        
        //wait for 20s
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //find login userName and password editText 
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("seleniumcookies@126.com");
        textFieldsList.get(1).sendKeys("cookies123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //find ok button byName
        driver.findElementByName("OK").click();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        
        //find keyword 首页 and verify it is display
        Assert.assertTrue( driver.findElement(By.name("首页")).isDisplayed());*/
    	
    	
    	System.out.println(driver.getPageSource());
    	
    	System.out.println("test====================");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Thread.sleep(1000);
    	WebElement loginButton = null;
    			
    		/*	loginButton = 		driver.findElement(By.id("com.zhihu.android:id/tab_icon"));
        loginButton.click();*/
        
        
        
       
        
        
        System.out.println("点击????===com.zhihu.android:id/tab_title");
        //如果id有多個通過findElements獲取
        loginButton = driver.findElements(By.id("com.zhihu.android:id/tab_title")).get(2);
        
        
        System.out.println("test=="+loginButton.getText());
        
        
        loginButton.click();
        
        
        
        Thread.sleep(100000);
        
        
        
        
        
        
        
    }
}