package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.CartPage;
import PagePackage.FillFormPage;
import PagePackage.ProductPage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;


public class PageTest extends BaseClass {
    FillFormPage fillform;
    public PageTest(){
        super();
    }


    @Test
    public void selectProduct() throws MalformedURLException, InterruptedException {

        fillform= new FillFormPage(driver);
        fillform.enterName("jhanvi");
        fillform.enterGender("female");
        fillform.country();
        ProductPage productpage=fillform.submit();

        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
        Thread.sleep(2000);
        //after adding first product add to cart will change to added to cart that why we will again click on indexed 0
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
        CartPage cartPage= new CartPage(driver);
        double sum=cartPage.getprice();
        double cartPrice=cartPage.Totalprice();

        Assert.assertEquals(sum,cartPrice);
        //longpress gesture
        WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        ((JavascriptExecutor)driver).executeScript("mobile:longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();


    }
}
