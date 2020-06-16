package utilities;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.w3c.dom.Document;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;





public class commonOps extends base
{

    public static String getData(String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try
        {
            fXmlFile = new File("/configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e)
        {
            System.out.println("Error reading XMLfile:" + e);

        }
        finally
        {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }



    public void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver=initFirefoxDrive();
        else if (browserType.equalsIgnoreCase("ie"))
            driver=initexplorer();

        else
            throw new RuntimeException(("Invalid platform name stated"));
        managePages.init();


        driver.manage().window().maximize();
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait= new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        action= new Actions(driver);


    }

    public static WebDriver initChromeDriver()
    {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      return driver;
    }

    public static WebDriver initFirefoxDrive()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initexplorer()

    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }



    public  static void initMoblie()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try
        {
            driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), dc);
        } catch (Exception e)
        {
            System.out.println("cant connect to Appium server :" +e);
        }

        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeOut")), TimeUnit.SECONDS);


    }


    public static void initAPI()
    {
        RestAssured.baseURI= getData("url_api");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("user"),getData("password"));

    }


    public static void initElectron()
    {
       System.setProperty("webDriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt= new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver((dc));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);


    }


    public static void initDesktop()
    {
        dc.setCapability("app", ("Calculator_app"));
        try
        {
        driver = new WindowsDriver(new URL(getData("Appium_server")),dc);
    }
        catch(MalformedURLException e)
        {
            e.printStackTrace();

        }
    }





    @BeforeClass
    public void start()
    {
        if(getData("PlatFromName").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (getData("PlatFromName").equalsIgnoreCase("mobile"))
         initMoblie();
        else if (getData("PlatFromName").equalsIgnoreCase("api"))
            initAPI();
        else if (getData("PlatFromName").equalsIgnoreCase("electron"))
            initElectron();
        else if (getData("PlatFromName").equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException(("Invalid PlatFromName name stated"));
        managePages.init();
        manageDB.initConnection(getData("dbUrl"), getData("dbUser"), getData("dbPasssword"));



    }

    @AfterMethod
    public void afterMethod()
    {
        if (getData("PlatFromName").equalsIgnoreCase("web"))
           driver.get(getData("url"));
    }

    @AfterClass
    public void endTest()
    {
        manageDB.closeConection();
        if (!getData("PlatFromName").equalsIgnoreCase("api"))
      driver.quit();
    }
}
