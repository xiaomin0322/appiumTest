package com.Demo;
 
import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
 
public class AppDemo {
    private AppiumDriver driver;
 
    @Before
    public void setUp() throws Exception {
        // set up appium
       /* File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);*/
    	
    	 DesiredCapabilities cap = new DesiredCapabilities();
         cap.setCapability(CapabilityType.BROWSER_NAME, ""); 
         cap.setCapability("platformName", "Android"); //指定测试平台
         cap.setCapability("deviceName", "Z2X4C15702014407"); //指定测试机的ID,通过adb命令`adb devices`获取
         cap.setCapability("platformVersion", "6.0"); 

         //将上面获取到的包名和Activity名设置为值
        // cap.setCapability("appPackage", "com.meizu.flyme.calculator");
        // cap.setCapability("appActivity", "com.meizu.flyme.calculator.Calculator");

         //A new session could not be created的解决方法
       //  cap.setCapability("appWaitActivity","com.meizu.flyme.calculator.Calculator");
         //每次启动时覆盖session，否则第二次后运行会报错不能新建session
         cap.setCapability("sessionOverride", true);

         driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    	
    }
 
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    
    @Test 
    public void plus(){

        //获取1
        driver.findElementById("com.meizu.flyme.calculator:id/digit1").click();
        //获取+
        driver.findElementById("com.meizu.flyme.calculator:id/plus").click();
        //获取2
        driver.findElementById("com.meizu.flyme.calculator:id/digit2").click();
        //获取=
        driver.findElementById("com.meizu.flyme.calculator:id/eq").click();

         System.out.println("======================================");  
    }
 
    @Test
    public void addContact(){
        WebElement el = driver.findElement(By.name("Add Contact"));
        el.click();
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(2).sendKeys("Some@example.com");
        driver.swipe(100, 500, 100, 100, 2);
        driver.findElementByName("Save").click();
    }
}