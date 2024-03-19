package PagePackage;

import BasePackage.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseClass {
    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    List<WebElement> productPrice;

    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    WebElement cartTatal;

    public List<WebElement> getProductList(){
      return productPrice;

    }
    public double getprice() {
        int count = productPrice.size();
        double sum = 0;

        for (int i = 0; i < count; i++) {
            String amountstring = productPrice.get(i).getText();
            //to convert string to double
            Double price = Double.parseDouble(amountstring.substring(1));
            sum = sum + price;
        }
        return sum;

    }
    public Double Totalprice(){
        double cartprice=0;
        String cartpricestring=cartTatal.getText();
        String Displyamount=cartpricestring.substring(1);
        Double cartPrice= Double.parseDouble(Displyamount);
        return cartPrice;
    }
}
