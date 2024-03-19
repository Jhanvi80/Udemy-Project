package Utility;

import io.appium.java_client.android.AndroidDriver;

public class AndroidUtils  {
    AndroidDriver driver;
    public AndroidUtils(AndroidDriver driver){
        this.driver=driver;
    }
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT=10;


}
