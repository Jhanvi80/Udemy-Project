package PagePackage;

import BasePackage.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FillFormPage extends BaseClass {
 AndroidDriver driver;

    public FillFormPage(AndroidDriver driver){

        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    WebElement Myname;


    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    WebElement femaleGender;
    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    WebElement maleGender;


    @AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
    WebElement counryfield;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    WebElement submitbutton;

    public void enterName(String Name){
        Myname.sendKeys(Name);
        driver.hideKeyboard();

    }
    public void enterGender( String Gender){
        if(Gender.contains("female")){
            femaleGender.click();
        }
        else{
            maleGender.click();
        }
    }
    public void country(){
        counryfield.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cuba\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Cuba']")).click();
    }
    public ProductPage submit(){
        submitbutton.click();
        return new ProductPage(driver);
    }

}
