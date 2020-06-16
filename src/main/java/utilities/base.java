package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();

//web//
    public static pageObjects.Grafana.logInPage grafanaLogin;
    public static pageObjects.Grafana.mainPage grafanaMain;
    public static pageObjects.Grafana.leftMenuPage grafanaLeftMeun;
    public static pageObjects.Grafana.serverAdminMenuPage grafanaServerAdminMenuPage;
    public static pageObjects.Grafana.serverAdminMainPage grafanaServerAdminMainPage;
    public static pageObjects.Grafana.userListPage grafanaUserListPage;


//mobile//
    public static pageObjects.Mortgage.mainPage mortgageMain;
    public static pageObjects.ElectronDemo.mainPage electronMain;

    public static pageObjects.Calculator.mainPage calcmain ;

//api//
   public static RequestSpecification httpRequest;
   public static Response response;
   public static JSONObject requestParams = new JSONObject();
   public static JsonPath jp;


   public static Connection con;
   public static Statement stmt;
   public static ResultSet rs;






}
