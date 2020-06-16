package sanityTest;

import extensions.uiAction;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.commonOps;
import workFlows.webFlows;
import extensions.verification;



@Listeners(utilities.listeners.class)
public class grafanaWeb extends commonOps
{
    @Test(description = "Test01:Login to Grafana")
    @Description("Test description: Login to Grafana web application")
    public static void test01_login()
    {
        webFlows.login("admin", "admin");
        verification.textInElement(grafanaMain.txt_mainHeading, "Home Dashboard");
    }

    @Test(description = "Test02:Verify the defult user")
    @Description("Test description: Verify that number of user should be one")
    public static void test02_vefityDefaltUsers()
    {
        uiAction.mouseHoverElement(grafanaLeftMeun.btn_ServerAdmin, grafanaServerAdminMenuPage.link_users);
        verification.numberOfElement(grafanaServerAdminMainPage.rows, 1);

    }

    @Test(description = "Test03: Add and verify users")
    @Description("Test description: add a new user and verify the number of user is 2")
    public static void test03_addNewUser()
    {
        uiAction.mouseHoverElement(grafanaLeftMeun.btn_ServerAdmin, grafanaServerAdminMenuPage.link_users);
        webFlows.createUser("Priel", "priel@gmail.com", "priel", "12345");
        verification.numberOfElement(grafanaServerAdminMainPage.rows, 2);
    }

    @Test(description = "Test04:Delete last user")
    @Description("Test description: verify that user deleted verify the number of user is 1 ")
    public static void test04_deleteAndVerifyUser()
    {
        uiAction.mouseHoverElement(grafanaLeftMeun.btn_ServerAdmin, grafanaServerAdminMenuPage.link_users);
        webFlows.deleteLastUser();
        verification.numberOfElement(grafanaServerAdminMainPage.rows, 1);
    }

    @Test(description = "Test05: verify avatar image")
    @Description("Test description: verify grafana default image is avatar ")
    public static void test05_verifyAvatar()
    {
        verification.visualElement(grafanaLeftMeun.img_Avatar, "grafanaAvatar");
    }
}
